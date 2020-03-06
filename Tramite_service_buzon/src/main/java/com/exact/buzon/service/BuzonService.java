package com.exact.buzon.service;

import com.exact.buzon.dao.IBuzonDAO;
import com.exact.buzon.entity.Buzon;

public class BuzonService {
	
	private IBuzonDAO buzondao;
	
	public BuzonService (IBuzonDAO buzondao) {
		this.buzondao = buzondao;
	}
	
	public Iterable<Buzon> buscarBuzon(String texto) {
		Iterable<Buzon> buzones = buzondao.buscarBuzon(texto);
		return buzones;
	}

}
