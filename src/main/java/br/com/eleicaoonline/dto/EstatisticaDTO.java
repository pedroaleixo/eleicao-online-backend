package br.com.eleicaoonline.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class EstatisticaDTO  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<RegistroEstatisticaDTO> registros = new ArrayList<>();
	
	private Integer totalElementos;	
	
	public void addRegistro(RegistroEstatisticaDTO registro) {
		registros.add(registro);
	}

}
