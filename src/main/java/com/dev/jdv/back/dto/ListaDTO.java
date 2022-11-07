package com.dev.jdv.back.dto;

import com.dev.jdv.back.model.Lista;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Julian076
 *
 */
@Setter
@Getter
public class ListaDTO {

	private Integer idLista;
	private String nombre;

	public ListaDTO modeloAdto(Lista modelo) {
		ListaDTO dto = new ListaDTO();
		dto.setIdLista(modelo.getIdLista());
		dto.setNombre(modelo.getNombre());
		return dto;
	}

	public Lista dtoAModelo(ListaDTO dto) {
		Lista modelo = new Lista();
		modelo.setIdLista(dto.getIdLista());
		modelo.setNombre(dto.getNombre());
		return modelo;
	}
}
