package presentacion.vista;

import javax.swing.JPanel;
import entidad.Persona;
import javax.swing.JLabel;
import javax.swing.*;
import java.util.ArrayList;
import presentacion.controlador.Controlador;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class panelModificarPersona extends JPanel {

	private static final long serialVersionUID = 1L;
	private JList<Persona> list;
    private DefaultListModel<Persona> listModel;
    private Controlador controlador;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JButton btnModificar;
    private JTextField txtDni;

	public panelModificarPersona(Controlador controlador) {
		
		super();
		initialize();
        this.controlador = controlador;
		
	}

	private void initialize() {
		this.setBounds(100, 100, 514, 455);
		this.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 444, 293);
		this.add(panel);
		panel.setLayout(null);

        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
        list.setBounds(50, 35, 297, 121);
        panel.add(list);
		
		JLabel lblNombre = new JLabel("Seleccione la persona que desea modificar");
		lblNombre.setBounds(50, 11, 215, 14);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
        txtNombre.setBounds(0, 182, 91, 20);
        panel.add(txtNombre);
        txtNombre.setColumns(10);

        txtApellido = new JTextField();
        txtApellido.setBounds(92, 182, 100, 20);
        panel.add(txtApellido);
        txtApellido.setColumns(10);

        btnModificar = new JButton("MODIFICAR");
        btnModificar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnModificar.setBounds(290, 181, 91, 23);
        panel.add(btnModificar);
        
        txtDni = new JTextField();
        txtDni.setBounds(194, 182, 86, 20);
        panel.add(txtDni);
        txtDni.setColumns(10);
        
        JLabel lblNombre_1 = new JLabel("Nombre");
        lblNombre_1.setBounds(0, 167, 46, 14);
        panel.add(lblNombre_1);
        
        JLabel lblApellido = new JLabel("Apellido");
        lblApellido.setBounds(92, 167, 46, 14);
        panel.add(lblApellido);
        
        JLabel lblDni = new JLabel("DNI");
        lblDni.setBounds(194, 167, 46, 14);
        panel.add(lblDni);

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
    
    public String getNuevoDNI() {
        return txtDni.getText();
    }
    
	public void show()
	{
		this.setVisible(true);
	}
}
