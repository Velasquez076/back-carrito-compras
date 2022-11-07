package com.dev.jdv.back.service;

import java.util.List;

import com.dev.jdv.back.dto.CarritoDTO;
import com.dev.jdv.back.dto.ProductoDTO;

/**
 * 
 * @author Julian076
 *
 */
public interface ICarritoService {
	
	public List<CarritoDTO> anadirCarrito(ProductoDTO dto);
	
	public List<CarritoDTO> mostrarCarrito();

}
