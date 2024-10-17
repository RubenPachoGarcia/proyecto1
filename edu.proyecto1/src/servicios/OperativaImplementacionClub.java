package servicios;

import java.util.Scanner;

import conexion.conexionPostgreSQL;
import controladores.Inicio;
import dtos.ClubDto;

public class OperativaImplementacionClub implements OperativaInterfazClub{

	Scanner sc=new Scanner (System.in);
	
	public ClubDto altaClub() {
		
		ClubDto nuevoClub=new ClubDto();
		
		nuevoClub.setId_club(idAutomaticoClub());
		
		System.out.println("Introduzca el nombre del club: ");
		String nombreNuevoClub=sc.nextLine();
		nuevoClub.setNombre_club(nombreNuevoClub);
		
		conexionPostgreSQL conexionPostgreSQL=new conexionPostgreSQL();
		conexionPostgreSQL.insertTablaClubes(nuevoClub);
		
		Inicio.listaClubes.add(nuevoClub);
		
		return nuevoClub;
	}
	
	private long idAutomaticoClub() {
		
		long idAutomatico;
		int tamanioLista=Inicio.listaClubes.size();
		
		if(tamanioLista==0) {
			
			idAutomatico=1;
		}
		else 
		{
			idAutomatico=Inicio.listaClubes.get(tamanioLista - 1).getId_club() + 1;
		}
		
		return idAutomatico;
	}
	
	public void modificarClub() {
		  
		 System.out.println("Introduzca el nombre del club que desea modificar el nombre: ");
		 String nombreAModificar=sc.nextLine();
		 
		 for(ClubDto clubAModificar:Inicio.listaClubes) {
			 
			 if(nombreAModificar.equals(clubAModificar.getNombre_club())) {
				 
				 System.out.println(clubAModificar); 				 				 				 
				 
				 System.out.println("Introduzca el nuevo valor de nombre: ");
				 String nuevoNombreClub=sc.nextLine();
				 clubAModificar.setNombre_club(nuevoNombreClub);
				 
				 conexionPostgreSQL conexionPostgreSQL=new conexionPostgreSQL();
				 conexionPostgreSQL.updateTablaClubes(clubAModificar);
			 }
		 }
	 }
	
	public void eliminarClub() {
		 
		 System.out.println("Introduzca el nombre del club que desea eliminar: ");
		 String nombreClubAEliminar=sc.nextLine();
		 
		 for(ClubDto clubAEliminar:Inicio.listaClubes) {
			 
			 if(nombreClubAEliminar.equals(clubAEliminar.getNombre_club())) {
				 
				 conexionPostgreSQL conexionPostgreSQL=new conexionPostgreSQL();
				 conexionPostgreSQL.eliminarTablaClubes(clubAEliminar);
				 
				 Inicio.listaClubes.remove(clubAEliminar);
				 
				 System.out.println("El club se ha eliminado");
				 
				 break;
			 }
		 }
	 }
}
