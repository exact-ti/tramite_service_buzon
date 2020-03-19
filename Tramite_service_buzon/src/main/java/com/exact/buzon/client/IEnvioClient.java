package com.exact.buzon.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("servicio-tramite")
public interface IEnvioClient {
	
	@GetMapping("/buzones/{id}/destinatariosfrecuentes")
	List<Long> listarDestinatariosIdsFrecuentesPorRemitenteId(@PathVariable("id") Long id, @RequestParam("cantidad") int cantidad);
	
}
