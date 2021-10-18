package br.com.eleicaoonline.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.eleicaoonline.domain.Eleicao;
import br.com.eleicaoonline.web.filtro.FiltroEleicao;

@Repository
public interface EleicaoRepository extends PagingAndSortingRepository<Eleicao, Long> {
	
	@Query("select e from Eleicao e "
			+ "where (:#{#filtro.nome} is null or lower(e.nome) like lower(concat('%', :#{#filtro.nome},'%'))) "
			+ "and (:#{#filtro.instituicao} is null or lower(e.instituicao) like lower(concat('%', :#{#filtro.instituicao},'%'))) "
			+ "and (cast(cast(:#{#filtro.dataHoraInicio} as text) as timestamp) is null or e.dataHoraInicio >= :#{#filtro.dataHoraInicio})"
	        + "and (cast(cast(:#{#filtro.dataHoraFim} as text) as timestamp) is null or e.dataHoraFim <= :#{#filtro.dataHoraFim})"
	        + "and (:#{#filtro.situacao} is null or e.situacao = :#{#filtro.situacao})")
	Page<Eleicao> filtrar(@Param("filtro") FiltroEleicao filtro, Pageable pageable);
	
}
