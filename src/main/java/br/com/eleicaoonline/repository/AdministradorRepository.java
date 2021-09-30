package br.com.eleicaoonline.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.eleicaoonline.domain.Administrador;

@Repository
public interface AdministradorRepository extends PagingAndSortingRepository<Administrador, Long> {

}
