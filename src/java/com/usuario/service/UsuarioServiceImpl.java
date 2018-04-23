
package com.usuario.service;

import com.usuario.dao.UsuarioDao;
import com.usuario.dao.UsuarioDaoImpl;
import com.usuarios.domain.Usuario;
import java.util.List;


public class UsuarioServiceImpl implements UsuarioService{
    // patron Dao
    private UsuarioDao usuarioDao= new UsuarioDaoImpl();

    @Override
    public void crearRegistro(Usuario usuario) {
        System.out.println("Capa de servicio");
        usuarioDao.crearRegistro(usuario);
        
    }

    @Override
    public List<Usuario> obtenerRegistros() {
        System.out.println("obtener Registro");
        return usuarioDao.obtenerRegistros();
    }

    @Override
    public void actualizarRegistro(Usuario usuario) {
        usuarioDao.actualizarRegistro(usuario);
    }

    @Override
    public Integer eliminarRegistro(Integer idUusario) {
        return usuarioDao.eliminarRegistro(idUusario);
    }

    @Override
    public Usuario obtenerRegistro(Integer idUsuario) {
        return usuarioDao.obtenerRegistro(idUsuario);
    }

    
}
