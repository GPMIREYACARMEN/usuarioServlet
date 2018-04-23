
package com.usuario.controller;

import com.usuario.service.UsuarioService;
import com.usuario.service.UsuarioServiceImpl;
import com.usuarios.domain.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet(name = "ListarUsuarioServlet", urlPatterns = {"/ListarUsuarioServlet"})// nombre wue se va 
//nombrar el servlet en el archivo web.xml
public class ListarUsuarioServlet extends HttpServlet {

   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // generar la pagina html para mostrar los usuarios
        
        // indicar sí se generará código html o xml
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
        salida.println("<h1>Listar Usuario</h1>");
      
        
        salida.println("<table class='table");
        // encabezado del table
        salida.print("<thead class='thead-dark'> "
                +"<tr>"
                +"<th>Id Usuario</th>"
                +"<th> Nombre </th>"
                +"<th>Password</th>"
                +"<th>Editar</th>"
                +"<th>Eliminar</th>"
                + "</tr>"
                + "</thead>");
        
        /// cuerpo del table
        // for java 8
        
        UsuarioService usuarioService = new UsuarioServiceImpl();
        List<Usuario> listaUsuario = usuarioService.obtenerRegistros();
        
        listaUsuario.forEach((usuario) -> {
            salida.print("<tr>" 
                    + "<td>"+usuario.getIdUsuario()+"</td>"
                    + "<td>"+usuario.getUsr()+"</td>"
                    + "<td>"+usuario.getPwd()+"</td>"
                    + "<td><a href='ActualizarUsuarioServletVista?idUsuario="+usuario.getIdUsuario()+"'>Editar</a></td>"
                    + "<td><a href='EliminarUsuarioServlet?idUsuario="+usuario.getIdUsuario()+"'>Elimar</a></td>"
                    + "</tr>");
        });
        
        salida.println("</table>");
        salida.println("<a class='btn btn-info' role='button' href='index.html'> Principal</a>");
        salida.println("</body>");
        
        salida.println("</html>");

    }

  

}
