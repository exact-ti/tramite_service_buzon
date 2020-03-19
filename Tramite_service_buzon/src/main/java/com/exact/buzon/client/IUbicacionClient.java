package com.exact.buzon.client;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("servicio-ubicacion")
public interface IUbicacionClient {
	
	@GetMapping("/areas")
	List<Map<String, Object>> listarAreasByCodigosUbicaciones(@RequestParam("codigos") List<String> ids);
	
	
}
