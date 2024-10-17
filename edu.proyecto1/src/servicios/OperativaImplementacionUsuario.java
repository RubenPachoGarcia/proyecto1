package servicios;
import java.util.Scanner;

import conexion.conexionPostgreSQL;
import controladores.Inicio;
import dtos.UsuarioDto;

public class OperativaImplementacionUsuario implements OperativaInterfazUsuario {

	Scanner sc=new Scanner (System.in);
	
	public UsuarioDto altaUsuario() {
		
		UsuarioDto nuevoUsuario=new UsuarioDto();
		
		nuevoUsuario.setId_usuario(idAutomaticoUsuario());
		
		System.out.println("Introduzca su telefono: ");
		int telefonoNuevoUsuario=sc.nextInt();
		nuevoUsuario.setTelefono_usuario(telefonoNuevoUsuario);
		
		sc.nextLine();
		System.out.println("Introduzca su nombre: ");
		String nombreNuevoUsuario=sc.nextLine();
		nuevoUsuario.setNombre_usuario(nombreNuevoUsuario);
		
		System.out.println("Introduzca sus apellidos: ");
		String apellidosNuevoUsuario=sc.nextLine();
		nuevoUsuario.setApellidos_usuario(apellidosNuevoUsuario);
		
		System.out.println("Introduzca su email: ");
		String gmailNuevoUsuario=sc.next();
		nuevoUsuario.setGmail_usuario(gmailNuevoUsuario);
		
		conexionPostgreSQL conexionPostgreSQL=new conexionPostgreSQL();
		conexionPostgreSQL.insertTablaUsuarios(nuevoUsuario);
		
		Inicio.listaUsuarios.add(nuevoUsuario);
		
		return nuevoUsuario;
	}
	
	private long idAutomaticoUsuario() {
		
		long idAutomatico;
		int tamanioLista=Inicio.listaUsuarios.size();
		
		if(tamanioLista==0) {
			
			idAutomatico=1;
		}
		else 
		{
			idAutomatico=Inicio.listaUsuarios.get(tamanioLista - 1).getId_usuario() + 1;
		}
		
		return idAutomatico;
	}
	
	
	 public void modificarUsuario() {
	  
		 System.out.println("Introduzca el gmail del usuario que desea modificar: ");
		 String gmailAModificar=sc.nextLine();
		 
		 for(UsuarioDto usuarioAModificar:Inicio.listaUsuarios) {
			 
			 if(gmailAModificar.equals(usuarioAModificar.getGmail_usuario())) {
				 
				 System.out.println(usuarioAModificar);
				 
				 int opcionUsuario;
				 
				 System.out.println("-------------------");
				 System.out.println("0. Nombre");
				 System.out.println("1. Apellidos");
				 System.out.println("2. Gmail");
				 System.out.println("3. Telefono");
				 System.out.println("-------------------");
				 System.out.println("Seleccione el campo que desee: ");
				 
				 opcionUsuario=sc.nextInt();
				 
				 switch(opcionUsuario) {
				 
				 case 0:
					 sc.nextLine();
					 System.out.println("Introduzca el nuevo valor de nombre: ");
					 String nuevoNombreUsuario=sc.nextLine();
					 usuarioAModificar.setNombre_usuario(nuevoNombreUsuario);
					 break;
				 case 1:
					 sc.nextLine();
					 System.out.println("Introduzca el nuevo valor de apellidos: ");
					 String nuevoApellidoUsuario=sc.nextLine();
					 usuarioAModificar.setApellidos_usuario(nuevoApellidoUsuario);
					 break;
				 case 2:
					 System.out.println("Introduzca el nuevo valor de gmail: ");
					 String nuevoGmailUsuario=sc.next();
					 usuarioAModificar.setGmail_usuario(nuevoGmailUsuario);
					 break;
				 case 3:
					 System.out.println("Introduzca el nuevo valor de telefono: ");
					 int nuevoTelefonoUsuario=sc.nextInt();
					 usuarioAModificar.setTelefono_usuario(nuevoTelefonoUsuario);
					 break;
				 default:
					 System.out.println("La opcion seleccionada no existe");
					 break;
				 } 
				 
				 conexionPostgreSQL conexionPostgreSQL=new conexionPostgreSQL();
				 conexionPostgreSQL.updateTablaUsuarios(usuarioAModificar);
			 }
		 }
	 } 
	 
	 public void eliminarUsuario() {
		 
		 System.out.println("Introduzca el gmail del usuario que desea eliminar: ");
		 String gmailAEliminar=sc.next();
		 
		 for(UsuarioDto usuarioAEliminar:Inicio.listaUsuarios) {
			 
			 if(gmailAEliminar.equals(usuarioAEliminar.getGmail_usuario())) {
				 
				 conexionPostgreSQL conexionPostgreSQL=new conexionPostgreSQL();
				 conexionPostgreSQL.eliminarTablaUsuarios(usuarioAEliminar);
				 
				 Inicio.listaUsuarios.remove(usuarioAEliminar);
				 
				 System.out.println("El usuario se ha eliminado");
				 
				 break;
			 }
		 }
	 }
}
