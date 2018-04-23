package com.usuario.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionSingleton {
    // declaración  de las variables
    
    private final String host;//127.0.0.1 ó localhost ip del servidor
    private final String driver;// postgres-jdbc:postgresql
    private final String nameBD;
    private final String dsn;//data sourse name

    // datos de conexion 
    private final String user;
    private final String pwd;
    
    //variable para establecer l conexion con la BD
    private static Connection connection;
    
    //clase estática
  //  private static ConexionSingleton conexionSingleton;
    
    // implementacion del constructor
    public ConexionSingleton() {
        
        this.host = "localhost:5432";
        this.driver = "jdbc:postgresql";
        this.nameBD = "usuarios";
        
        this.dsn = driver+"://"+host+"/"+nameBD;
        
        this.user= "postgres";
        this.pwd= "web";
        
                   //connection = DriverManager.getConnection(dsn, user, pwd);
        conectarBaseDatos();
    }
    
    public  void conectarBaseDatos(){
         try{
             //Class.forName("org.postgresql.Driver");
             DriverManager.registerDriver(new org.postgresql.Driver());
            connection = DriverManager.getConnection(dsn, user, pwd);
             System.out.println("Acceso a la base de datos");
            
        }catch(SQLException e){
            System.out.println("Error de conexion: "+e.getMessage());
        }
    } 
    
    public static Connection getConexionSingleton(){
        
        if(connection== null){
             new ConexionSingleton();
            System.out.println("se hizo la conexion");
        }
        else{
            System.out.println("La conexion solo se puede Estableces una sóla vez");
        }
        return connection;
    }
    
    // cierra la conexion
    public static void cerrarConexion(){
        try{
            connection.close();
            
        }catch(SQLException e){
            System.out.println("Error al cerrar la conexión" + e.getMessage());
        }
    }
    
    // implementar el main para comprobar la conexion con la bd
    /*public static void main(String[] args) {
        Connection conexion= ConexionSingleton.getConexionSingleton();
        conexion=ConexionSingleton.getConexionSingleton();
        Connection conexion2= ConexionSingleton.getConexionSingleton();
        conexion2=ConexionSingleton.getConexionSingleton();
        
    }
    */
}
