package br.com.eleicaoonline.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.eleicaoonline.domain.Voto;
import br.com.eleicaoonline.service.VotoService;

@Transactional(rollbackOn = { Exception.class })
@Service
public class VotoServiceImpl extends BaseService<Voto> implements VotoService {

}
