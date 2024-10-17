package controladores;
import java.util.ArrayList;
import java.util.List;
import conexion.conexionPostgreSQL;
import dtos.ClubDto;
import dtos.UsuarioDto;
import servicios.MenuImplementacion;
import servicios.MenuInterfaz;

public class Inicio {
	
	public static List<UsuarioDto> listaUsuarios = new ArrayList<>();
	
	public static List<ClubDto> listaClubes = new ArrayList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MenuInterfaz mi=new MenuImplementacion();
		
		try {
			
			conexionPostgreSQL.mostrarDatosDeTablaUsuarios();
			conexionPostgreSQL.mostrarDatosDeTablaClubes();
			
			System.out.println("BIENVENIDO");
		} 
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		byte opcion;
		boolean cerrarMenu=false;
		
		while(!cerrarMenu) {
			
			opcion=mi.menuPrincipal();
			
			switch(opcion) {
				case 0:
					System.out.println("Cierre de la aplicacion");
					cerrarMenu=true;
					break;
				case 1:
					System.out.println("Opcion 1");
					opcion=mi.menuUsuario();
					break;
				case 2:
					System.out.println("Opcion 2");
					for(UsuarioDto usuario : listaUsuarios) {
						
						System.out.println(usuario);
					}
					break;
				case 3:
					System.out.println("Opcion 3");
					opcion=mi.menuClub();
					break;
				case 4:
					System.out.println("Opcion 4");
					for(ClubDto club: listaClubes) {
						
						System.out.println(club);
					}
					break;
				default:
					System.out.println("La opcion seleccionada no existe");
					break;		
			}
		}		
	}
}
