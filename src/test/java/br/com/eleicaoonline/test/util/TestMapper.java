package br.com.eleicaoonline.test.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.eleicaoonline.dto.AdministradorDTO;
import br.com.eleicaoonline.dto.CandidatoDTO;
import br.com.eleicaoonline.dto.CargoDTO;
import br.com.eleicaoonline.dto.EleicaoDTO;
import br.com.eleicaoonline.dto.EleitorDTO;

@Component
public class TestMapper {

	@Autowired
	private ObjectMapper objectMapper;

	@SuppressWarnings("rawtypes")
	public List deserializePageToList(String actualResult, Class clazz)
			throws JsonProcessingException, JsonMappingException {
		JsonNode contentNode = objectMapper.readTree(actualResult).findValue("content");

		if (clazz.equals(AdministradorDTO.class)) {
			return objectMapper.readValue(contentNode.toString(), new TypeReference<List<AdministradorDTO>>() {
			});
		} else if (clazz.equals(CandidatoDTO.class)) {
			return objectMapper.readValue(contentNode.toString(), new TypeReference<List<CandidatoDTO>>() {
			});
		} else if (clazz.equals(EleitorDTO.class)) {
			return objectMapper.readValue(contentNode.toString(), new TypeReference<List<EleitorDTO>>() {
			});
		} else if (clazz.equals(EleicaoDTO.class)) {
			return objectMapper.readValue(contentNode.toString(), new TypeReference<List<EleicaoDTO>>() {
			});
		}

		return null;
	}
	
	@SuppressWarnings("rawtypes")
	public List deserializeToList(String actualResult, Class clazz)
			throws JsonProcessingException, JsonMappingException {		

		if (clazz.equals(AdministradorDTO.class)) {
			return objectMapper.readValue(actualResult, new TypeReference<List<AdministradorDTO>>() {
			});
		} else if (clazz.equals(CandidatoDTO.class)) {
			return objectMapper.readValue(actualResult, new TypeReference<List<CandidatoDTO>>() {
			});
		} else if (clazz.equals(EleitorDTO.class)) {
			return objectMapper.readValue(actualResult, new TypeReference<List<EleitorDTO>>() {
			});
		} else if (clazz.equals(EleicaoDTO.class)) {
			return objectMapper.readValue(actualResult, new TypeReference<List<EleicaoDTO>>() {
			});
		}  else if (clazz.equals(CargoDTO.class)) {
			return objectMapper.readValue(actualResult, new TypeReference<List<CargoDTO>>() {
			});
		}

		return null;
	}

	public <T> T deserializeToObject(String actualResult, Class<T> clazz)
			throws JsonProcessingException, JsonMappingException {
		JsonNode contentNode = objectMapper.readTree(actualResult);
		return objectMapper.readValue(contentNode.toString(), clazz);
	}

}
