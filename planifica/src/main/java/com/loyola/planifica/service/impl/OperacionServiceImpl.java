package com.loyola.planifica.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loyola.model.Operacion;
import com.loyola.planifica.mappers.OperacionMapper;
import com.loyola.planifica.service.OperacionService;

@Service
public class OperacionServiceImpl implements OperacionService{

	@Autowired
	OperacionMapper operacionMapper;
	
	@Override
	public Operacion findById(Integer id) {
		return operacionMapper.findByUsuario(id);		
	}

	@Override
	public void register(Operacion t) {
		try {
			operacionMapper.register(t);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Operacion t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Operacion> findAll() {
		// TODO Auto-generated method stub
		return operacionMapper.finAll();
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	
	
}
