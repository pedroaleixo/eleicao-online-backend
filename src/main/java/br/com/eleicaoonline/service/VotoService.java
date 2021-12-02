package br.com.eleicaoonline.service;

import java.util.Arrays;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.eleicaoonline.domain.Eleitor;
import br.com.eleicaoonline.domain.Voto;
import br.com.eleicaoonline.repository.EleitorRepository;
import br.com.eleicaoonline.repository.VotoRepository;
import br.com.eleicaoonline.service.validation.EleicaoNaoIniciadaValidation;
import br.com.eleicaoonline.utils.CryptoUtil;
import br.com.eleicaoonline.utils.RSAUtil;
import lombok.extern.java.Log;

@Log
@Transactional(rollbackFor = { Exception.class })
@Service
public class VotoService extends BaseService {
	
	@Autowired
	private VotoRepository repository;
	
	@Autowired
	private EleitorRepository eleitorRepository;
	
	@Autowired
	protected EleicaoNaoIniciadaValidation eleicaoNaoIniciadaValidation;

	public void cadastrarVoto(Voto voto, Long idPessoa) {
		log.info("Executando cadastrarVoto");
		
		validateEntity(voto);
		
		validateBusiness(voto, Arrays.asList(eleicaoNaoIniciadaValidation));
		
		repository.save(voto);	
		
		Eleitor eleitor = eleitorRepository.findEleitorByPessoaId(idPessoa, voto.getEleicao().getId());
		if(eleitor != null) {			
			eleitor.setDataHoraVotou(Calendar.getInstance().getTime());
			eleitorRepository.save(eleitor);
		}
			
	}

	public String obterChavePublica() {
		String chavePublica = CryptoUtil.getPublicKeyAsString();
        return RSAUtil.pemStringPrint(chavePublica);
	}
	

}
