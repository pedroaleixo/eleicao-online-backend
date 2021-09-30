package br.com.eleicaoonline.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.eleicaoonline.service.EleitorService;

@Transactional(rollbackOn = { Exception.class })
@Service
public class EleitorServiceImpl implements EleitorService {

}
