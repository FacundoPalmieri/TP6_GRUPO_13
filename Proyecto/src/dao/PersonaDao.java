package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import entidad.Persona;

public class PersonaDao {

	private String host = "jdbc:mysql://localhost:3306/";
	private String user ="root";
	private String pass = "root";
	private String dbName = "dbpersonas";

	public PersonaDao()
	{
	
	}
	
	public int AgregarPersona (Persona persona)
	{
		String query = "insert into Personas (Dni,Nombre,Apellido)values ('"+persona.getDni() + "', '" + persona.getNombre() + "', '" + persona.getApellido() + "')";
		Connection cn = null;
		int filas=0;
		
		try {
            cn = DriverManager.getConnection(host + dbName, user, pass);
            Statement st = cn.createStatement();
            filas = st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return filas;
    }
}
