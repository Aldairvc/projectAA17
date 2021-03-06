package com.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.app.models.dao.ICategoriaDao;
import com.springboot.app.models.entity.Categoria;

@Service
public class CategoriaServicelmpl implements ICategoriaService{

	@Autowired
	private ICategoriaDao categoriaDao;
	
	
	@Override
	@Transactional
	public List<Categoria> findAll() {
		// TODO Auto-generated method stub
		return (List<Categoria>) categoriaDao.findAll();
	}

	@Override
	@Transactional
	public void save(Categoria categoria) {
		// TODO Auto-generated method stub
		 categoriaDao.save(categoria);
	}

	@Override
	@Transactional
	public Categoria findOne(Long idcategoria) {
		// TODO Auto-generated method stub
		return categoriaDao.findById(idcategoria).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long idcategoria) {
		// TODO Auto-generated method stub
		categoriaDao.deleteById(idcategoria);
	}

}
