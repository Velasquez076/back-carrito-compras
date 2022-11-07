package com.dev.jdv.back.serviceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dev.jdv.back.dto.ListaDTO;
import com.dev.jdv.back.dto.ProductoDTO;
import com.dev.jdv.back.model.Producto;
import com.dev.jdv.back.repository.ListaRepository;
import com.dev.jdv.back.repository.ProductoRepository;
import com.dev.jdv.back.service.IProductoService;
import com.dev.jdv.back.util.Constantes;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Julian076
 *
 */
@Slf4j
@Service
public class ProductoServiceImp implements IProductoService {

	@Autowired
	private ProductoRepository productoRepository;

	@Autowired
	private ListaRepository listaRepository;

	@Override
	public ProductoDTO crear(ProductoDTO dto) {
		Producto modelo = dto.dtoAModelo(dto);
		productoRepository.save(modelo);
		return dto;
	}

	@Override
	public List<ProductoDTO> listarTodos() {
		List<Object[]> listaModelo = productoRepository.listarTodosProductos();

		List<ProductoDTO> listaDto = new ArrayList<>();

		for (Object[] modelo : listaModelo) {
			ProductoDTO dto = new ProductoDTO();
			dto.setId(Integer.valueOf(String.valueOf(modelo[0])));
			dto.setCodigo(String.valueOf(modelo[1]));
			dto.setDescripcion(String.valueOf(modelo[2]));
			dto.setCantidad(Integer.valueOf(String.valueOf(modelo[3])));
			dto.setPrecio(Integer.valueOf(String.valueOf(modelo[4])));
			dto.setImagen(String.valueOf(modelo[5]));
			dto.setIdCategoria(String.valueOf(modelo[6]));
			dto.setIdEstado(String.valueOf(modelo[7]));
			String categoria = listaRepository.consultaValor(Integer.valueOf(dto.getIdCategoria()));
			String estado = listaRepository.consultaValor(Integer.valueOf(dto.getIdEstado()));
			dto.setCategoria(categoria);
			dto.setEstado(estado);

			listaDto.add(dto);
		}

		return listaDto;
	}

	@Override
	public ProductoDTO editar(ProductoDTO dto) {
		// Se consulta el producto a editar
		Producto producto = productoRepository.findById(dto.getId()).orElse(null);
		try {
			log.info("Se inicia la modificacion del producto {}");
			if (dto.getId() != null || producto != null) {
				producto = dto.dtoAModelo(dto);
				productoRepository.save(producto);
				log.info("Se modifica el producto con id: {}", dto.getId());
			}
		} catch (Exception e) {
			log.error("Error en la modificacion del producto {}", e.getMessage());
		}
		return dto;
	}

	@Override
	public ProductoDTO buscarPorId(Integer id) {
		log.info("Se inicia la busqueda del producto por id {}");
		ProductoDTO dto = new ProductoDTO();
		try {
			Producto modelo = productoRepository.findById(id).orElse(null);
			if (modelo.getId() != null) {
				log.info("Se encontro el producto por id {}");
				dto = dto.modeloADto(modelo);
				String categoria = listaRepository.consultaValor(modelo.getIdCategoria());
				String estado = listaRepository.consultaValor(modelo.getIdEstado());
				dto.setCategoria(categoria);
				dto.setEstado(estado);
			}
		} catch (Exception e) {
			log.error("Error en la busqueda {}", e.getMessage());
		}
		return dto;
	}

	@Override
	public void borrarRegistro(Integer id) {
		log.info("Se inicia la busqueda del producto por id {}");
		if (id != null) {
			productoRepository.deleteById(id);
			log.info("Producto borrado id {}");
		} else {
			log.error("No hay id de producto a borrar {}");
		}

	}

	@Override
	public ProductoDTO obtenerListasCategoriaYEstado() {

		ProductoDTO productoDto = new ProductoDTO();
		List<ListaDTO> listaCategoria = new ArrayList<>();
		List<ListaDTO> listaEstadoProducto = new ArrayList<>();

		List<Object[]> categoria = listaRepository.buscarCategoriaYEstado(Constantes.CATEGORIA_PRODUCTO);
		List<Object[]> estadoProd = listaRepository.buscarCategoriaYEstado(Constantes.ESTADO_PRODUCTO);

		for (Object[] categoriaPro : categoria) {
			ListaDTO dto = new ListaDTO();
			dto.setIdLista(Integer.valueOf(String.valueOf(categoriaPro[0])));
			dto.setNombre(String.valueOf(categoriaPro[1]));
			listaCategoria.add(dto);
		}

		for (Object[] estado : estadoProd) {
			ListaDTO dto = new ListaDTO();
			dto.setIdLista(Integer.valueOf(String.valueOf(estado[0])));
			dto.setNombre(String.valueOf(estado[1]));
			listaEstadoProducto.add(dto);
		}

		productoDto.setListaCategoria(listaCategoria);
		productoDto.setListaEstado(listaEstadoProducto);
		log.info("Se envian al navegador las listas {}");
		return productoDto;
	}

	@Override
	public ResponseEntity<Object> buscarTodosPaginado(Integer num, Integer tam, String ord, String dir) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Object> buscarPorDescripcionCodigoCategoria(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return null;
	}

}
