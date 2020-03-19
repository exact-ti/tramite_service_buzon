package com.exact.buzon.dao;

import java.util.List;

public interface IEnvioDAO {
	
	List<Long> listarPrimerosDestinatariosIdsPorRemitenteId(Long remitenteId, int cantidad); 
}
