package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.PersonaDao;
import entidad.Persona;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class panelModificarPersona extends JPanel {

	
	
	 public panelModificarPersona() {
			
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
		
		JLabel lblNombre = new JLabel("Seleccione la persona que desea modificar");
		lblNombre.setBounds(128, 11, 215, 14);
		panel.add(lblNombre);

	}
	
	public void show()
	{
		this.setVisible(true);
	}
}
