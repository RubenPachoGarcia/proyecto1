package conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controladores.Inicio;
import dtos.ClubDto;
import dtos.UsuarioDto;

public class conexionPostgreSQL {

    private static final String url = "jdbc:postgresql://localhost:1045/proyecto1"; 
    private static final String user = "postgres"; 
    private static final String password = "sevillista04";

    public static Connection conectar() {
        Connection conexion = null;

        try {

            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa a PostgreSQL!");
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Driver no encontrado: " + e.getMessage());
        }

        return conexion;
    }

    public static void mostrarDatosDeTablaUsuarios() {       

        String consultaSQL = "SELECT * FROM proyecto1_schema.\"usuarios\"";
        try (Connection conexion = conectar(); 
             Statement statement = conexion.createStatement();  
             ResultSet resultado = statement.executeQuery(consultaSQL)) {             

            while (resultado.next()) {
                Long id=resultado.getLong("id_usuario");
                String nombre=resultado.getString("nombre_usuario");
                String apellido=resultado.getString("apellidos_usuario");
                String gmail=resultado.getString("gmail_usuario");
                Integer telefono=resultado.getInt("telefono_usuario");

                UsuarioDto usuario=new UsuarioDto(id, nombre, apellido, gmail, telefono);
                Inicio.listaUsuarios.add(usuario);
            }    
        } catch (SQLException e) {
            System.out.println("Error al obtener los datos: " + e.getMessage());
        }
    } 
    
    public void insertTablaUsuarios(UsuarioDto usuarioDto) {
    	
    	String consultaSQL = String.format("INSERT INTO proyecto1_schema.\"usuarios\" (id_usuario, nombre_usuario, apellidos_usuario, gmail_usuario, telefono_usuario)"
    			+ "VALUES (%d, '%s', '%s', '%s', %d)", usuarioDto.getId_usuario(), usuarioDto.getNombre_usuario(), usuarioDto.getApellidos_usuario(), usuarioDto.getGmail_usuario(), usuarioDto.getTelefono_usuario());
    	
    	try (Connection conexion = conectar(); 
             Statement statement = conexion.createStatement())
    	{
    		statement.executeUpdate(consultaSQL);
    	}catch (SQLException e) {
            System.out.println("Error al obtener los datos: " + e.getMessage());
        }
    }
    
    public void updateTablaUsuarios(UsuarioDto usuarioDto) {
    	
        String consultaSQL = String.format("UPDATE proyecto1_schema.\"usuarios\" "
                + "SET nombre_usuario = '%s', apellidos_usuario = '%s', gmail_usuario = '%s', telefono_usuario = %d "
                + "WHERE id_usuario = %d",
                usuarioDto.getNombre_usuario(), usuarioDto.getApellidos_usuario(), usuarioDto.getGmail_usuario(), usuarioDto.getTelefono_usuario(), usuarioDto.getId_usuario());

        try (Connection conexion = conectar(); 
            Statement statement = conexion.createStatement()) 
        {
        	statement.executeUpdate(consultaSQL);
        } catch (SQLException e) {
            System.out.println("Error al actualizar los datos: " + e.getMessage());
        }
    }
    
    public void eliminarTablaUsuarios(UsuarioDto usuarioDto) {
        
    	String consultaSQL = String.format("DELETE FROM proyecto1_schema.\"usuarios\" WHERE gmail_usuario = '%s'", usuarioDto.getGmail_usuario());
        
        try (Connection conexion = conectar(); 
            Statement statement = conexion.createStatement()) {
        	statement.executeUpdate(consultaSQL);
        } catch (SQLException e) {
            System.out.println("Error al eliminar el usuario: " + e.getMessage());
        }
    }
    
    public static void mostrarDatosDeTablaClubes() {       

    	String consultaSQL = "SELECT * FROM proyecto1_schema.\"clubes\"";
        try (Connection conexion = conectar(); 
             Statement statement = conexion.createStatement();  
             ResultSet resultado = statement.executeQuery(consultaSQL)) {             

            while (resultado.next()) {
                Long id=resultado.getLong("id_club");
                String nombre=resultado.getString("nombre_club");

                ClubDto club=new ClubDto(id, nombre);
                Inicio.listaClubes.add(club);
            }    
        } catch (SQLException e) {
            System.out.println("Error al obtener los datos: " + e.getMessage());
        }
    }
    
    public void insertTablaClubes(ClubDto clubDto) {
    	
    	String consultaSQL = String.format("INSERT INTO proyecto1_schema.\"clubes\" (id_club, nombre_club)"
    			+ "VALUES (%d, '%s')", clubDto.getId_club(), clubDto.getNombre_club());
    	
    	try (Connection conexion = conectar(); 
             Statement statement = conexion.createStatement())
    	{
    		statement.executeUpdate(consultaSQL);
    	}catch (SQLException e) {
            System.out.println("Error al obtener los datos: " + e.getMessage());
        }
    }
    
    public void updateTablaClubes(ClubDto clubDto) {
    	
        String consultaSQL = String.format("UPDATE proyecto1_schema.\"clubes\" "
                + "SET nombre_club = '%s'",
                clubDto.getNombre_club());

        try (Connection conexion = conectar(); 
             Statement statement = conexion.createStatement()) {
        	statement.executeUpdate(consultaSQL);
        } catch (SQLException e) {
            System.out.println("Error al actualizar los datos: " + e.getMessage());
        }
    }
    
    public void eliminarTablaClubes(ClubDto clubDto) {
        
        String consultaSQL = String.format("DELETE FROM proyecto1_schema.\"clubes\" WHERE nombre_club = '%s'", clubDto.getNombre_club());
        
        try (Connection conexion = conectar(); 
            Statement statement = conexion.createStatement()) {
        	statement.executeUpdate(consultaSQL);
        } catch (SQLException e) {
            System.out.println("Error al eliminar el club: " + e.getMessage());
        }
    }
}