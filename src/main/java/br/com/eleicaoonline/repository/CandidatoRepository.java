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
			+ "and c.branco = false "
			+ "and (cast(:#{#filtro.nome} as text) is null or lower(c.pessoa.nome) like lower(concat('%', cast(:#{#filtro.nome} as text),'%'))) "
			+ "and (:#{#filtro.cpf} is null or c.pessoa.cpf = :#{#filtro.cpf}) "
			+ "and (:#{#filtro.idCargo} is null or c.cargo.id = :#{#filtro.idCargo}) order by c.pessoa.nome asc")
	Page<Candidato> filtrar(@Param("filtro") FiltroPessoa filtro, Pageable pageable);	
	
	@Query("select count(*) > 0 from Candidato can where can.id = :idCandidato and can.eleicao.situacao <> 0")
	Boolean candidatoAssociadoEleicaoNaoCadastrada(@Param("id") Long idCandidato);
	
	public Candidato findByPessoaCpfAndEleicaoId(Long cpf, Long eleicaoId);

}
