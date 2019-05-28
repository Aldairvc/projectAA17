package com.springboot.app.models.service;

import java.util.List;

import com.springboot.app.models.entity.Compania;

public interface ICompaniaService {

	public List<Compania> findAll();
	public void save (Compania compania);
	public Compania findOne(Long idcompania);
	public void delete(Long idcompania);
}
