package br.com.eleicaoonline.service.validation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import br.com.eleicaoonline.domain.Candidato;
import br.com.eleicaoonline.domain.Eleicao;
import br.com.eleicaoonline.domain.Eleitor;
import br.com.eleicaoonline.domain.enums.SituacaoEleicao;
import br.com.eleicaoonline.exception.BusinessException;
import br.com.eleicaoonline.exception.SystemException;
import br.com.eleicaoonline.repository.EleicaoRepository;

@Component
public class EleicaoNaoCadastradaValidation implements Validation<Object> {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private EleicaoRepository repository;

	@Override
	public void validate(Object obj) {
		Eleicao eleicao = null;

		if (obj != null) {
			if (obj instanceof Eleicao) {
				eleicao = (Eleicao) obj;
			} else if (obj instanceof Candidato) {
				eleicao = ((Candidato) obj).getEleicao();
			} else if (obj instanceof Eleitor) {
				eleicao = ((Eleitor) obj).getEleicao();
			}
			Optional<Eleicao> optEleicao = repository.findById(eleicao.getId());
			if (optEleicao.isPresent() && !optEleicao.get().getSituacao().equals(SituacaoEleicao.CADASTRADA)) {
				throw new BusinessException(
						messageSource.getMessage(ValidationMessageKey.ELEICAO_NAO_CADASTRADA, null, null));
			}
		} else {
			throw new SystemException(
					messageSource.getMessage(ValidationMessageKey.ENTIDADE_NAO_EXISTENTE, null, null));
		}

	}

}