package com.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.app.models.dao.ICompaniaDao;
import com.springboot.app.models.entity.Categoria;
import com.springboot.app.models.entity.Cliente;
import com.springboot.app.models.entity.Compania;

@Service
public class CompaniaServicelmpl  implements ICompaniaService{
	@Autowired
	private ICompaniaDao companiaDao; 
	
	@Override
	@Transactional
	public List<Compania> findAll() {
		// TODO Auto-generated method stub
		return (List<Compania>) companiaDao.findAll();
	}

	@Override
	@Transactional
	public void save(Compania compania) {
		// TODO Auto-generated method stub
		companiaDao.save(compania);
	}

	@Override
	@Transactional
	public Compania findOne(Long idcompania) {
		// TODO Auto-generated method stub
		return companiaDao.findById(idcompania).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long idcompania) {
		companiaDao.deleteById(idcompania);
	}

	


}
