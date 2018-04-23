
package com.usuario.controller;


import com.usuario.service.UsuarioService;
import com.usuario.service.UsuarioServiceImpl;
import com.usuarios.domain.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ActualizarUsuarioServlet extends HttpServlet {
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usr = request.getParameter("usr");
        String pwd = request.getParameter("pwd");
        Integer idUsuario =Integer.parseInt(request.getParameter("idUsuario"));
        
        Usuario usuario =new Usuario(idUsuario,usr,pwd);
        //UsuarioDao usuarioDao = new UsuarioDaoImpl(); cambiado por Ususarioservice
        UsuarioService usuarioService = new UsuarioServiceImpl();
        
       // actualizar registro
        usuarioService.actualizarRegistro(usuario);
        
        
        response.sendRedirect("ListarUsuarioServlet");/// lleva a la pagina que queremos ir
    }


}
