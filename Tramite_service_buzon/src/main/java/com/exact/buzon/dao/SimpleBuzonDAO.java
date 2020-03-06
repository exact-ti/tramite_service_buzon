package com.exact.buzon.dao;

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
	public Iterable<Buzon> buscarBuzon(String texto) {
		Iterable<Buzon> buzones = simplebuzonrepository.findBuzonesByNombre(texto);
		return buzones;
	}
}
