package br.com.eleicaoonline.service.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import br.com.eleicaoonline.domain.Administrador;
import br.com.eleicaoonline.domain.Candidato;
import br.com.eleicaoonline.domain.Eleicao;
import br.com.eleicaoonline.domain.Eleitor;
import br.com.eleicaoonline.exception.BusinessException;
import br.com.eleicaoonline.repository.AdministradorRepository;
import br.com.eleicaoonline.repository.CandidatoRepository;
import br.com.eleicaoonline.repository.EleitorRepository;

@Component
public class EntidadeNaoExistenteValidation implements Validation<Object> {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private AdministradorRepository administradorRepository;

	@Autowired
	private CandidatoRepository eleicaoRepository;

	@Autowired
	private CandidatoRepository candidatoRepository;

	@Autowired
	private EleitorRepository eleitorRepository;

	@Override
	public void validate(Object obj) {
		boolean existe = false;
		if (obj instanceof Administrador) {
			existe = administradorRepository.existsById(((Administrador) obj).getId());
		} else if (obj instanceof Eleicao) {
			existe = eleicaoRepository.existsById(((Eleicao) obj).getId());
		} else if (obj instanceof Candidato) {
			existe = eleitorRepository.existsById(((Candidato) obj).getId());
		} else if (obj instanceof Eleitor) {
			existe = candidatoRepository.existsById(((Eleitor) obj).getId());
		}
		if(!existe) {
			throw new BusinessException("");
		}

	}

}