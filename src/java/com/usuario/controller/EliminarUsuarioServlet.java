
package com.usuario.controller;

import com.usuario.service.UsuarioService;
import com.usuario.service.UsuarioServiceImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EliminarUsuarioServlet", urlPatterns = {"/EliminarUsuarioServlet"})
public class EliminarUsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id=request.getParameter("idUsuario");
        Integer idUsuario =Integer.parseInt(id);
        
        // se llama la implementacion de sevicio
        UsuarioService usuarioService = new UsuarioServiceImpl();
        Integer estado= usuarioService.eliminarRegistro(idUsuario);
        
        if(estado >0){
            response.sendRedirect("ListarUsuarioServlet");// debe ser iagual a la clase
        }
        else{
            // codificar con java scrip el mensaje de error
            System.out.println("No se pudo eliminar el usuario");
        }
    }


}
