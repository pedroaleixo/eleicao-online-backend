package br.com.eleicaoonline.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.eleicaoonline.service.ResultadoService;

@Transactional(rollbackOn = { Exception.class })
@Service
public class ResultadoServiceImpl implements ResultadoService {

}
