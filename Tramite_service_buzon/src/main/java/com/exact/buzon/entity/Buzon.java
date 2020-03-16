package com.exact.buzon.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="buzon")
public class Buzon implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="buzon_id")
	private Long id;
	
	@Column(nullable=false, length = 100)
	private String nombre;
		
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="tipo_buzon_id")
	private TipoBuzon tipoBuzon;
	
	@Column(name="ubicacion_id")
	@JsonIgnore
	private Long ubicacionId;
	
	
	@Column(name="ubicacion_nombre", nullable=false, length = 100)
	@JsonIgnore
	private String ubicacionNombre;
	
	@Transient
	private Map<String, Object> ubicacion;
	
	


	public Map<String, Object> getUbicacion() {
		ubicacion = new HashMap<String, Object>();
		this.ubicacion.put("id", ubicacionId);
		this.ubicacion.put("nombre", ubicacionNombre);
		return ubicacion;
	}


	public void setUbicacion(Map<String, Object> ubicacion) {
		this.ubicacion = ubicacion;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public TipoBuzon getTipoBuzon() {
		return tipoBuzon;
	}


	public void setTipoBuzon(TipoBuzon tipoBuzon) {
		this.tipoBuzon = tipoBuzon;
	}


	public Long getUbicacionId() {
		return ubicacionId;
	}


	public void setUbicacionId(Long ubicacionId) {		
		this.ubicacionId = ubicacionId;
	}


	public String getUbicacionNombre() {
		return ubicacionNombre;
	}


	public void setUbicacionNombre(String ubicacionNombre) {		
		this.ubicacionNombre = ubicacionNombre;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	
	
}
