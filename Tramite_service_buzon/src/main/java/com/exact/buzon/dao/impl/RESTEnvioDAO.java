package com.exact.buzon.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.exact.buzon.client.IEnvioClient;
import com.exact.buzon.dao.IEnvioDAO;

@Component
@Qualifier("RESTEnvioDAO")
public class RESTEnvioDAO implements IEnvioDAO{
	
	@Autowired
	IEnvioClient envioClient;
	
	@Override
	public List<Long> listarPrimerosDestinatariosIdsPorRemitenteId(Long remitenteId, int cantidad) {
		return envioClient.listarDestinatariosIdsFrecuentesPorRemitenteId(remitenteId, cantidad);
		
	}
	
}
