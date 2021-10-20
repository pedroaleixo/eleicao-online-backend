package br.com.eleicaoonline.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.eleicaoonline.controller.filtro.FiltroPessoa;
import br.com.eleicaoonline.domain.Candidato;

@Repository
public interface CandidatoRepository extends PagingAndSortingRepository<Candidato, Long> {
	
	@Query("select c from Candidato c "
			+ "where c.eleicao.id = :#{#filtro.idEleicao} "
			+ "and (cast(:#{#filtro.nome} as text) is null or lower(c.pessoa.nome) like lower(concat('%', cast(:#{#filtro.nome} as text),'%'))) "
			+ "and (:#{#filtro.cpf} is null or c.pessoa.cpf = :#{#filtro.cpf}) ")
	Page<Candidato> filtrar(@Param("filtro") FiltroPessoa filtro, Pageable pageable);	

}
