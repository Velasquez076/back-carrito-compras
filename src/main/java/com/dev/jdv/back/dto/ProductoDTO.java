package com.dev.jdv.back.dto;

import java.util.List;

import com.dev.jdv.back.model.Producto;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Julian076
 *
 */
@Setter
@Getter
public class ProductoDTO {

	private Integer id;
	private String codigo;
	private String descripcion;
	private Integer cantidad;
	private Integer precio;
	private String imagen;
	private String idCategoria;
	private String idEstado;
	private String estado;
	private Integer cantidadaVender;
	private String categoria;
	private CarritoDTO carrito;
	private List<ListaDTO> listaCategoria;
	private List<ListaDTO> listaEstado;
	
	
	public Producto dtoAModelo(ProductoDTO dto) {
		Producto modelo = new Producto();
		modelo.setId(dto.getId());
		modelo.setCodigo(dto.getCodigo());
		modelo.setDescripcion(dto.getDescripcion());
		modelo.setCantidad(dto.getCantidad());
		modelo.setIdCategoria(Integer.parseInt(dto.getIdCategoria()));
		modelo.setIdEstado(Integer.parseInt(dto.getIdEstado()));
		modelo.setPrecio(dto.getPrecio());
		modelo.setImagen(dto.getImagen());
		return modelo;
	}
	
	public ProductoDTO modeloADto(Producto modelo) {
		ProductoDTO dto = new ProductoDTO();
		dto.setId(modelo.getId());
		dto.setCodigo(modelo.getCodigo());
		dto.setDescripcion(modelo.getDescripcion());
		dto.setCantidad(modelo.getCantidad());
		dto.setIdCategoria(String.valueOf(modelo.getIdCategoria()));
		dto.setIdEstado(String.valueOf(modelo.getIdEstado()));
		dto.setPrecio(modelo.getPrecio());
		dto.setImagen(modelo.getImagen());
		dto.setCarrito(new CarritoDTO());
		return dto;
	}
}
