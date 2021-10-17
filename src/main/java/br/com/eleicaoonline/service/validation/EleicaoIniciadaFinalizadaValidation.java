package br.com.eleicaoonline.service.validation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import br.com.eleicaoonline.domain.Eleicao;
import br.com.eleicaoonline.domain.enums.SituacaoEleicao;
import br.com.eleicaoonline.exception.BusinessException;
import br.com.eleicaoonline.repository.EleicaoRepository;

@Component
public class EleicaoIniciadaFinalizadaValidation implements Validation<Eleicao> {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private EleicaoRepository repository;

	@Override
	public void validate(Eleicao eleicao) {
		Optional<Eleicao> optEleicao = repository.findById(eleicao.getId());
		if (optEleicao.isPresent() && (optEleicao.get().getSituacao().equals(SituacaoEleicao.INICIADA)
				|| optEleicao.get().getSituacao().equals(SituacaoEleicao.FINALIZADA))) {
			throw new BusinessException(messageSource.getMessage(ValidationMessageKey.ELEICAO_INICIADA_FINALIZADA, null, null));
		}

	}

}