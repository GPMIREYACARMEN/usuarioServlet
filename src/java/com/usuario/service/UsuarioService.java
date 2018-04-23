
package com.usuario.service;

import com.usuarios.domain.Usuario;
import java.util.List;


public interface UsuarioService {
    public void crearRegistro(Usuario usuario);
    public List<Usuario> obtenerRegistros();
    public void actualizarRegistro(Usuario usuario);
    public Integer eliminarRegistro(Integer idUusario);
    public Usuario obtenerRegistro(Integer idUsuario);
}
