package br.com.eleicaoonline.domain.enums;

public enum TipoEstatistica {

	ELEITORADO_POR_SEXO(0),

	ELEITORADO_POR_FAIXA_ETARIA(1),

	ELEITORADO_POR_REGIAO(2),

	CANDIDATO_POR_SEXO(3),

	CANDIDATO_POR_FAIXA_ETARIA(4),

	DISTRIBUICAO_VOTANTES_DIA(5);
	
	
	private int value;

	private TipoEstatistica(int value) {
		this.value = value;
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
