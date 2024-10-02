package conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class conexionPostgreSQL {

    private final String url = "jdbc:postgresql://localhost:1045/proyecto1"; 
    private final String user = "postgres"; 
    private final String password = "sevillista04";

    public Connection conectar() {
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

    public void mostrarDatosDeTabla(String nombreTabla) {       

        String consultaSQL = "SELECT * FROM proyecto1_schema.\"" + nombreTabla + "\"";
        try (Connection conexion = conectar(); 
             Statement statement = conexion.createStatement();  
             ResultSet resultado = statement.executeQuery(consultaSQL)) {            

            int columnCount = resultado.getMetaData().getColumnCount();
            StringBuilder header = new StringBuilder("| ");
            for (int i = 1; i <= columnCount; i++) {
                header.append(resultado.getMetaData().getColumnName(i)).append(" | ");
            }

            System.out.println(header);
            System.out.println("-".repeat(header.length()));            

            while (resultado.next()) {
                StringBuilder row = new StringBuilder("| ");
                for (int i = 1; i <= columnCount; i++) {
                    row.append(resultado.getString(i)).append(" | ");
                }

                System.out.println(row);
            }
            
        } catch (SQLException e) {
            System.out.println("Error al obtener los datos: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        conexionPostgreSQL mostrarDatos = new conexionPostgreSQL();        

        System.out.print("Introduzca el nombre de la tabla que quieres mostrar: ");

        String nombreTabla = scanner.nextLine();        

        mostrarDatos.mostrarDatosDeTabla(nombreTabla);

        scanner.close();
    }
}