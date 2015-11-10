package com.loyola.planifica.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.loyola.model.Usuario;
import com.loyola.planifica.service.UsuarioService;

@RestController
@RequestMapping("usuarios")
public class UsuarioController{

	@Autowired
	UsuarioService usuarioService;	
	
	
	@RequestMapping(value="/",method=RequestMethod.GET,produces = "application/json")
	public List<Usuario> get()
	{
		return usuarioService.findAll();
	}
	
	@RequestMapping(value="{id}",method=RequestMethod.GET,produces = "application/json")
	public Usuario get(@PathVariable("id")Integer id)
	{
		return usuarioService.findById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,produces = "application/json")
	public Map<String,Object> insert(
			@RequestBody Usuario usuario
			)
	{	
		Map<String,Object> resultMap=new HashMap<String, Object>();
		try {
			usuarioService.register(usuario);
			resultMap.put("success", "success");
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		return resultMap;
				
	}
		
	@RequestMapping(value="{id}",method=RequestMethod.DELETE,produces = "application/json")
	public Map<String,Object> delete(
			@PathVariable("id")Integer id			
			)
	{
		Map<String,Object> resultMap=new HashMap<String, Object>();		
		try {
			usuarioService.delete(id);
			resultMap.put("success", "success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultMap;
				
	}
	
	
	
	
	
	
}
