package br.com.eleicaoonline.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.eleicaoonline.domain.Voto;

@Repository
public interface VotoRepository extends PagingAndSortingRepository<Voto, Long>{
	
	List<Voto> findByEleicaoId(Long idEleicao);

}
