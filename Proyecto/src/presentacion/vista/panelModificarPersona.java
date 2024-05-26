package presentacion.vista;

import javax.swing.JPanel;

import daoImpl.PersonaDaoImpl;
import entidad.Persona;

import javax.swing.JLabel;
import javax.swing.*;
import java.util.ArrayList;
import entidad.Persona;
import presentacion.controlador.Controlador;

public class panelModificarPersona extends JPanel {

	private static final long serialVersionUID = 1L;
	private JList<Persona> list;
    private DefaultListModel<Persona> listModel;
    private Controlador controlador;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JButton btnModificar;

	public panelModificarPersona(Controlador controlador) {
		
		super();
		initialize();
        this.controlador = controlador;
		
	}

	private void initialize() {
		this.setBounds(100, 100, 514, 455);
		this.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(60, 22, 444, 293);
		this.add(panel);
		panel.setLayout(null);

        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
        list.setBounds(26, 36, 252, 121);
        panel.add(list);
		
		JLabel lblNombre = new JLabel("Seleccione la persona que desea modificar");
		lblNombre.setBounds(22, 11, 215, 14);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
        txtNombre.setBounds(26, 168, 99, 20);
        panel.add(txtNombre);
        txtNombre.setColumns(10);

        txtApellido = new JTextField();
        txtApellido.setBounds(128, 168, 109, 20);
        panel.add(txtApellido);
        txtApellido.setColumns(10);

        btnModificar = new JButton("MODIFICAR");
        btnModificar.setBounds(257, 168, 109, 23);
        panel.add(btnModificar);

	}
	
	public void cargarPersonas() {
        listModel.clear();
        ArrayList<Persona> personas = controlador.listarPersonas();
        for (Persona persona : personas) {
            listModel.addElement(persona);
        }
    }

    public JButton getBtnModificar() {
        return btnModificar;
    }

    public Persona getPersonaSeleccionada() {
        return list.getSelectedValue();
    }

    public String getNuevoNombre() {
        return txtNombre.getText();
    }

    public String getNuevoApellido() {
        return txtApellido.getText();
    }
	public void show()
	{
		this.setVisible(true);
	}
}
