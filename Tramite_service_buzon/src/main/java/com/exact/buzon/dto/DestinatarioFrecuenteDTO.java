package com.exact.buzon.dto;

import java.io.Serializable;

import com.exact.buzon.entity.Buzon;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DestinatarioFrecuenteDTO implements Serializable {
	
	private Long id;
	private String nombre;
	private String area;
	private String sede;
	
	public DestinatarioFrecuenteDTO(Buzon buzon, String area, String sede) {
		this.id = buzon.getId();
		this.nombre = buzon.getNombre();
		this.area = area;
		this.sede = sede;
	}
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
