package br.com.eleicaoonline.converter;

import javax.persistence.AttributeConverter;

import br.com.eleicaoonline.domain.enums.Genero;

public class GeneroConverter implements AttributeConverter<Genero, String> {
	
	@Override
	public String convertToDatabaseColumn(Genero from) {
		String value = Genero.OUTRO.getValue();

		if (from == Genero.FEMININO) {
			value = Genero.FEMININO.getValue();
		} else if (from == Genero.MASCULINO) {
			value = Genero.MASCULINO.getValue();
		}

		return value;
	}

	@Override
	public Genero convertToEntityAttribute(String to) {
		Genero g = Genero.OUTRO;
		
		if (Genero.FEMININO.getValue().equals(to)) {
			g = Genero.FEMININO;
		} else if (Genero.MASCULINO.getValue().equals(to)) {
			g = Genero.MASCULINO;
		}
		return g;
	}
}
