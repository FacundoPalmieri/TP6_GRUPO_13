package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Persona;

public interface IPersonaDao {
	
	public int AgregarPersona(Persona persona) throws SQLException;
	
	public int ModificarPersona(Persona persona);
	
	public boolean EliminarPersona(Persona personaDelete);
	
	public ArrayList<Persona> ListarPersonas();
	
}
