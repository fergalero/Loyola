package com.loyola.planifica.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.loyola.model.Operacion;

public interface OperacionMapper {
	
	@Select("SELECT tipo,monto,fecha FROM operacion WHERE id_usuario = #{id_usuario}")
    Operacion findByUsuario(@Param("id_usuario") Integer id);
	
	@Insert("INSERT INTO operacion (tipo,monto,fecha,estado,id_usuario) "
			+ "values(#{tipo},#{monto},#{fecha}"
			+ ",#{estado},#{usuario})")
	void register(Operacion operacion); 
	
	@Delete("DELETE FROM usuario WHERE id_usuario = #{id}")
	void delete(@Param("id") Integer id); 
	
	@Select("SELECT id_operacion id,tipo,monto,fecha,estado,id_usuario usuario FROM usuario")
    List<Operacion> finAll();

}
