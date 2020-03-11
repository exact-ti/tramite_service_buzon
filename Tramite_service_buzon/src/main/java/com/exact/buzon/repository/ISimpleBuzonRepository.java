package com.exact.buzon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exact.buzon.entity.Buzon;

@Repository
public interface ISimpleBuzonRepository extends CrudRepository<Buzon, String> {

	@Query(value="Select * From buzon where nombre like '%' + ?1 + '%' or ubicacion_nombre like '%' + ?1 + '%'", nativeQuery=true)
	public Iterable<Buzon> findBuzonesByNombre(String texto);
	
	@Query(value="Select * from buzon b where b.buzon_id = ?1", nativeQuery = true)
	public Iterable<Buzon> findBuzonesByUsuarioId(Long usuarioId);
	
	//CrudRepository -> findByUbicacionIdIn (método del CrudRepository que busca una lista de ids separadas por comas que no sean la id de la misma tabla)
	public List<Buzon> findByUbicacionIdIn(List<Long> ubicacionesIds);
	
	
	//CrudRepository -> save
	//----------------------
	
	
}
