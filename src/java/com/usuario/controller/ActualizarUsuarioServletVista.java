/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usuario.controller;

import com.usuario.service.UsuarioService;
import com.usuario.service.UsuarioServiceImpl;
import com.usuarios.domain.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LabInfo01
 */
@WebServlet(name = "ActualizarUsuarioServletVista", urlPatterns = {"/ActualizarUsuarioServletVista"})
public class ActualizarUsuarioServletVista extends HttpServlet {


    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        String id=request.getParameter("idUsuario");// id de la tabla
        Integer idUsuario =Integer.parseInt(id);
        
        UsuarioService usuarioService=new UsuarioServiceImpl();
        Usuario usuario = usuarioService.obtenerRegistro(idUsuario);
        
        response.setContentType("text/html;charset=UTF-8");// text/html o text/xml
        
        // codificar etiquetas htmml
        PrintWriter salida = response.getWriter();
        salida.println("<!DOCTYPE html>");
        salida.println("<html>");
        salida.println("<head>");
        salida.println("<title>Listar Usuario</title>");
        salida.print("<link rel='stylesheet' href='resources/css/bootstrap.min.css'>");
        //salida.print("<link rel='stylesheet' href='resources/font-awesome-4.7.0/css/font-awesome.min.css'>");
        salida.print("<script src='resources/js/bootstrap.min.js'></script>");
        salida.println("</head>");
        
        salida.println("<body>");
        salida.println("<div class='container'>");
        salida.println("<h1>Actualizar Usuario </h1>");
        salida.print("<form id='idForm' action='ActualizarUsuarioServlet' method='get'> ");
        
        salida.print("<div class='form-group'>"); 
        salida.print("<label for='usrUsuario'> Nombre de Usuario</label>");
        salida.print("<input type='text' name='usr' id='usrUsuario' value='"+usuario.getUsr()+"' placeholder='Nombre de Usuario '>");
        salida.print("</div>");
                
        salida.print("<div class='form-group'>"); 
        salida.print("<label for='pwdUsuario'> Password del Usuario</label>");
        salida.print("<input type='password' name='pwd' id='pwdUsuario' value='"+usuario.getPwd()+"' placeholder='Password del Usuario '>");
        salida.print("</div>");
        
        salida.print("<div class='form-group'>"); 
        salida.print("<label for='idUsuario'> Id del Usuario</label>");
        salida.print("<input type='text' name='idUsuario' id='idUsuario' value='"+usuario.getIdUsuario()+"' placeholder='Id del Usuario '>");
        salida.print("</div>");
        
        salida.print("<button type='submit' class='btn btn-primary'> Guardar </button>");
        salida.print("<a class='btn btn-info' role='button' href='index.html'> Principal</a>");
        salida.print("</form>");
            
            
            
            //<!--<a class="btn btn-primary" role="button" href="#"> Agregar Usuario </a> -->
            
        salida.print("</div>");
        salida.print("</body>");
        salida.print("</html>");

    }

    

}
