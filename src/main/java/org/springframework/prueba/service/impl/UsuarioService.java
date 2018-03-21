package org.springframework.prueba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.prueba.dao.impl.UsuarioDAO;
import org.springframework.prueba.model.Usuario;
import org.springframework.prueba.service.interfaces.UsuarioServiceInterface;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UsuarioServiceInterface {
	@Autowired
	UsuarioDAO usuarioDAO;
	
	public Usuario buscarUsuario(int id) {
		return usuarioDAO.buscarUsuario(id); 
	}

	public List<Usuario> listaUsuarios() {
		return usuarioDAO.listaUsuarios();
	}

	public Usuario alta(Usuario usuario) {
		return usuarioDAO.alta(usuario);
		
	}
	
	public Usuario modificar(Usuario usuario) {
		return usuarioDAO.modificar(usuario); 
	}

	public int eliminar(int id) {
		return usuarioDAO.eliminar(id); 
		 
	}

}
