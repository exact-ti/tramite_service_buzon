package com.exact.buzon.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.exact.buzon.dao.IAreaDAO;
import com.exact.buzon.dao.IBuzonDAO;
import com.exact.buzon.dao.IEnvioDAO;
import com.exact.buzon.dto.DestinatarioFrecuenteDTO;
import com.exact.buzon.entity.Buzon;

public class BuzonService {

	private IBuzonDAO buzonDAO;

	private IEnvioDAO envioDAO;

	private IAreaDAO areaDAO;

	public BuzonService(IBuzonDAO buzonDAO) {
		this.buzonDAO = buzonDAO;
	}

	public BuzonService(IBuzonDAO buzonDAO, IEnvioDAO envioDAO, IAreaDAO areaDAO) {
		this.buzonDAO = buzonDAO;
		this.envioDAO = envioDAO;
		this.areaDAO = areaDAO;
	}

	public Iterable<Buzon> buscarBuzonPorNombre(String texto) {
		Iterable<Buzon> buzones = buzonDAO.buscarBuzonPorNombre(texto);
		return buzones;
	}

	public List<Buzon> buscarBuzonesPorUsuarioId(Long usuarioId) {
		List<Buzon> buzones = buzonDAO.buscarBuzonesPorUsuarioId(usuarioId);
		return buzones;
	}

	public List<Buzon> buscarBuzonesPorUbicacionesIds(List<Long> ubicacionesIds) {
		List<Buzon> buzones = buzonDAO.buscarBuzonesPorUbicacionesIds(ubicacionesIds);
		return buzones;
	}

	public List<DestinatarioFrecuenteDTO> listarDestinatariosFrecuentes(Long buzonId, int cantidad) {
		List<DestinatarioFrecuenteDTO> destinatariosFrecuentesDtOs = new ArrayList<DestinatarioFrecuenteDTO>();
		List<Long> destinatariosIds = envioDAO.listarPrimerosDestinatariosIdsPorRemitenteId(buzonId, cantidad);
		List<Buzon> buzones = buzonDAO.listarBuzonesPorIds(destinatariosIds);
		
		List<Map<String, Object>> areas = areaDAO.listarAreasByCodigosUbicaciones(
				buzones.stream().map(buzon -> buzon.getUbicacionCodigo()).collect(Collectors.toList()));
		areas.sort((a, b) -> a.get("codigo").toString().compareTo(b.get("codigo").toString()));
		buzones.sort((a, b) -> a.getUbicacionCodigo().compareTo(b.getUbicacionCodigo()));
		int i = 0;
		int j = 0;
		while (i < buzones.size()) {
			Buzon buzon = buzones.get(i);
			Map<String, Object> area = areas.get(j);
			if (!buzon.getUbicacionCodigo().equals(area.get("codigo"))) {
				j++;
			} else {
				DestinatarioFrecuenteDTO dto = new DestinatarioFrecuenteDTO(buzon, area.get("nombre").toString(),
						area.get("sede").toString());
				destinatariosFrecuentesDtOs.add(dto);
				i++;
			}
		}
		return destinatariosFrecuentesDtOs;
	}

	/* **************************************** */

}
