package com.dev.jdv.back.service;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;

import com.dev.jdv.back.dto.ProductoDTO;

/**
 * 
 * @author Julian076
 *
 */
public interface IProductoService {
	
	@Transactional
	public ProductoDTO crear(ProductoDTO dto);
	
	public ProductoDTO obtenerListasCategoriaYEstado();

	public List<ProductoDTO> listarTodos();
	
	public ProductoDTO editar(ProductoDTO dto);
	
	public ProductoDTO buscarPorId(Integer id);
	
	public void borrarRegistro(Integer id);
	
	public ResponseEntity<Object> buscarTodosPaginado(Integer num, Integer tam, String ord, String dir);
	
	public ResponseEntity<Object> buscarPorDescripcionCodigoCategoria(Map<String, Object> data);
	
}

