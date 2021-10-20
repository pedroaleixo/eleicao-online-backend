package br.com.eleicaoonline.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.eleicaoonline.domain.Eleicao;

@Repository
public interface EstatisticaRepository extends PagingAndSortingRepository<Eleicao, Long> {
	
	public List<Object[]> buscarEleitoradoPorSexo(Long idEleicao);
	
	public List<Object[]> buscarEleitoradoPorFaixaEtaria(Long idEleicao);
	
	public List<Object[]> buscarEleitoradoPorRegiao(Long idEleicao);
	
	public List<Object[]> buscarCandidatosPorSexo(Long idEleicao);
	
	public List<Object[]> buscarCandidatosPorFaixaEtaria(Long idEleicao);
	
	public List<Object[]> buscarDistribuicaoVotantesPorDia(Long idEleicao);

}
