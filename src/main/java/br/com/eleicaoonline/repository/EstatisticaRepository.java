package br.com.eleicaoonline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.eleicaoonline.domain.Eleicao;

@Repository
public interface EstatisticaRepository extends PagingAndSortingRepository<Eleicao, Long> {
	
	@Query("select eleitores.pessoa.genero, count(*) from Eleicao e "
			+ "join e.eleitores eleitores "
			+ "where e.id = :idEleicao group by eleitores.pessoa.genero")
	public List<Object[]> buscarEleitoradoPorSexo(@Param("idEleicao") Long idEleicao);

	
	@Query("select candidatos.pessoa.genero, count(*) from Eleicao e "
			+ "join e.candidatos candidatos "
			+ "where e.id = :idEleicao group by candidatos.pessoa.genero")
	public List<Object[]> buscarCandidatosPorSexo(@Param("idEleicao") Long idEleicao);	
	
}
