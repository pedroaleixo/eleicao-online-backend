package br.com.eleicaoonline.domain.enums;

public enum Genero {
	
	MASCULINO("masculino"),

	FEMININO("feminino");

	private String value;

	private Genero(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}

	public static Genero fromValue(String text) {
		for (Genero b : Genero.values()) {
			if (String.valueOf(b.value).equals(text)) {
				return b;
			}
		}
		return null;
	}
}