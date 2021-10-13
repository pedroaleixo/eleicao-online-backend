package br.com.eleicaoonline.utils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
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
		List<D> targetList = new ArrayList<D>();
		if (source != null) {
			source.stream().forEach(e -> targetList.add(this.modelMapper.map(e, destClass)));
			return targetList;
		}
		return null;
	}

	public <S, D> Page<D> toPage(Page<S> source, Type destClass) {
		if (source != null) {
			return new PageImpl<D>(this.toList(source.getContent(), destClass), source.getPageable(),
					source.getTotalElements());
		}
		return null;
	}

}