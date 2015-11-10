package com.loyola.planifica.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.loyola.model.Usuario;

public interface UsuarioMapper {
	
	@Select("SELECT id_usuario id,rol,nombre,apellido,saldo FROM usuario WHERE id_usuario = #{id}")
    Usuario findById(@Param("id") Integer id);
	
	@Insert("INSERT INTO usuario (rol,clave,username,nombre,apellido,saldo,estado) "
			+ "values(#{rol},#{clave},#{username}"
			+ ",#{nombre},#{apellido},#{saldo},#{estado})")
	void register(Usuario usuario); 
	
	@Delete("DELETE FROM usuario WHERE id_usuario = #{id}")
	void delete(@Param("id") Integer id); 
	
	@Select("SELECT id_usuario id,nombre,apellido,saldo,estado,rol FROM usuario")
    List<Usuario> finAll();

}
