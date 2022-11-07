package com.dev.jdv.back.dto;

import java.time.LocalDate;

import com.dev.jdv.back.util.Constantes;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Julian076
 *
 */
@Setter
@Getter
public class CarritoDTO {

	private Integer id;
	private String codigo;
	private String descripcion;
	private Integer cantidadProductoAVender;
	private Integer valorTotal;
	private LocalDate createAt;
	
	public CarritoDTO productoACarrito(ProductoDTO dto) {
		CarritoDTO carro = new CarritoDTO();
		carro.setId(dto.getId());
		carro.setCodigo(dto.getCodigo());
		carro.setDescripcion(dto.getDescripcion());
		if (dto.getCantidadaVender() == null) {
			carro.setCantidadProductoAVender(Constantes.UNO);
		}else {
			carro.setCantidadProductoAVender(dto.getCantidadaVender());
		}
		carro.setCreateAt(LocalDate.now());
		return carro;
	}
}
