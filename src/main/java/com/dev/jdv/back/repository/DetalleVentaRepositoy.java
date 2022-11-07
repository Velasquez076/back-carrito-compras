package com.dev.jdv.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.jdv.back.model.DetalleVenta;

/**
 * 
 * @author Julian076
 *
 */
@Repository
public interface DetalleVentaRepositoy extends JpaRepository<DetalleVenta, Integer> {

}
