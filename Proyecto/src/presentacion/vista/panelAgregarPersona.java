package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class panelAgregarPersona extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldDni;
	
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
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(110, 102, 89, 23);
		panel.add(btnAceptar);

	}
	
	public void show()
	{
		this.setVisible(true);
	}
}
