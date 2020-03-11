package com.exact.buzon.filter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.BeanIds;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
	
	private String key;
	Properties properties;

	
	public JWTAuthorizationFilter(AuthenticationManager authenticationManager) throws IOException {
		super(authenticationManager);
		properties = new Properties();
		InputStream input = new FileInputStream("./secret.properties");
		properties.load(input);
		key = properties.getProperty("jwt.key");
	}
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String header = request.getHeader("Authorization");

		if (header == null) {
			return;
		}

		String token = header.replace("Bearer ", "");

		if (token == null) {
			return;
		}

		Claims claims = null;

		try {
			claims = Jwts.parser().setSigningKey(key.getBytes()).parseClaimsJws(token).getBody();
		} catch (ExpiredJwtException eje) {
			response.setStatus(894);
			response.sendError(894, "EL TOKEN ENVIADO HA EXPIRADO");
			return;
		} catch (MalformedJwtException mje) {
			response.setStatus(498);
			response.sendError(498, "EL TOKEN ENVIADO ES INVÁLIDO");
			return;
		} catch (SignatureException se) {
			response.setStatus(498);
			response.sendError(498, "EL TOKEN ENVIADO ES INVÁLIDO");
			return;
		}

		UsernamePasswordAuthenticationToken authentication = null;
		Long usuarioId = Long.valueOf(claims.get("id").toString());
		Map<String, Object> datosUsuario = new HashMap<String, Object>();
		datosUsuario.put("id", usuarioId);
		Object authoritiesJson = claims.get("authorities");
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		
		((ArrayList<String>) authoritiesJson).forEach(authority -> {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority);
			authorities.add(grantedAuthority);
		});
		
		authentication = new UsernamePasswordAuthenticationToken(datosUsuario, null, authorities);		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		super.doFilterInternal(request, response, chain);
	}

}
