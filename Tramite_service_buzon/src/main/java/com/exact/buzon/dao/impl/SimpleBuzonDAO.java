package com.exact.buzon.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.exact.buzon.dao.IBuzonDAO;
import com.exact.buzon.entity.Buzon;
import com.exact.buzon.repository.ISimpleBuzonRepository;

@Component
@Qualifier("SimpleBuzonDAO")
public class SimpleBuzonDAO implements IBuzonDAO{

	@Autowired
	ISimpleBuzonRepository buzonRepository;
	
	
	@Override
	public List<Buzon> buscarBuzonPorNombre(String texto) {
		List<Buzon> buzones = buzonRepository.findBuzonesByNombreContaining(texto);
		return buzones;
	}	
	
	
		
	@Override
	public List<Buzon> buscarBuzonesPorUsuarioId(Long usuarioId) {
		List<Buzon> buzones = buzonRepository.findBuzonesByUsuarioId(usuarioId);		
		return buzones;
	}
	
	
	@Override
	public List<Buzon> listarBuzonesPorCodigosUbicaciones(List<String> codigosUbicaciones) {
		List<Buzon> buzones = (List<Buzon>) buzonRepository.findByUbicacionCodigoIn(codigosUbicaciones);
		return buzones;
	}


	@Override
	public Buzon registrarBuzon(Buzon buzon) {
		return buzonRepository.save(buzon);
	}


	@Override
	public List<Buzon> listarBuzonesPorIds(List<Long> ids) {
		return (List<Buzon>) buzonRepository.findAllById(ids);
	}
	
	
	

	

}
