package br.com.eleicaoonline.exception.response;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ValidationExceptionResponse {
	private List<Violation> violations = new ArrayList<>();

}
