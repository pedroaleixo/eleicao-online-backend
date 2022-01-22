package br.com.eleicaoonline.service.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import br.com.eleicaoonline.domain.Administrador;
import br.com.eleicaoonline.domain.Candidato;
import br.com.eleicaoonline.domain.Eleitor;
import br.com.eleicaoonline.domain.Pessoa;
import br.com.eleicaoonline.exception.BusinessException;
import br.com.eleicaoonline.repository.AdministradorRepository;
import br.com.eleicaoonline.repository.CandidatoRepository;
import br.com.eleicaoonline.repository.EleitorRepository;
import br.com.eleicaoonline.repository.PessoaRepository;

@Component
public class CPFCadastradoValidation implements Validation<Object> {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private PessoaRepository repository;
	
	@Autowired
	private CandidatoRepository candidatoRepository;
	
	@Autowired
	private EleitorRepository eleitorRepository;

	@Autowired
	private AdministradorRepository administradorRepository;

	@Override
	public void validate(Object obj) {
		boolean cpfCadastrado = false;

		if (obj != null) {
			if (obj instanceof Pessoa) {
				cpfCadastrado = repository.findByCpf(((Pessoa) obj).getCpf()) != null;
			} else if (obj instanceof Candidato) {
				Candidato c = ((Candidato) obj);
				cpfCadastrado = candidatoRepository.findByPessoaCpfAndEleicaoId(c.getPessoa().getCpf(), c.getEleicao().getId()) != null;
			} else if (obj instanceof Eleitor) {
				Eleitor e = ((Eleitor) obj);
				cpfCadastrado = eleitorRepository.findByPessoaCpfAndEleicaoId(e.getPessoa().getCpf(), e.getEleicao().getId()) != null;
			}  else if (obj instanceof Administrador) {
				cpfCadastrado = administradorRepository.findByPessoaCpf(((Administrador) obj).getPessoa().getCpf()) != null;
			}
			if (cpfCadastrado) {
				throw new BusinessException(
						messageSource.getMessage(ValidationMessageKey.CPF_CADASTRADO, null, null));
			}
		}
	}

}
