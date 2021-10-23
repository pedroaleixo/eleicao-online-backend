package br.com.eleicaoonline.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class EstatisticaDTO  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<RegistroEstatisticaDTO> registros;
	
	private Integer totalElementos;

}
