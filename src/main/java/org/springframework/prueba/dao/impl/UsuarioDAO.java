package org.springframework.prueba.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.prueba.dao.interfaces.UsuarioDaoInterface;
import org.springframework.prueba.model.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDAO implements UsuarioDaoInterface {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Usuario buscarUsuario(int id) {
		String queryUsuario = "SELECT * FROM USUARIOS WHERE ID = ?";
		return jdbcTemplate.queryForObject(queryUsuario, new Object[] { id },
				new BeanPropertyRowMapper<Usuario>(Usuario.class));
		
	}

	public List<Usuario> listaUsuarios() {
		String queryUsuarios = "SELECT * FROM USUARIOS";
		return jdbcTemplate.query(queryUsuarios,
				new BeanPropertyRowMapper<Usuario>(Usuario.class));
	}

	public Usuario alta(Usuario usuario) {

		String sql = "SELECT ID_USU_SEQ.nextval FROM DUAL";
		int idUsuario = Integer.parseInt((String) jdbcTemplate.queryForObject(sql, String.class));
		String insertUsuario = "INSERT INTO USUARIOS VALUES (?,?,?)";
		int r = jdbcTemplate.update(insertUsuario, idUsuario, usuario.getNombre(), usuario.getNombreUsuario());
		if (r == 1) {
			usuario.setId(idUsuario);
		}
		return usuario;
	}

	public Usuario modificar(Usuario usuario) {
		String sql = "UPDATE USUARIOS SET NOMBRE = ?, NOMBRE_USUARIO = ? WHERE ID = ?";

		int r = jdbcTemplate.update(sql, usuario.getNombre(), usuario.getNombreUsuario(), usuario.getId());
		if (r != 1) {
			usuario.setId(0);
		}

		return usuario;
	}

	public int eliminar(int id) {
		String sql = "DELETE FROM USUARIOS WHERE ID = ?";
		return jdbcTemplate.update(sql, id);
	}

}
