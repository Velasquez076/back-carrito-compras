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

/**
 * 
 * @author Julian076
 *
 */
@Setter
@Getter
@Entity
@Table(name = "tbl_lista", schema = "system")
public class Lista {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "system.tbl_lista_seq")
	@SequenceGenerator(name = "system.tbl_lista_seq", sequenceName = "system.tbl_lista_seq", allocationSize = 1)
	@Column(name = "list_list")
	private Integer idLista;
	
	@Column(name = "list_nombre")
	private String nombre;
	
	@Column(name = "list_descripcion")
	private String descripcion;
	
	@Column(name = "list_idpadre")
	private Integer idPadre;
	
}
