package com.exact.buzon.service;

import java.util.List;
import com.exact.buzon.dao.IBuzonDAO;
import com.exact.buzon.entity.Buzon;

public class BuzonService {
	
	private IBuzonDAO buzondao;
	
	public BuzonService (IBuzonDAO buzondao) {
		this.buzondao = buzondao;
	}
	
	
	public Iterable<Buzon> buscarBuzonPorNombre(String texto) {
		Iterable<Buzon> buzones = buzondao.buscarBuzonPorNombre(texto);
		return buzones;
	}	
	
	
	public List<Buzon> buscarBuzonesPorUsuarioId(Long usuarioId){
		List<Buzon> buzones = buzondao.buscarBuzonesPorUsuarioId(usuarioId);
		return buzones;
	}
	
	
	public List<Buzon> buscarBuzonesPorUbicacionesIds (List<Long> ubicacionesIds) {		
		List<Buzon> buzones = buzondao.buscarBuzonesPorUbicacionesIds(ubicacionesIds);
		return buzones;
	}
	
	
	
	/*
	public Buzon listarBuzonesByUsuarioId(Long id) {
		if (buzon.getId() == null) {
			return null;
		}		
		return null;
	}
	*/
	
	
	
	

}
