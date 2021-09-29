package br.com.eleicaoonline.domain.enums;

public enum GeneroEnum {
	MASCULINO("masculino"),

	FEMININO("feminino");

	private String value;

	GeneroEnum(String value) {
		this.value = value;
	}

	@Override

	public String toString() {
		return String.valueOf(value);
	}

	public static GeneroEnum fromValue(String text) {
		for (GeneroEnum b : GeneroEnum.values()) {
			if (String.valueOf(b.value).equals(text)) {
				return b;
			}
		}
		return null;
	}
}