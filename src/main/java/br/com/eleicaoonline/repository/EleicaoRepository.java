package br.com.eleicaoonline.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.eleicaoonline.controller.filtro.FiltroEleicao;
import br.com.eleicaoonline.domain.Eleicao;
import br.com.eleicaoonline.domain.Pessoa;
import br.com.eleicaoonline.domain.enums.SituacaoEleicao;

@Repository
public interface EleicaoRepository extends PagingAndSortingRepository<Eleicao, Long> {
	
	@Query("select e from Eleicao e "
			+ "where (cast(:#{#filtro.nome} as text) is null or lower(e.nome) like lower(concat('%', cast(:#{#filtro.nome} as text),'%'))) "
			+ "and (cast(:#{#filtro.instituicao} as text) is null or lower(e.instituicao) like lower(concat('%', cast(:#{#filtro.instituicao} as text),'%'))) "
			+ "and (cast(cast(:#{#filtro.dataHoraInicio} as text) as timestamp) is null or e.dataHoraInicio >= :#{#filtro.dataHoraInicio})"
	        + "and (cast(cast(:#{#filtro.dataHoraFim} as text) as timestamp) is null or e.dataHoraFim <= :#{#filtro.dataHoraFim})"
	        + "and (:#{#filtro.situacao} is null or e.situacao = :#{#filtro.situacao})")
	Page<Eleicao> filtrar(@Param("filtro") FiltroEleicao filtro, Pageable pageable);
	
	
	List<Eleicao> findBySituacao(@Param("situacao") SituacaoEleicao situacao);
	
	
	@Query("select membro from Eleicao e join e.comissaoEleitoral.membros membro where membro.email = :email")
	List<Pessoa> findMembroComissaoEleitoralByEmail(@Param("email") String email);
	
	@Query("select e from Eleicao e join e.eleitores eleitor where eleitor.pessoa.id = :idPessoa")
	List<Eleicao> findByPessoaEleitor(@Param("idPessoa") Long idPessoa);
	
	@Query("select e from Eleicao e join e.comissaoEleitoral.membros membro where membro.id = :idPessoa")
	List<Eleicao> findByPessoaMembroComissao(@Param("idPessoa") Long idPessoa);
	
}
