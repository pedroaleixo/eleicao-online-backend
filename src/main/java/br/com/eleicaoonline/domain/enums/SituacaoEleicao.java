package br.com.eleicaoonline.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum SituacaoEleicao {

	CADASTRADA("Cadastrada", 0),

	INICIADA("Iniciada", 1),
	
	EM_PROCESSAMENTO("Em processamento", 2),
	
	PROCESSADA("Processada", 3),
	
	FALHA_PROCESSAMENTO("Falha no processamento", 4),

	FINALIZADA("Finalizada", 5);

	private String label;
	private int value;

	private SituacaoEleicao(String label, int value) {
		this.label = label;
		this.value = value;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	@JsonValue
	public String toString() {
		return String.valueOf(value);
	}

	@JsonCreator
	public static SituacaoEleicao fromValue(int text) {
		for (SituacaoEleicao b : SituacaoEleicao.values()) {
			if (b.value == text) {
				return b;
			}
		}
		return null;
	}

}
