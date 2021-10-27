package br.com.eleicaoonline.converter;

import javax.persistence.AttributeConverter;

import br.com.eleicaoonline.domain.enums.SituacaoEleicao;

public class SituacaoEleicaoConverter implements AttributeConverter<SituacaoEleicao, Integer> {

	@Override
	public Integer convertToDatabaseColumn(SituacaoEleicao from) {
		Integer value = SituacaoEleicao.CADASTRADA.getValue();

		switch (from) {
		case INICIADA:
			value = SituacaoEleicao.INICIADA.getValue();
			break;
		case EM_PROCESSAMENTO:
			value = SituacaoEleicao.EM_PROCESSAMENTO.getValue();
			break;
		case PROCESSADA:
			value = SituacaoEleicao.PROCESSADA.getValue();
			break;
		case FALHA_PROCESSAMENTO:
			value = SituacaoEleicao.FALHA_PROCESSAMENTO.getValue();
			break;
		case FINALIZADA:
			value = SituacaoEleicao.FINALIZADA.getValue();
			break;
		default:
			value = SituacaoEleicao.CADASTRADA.getValue();
			break;
		}

		return value;
	}

	@Override
	public SituacaoEleicao convertToEntityAttribute(Integer to) {
		SituacaoEleicao s = SituacaoEleicao.CADASTRADA;

		if (SituacaoEleicao.INICIADA.getValue() == to) {
			s = SituacaoEleicao.INICIADA;
		} else if (SituacaoEleicao.EM_PROCESSAMENTO.getValue() == to) {
			s = SituacaoEleicao.EM_PROCESSAMENTO;
		} else if (SituacaoEleicao.PROCESSADA.getValue() == to) {
			s = SituacaoEleicao.PROCESSADA;
		} else if (SituacaoEleicao.FALHA_PROCESSAMENTO.getValue() == to) {
			s = SituacaoEleicao.FALHA_PROCESSAMENTO;
		} else if (SituacaoEleicao.FINALIZADA.getValue() == to) {
			s = SituacaoEleicao.FINALIZADA;
		}

		return s;
	}
}
