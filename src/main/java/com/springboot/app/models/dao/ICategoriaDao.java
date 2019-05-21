package com.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.app.models.entity.Categoria;
public interface ICategoriaDao extends CrudRepository<Categoria, Long> {

}
