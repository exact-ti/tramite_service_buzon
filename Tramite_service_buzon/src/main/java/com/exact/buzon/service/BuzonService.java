package com.exact.buzon.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.exact.buzon.dao.IAreaDAO;
import com.exact.buzon.dao.IBuzonDAO;
import com.exact.buzon.dao.IEnvioDAO;
import com.exact.buzon.dto.BuzonDTO;
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

	public BuzonService(IBuzonDAO buzonDAO, IAreaDAO areaDAO) {
		this.buzonDAO = buzonDAO;
		this.areaDAO = areaDAO;
	}

	public List<BuzonDTO> buscarBuzonPorNombre(String texto) {
		List<Buzon> buzones = buzonDAO.buscarBuzonPorNombre(texto.toUpperCase());
		return agregarAreaYSedeABuzon(buzones);
	}

	public List<Buzon> buscarBuzonesPorUsuarioId(Long usuarioId) {
		List<Buzon> buzones = buzonDAO.buscarBuzonesPorUsuarioId(usuarioId);
		return buzones;
	}

	public List<Buzon> listarBuzonesPorCodigosUbicaciones(List<String> codigosUbicaciones) {
		List<Buzon> buzones = buzonDAO.listarBuzonesPorCodigosUbicaciones(codigosUbicaciones);
		return buzones;
	}

	public List<BuzonDTO> listarDestinatariosFrecuentes(Long buzonId, int cantidad) {
		List<Long> destinatariosIds = envioDAO.listarPrimerosDestinatariosIdsPorRemitenteId(buzonId, cantidad);
		List<Buzon> buzones = buzonDAO.listarBuzonesPorIds(destinatariosIds);
		return agregarAreaYSedeABuzon(buzones);

	}
	
	public List<Buzon> listarBuzonesPorIds(List<Long> ids){
		return buzonDAO.listarBuzonesPorIds(ids);
	}
	

	/* **************************************** */

	public List<BuzonDTO> agregarAreaYSedeABuzon(List<Buzon> buzones) {
		if (buzones.size() == 0) {
			return new ArrayList<BuzonDTO>();
		}
		List<BuzonDTO> destinatariosFrecuentesDtOs = new ArrayList<BuzonDTO>();
		List<String> codigosUbicaciones = buzones.stream().map(buzon -> buzon.getCodigoUbicacion())
				.collect(Collectors.toList());
		List<Map<String, Object>> areas = areaDAO.listarAreasByCodigosUbicaciones(codigosUbicaciones);
		areas.sort((a, b) -> a.get("codigo").toString().compareTo(b.get("codigo").toString()));
		buzones.sort((a, b) -> a.getCodigoUbicacion().compareTo(b.getCodigoUbicacion()));
		int i = 0;
		int j = 0;
		while (i < buzones.size()) {
			Buzon buzon = buzones.get(i);
			Map<String, Object> area = areas.get(j);
			if (!buzon.getCodigoUbicacion().equals(area.get("codigo"))) {
				j++;
			} else {
				BuzonDTO dto = new BuzonDTO(buzon, area.get("nombre").toString(),
						area.get("sede").toString());
				destinatariosFrecuentesDtOs.add(dto);
				i++;
			}
		}
		return destinatariosFrecuentesDtOs;
	}

}
