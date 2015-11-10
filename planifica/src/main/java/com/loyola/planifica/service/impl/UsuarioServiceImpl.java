package com.loyola.planifica.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loyola.model.Usuario;
import com.loyola.planifica.mappers.UsuarioMapper;
import com.loyola.planifica.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	UsuarioMapper usuarioMapper;
			
	@Override
	public Usuario findById(Integer id) {
		// TODO Auto-generated method stub
		return usuarioMapper.findById(id);
	}

	@Override
	public void register(Usuario t) {		
		try {
			usuarioMapper.register(t);			
		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}

	@Override
	public void update(Usuario t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Usuario> findAll() {
		return usuarioMapper.finAll();
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub		
		try 
		{
			System.out.println("ID: "+id);
			usuarioMapper.delete(id);					
		} catch (Exception e) 
		{
			e.printStackTrace();					
		}
								
		
	}
	
	

}
