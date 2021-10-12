package br.com.eleicaoonline.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.eleicaoonline.domain.Pessoa;

@Repository
public interface PessoaRepository extends PagingAndSortingRepository<Pessoa, Long> {
	
	public Pessoa findByCpf(Long cpf);
	
	public Pessoa findByEmail(String email);

}
