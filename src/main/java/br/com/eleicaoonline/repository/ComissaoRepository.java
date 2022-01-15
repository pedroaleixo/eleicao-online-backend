package br.com.eleicaoonline.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.eleicaoonline.domain.ComissaoEleitoral;

@Repository
public interface ComissaoRepository extends PagingAndSortingRepository<ComissaoEleitoral, Long>{
	
}
