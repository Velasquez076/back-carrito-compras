package com.dev.jdv.back.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.jdv.back.dto.ProductoDTO;
import com.dev.jdv.back.service.IProductoService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Julian076
 *
 */
@Slf4j
@RestController
@RequestMapping("/api/producto")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoController {

	@Autowired
	private IProductoService productoService;

	/**
	 * Metodo para consumir el servicio para crear un producto
	 * 
	 * @param dto
	 * @return -> ResponseEntity con el estado de la respuesta
	 */
	@PostMapping
	public ResponseEntity<ProductoDTO> crear(@RequestBody ProductoDTO dto) {
		ProductoDTO resp = new ProductoDTO();
		log.info("Creando producto {}", dto);
		try {
			resp = productoService.crear(dto);
			log.info("Respuesta Exitosa al crear el producto {}", dto);
		} catch (Exception e) {
			log.error("Respuesta Fallida al crear el producto");
		}
		return new ResponseEntity<>(resp, HttpStatus.CREATED);
	}

	@GetMapping("/listas")
	public ResponseEntity<ProductoDTO> obtenerListas() {
		ProductoDTO resp = new ProductoDTO();
		try {
			resp = productoService.obtenerListasCategoriaYEstado();
			log.info("Respuesta exitosa para la consulta de listas {}", resp);
		} catch (Exception e) {
			log.error("Respuesta Fallida para la consulta de listas {}", resp);
		}
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

	/**
	 * Metodo para mostrar a todos los productos
	 * 
	 * @return -> ResponseEntity<List<Producto>> respuesta con los productos
	 */
	@GetMapping
	public ResponseEntity<List<ProductoDTO>> listarTodos() {
		log.info(".:: Listando todos los productos {} ::.");
		List<ProductoDTO> resp = new ArrayList<>();
		try {
			resp = productoService.listarTodos();
			log.info("Respuesta Exitosa al listar los productos");
		} catch (Exception e) {
			log.error("Respuesta Fallida al listar los producto");
		}
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

	/**
	 * Metodo para consumir el servicio para editar un producto
	 * 
	 * @param dto
	 * @return -> ResponseEntity con el estado de la respuesta del servicio
	 */
	@PutMapping
	public ResponseEntity<ProductoDTO> editar(@RequestBody ProductoDTO dto) {
		ProductoDTO resp = new ProductoDTO();
		log.info("Editando producto {}");
		try {
			resp = productoService.editar(dto);
			log.info("Respuesta Exitosa al Editar el producto {}");
		} catch (Exception e) {
			log.error("Respuesta Fallida al Editar el producto");
		}
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

	/**
	 * Metodo para mostrar a todos los productos
	 * 
	 * @return -> ResponseEntity<List<Producto>> respuesta con los productos
	 */
	@GetMapping("/{id}")
	public ResponseEntity<ProductoDTO> consultarPorID(@PathVariable("id") Integer id) {
		log.info("Listando el producto con id: {}", id);
		ProductoDTO resp = new ProductoDTO();
		try {
			resp = productoService.buscarPorId(id);
			log.info("Respuesta Exitosa al listar los productos");
		} catch (Exception e) {
			log.error("Respuesta Fallida al listar los producto");
		}
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

	/**
	 * Metodo para mostrar a todos los productos
	 * 
	 * @return -> ResponseEntity<List<Producto>> respuesta con los productos
	 */
	@SuppressWarnings("rawtypes")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> borrarPorID(@PathVariable("id") Integer id) {
		log.info("Borrar el producto con id: {}", id);
		try {
			productoService.borrarRegistro(id);
			log.info("Respuesta Exitosa al borrar el producto");
		} catch (Exception e) {
			log.error("Respuesta Fallida al borrar el producto");
		}
		return new ResponseEntity(HttpStatus.OK);
	}

}
