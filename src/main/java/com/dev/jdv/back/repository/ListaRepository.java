package com.dev.jdv.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dev.jdv.back.model.Lista;

/**
 * 
 * @author Julian076
 *
 */
@Repository
public interface ListaRepository extends JpaRepository<Lista, Integer>{

	@Query(value = "select b.list_list, b.list_nombre from tbl_lista a "
			+ "inner join tbl_lista b on a.list_list = b.list_idpadre "
			+ "where a.list_nombre = :nombreLista ", nativeQuery = true)
	public List<Object[]> buscarCategoriaYEstado(@Param("nombreLista") String nombreLista);
	
	
	@Query(value = "select list_nombre from tbl_lista where list_list = :id", nativeQuery = true)
	public String consultaValor(@Param("id") Integer id);
}
