package com.springboot.app.models.service;

import java.util.List;

import com.springboot.app.models.entity.Categoria;

public interface ICategoriaService {

	
	public List<Categoria> findAll();

	public void save(Categoria categoria);
	
	public Categoria findOne(Long idcategoria);
	
	public void delete(Long idcategoria);
	
}
