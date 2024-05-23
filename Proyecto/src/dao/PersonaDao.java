package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

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
}
