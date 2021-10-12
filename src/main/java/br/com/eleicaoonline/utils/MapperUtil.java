package br.com.eleicaoonline.utils;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapperUtil {

	@Autowired
	private ModelMapper modelMapper;

	public <S, D> D mapTo(S source, Class<D> destClass) {
		if (source != null) {
			return this.modelMapper.map(source, destClass);
		}
		return null;
	}

	public <S, D> List<D> toList(List<S> source, Type destClass) {
		if (source != null) {
			return this.modelMapper.map(source, destClass);
		}
		return null;
	}

}