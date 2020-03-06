package com.exact.buzon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exact.buzon.dao.IBuzonDAO;
import com.exact.buzon.entity.Buzon;
import com.exact.buzon.service.BuzonService;

@RestController
@RequestMapping("/buzones")
public class BuzonController {
	
	
	@Autowired
	@Qualifier("simpleBuzonDAO")
	IBuzonDAO buzondao;
	
	//FALTA EL AUTENTICATION //POR CONFIRMAR QUE SE VA A USAR
	
	BuzonService buzonservice;
	
	@GetMapping("/{textoo}")
	public ResponseEntity<Iterable<Buzon>> listarByPerfilId(@PathVariable String textoo){
		String texto = textoo;
		buzonservice = new BuzonService(buzondao);
		return new ResponseEntity<Iterable<Buzon>>(buzonservice.buscarBuzon(texto), HttpStatus.OK);
	}
	

}
