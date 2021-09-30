package br.com.eleicaoonline.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.eleicaoonline.domain.Eleitor;

@Repository
public interface EleitorRepository extends PagingAndSortingRepository<Eleitor, Long> {

}
