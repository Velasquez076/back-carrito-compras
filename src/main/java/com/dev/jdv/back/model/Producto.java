 package com.dev.jdv.back.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "tbl_producto", schema = "system")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "system.tbl_producto_seq")
	@SequenceGenerator(name = "system.tbl_producto_seq", sequenceName = "system.tbl_producto_seq", allocationSize = 1)
	@Column(name = "prod_id")
	private Integer id;
	
	@Column(name = "prod_codigo", unique = true)
	private String codigo;
	
	@Column(name = "prod_descripcion")
	private String descripcion;
	
	@Column(name = "prod_cantidad")
	private Integer cantidad;
	
	@Column(name = "prod_precio")
	private Integer precio;
	
	@Column(name = "prod_idestado")
	private Integer idEstado;
	
	@Column(name = "prod_idcategoria")
	private Integer idCategoria;
	
	@Column(name = "prod_imagen")
	private String imagen;
	
}
