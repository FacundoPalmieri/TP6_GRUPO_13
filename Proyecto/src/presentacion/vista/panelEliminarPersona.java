package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import daoImpl.PersonaDaoImpl;
import entidad.Persona;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class panelEliminarPersona extends JPanel {

	
	
	 public panelEliminarPersona() {
			
		super();
		initialize();
	}

	private void initialize() {
		this.setBounds(100, 100, 514, 455);
		this.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(60, 22, 444, 227);
		this.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("ELIMINAR USUARIOS");
		lblNombre.setBounds(63, 11, 161, 14);
		panel.add(lblNombre);
		
		JList list = new JList();
		list.setBounds(26, 36, 252, 121);
		panel.add(list);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(109, 168, 89, 23);
		panel.add(btnEliminar);

	}
	
	public void show()
	{
		this.setVisible(true);
	}
}
