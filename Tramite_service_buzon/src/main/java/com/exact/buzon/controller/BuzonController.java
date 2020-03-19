package com.exact.buzon.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exact.buzon.dao.IBuzonDAO;
import com.exact.buzon.entity.Buzon;
import com.exact.buzon.service.BuzonService;
import com.exact.commons.auth.UserAuthenticated;

@RestController
@RequestMapping("/buzones")
public class BuzonController {

	@Autowired
	@Qualifier("simpleBuzonDAO")
	IBuzonDAO buzondao;

	// FALTA EL AUTENTICATION //POR CONFIRMAR QUE SE VA A USAR

	BuzonService buzonservice;

	@GetMapping("/{textoo}")
	public ResponseEntity<Iterable<Buzon>> buscarBuzon(@PathVariable String textoo) {
		String texto = textoo;
		buzonservice = new BuzonService(buzondao);
		return new ResponseEntity<Iterable<Buzon>>(buzonservice.buscarBuzonPorNombre(texto), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<Iterable<Buzon>> buscarBuzonesPorUsuarioId(Authentication authentication) {

		UserAuthenticated usuario = (UserAuthenticated) authentication.getPrincipal();
		Long id = Long.valueOf(usuario.getName());
		buzonservice = new BuzonService(buzondao);
		return new ResponseEntity<Iterable<Buzon>>(buzonservice.buscarBuzonesPorUsuarioId(id), HttpStatus.OK);
	}

	@GetMapping(params = "ids")
	public ResponseEntity<List<Buzon>> buscarBuzonesPorUbicacionesIds(@RequestParam("ids") List<Long> ubicacionesIds) {
		buzonservice = new BuzonService(buzondao);
		return new ResponseEntity<List<Buzon>>(buzonservice.buscarBuzonesPorUbicacionesIds(ubicacionesIds),
				HttpStatus.OK);
	}

	// @GetMapping("/{id}/destinatariosfrecuentes")
//	public ResponseEntity<List<Buzon>> 

	/*
	 * //CREAR UN BUZON
	 * 
	 * @PostMapping public ResponseEntity<Buzon> crearNuevoBuzon(@RequestBody Buzon
	 * buzon){ try { return new ResponseEntity<>(buzonservice.crearBuzon(buzon),
	 * HttpStatus.OK); } catch (Exception e) { return new
	 * ResponseEntity<>(HttpStatus.BAD_REQUEST); } }
	 */

}
