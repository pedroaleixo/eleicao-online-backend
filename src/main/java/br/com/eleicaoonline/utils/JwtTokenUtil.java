package br.com.eleicaoonline.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import br.com.eleicaoonline.domain.Eleicao;
import br.com.eleicaoonline.domain.Pessoa;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil implements Serializable {
	
	private static final String PERFIS = "perfis";
	private static final String PESSOA = "pessoa";
	private static final String ELEICOES = "eleicoes";
	private static final long serialVersionUID = -2550185165626007488L;
	public static final long JWT_TOKEN_VALIDITY = 15 * 60;

	@Value("${jwt.secret}")
	private String secret;

	//retorna o username do token jwt 
	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}

	//retorna expiration date do token jwt 
	public Date getExpirationDateFromToken(String token) {	
		return getClaimFromToken(token, Claims::getExpiration);
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getPerfisFromToken(String token) {
		if(token != null) {
			List<String> stringPerfis = (List<String>) getAllClaimsFromToken(token).get("perfis");	
			return stringPerfis;
		}
		
		return new ArrayList<String>();
	}

	//para retornar qualquer informação do token nos iremos precisar da secret key
	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

	
	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}		
	
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();		
		final String authorities = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));		
		claims.put(PERFIS, authorities);			
		return doGenerateToken(claims, userDetails.getUsername());
	}
	
	public String generateToken(UserDetails userDetails, Pessoa pessoa, List<Eleicao> eleicoes) {
		Map<String, Object> claims = new HashMap<>();		
		final List<String> authorities = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());		
		
		List<Long> idEleicoes = new ArrayList<Long>();
		if(eleicoes != null && !eleicoes.isEmpty()) {
			idEleicoes = eleicoes.stream().map(Eleicao::getId).collect(Collectors.toList());
		}		
		
		claims.put(PERFIS, authorities);	
		claims.put(PESSOA, pessoa.getId());
		claims.put(ELEICOES, idEleicoes);
		return doGenerateToken(claims, userDetails.getUsername());
	}
	
	

	//Cria o token e define tempo de expiração pra ele
	private String doGenerateToken(Map<String, Object> claims, String subject) {
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	//valida o token
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

}