
package com.usuario.dao;

import com.usuario.db.ConexionSingleton;
import com.usuarios.domain.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDaoImpl implements UsuarioDao{
    private Connection connection;
    private PreparedStatement preparedstatement;
    private ResultSet resultSet;
    private String query;
    //private Statement statement2;
    @Override
    public List<Usuario> obtenerRegistros() {
        List<Usuario> listaRegistro = new ArrayList<>();
        try {
            connection = ConexionSingleton.getConexionSingleton();
            query = "SELECT * FROM usuario";

            preparedstatement =  connection.prepareStatement(query);
            //statement=connection.prepareStatement(query);
            resultSet = preparedstatement.executeQuery();

            while(resultSet.next()){
                System.out.println("obteniendo datos.. lista de datos");
                    Usuario usuario = new Usuario();
                    usuario.setIdUsuario(resultSet.getInt("idUsuario"));
                    usuario.setUsr(resultSet.getString("usr"));
                    usuario.setPwd(resultSet.getString("pwd"));
                    System.out.println(resultSet.getInt("idUsuario"));
                    System.out.println(resultSet.getString("usr"));
                    System.out.println(resultSet.getString("pwd"));
                    listaRegistro.add(usuario);
            }
            resultSet.close();
            preparedstatement.close();

            //return listaRegistro;
        } catch(SQLException e) {
            System.out.println("Error al obtener los registros"+ e.getMessage());
                //return null;
        }
        return listaRegistro;
    }
	@Override
	public Usuario obtenerRegistro(Integer id) {
            Usuario usuario= null;
            try{
                connection = ConexionSingleton.getConexionSingleton();
                query = "SELECT * From Usuario WHERE idUsuario =?";
                preparedstatement = connection.prepareStatement(query);

                preparedstatement.setInt(1, id);
                resultSet = preparedstatement.executeQuery();

                if(resultSet.next()) {
                    usuario = new Usuario();
                    usuario.setIdUsuario(resultSet.getInt("idusuario"));
                    usuario.setUsr(resultSet.getString("usr"));
                    usuario.setPwd(resultSet.getString("pwd"));
                    // Configurar los demás
                }

                resultSet.close();
                preparedstatement.close();
                return usuario;
            } catch(SQLException e) {
                System.out.println("Error al obtener el registros"+ e.getMessage());
                    return null;
            }
        //return null;
	}

  @Override
	public void crearRegistro(Usuario usuario) {
		try {
			connection = ConexionSingleton.getConexionSingleton();
			query = "INSERT INTO usuario(usr, pwd) VALUES(?, ?)";

			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, usuario.getUsr());
			preparedstatement.setString(2, usuario.getPwd());
			preparedstatement.executeUpdate();

			preparedstatement.close();
		} catch(SQLException e) {
                    System.out.println("Error al Crear el registro" +e.getMessage());
		
		}
	}

	@Override
	public void actualizarRegistro (Usuario usuario) {
		try {
			connection = ConexionSingleton.getConexionSingleton();
			query = "UPDATE Usuario SET usr = ?, pwd = ? WHERE idUsuario = ?";

			preparedstatement = connection.prepareStatement(query);
                        
			preparedstatement.setString(1, usuario.getUsr());
			preparedstatement.setString(2, usuario.getPwd());
                        preparedstatement.setInt(3, usuario.getIdUsuario());
			preparedstatement.executeUpdate();

			preparedstatement.close();
                        System.out.println("Se hizo la actualizacion");
		} catch(SQLException e) {
                    System.out.println("Error al Actualizar los registros"+e.getMessage());
		}
	}

	@Override
	public Integer eliminarRegistro(Integer idUsuario) {
            Integer exito = null;
		try {
			connection = ConexionSingleton.getConexionSingleton();;
			query = "DELETE FROM Usuario WHERE idUsuario = ?";

			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setInt(1, idUsuario);
			exito=preparedstatement.executeUpdate();
                        System.out.println("Exito valor:  "+exito);

			preparedstatement.close();
                        return exito;
		} catch(SQLException e) {
                    System.out.println("Error al eliminar el registro"+e.getMessage());
                    return null;
		}
	}
    
}
