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

import com.loyola.model.Operacion;
import com.loyola.planifica.service.OperacionService;



@RestController
@RequestMapping("operaciones")
public class OperacionController{

	
	@Autowired
	OperacionService operacionService;	
	
	
	@RequestMapping(value="/",method=RequestMethod.GET,produces = "application/json")
	public List<Operacion> get()
	{
		return operacionService.findAll();
	}
	
	@RequestMapping(value="{id}",method=RequestMethod.GET,produces = "application/json")
	public Operacion get(@PathVariable("id")Integer id)
	{
		return operacionService.findById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,produces = "application/json")
	public Map<String,Object> insert(
			@RequestBody Operacion operacion
			)
	{	
		
		Map<String,Object> resultMap=new HashMap<String, Object>();
		try {
			operacionService.register(operacion);
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
			operacionService.delete(id);
			resultMap.put("success", "success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultMap;
				
	}
	
	
	

	
	
	
	
	
}
