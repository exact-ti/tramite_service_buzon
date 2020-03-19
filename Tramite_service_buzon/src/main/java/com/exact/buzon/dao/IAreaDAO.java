package com.exact.buzon.dao;

import java.util.List;
import java.util.Map;

public interface IAreaDAO {
	
	List<Map<String, Object>> listarAreasByCodigosUbicaciones(List<String> ids);
	
}
