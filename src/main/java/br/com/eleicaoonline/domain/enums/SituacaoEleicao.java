package br.com.eleicaoonline.domain.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum SituacaoEleicao {

	CADASTRADA("Cadastrada", 0),

	INICIADA("Iniciada", 1),

	FINALIZADA("Finalizada", 2);

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
	public String toString() {
		return String.valueOf(value);
	}

	public static SituacaoEleicao fromValue(int text) {
		for (SituacaoEleicao b : SituacaoEleicao.values()) {
			if (b.value == text) {
				return b;
			}
		}
		return null;
	}

}
