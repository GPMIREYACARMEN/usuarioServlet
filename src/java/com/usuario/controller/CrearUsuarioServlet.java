
package com.usuario.controller;

import com.usuario.dao.UsuarioDao;
import com.usuario.dao.UsuarioDaoImpl;
import com.usuario.service.UsuarioService;
import com.usuario.service.UsuarioServiceImpl;
import com.usuarios.domain.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CrearUsuarioServlet extends HttpServlet {

    
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //mandar a llamar
        //recibir parámatros de la vista (html)
        
        String usr = request.getParameter("usr");
        String pwd = request.getParameter("pwd");
        
        //UsuarioDao usuarioDao = new UsuarioDaoImpl(); cambiado por Ususarioservice
        UsuarioService usuarioService = new UsuarioServiceImpl();
        Usuario usuario =new Usuario(usr,pwd);
       
        usuarioService.crearRegistro(usuario);
        
        
        response.sendRedirect("ListarUsuarioServlet");/// lleva a la pagina que queremos ir
    }

 
}
