package com.exact.buzon.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.exact.buzon.entity.Buzon;
import com.exact.buzon.repository.ISimpleBuzonRepository;

@Component
@Qualifier("simpleBuzonDAO")
public class SimpleBuzonDAO implements IBuzonDAO{

	@Autowired
	ISimpleBuzonRepository simplebuzonrepository;
	
	
	@Override
	public Iterable<Buzon> buscarBuzonPorNombre(String texto) {
		Iterable<Buzon> buzones = simplebuzonrepository.findBuzonesByNombre(texto);
		return buzones;
	}	
	
		
	@Override
	public List<Buzon> buscarBuzonesPorUsuarioId(Long usuarioId) {
		List<Buzon> buzones = simplebuzonrepository.findBuzonesByUsuarioId(usuarioId);		
		return buzones;
	}
	
	
	@Override
	public List<Buzon> buscarBuzonesPorUbicacionesIds(List<Long> ubicacionesIds) {
		List<Buzon> buzones = (List<Buzon>) simplebuzonrepository.findByUbicacionIdIn(ubicacionesIds);
		return buzones;
	}


	@Override
	public Buzon registrarBuzon(Buzon buzon) {
		return simplebuzonrepository.save(buzon);
	}
	
	
	

	

}
