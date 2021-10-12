package br.com.eleicaoonline.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.eleicaoonline.service.CandidatoService;

@Transactional(rollbackOn = { Exception.class })
@Service
public class CandidatoServiceImpl extends BaseService implements CandidatoService {

}
