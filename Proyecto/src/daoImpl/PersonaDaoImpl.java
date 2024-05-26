package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.IPersonaDao;
import entidad.Persona;

public class PersonaDaoImpl implements IPersonaDao {
	private String host = "jdbc:mysql://localhost:3306/";
	private String user ="root";
	//Comentar el que corresrootponda
    private String pass = "root";
	//private String pass = "ROOT";
	private String dbName = "bdpersonas";

	public PersonaDaoImpl()
	{
	
	}
	
	public int AgregarPersona(Persona persona) throws SQLException{
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
	
	
	public ArrayList<Persona> ListarPersonas() {
        ArrayList<Persona> listaPersonas = new ArrayList<>();
        String query = "SELECT * FROM personas";
        Connection cn = null;
        try {
            cn = DriverManager.getConnection(host + dbName, user, pass);
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Persona p = new Persona();
                p.setNombre(rs.getString("Nombre"));
                p.setApellido(rs.getString("Apellido"));
                p.setDni(rs.getString("Dni"));
                listaPersonas.add(p);
            }
        } catch (Exception e) {
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
        return listaPersonas;
    }


	@Override
	public int ModificarPersona(Persona persona) {
		String query = "UPDATE Personas SET Nombre = ?, Apellido = ?, Dni = ? WHERE Dni = ?";
        Connection cn = null;
        int filasAfectadas = 0;
        try {
            cn = DriverManager.getConnection(host + dbName, user, pass);
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, persona.getNombre());
            pst.setString(2, persona.getApellido());
            pst.setString(3, persona.getDni());
            filasAfectadas = pst.executeUpdate();
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
        return filasAfectadas;
	}
	
	
	@Override
	public boolean EliminarPersona(Persona personaDelete) {
		 Connection cn = null;
		    try {
		        cn = DriverManager.getConnection(host + dbName, user, pass);
		        Statement st = cn.createStatement();
		        String query = "DELETE FROM Personas WHERE Dni = '" + personaDelete.getDni() + "'";
		        int filasAfectadas = st.executeUpdate(query);
		        return filasAfectadas > 0;
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return false;
		    } finally {
		        if (cn != null) {
		            try {
		                cn.close();
		            } catch (SQLException e) {
		                e.printStackTrace();
		            }
		        }
		    }
	}

}
