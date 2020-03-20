package com.exact.buzon.dao;

import java.util.List;

import com.exact.buzon.entity.Buzon;

public interface IBuzonDAO {
	
	List<Buzon> buscarBuzonPorNombre(String texto);		
	List<Buzon> buscarBuzonesPorUsuarioId(Long usuarioId);	
	List<Buzon> buscarBuzonesPorUbicacionesIds(List<Long> ubicacionesIds);
	Buzon registrarBuzon(Buzon buzon);
	List<Buzon> listarBuzonesPorIds(List<Long> ids);

}
