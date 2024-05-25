package presentacion.vista;

import javax.swing.JPanel;

import entidad.Persona;
import presentacion.controlador.Controlador;

import javax.swing.JLabel;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;

public class panelEliminarPersona extends JPanel {

	private static final long serialVersionUID = 1L;
    private JList<Persona> list;
    private DefaultListModel<Persona> listModel;
    private Controlador controlador;

	public panelEliminarPersona(Controlador controlador) {
		super();
		this.controlador = controlador;
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
		
		listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
        list.setBounds(26, 36, 252, 121);
        panel.add(list);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(109, 168, 89, 23);
		panel.add(btnEliminar);

	}
	
	public void cargarPersonas() {
        listModel.clear();
        ArrayList<Persona> personas = controlador.listarPersonas();
        if (personas == null) {
            System.out.println("Error: La lista de personas es null");
        } else {
            for (Persona persona : personas) {
                listModel.addElement(persona);
            }
        }
    }
	
	
	public void show()
	{
		this.setVisible(true);
	}
}
