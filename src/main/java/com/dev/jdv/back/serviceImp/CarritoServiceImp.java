package com.dev.jdv.back.serviceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dev.jdv.back.dto.CarritoDTO;
import com.dev.jdv.back.dto.ProductoDTO;
import com.dev.jdv.back.service.ICarritoService;
import com.dev.jdv.back.util.Constantes;

/**
 * 
 * @author Julian076
 *
 */
@Service
public class CarritoServiceImp implements ICarritoService{
	
	CarritoDTO carrito = new CarritoDTO();
	List<CarritoDTO> listaCarrito = new ArrayList<>();
	
	
	@Override
	public List<CarritoDTO> anadirCarrito(ProductoDTO dto) {
		Integer totalVenta;
		if(dto.getCantidadaVender() == null ) {
			totalVenta = Constantes.UNO * dto.getPrecio();
		}else {
			totalVenta = dto.getCantidadaVender() * dto.getPrecio();
		}
		carrito = carrito.productoACarrito(dto);
		carrito.setValorTotal(totalVenta);
		
		listaCarrito.add(carrito);
		return listaCarrito;
	}
	
	@Override
	public List<CarritoDTO> mostrarCarrito(){
		return listaCarrito;
	
	}
}
