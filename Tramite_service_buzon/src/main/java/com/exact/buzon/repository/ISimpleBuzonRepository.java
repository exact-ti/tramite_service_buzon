package com.exact.buzon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exact.buzon.entity.Buzon;

@Repository
public interface ISimpleBuzonRepository extends CrudRepository<Buzon, Long> {

	public List<Buzon> findBuzonesByNombreContaining(String texto);
	
	public List<Buzon> findBuzonesByUsuarioId(Long usuarioId);
	
	public List<Buzon> findByUbicacionCodigoIn(List<String> codigosUbicaciones);
	
	
	//CrudRepository -> save
	//----------------------
	
	
}
