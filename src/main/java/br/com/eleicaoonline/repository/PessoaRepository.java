package br.com.eleicaoonline.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.eleicaoonline.controller.filtro.FiltroPessoa;
import br.com.eleicaoonline.domain.Pessoa;

@Repository
public interface PessoaRepository extends PagingAndSortingRepository<Pessoa, Long> {
	
	@Query("select p from Pessoa p "
			+ "where p.id <> 1000001 "
			+ "and (cast(:#{#filtro.nome} as text) is null or lower(p.nome) like lower(concat('%', cast(:#{#filtro.nome} as text),'%'))) "
			+ "and (:#{#filtro.cpf} is null or p.cpf = :#{#filtro.cpf}) order by p.nome asc")
	Page<Pessoa> filtrar(@Param("filtro") FiltroPessoa filtro, Pageable pageable);
	
	public Pessoa findByCpf(Long cpf);
	
	public Pessoa findByEmail(String email);
	
	@Query("select count(*) > 0 from Pessoa p "
			+ "where "
			+ "p.id = :idPessoa "
			+ "AND ( "
			+ "exists (select ele from Eleitor ele where ele.pessoa.id = p.id and ele.eleicao.situacao <> 0) "
			+ "	OR "
			+ "exists (select can from Candidato can where can.pessoa.id = p.id and can.eleicao.situacao <> 0) "
			+ ")")
	Boolean pessoaAssociadaEleicaoNaoCadastrada(@Param("idPessoa") Long idPessoa);
	
	@Transactional
	@Modifying
	@Query("delete from Administrador a where a.pessoa.id =:idPessoa")
	void deletarAdministradoresAssociadoPessoa(@Param("idPessoa") Long idPessoa);

	@Transactional
	@Modifying
	@Query("delete from Eleitor e where e.pessoa.id =:idPessoa")
	void deletarEleitoresAssociadoPessoa(@Param("idPessoa") Long idPessoa);

	@Transactional
	@Modifying
	@Query("delete from Candidato c where c.pessoa.id =:idPessoa")
	void deletarCandidatosAssociadoPessoa(@Param("idPessoa") Long idPessoa);

}
