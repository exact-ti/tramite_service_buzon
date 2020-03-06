package com.exact.buzon.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exact.buzon.entity.Buzon;

@Repository
public interface ISimpleBuzonRepository extends CrudRepository<Buzon, String> {

	@Query(value="Select * From buzon where nombre like '%' + ?1 + '%' or ubicacion_nombre like '%' + ?1 + '%'", nativeQuery=true)
	public Iterable<Buzon> findBuzonesByNombre(String texto);
	
}
