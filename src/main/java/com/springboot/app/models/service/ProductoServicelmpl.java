package com.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.app.models.dao.IProductoDao;
import com.springboot.app.models.entity.Producto;

@Service
public class ProductoServicelmpl implements IProductoService {

	@Autowired
	private IProductoDao productoDao;
	
	
	@Override
	@Transactional
	public List<Producto> findAll() {
		
		return (List<Producto>) productoDao.findAll();
	}

	@Override
	@Transactional
	public void save(Producto producto) {
		
		productoDao.save(producto);
		
	}

	@Override
	@Transactional
	public Producto findOne(Long idproducto) {
		
		return productoDao.findById(idproducto).orElse(null);
		
	}

	@Override
	@Transactional
	public void delete(Long idproducto) {
		
		productoDao.deleteById(idproducto);
		
	}

}
