package dtos;

public class UsuarioDto {
	
	//Atributos
	long id_usuario=0;
	String nombre_usuario="aaaaa";
	String apellidos_usuario="aaaaa";
	String gmail_usuario="aaaaa";
	int telefono_usuario=0;
	
	//Metodos Getters y Setters
	public long getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(long id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNombre_usuario() {
		return nombre_usuario;
	}
	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	public String getApellidos_usuario() {
		return apellidos_usuario;
	}
	public void setApellidos_usuario(String apellidos_usuario) {
		this.apellidos_usuario = apellidos_usuario;
	}
	public String getGmail_usuario() {
		return gmail_usuario;
	}
	public void setGmail_usuario(String gmail_usuario) {
		this.gmail_usuario = gmail_usuario;
	}
	public int getTelefono_usuario() {
		return telefono_usuario;
	}
	public void setTelefono_usuario(int telefono_usuario) {
		this.telefono_usuario = telefono_usuario;
	}
	
	//Constructor con todos los campos
	public UsuarioDto(long id_usuario, String nombre_usuario, String apellidos_usuario, String gmail_usuario,
			int telefono_usuario) {
		super();
		this.id_usuario = id_usuario;
		this.nombre_usuario = nombre_usuario;
		this.apellidos_usuario = apellidos_usuario;
		this.gmail_usuario = gmail_usuario;
		this.telefono_usuario = telefono_usuario;
	}
	
	//Constructor vacio
	public UsuarioDto() {
		super();
	}
	
	//Metodo ToString
	@Override
	public String toString() {
		
		String objetoStringUsuario = id_usuario + ";" + nombre_usuario +  ";" + apellidos_usuario + ";" + gmail_usuario + ";" + telefono_usuario;
		return objetoStringUsuario;		
	}
}