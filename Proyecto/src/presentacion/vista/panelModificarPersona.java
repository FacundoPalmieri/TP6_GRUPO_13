package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class panelModificarPersona extends JPanel {

	private static final long serialVersionUID = 1L;

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
