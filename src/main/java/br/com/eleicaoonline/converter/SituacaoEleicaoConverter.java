package br.com.eleicaoonline.converter;

import javax.persistence.AttributeConverter;

import br.com.eleicaoonline.domain.enums.SituacaoEleicao;

public class SituacaoEleicaoConverter implements AttributeConverter<SituacaoEleicao, Integer> {
	
	@Override
	public Integer convertToDatabaseColumn(SituacaoEleicao from) {
		Integer value = SituacaoEleicao.CADASTRADA.getValue();
		
		if (from == SituacaoEleicao.INICIADA) {
			value = SituacaoEleicao.INICIADA.getValue();
		} else if (from == SituacaoEleicao.FINALIZADA) {
			value = SituacaoEleicao.FINALIZADA.getValue();
		}

		return value;
	}

	@Override
	public SituacaoEleicao convertToEntityAttribute(Integer to) {
		SituacaoEleicao s = SituacaoEleicao.CADASTRADA;
		
		if (SituacaoEleicao.INICIADA.getValue() == to) {
			s = SituacaoEleicao.INICIADA;
		} else if (SituacaoEleicao.FINALIZADA.getValue() == to) {
			s = SituacaoEleicao.FINALIZADA;
		}
		return s;
	}
}
