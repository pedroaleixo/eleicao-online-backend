package br.com.eleicaoonline.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.eleicaoonline.controller.filtro.FiltroPessoa;
import br.com.eleicaoonline.domain.Pessoa;

@Repository
public interface PessoaRepository extends PagingAndSortingRepository<Pessoa, Long> {
	
	@Query("select p from Pessoa p "
			+ "where (cast(:#{#filtro.nome} as text) is null or lower(p.nome) like lower(concat('%', cast(:#{#filtro.nome} as text),'%'))) "
			+ "and (:#{#filtro.cpf} is null or p.cpf = :#{#filtro.cpf}) ")
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

}
