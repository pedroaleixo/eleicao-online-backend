package br.com.eleicaoonline.converter;

import javax.persistence.AttributeConverter;

import br.com.eleicaoonline.domain.enums.Genero;

public class GeneroConverter implements AttributeConverter<Genero, String> {

	@Override
	public String convertToDatabaseColumn(Genero from) {
		String value = null;

		if (from != null) {
			if (from == Genero.FEMININO) {
				value = Genero.FEMININO.getValue();
			} else if (from == Genero.MASCULINO) {
				value = Genero.MASCULINO.getValue();
			} else if (from == Genero.OUTRO) {
				value = Genero.OUTRO.getValue();
			}
		}

		return value;
	}

	@Override
	public Genero convertToEntityAttribute(String to) {
		Genero g = null;
		if (to != null) {
			if (Genero.FEMININO.getValue().equals(to)) {
				g = Genero.FEMININO;
			} else if (Genero.MASCULINO.getValue().equals(to)) {
				g = Genero.MASCULINO;
			} else if (Genero.OUTRO.getValue().equals(to)) {
				g = Genero.OUTRO;
			}
		}
		return g;
	}
}
