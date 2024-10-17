package servicios;

import java.util.Scanner;

public class MenuImplementacion implements MenuInterfaz {

	OperativaInterfazUsuario oiu=new OperativaImplementacionUsuario();
	OperativaInterfazClub oic=new OperativaImplementacionClub();
	
	Scanner sc=new Scanner(System.in);
	
	public byte menuPrincipal() {
		
		byte opcionUsuario;
		
		System.out.println("MENU PRINCIPAL");
		System.out.println("-------------------");
		System.out.println("0. Cerrar aplicacion");
		System.out.println("1. Usuarios");
		System.out.println("2. Mostrar usuarios");
		System.out.println("3. Clubes");
		System.out.println("4. Mostrar clubes");
		System.out.println("-------------------");
		System.out.println("Seleccione la opcion que desee: ");
		
		opcionUsuario=sc.nextByte();
		
		return opcionUsuario;
	}
	
	public byte menuUsuario() {
		
		byte opcionUsuarioUsuario;
		
		System.out.println("0. Volver");
		System.out.println("1. Alta usuario");
		System.out.println("2. Modificar usuario");
		System.out.println("3. Eliminar usuario");
		System.out.println("-------------------");
		System.out.println("Seleccione la opcion que desee: ");
		
		opcionUsuarioUsuario=sc.nextByte();
		
		switch(opcionUsuarioUsuario) {
			case 0:
				System.out.println("Cierre del menu");
				break;
			case 1:
				System.out.println("Opcion 1");
				oiu.altaUsuario();
				break;
			case 2:
				System.out.println("Opcion 2");
				oiu.modificarUsuario();
				break;
			case 3:
				System.out.println("Opcion 3");
				oiu.eliminarUsuario();
				break;
			default:
				System.out.println("La opcion seleccionada no existe");
				break;		
		}
		
		return opcionUsuarioUsuario;
	}
	
	public byte menuClub() {
		
		byte opcionUsuarioClub;
		
		System.out.println("0. Volver");
		System.out.println("1. Alta club");
		System.out.println("2. Modificar club");
		System.out.println("3. Eliminar club");
		System.out.println("-------------------");
		System.out.println("Seleccione la opcion que desee: ");
		
		opcionUsuarioClub=sc.nextByte();
		
			switch(opcionUsuarioClub) {
			case 0:
				System.out.println("Cierre del menu");
				break;
			case 1:
				System.out.println("Opcion 1");
				oic.altaClub();
				break;
			case 2:
				System.out.println("Opcion 2");
				oic.modificarClub();
				break;
			case 3:
				System.out.println("Opcion 3");
				oic.eliminarClub();
				break;
			default:
				System.out.println("La opcion seleccionada no existe");
				break;		
		}
		
		return opcionUsuarioClub;
	}
}
