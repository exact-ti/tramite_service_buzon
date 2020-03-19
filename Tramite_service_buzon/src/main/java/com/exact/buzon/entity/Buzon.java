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

import lombok.Data;

@Entity
@Table(name="buzon")
@Data
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
	
	@Column(name="ubicacion_codigo")
	@JsonIgnore
	private String ubicacionCodigo;
	
	


	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	
	
}
