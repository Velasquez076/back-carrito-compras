package com.dev.jdv.back.model;

import java.time.LocalDate;

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
@Table(name = "tbl_detalle_venta", schema = "system")
public class DetalleVenta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "system.tbl_detalle_venta_seq")
	@SequenceGenerator(name = "system.tbl_detalle_venta_seq", sequenceName = "system.tbl_detalle_venta_sql", allocationSize = 1)
	@Column(name = "det_id")
	private Integer id;
	
	@Column(name = "det_idproducto")
	private Integer idProducto;
	
	@Column(name = "det_cantidadventa")
	private Integer cantidadVenta;
	
	@Column(name = "det_total_venta")
	private Integer valorTotalVenta;
	
	@Column(name = "det_create_at")
	private LocalDate createAt;
		

}
