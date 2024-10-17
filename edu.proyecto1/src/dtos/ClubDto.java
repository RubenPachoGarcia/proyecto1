package dtos;

public class ClubDto {

	//Atributos
	long id_club=0;
	String nombre_club="aaaaa";
	
	//Metodos Getters y Setters
	public long getId_club() {
		return id_club;
	}
	public void setId_club(long id_club) {
		this.id_club = id_club;
	}
	public String getNombre_club() {
		return nombre_club;
	}
	public void setNombre_club(String nombre_club) {
		this.nombre_club = nombre_club;
	}
	
	//Constructor con todos los campos
	public ClubDto(long id_club, String nombre_club) {
		super();
		this.id_club = id_club;
		this.nombre_club = nombre_club;
	}
	
	//Constructor vacio
	public ClubDto() {
		super();
	}
	
	//Metodo ToString
	@Override
	public String toString() {
		
		String objetoStringClub = id_club + ";" + nombre_club;
		return objetoStringClub;		
	}
}
