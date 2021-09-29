package br.com.eleicaoonline.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SituacaoEnum {
	CADASTRADA("cadastrada"),

	INICIADA("iniciada"),

	FINALIZADA("finalizada");

	private String value;

	SituacaoEnum(String value) {
		this.value = value;
	}

	@Override
	@JsonValue
	public String toString() {
		return String.valueOf(value);
	}

	@JsonCreator
	public static SituacaoEnum fromValue(String text) {
		for (SituacaoEnum b : SituacaoEnum.values()) {
			if (String.valueOf(b.value).equals(text)) {
				return b;
			}
		}
		return null;
	}

}
