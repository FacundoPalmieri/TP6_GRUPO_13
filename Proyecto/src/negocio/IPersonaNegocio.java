package negocio;

import java.util.ArrayList;

import entidad.Persona;

public interface IPersonaNegocio {
	
	public int AgregarPersona(Persona persona);
	
	public boolean EliminarPersona(Persona personaDelete);
	
	public ArrayList<Persona> ListarPersonas();
	
	public int ModificarPersona(Persona persona);
	
}
