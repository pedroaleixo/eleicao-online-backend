package br.com.eleicaoonline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.eleicaoonline.domain.Eleicao;

@Repository
public interface EstatisticaRepository extends PagingAndSortingRepository<Eleicao, Long> {
	
	@Query("select e from Eleicao e")
	public List<Object[]> buscarEleitoradoPorSexo(Long idEleicao);
	
	@Query("select e from Eleicao e")
	public List<Object[]> buscarEleitoradoPorFaixaEtaria(Long idEleicao);
	
	@Query("select e from Eleicao e")
	public List<Object[]> buscarEleitoradoPorRegiao(Long idEleicao);
	
	@Query("select e from Eleicao e")
	public List<Object[]> buscarCandidatosPorSexo(Long idEleicao);
	
	@Query("select e from Eleicao e")
	public List<Object[]> buscarCandidatosPorFaixaEtaria(Long idEleicao);
	
	@Query("select e from Eleicao e")
	public List<Object[]> buscarDistribuicaoVotantesPorDia(Long idEleicao);

}
