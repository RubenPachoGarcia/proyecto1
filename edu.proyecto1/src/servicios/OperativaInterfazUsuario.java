package servicios;
import dtos.UsuarioDto;

public interface OperativaInterfazUsuario {

	public UsuarioDto altaUsuario();
	
	public void modificarUsuario();
	
	public void eliminarUsuario();
}
