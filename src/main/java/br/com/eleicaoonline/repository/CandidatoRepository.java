package br.com.eleicaoonline.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.eleicaoonline.domain.Candidato;

@Repository
public interface CandidatoRepository extends PagingAndSortingRepository<Candidato, Long> {

}
