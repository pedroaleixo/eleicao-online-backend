package br.com.eleicaoonline.converter;

import javax.persistence.AttributeConverter;

import br.com.eleicaoonline.domain.enums.Genero;

public class GeneroConverter implements AttributeConverter<Genero, Character> {
	
	@Override
	public Character convertToDatabaseColumn(Genero from) {

		Character value = 'O';

		if (from == Genero.FEMININO) {
			value = 'F';
		} else if (from == Genero.MASCULINO) {
			value = 'M';
		}

		return value;
	}

	@Override
	public Genero convertToEntityAttribute(Character to) {
		Genero g = Genero.OUTRO;
		
		if ('F' == to) {
			g = Genero.FEMININO;
		} else if ('M' == to) {
			g = Genero.MASCULINO;
		}
		return g;
	}
}
