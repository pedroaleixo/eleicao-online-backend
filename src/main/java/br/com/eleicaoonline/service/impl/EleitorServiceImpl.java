package br.com.eleicaoonline.service.impl;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;

import org.springframework.stereotype.Service;

import br.com.eleicaoonline.exception.BusinessException;
import br.com.eleicaoonline.exception.SystemException;
import br.com.eleicaoonline.service.EleitorService;

@Transactional(rollbackOn = { Exception.class, SystemException.class, BusinessException.class,
		ConstraintViolationException.class })
@Service
public class EleitorServiceImpl extends BaseService implements EleitorService {

}
