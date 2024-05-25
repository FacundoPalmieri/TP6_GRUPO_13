package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.IPersonaDao;
import entidad.Persona;

public class PersonaDaoImpl implements IPersonaDao {
	private String host = "jdbc:mysql://localhost:3306/";
	private String user ="root";
	//Comentar el que corresponda
    private String pass = "root";
	//private String pass = "ROOT";
	//private String pass = "admin";
	private String dbName = "bdpersonas";

	public void PersonaDao()
	{
	
	}
	
	public int agregarPersona(Persona persona) throws SQLException{
	    String query = "INSERT INTO Personas (Nombre, Apellido, Dni) VALUES ('"+persona.getNombre()+"','"+persona.getApellido()+"','"+persona.getDni()+"')";
	    Connection cn = null;
	    int filas = 0;
	    
	    try {
	        cn = DriverManager.getConnection(host + dbName, user, pass);
	        Statement st = cn.createStatement();
	        filas = st.executeUpdate(query);

	     
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw e;
	    } finally {
	        if (cn != null) {
	            try {
	                cn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    return filas;
	}
	
	
	public ArrayList<Persona> listarPersonas(String dni) {
		ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
		String query="SELECT * FROM personas";
		Connection cn= null;
		
		try {
			cn = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				Persona p = new Persona();
				p.setNombre(rs.getString("Nombre"));
				p.setApellido(rs.getString("Apellido"));
				p.setDni(rs.getString("Dni"));
				listaPersonas.add(p);
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return listaPersonas;
	}

	@Override
	public int AgregarPersona(Persona persona) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int ModificarPersona(Persona persona) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	@Override
	public boolean EliminarPersona(Persona personaDelete) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Persona> ListarPersonas() {
		// TODO Auto-generated method stub
		return null;
	}

}
