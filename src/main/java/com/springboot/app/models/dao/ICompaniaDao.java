package com.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.app.models.entity.Compania;

public interface ICompaniaDao extends CrudRepository<Compania, Long>{

}
