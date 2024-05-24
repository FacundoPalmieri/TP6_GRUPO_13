package dao;

import java.util.ArrayList;

import entidad.Persona;

public interface IPersonaDao {
	
	public int AgregarPersona(Persona persona);
	
	public int ModificarPersona(Persona persona);
	
	public boolean EliminarPersona(Persona personaDelete);
	
	public ArrayList<Persona> ListarPersonas();
	
}
