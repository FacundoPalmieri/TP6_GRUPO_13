package presentacion.vista;

import javax.swing.JPanel;
import entidad.Persona;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;

public class panelEliminarPersona extends JPanel {

	private static final long serialVersionUID = 1L;
    public JList<Persona> list;
    public DefaultListModel<Persona> listModel;
    public JButton btnEliminar;

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
		
		listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
        list.setBounds(26, 36, 252, 121);
        panel.add(list);
		
        btnEliminar = new JButton("ELIMINAR");
        btnEliminar.setBounds(109, 168, 89, 23);
        panel.add(btnEliminar);

	}
	
	
	public void show()
	{
		this.setVisible(true);
	}

	public JButton getBtnEliminar() {
		// TODO Auto-generated method stub
		return btnEliminar;
	}
	
	public JList<Persona> getList() {
        return list;
    }
    
    public DefaultListModel<Persona> getListModel() {
        return listModel;
    }
    
}
