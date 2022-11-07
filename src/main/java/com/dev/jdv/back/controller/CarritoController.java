package com.dev.jdv.back.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.jdv.back.dto.CarritoDTO;
import com.dev.jdv.back.dto.ProductoDTO;
import com.dev.jdv.back.service.ICarritoService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Julian076
 *
 */
@Slf4j
@RestController
@RequestMapping("/api/carrito")
@CrossOrigin(origins = "http://localhost:4200")
public class CarritoController {
	
	@Autowired
	private ICarritoService carritoService;
	
	
	@PostMapping("/add")
	public ResponseEntity<List<CarritoDTO>> anadirCarrito(@RequestBody ProductoDTO dto){
		List<CarritoDTO> resp = new ArrayList<>();
		log.info("Añadiendo producto al carro {}");
		try {
			resp = carritoService.anadirCarrito(dto);
			log.info("Respuesta Exitosa al añadir el producto {}");
		} catch (Exception e) {
			log.error("Respuesta Fallida al añadir el producto");
		}
		return new ResponseEntity<>(resp, HttpStatus.CREATED);
	}
	
	/**
	 * Metodo para mostrar a todos los productos
	 * @return -> ResponseEntity<List<Producto>> respuesta con los productos
	 */
	@GetMapping
	public ResponseEntity<List<CarritoDTO>> listarTodos(){
		log.info("Listando todos los productos {}");
		List<CarritoDTO> resp = new ArrayList<>();
		try {
			resp = carritoService.mostrarCarrito();
			log.info("Respuesta Exitosa al listar los productos");
		} catch (Exception e) {
			log.error("Respuesta Fallida al listar los producto");
		}
		return new ResponseEntity<>(resp, HttpStatus.OK);
	} 

}
