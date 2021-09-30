package br.com.eleicaoonline.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.eleicaoonline.domain.Eleicao;

@Repository
public interface EleicaoRepository extends PagingAndSortingRepository<Eleicao, Long> {

}
