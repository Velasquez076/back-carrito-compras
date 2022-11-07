package com.dev.jdv.back.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dev.jdv.back.model.Producto;

/**
 * 
 * @author Julian076
 *
 */
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
	
	@Query(value = "select prod_id, prod_codigo, prod_descripcion, "
			+ "prod_cantidad, prod_precio, prod_imagen, prod_idcategoria, prod_idestado "
			+ "from tbl_producto order by prod_id desc", nativeQuery = true)
	public List<Object[]> listarTodosProductos(String data);
	
	@Query(value = "select prod_id, prod_codigo, prod_descripcion, "
			+ "prod_cantidad, prod_precio, prod_imagen, prod_idcategoria, prod_idestado "
			+ "from tbl_producto order by prod_id desc", nativeQuery = true)
	public List<Object[]> listarTodosProductos();

	
	@Query(value = "select prod_id, prod_codigo, prod_descripcion, "
			+ "prod_cantidad, prod_precio, prod_imagen, prod_idcategoria, prod_idestado "
			+ "from tbl_producto where prod_descripcion LIKE %?1 ", nativeQuery = true)
	public Page<Object[]> buscarPorDescripcion(@Param("descripcion") String descripcion, Pageable pageable);
	
	
	@Query(value = "select prod_id, prod_codigo, prod_descripcion, "
			+ "prod_cantidad, prod_precio, prod_imagen, prod_idcategoria, prod_idestado "
			+ "from tbl_producto order by prod_id desc", nativeQuery = true)
	public Page<Object[]> findAllProductos(Pageable pageable);
	
	
	@Query(value = "select prod_id, prod_codigo, prod_descripcion, "
			+ "prod_cantidad, prod_precio, prod_imagen, prod_idcategoria, prod_idestado "
			+ "from tbl_producto where prod_descripcion LIKE %?1 ", nativeQuery = true)
	public Page<Object[]> buscarPorCodigo(@Param("codigo") String codigo, Pageable pageable);
	
	
	@Query(value = "select prod_id, prod_codigo, prod_descripcion, "
			+ "prod_cantidad, prod_precio, prod_imagen, prod_idcategoria, prod_idestado "
			+ "from tbl_producto where prod_descripcion LIKE %?1 ", nativeQuery = true)
	public Page<Object[]> buscarPorCategoria(@Param("categoria") String categoria, Pageable pageable);
	
	
}
