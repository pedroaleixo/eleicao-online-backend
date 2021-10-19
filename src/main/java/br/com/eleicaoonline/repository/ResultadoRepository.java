package br.com.eleicaoonline.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.eleicaoonline.domain.Resultado;

@Repository
public interface ResultadoRepository extends PagingAndSortingRepository<Resultado, Long> {
	
	public Resultado findByEleicaoId(Long eleicaoId);
	
}
