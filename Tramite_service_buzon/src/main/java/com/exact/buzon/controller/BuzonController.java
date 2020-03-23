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

import com.exact.buzon.dao.IAreaDAO;
import com.exact.buzon.dao.IBuzonDAO;
import com.exact.buzon.dao.IEnvioDAO;
import com.exact.buzon.dto.BuzonDTO;
import com.exact.buzon.entity.Buzon;
import com.exact.buzon.service.BuzonService;
import com.exact.commons.auth.UserAuthenticated;

@RestController
@RequestMapping("/buzones")
public class BuzonController {

	@Autowired
	@Qualifier("SimpleBuzonDAO")
	IBuzonDAO simpleBuzonDAO;
	
	@Autowired
	@Qualifier("RESTEnvioDAO")
	IEnvioDAO restEnvioDAO;
	
	@Autowired
	@Qualifier("RESTAreaDAO")
	IAreaDAO restAreaDAO;

	BuzonService buzonService;

	@GetMapping(params = "filtro")
	public ResponseEntity<Iterable<BuzonDTO>> buscarBuzonesPorNombre(@RequestParam String filtro) {
		buzonService = new BuzonService(simpleBuzonDAO, restEnvioDAO, restAreaDAO);
		return new ResponseEntity<Iterable<BuzonDTO>>(buzonService.buscarBuzonPorNombre(filtro), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<Iterable<Buzon>> buscarBuzonesPorUsuarioId(Authentication authentication) {

		UserAuthenticated usuario = (UserAuthenticated) authentication.getPrincipal();
		Long id = Long.valueOf(usuario.getName());
		buzonService = new BuzonService(simpleBuzonDAO, restAreaDAO);
		return new ResponseEntity<Iterable<Buzon>>(buzonService.buscarBuzonesPorUsuarioId(id), HttpStatus.OK);
	}

	@GetMapping(params = "codigosUbicaciones")
	public ResponseEntity<List<Buzon>> listarBuzonesPorCodigosUbicaciones(@RequestParam("codigosUbicaciones") List<String> codigosUbicaciones) {
		buzonService = new BuzonService(simpleBuzonDAO);
		return new ResponseEntity<List<Buzon>>(buzonService.listarBuzonesPorCodigosUbicaciones(codigosUbicaciones),
				HttpStatus.OK);
	}

	@GetMapping("/{id}/destinatariosfrecuentes")
	public ResponseEntity<List<BuzonDTO>> listarDestinatariosFrecuentes(@PathVariable("id") Long id, @RequestParam("cantidad") int cantidad){
		buzonService = new BuzonService(simpleBuzonDAO, restEnvioDAO, restAreaDAO);
		return new ResponseEntity<List<BuzonDTO>>(buzonService.listarDestinatariosFrecuentes(id, cantidad), HttpStatus.OK);
	}
}
