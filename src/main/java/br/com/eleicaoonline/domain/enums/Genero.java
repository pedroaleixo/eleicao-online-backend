package br.com.eleicaoonline.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Genero {
	
	MASCULINO("Masculino", "M"),

	FEMININO("Feminino", "F"),

	OUTRO("Outro", "O");

	private String label;
	private String value;

	private Genero(String label, String value) {
		this.label = label;
		this.value = value;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	@JsonValue
	public String toString() {
		return String.valueOf(value);
	}

	@JsonCreator
	public static Genero fromValue(String text) {
		for (Genero b : Genero.values()) {
			if (String.valueOf(b.value).equals(text)) {
				return b;
			}
		}
		return null;
	}
}