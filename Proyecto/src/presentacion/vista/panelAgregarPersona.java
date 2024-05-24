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

public class panelAgregarPersona extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldDni;
	private Persona persona = new Persona();
	private PersonaDaoImpl personaDao = new PersonaDaoImpl();
	
	 public panelAgregarPersona() {
			
		super();
		initialize();
	}

	private void initialize() {
		this.setBounds(100, 100, 514, 455);
		this.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 22, 444, 227);
		this.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(110, 3, 46, 14);
		panel.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(110, 38, 46, 14);
		panel.add(lblApellido);
		
		JLabel lblDni = new JLabel("Dni");
		lblDni.setBounds(110, 67, 46, 14);
		panel.add(lblDni);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(190, 0, 86, 20);
		panel.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(190, 35, 86, 20);
		panel.add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		textFieldDni = new JTextField();
		textFieldDni.setBounds(190, 64, 86, 20);
		panel.add(textFieldDni);
		textFieldDni.setColumns(10);
		textFieldDni.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
			}
		});
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try {
				if(!(textFieldNombre.getText().isEmpty() || textFieldApellido.getText().isEmpty() || textFieldDni.getText().isEmpty())) {
					persona.setNombre(textFieldNombre.getText());
					persona.setApellido(textFieldApellido.getText());
					persona.setDni(textFieldDni.getText());
					
					int filas = personaDao.agregarPersona(persona);
					
					if(filas == 1) {
					JOptionPane.showMessageDialog(null, "Persona agregada correctamente");
					  textFieldNombre.setText("");
					  textFieldApellido.setText("");
					  textFieldDni.setText("");
						
					}
					else {
						JOptionPane.showMessageDialog(null, "No se pudo agregar la persona");
					}	
		              
			    } else if(textFieldNombre.getText().isEmpty()) {
		            throw new Exception("Debe completar el nombre");
		            
		          } else if (textFieldApellido.getText().isEmpty()) {
		        		throw new Exception("Debe completar el apellido");
		        		
		        	} else {
		        	   throw new Exception("Debe completar el DNI");
		        	} 
			} catch (SQLException ex) {
	                   ex.printStackTrace();
	                   if (ex.getErrorCode() == 1062) { // Código de error de clave duplicada en MySQL
	                       JOptionPane.showMessageDialog(null, "DNI ya registrado en Base de Datos");
	                   } else {
	                       JOptionPane.showMessageDialog(null, "Error de base de datos: " + ex.getMessage());
	                   }
			   } catch (Exception ex) {
			          JOptionPane.showMessageDialog(null, ex.getMessage());
			        }
			}
		});
		btnAceptar.setBounds(110, 102, 89, 23);
		panel.add(btnAceptar);

	}
	
	public void show()
	{
		this.setVisible(true);
	}
}
