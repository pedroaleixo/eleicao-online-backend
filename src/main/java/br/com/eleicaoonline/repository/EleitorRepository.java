package br.com.eleicaoonline.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.eleicaoonline.controller.filtro.FiltroPessoa;
import br.com.eleicaoonline.controller.filtro.FiltroVotantes;
import br.com.eleicaoonline.domain.Eleicao;
import br.com.eleicaoonline.domain.Eleitor;

@Repository
public interface EleitorRepository extends PagingAndSortingRepository<Eleitor, Long> {

	@Query("select e from Eleitor e "
			+ "where e.eleicao.id = :#{#filtro.idEleicao} "
			+ "and (cast(:#{#filtro.nome} as text) is null or lower(e.pessoa.nome) like lower(concat('%', cast(:#{#filtro.nome} as text),'%'))) "
			+ "and (:#{#filtro.cpf} is null or e.pessoa.cpf = :#{#filtro.cpf}) ")
	Page<Eleitor> filtrar(@Param("filtro") FiltroPessoa filtro, Pageable pageable);

	@Query("select e.eleicao from Eleitor e where e.pessoa.id = :id")
	Page<Eleicao> listarEleicoesDisponiveis(@Param("id") Long id, Pageable pageable);
	
	
	@Query("select e from Eleitor e "
			+ "where e.eleicao.id = :#{#filtro.idEleicao} "
			+ "and ( ( ( cast(:#{#filtro.votou} as boolean) is null or :#{#filtro.votou} = false ) and e.dataHoraVotou is null) or (:#{#filtro.votou} = true and e.dataHoraVotou is not null) )"
			+ "and (cast(cast(:#{#filtro.dataHoraInicio} as text) as timestamp) is null or e.dataHoraVotou >= :#{#filtro.dataHoraInicio})"
	        + "and (cast(cast(:#{#filtro.dataHoraFim} as text) as timestamp) is null or e.dataHoraVotou <= :#{#filtro.dataHoraFim})"
			)
	Page<Eleitor> filtrarEleitoresVotantes(@Param("filtro") FiltroVotantes filtro, Pageable pageable);
	
	
	@Query("select e from Eleitor e where e.pessoa.email = :email")
	Eleitor findEleitorByEmail(@Param("email") String email);
	
	
}
