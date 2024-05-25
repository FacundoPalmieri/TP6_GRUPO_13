package negocioImpl;

import java.util.ArrayList;

import dao.IPersonaDao;
import daoImpl.PersonaDaoImpl;
import entidad.Persona;
import negocio.IPersonaNegocio;

public class PersonaNegocio implements IPersonaNegocio {
	
	public int AgregarPersona(Persona persona) {
		return 1;
	}
	
	
	public boolean EliminarPersona(Persona personaDelete) {
		return true;
	}
	
	
	public ArrayList<Persona> ListarPersonas(){
		ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
		IPersonaDao personaNegocioImpl = new PersonaDaoImpl();
		try {
			listaPersonas=personaNegocioImpl.ListarPersonas();
		}
		catch(Exception e){
			e.getStackTrace();
		}
		return listaPersonas;
	}
}
