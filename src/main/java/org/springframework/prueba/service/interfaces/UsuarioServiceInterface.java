package org.springframework.prueba.service.interfaces;

import java.util.List;

import org.springframework.prueba.model.Usuario;

public interface UsuarioServiceInterface {
	public Usuario buscarUsuario(int id); 
	public List<Usuario> listaUsuarios();
	public Usuario alta(Usuario usuario);
	public Usuario modificar(Usuario usuario);
	public int eliminar(int id); 
}
