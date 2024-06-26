package negocioImpl;

import java.util.ArrayList;

import dao.IPersonaDao;
import daoImpl.PersonaDaoImpl;
import entidad.Persona;
import negocio.IPersonaNegocio;

public class PersonaNegocio implements IPersonaNegocio {
	
	 private IPersonaDao personaDao;

	    public PersonaNegocio() {
	        this.personaDao = new PersonaDaoImpl();
	    }
	    
	    public int AgregarPersona(Persona persona) {
			int filas=0;
			IPersonaDao personaDao = new PersonaDaoImpl();
			try {
				filas=personaDao.AgregarPersona(persona);
			}
			catch(Exception e){
				e.getStackTrace();
			}
			return filas;
		}
	
	
	public boolean EliminarPersona(Persona personaDelete) {
		IPersonaDao personaDao = new PersonaDaoImpl();
	    try {
	        boolean eliminado = personaDao.EliminarPersona(personaDelete);
	        return eliminado;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false; // Devuelve false si hubo un error al intentar eliminar la persona
	    }
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
	
	
	public int ModificarPersona(Persona persona) {
		return personaDao.ModificarPersona(persona);
	}
}
