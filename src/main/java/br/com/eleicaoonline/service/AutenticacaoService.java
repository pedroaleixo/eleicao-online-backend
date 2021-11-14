package br.com.eleicaoonline.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.eleicaoonline.constants.Perfis;
import br.com.eleicaoonline.domain.Administrador;
import br.com.eleicaoonline.domain.Eleicao;
import br.com.eleicaoonline.domain.Eleitor;
import br.com.eleicaoonline.domain.Pessoa;
import br.com.eleicaoonline.utils.JwtTokenUtil;
import lombok.extern.java.Log;

@Log
@Transactional(rollbackFor = { Exception.class })
@Service
public class AutenticacaoService extends BaseService {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private AdministradorService administradorService;

	@Autowired
	private PessoaService pessoaService;

	@Autowired
	private EleicaoService eleicaoService;

	@Autowired
	private EleitorService eleitorService;

	public String gerarToken(String email, String nome, boolean url) {
		log.info("Executando gerarToken");
		
		List<GrantedAuthority> authorithies = new ArrayList<>();
		List<Eleicao> eleicoesAssociadas = new ArrayList<Eleicao>();
		Pessoa pessoa = null;

		Administrador admin = administradorService.buscarAdministradorPeloEmail(email);
		if (admin != null) {
			pessoa = admin.getPessoa();
			authorithies.add(new SimpleGrantedAuthority(Perfis.ADMINISTRADOR));
		}

		Pessoa membro = eleicaoService.buscarMembroComissaoEleitoralPeloEmail(email);
		if (membro != null) {
			pessoa = membro;
			authorithies.add(new SimpleGrantedAuthority(Perfis.COMISSAO));
		}

		List<Eleitor> eleitores = eleitorService.buscarEleitorPeloEmail(email);
		if (eleitores != null && !eleitores.isEmpty()) {
			for (Eleitor eleitor : eleitores) {
				pessoa = eleitor.getPessoa();
				eleicoesAssociadas.add(eleitor.getEleicao());
			}
			authorithies.add(new SimpleGrantedAuthority(Perfis.ELEITOR));
		}

		String token = "";
		if (authorithies.isEmpty()) {
			pessoa = pessoaService.buscarPessoaPeloEmail(email);
			if (pessoa != null) {
				authorithies.add(new SimpleGrantedAuthority(Perfis.PESSOA));
			}
		} 
		
		if (!authorithies.isEmpty()) {
			if(url) {
			token = "?token="
					+ jwtTokenUtil.generateToken(new User(nome, "", authorithies), pessoa, eleicoesAssociadas);
			} else {
				token = jwtTokenUtil.generateToken(new User(nome, "", authorithies), pessoa, eleicoesAssociadas);
			}
			}
		return token;

	}

}
