package com.exact.buzon.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.exact.buzon.client.IUbicacionClient;
import com.exact.buzon.dao.IAreaDAO;

@Component
@Qualifier("RESTAreaDAO")
public class RESTAreaDAO implements IAreaDAO {
	
	@Autowired
	IUbicacionClient ubicacionClient;
	
	@Override
	public List<Map<String, Object>> listarAreasByCodigosUbicaciones(List<String> ids) {
		return ubicacionClient.listarAreasByCodigosUbicaciones(ids);
	}

}
