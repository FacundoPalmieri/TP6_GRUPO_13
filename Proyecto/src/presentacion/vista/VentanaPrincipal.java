package presentacion.vista;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import javax.swing.SwingConstants;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenu mnPersonas;
	private JMenuItem menuAgregar;
	private JMenuItem menuModificar;
	private JMenuItem menuEliminar;
	private JMenuItem menuListar;
	

	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnPersonas = new JMenu("Persona");
		mnPersonas.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnPersonas);
		
		menuAgregar = new JMenuItem("Agregar");
		menuAgregar.setHorizontalAlignment(SwingConstants.LEFT);
		menuAgregar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnPersonas.add(menuAgregar);
		
		menuModificar = new JMenuItem("Modificar");
		menuModificar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnPersonas.add(menuModificar);
		
		menuEliminar = new JMenuItem("Eliminar");
		menuEliminar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnPersonas.add(menuEliminar);
		
		menuListar = new JMenuItem("Listar");
		menuListar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnPersonas.add(menuListar);
	}
	
	//getters y setters Menu Persona
	public JMenu getMnPersonas() {
		return mnPersonas;
	}

	public void setJMenu(JMenu mnPersonas) {
		this.mnPersonas = mnPersonas;
	}
	
	//getters y setters menu Agregar
	
	public JMenuItem getMnAgregar() {
		return menuAgregar;
	}

	public void setJMenuAgregar(JMenu mnAgregar) {
		this.menuAgregar = mnAgregar;
	}
	
	//getters y setters menu Modificar
	public JMenuItem getMenuModificar() {
		return menuModificar;
	}

	public void setMenuModificar(JMenuItem menuModificar) {
		this.menuModificar = menuModificar;
	}
	
	//getters y setters menu Eliminar

	public JMenuItem getMenuEliminar() {
		return menuEliminar;
	}

	public void setMenuEliminar(JMenuItem menuEliminar) {
		this.menuEliminar = menuEliminar;
	}
	
	
	//getters y setters menu Listar
	
	public JMenuItem getMenuListar() {
		return menuListar;
	}

	public void setMenuListar(JMenuItem menuListar) {
		this.menuListar = menuListar;
	}
	


}
