package br.com.eleicaoonline.domain.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TipoEstatistica {

	ELEITORADO_POR_SEXO("Eleitorado por sexo", 0),

	ELEITORADO_POR_FAIXA_ETARIA("Eleitorado por faixa etária", 1),

	CANDIDATO_POR_SEXO("Candidato por sexo", 2),

	CANDIDATO_POR_FAIXA_ETARIA("Candidato  por faixa etária", 3),

	DISTRIBUICAO_VOTANTES_DIA("Distribuição de votantes por dia", 4);

	private String label;
	private int value;

	private TipoEstatistica(String label, int value) {
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

	public static TipoEstatistica fromValue(int value) {
		for (TipoEstatistica b : TipoEstatistica.values()) {
			if (b.value == value) {
				return b;
			}
		}
		return null;
	}

}
