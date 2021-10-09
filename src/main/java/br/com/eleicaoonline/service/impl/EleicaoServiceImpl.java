package br.com.eleicaoonline.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.eleicaoonline.domain.Eleicao;
import br.com.eleicaoonline.service.EleicaoService;

@Transactional(rollbackOn = { Exception.class })
@Service
public class EleicaoServiceImpl extends BaseService<Eleicao> implements EleicaoService {

}
