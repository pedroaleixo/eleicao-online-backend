package br.com.eleicaoonline.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.eleicaoonline.controller.filtro.FiltroPessoa;
import br.com.eleicaoonline.domain.Administrador;

@Repository
public interface AdministradorRepository extends PagingAndSortingRepository<Administrador, Long> {
	
	@Query("select a from Administrador a "
			+ "where (cast(:#{#filtro.nome} as text) is null or lower(a.pessoa.nome) like lower(concat('%', cast(:#{#filtro.nome} as text),'%'))) "
			+ "and ( :#{#filtro.cpf} is null or a.pessoa.cpf = :#{#filtro.cpf} ) order by a.pessoa.nome asc")
	Page<Administrador> filtrar(@Param("filtro") FiltroPessoa filtro, Pageable pageable);
	
	@Query("select a from Administrador a where a.pessoa.email = :email")
	Administrador findAdministradorByEmail(@Param("email") String email);
	
	public Administrador findByPessoaCpf(Long cpf);

}
