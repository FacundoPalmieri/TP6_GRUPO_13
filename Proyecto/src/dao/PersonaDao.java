package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entidad.Persona;

public class PersonaDao {

	private String host = "jdbc:mysql://localhost:3306/";
	private String user ="root";
	private String pass = "root";
	private String dbName = "bdpersonas";

	public PersonaDao()
	{
	
	}
	
	public int agregarPersona(Persona persona) {
	    String query = "INSERT INTO Personas (Nombre, Apellido, Dni) VALUES ('"+persona.getNombre()+"','"+persona.getApellido()+"','"+persona.getDni()+"')";
	    Connection cn = null;
	    int filas = 0;
	    
	    try {
	        cn = DriverManager.getConnection(host + dbName, user, pass);
	        Statement st = cn.createStatement();
	        filas = st.executeUpdate(query);

	     
	    } catch (SQLException e) {
	        e.printStackTrace();
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
				p.setApellido(rs.getNString("Apellido"));
				p.setDni(rs.getString("Dni"));
				listaPersonas.add(p);
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return listaPersonas;
	}
}
