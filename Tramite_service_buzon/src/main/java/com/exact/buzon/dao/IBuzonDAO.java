package com.exact.buzon.dao;

import java.util.List;

import com.exact.buzon.entity.Buzon;

public interface IBuzonDAO {
	
	Iterable<Buzon> buscarBuzonPorNombre(String texto);	
	
	
	Iterable<Buzon> buscarBuzonesPorUsuarioId(Long usuarioId);	
		
	
	List<Buzon> buscarBuzonesPorUbicacionesIds(List<Long> ubicacionesIds);
	
	
	//Buzon crearBuzon(Long buzonId);

}
