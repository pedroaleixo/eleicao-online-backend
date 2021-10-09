package br.com.eleicaoonline.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.eleicaoonline.domain.Pessoa;
import br.com.eleicaoonline.service.PessoaService;

@Transactional(rollbackOn = { Exception.class })
@Service
public class PessoaServiceImpl extends BaseService<Pessoa> implements PessoaService {

}
