package br.com.eleicaoonline.service.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import br.com.eleicaoonline.domain.Candidato;
import br.com.eleicaoonline.domain.Eleitor;
import br.com.eleicaoonline.domain.Pessoa;
import br.com.eleicaoonline.exception.BusinessException;
import br.com.eleicaoonline.repository.AdministradorRepository;
import br.com.eleicaoonline.repository.CandidatoRepository;
import br.com.eleicaoonline.repository.EleicaoRepository;
import br.com.eleicaoonline.repository.EleitorRepository;
import br.com.eleicaoonline.repository.PessoaRepository;

@Component
public class EntidadeAssociadaEleicaoNaoCadastradaValidation implements Validation<Object> {

	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private AdministradorRepository administradorRepository;
	
	@Autowired
	private EleicaoRepository eleicaoRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private CandidatoRepository candidatoRepository;
	
	@Autowired
	private EleitorRepository eleitorRepository;

	@Override
	public void validate(Object obj) {
		boolean associado = false;
		
		if (obj != null) {
			if (obj instanceof Pessoa) {
				associado = pessoaRepository.pessoaAssociadaEleicaoNaoCadastrada(((Pessoa) obj).getId());
			} else if (obj instanceof Candidato) {
				associado = candidatoRepository.candidatoAssociadoEleicaoNaoCadastrada(((Candidato) obj).getId());
			} else if (obj instanceof Eleitor) {
				associado = eleitorRepository.eleitorAssociadoEleicaoNaoCadastrada(((Eleitor) obj).getId());
			}

			if (associado) {
				throw new BusinessException(
						messageSource.getMessage(ValidationMessageKey.ENTIDADE_ASSOCIADA_ELEICAO_NAO_CADASTRADA, null, null));
			}
		} 

	}

}