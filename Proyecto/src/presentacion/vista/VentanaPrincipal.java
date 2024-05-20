package presentacion.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import javax.swing.SwingConstants;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;

	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnPersona = new JMenu("Persona");
		mnPersona.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnPersona);
		
		JMenuItem MenuItemAgregar = new JMenuItem("Agregar");
		MenuItemAgregar.setHorizontalAlignment(SwingConstants.LEFT);
		MenuItemAgregar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnPersona.add(MenuItemAgregar);
		
		JMenuItem MenuItemModificar = new JMenuItem("Modificar");
		MenuItemModificar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnPersona.add(MenuItemModificar);
		
		JMenuItem MenuItemEliminar = new JMenuItem("Eliminar");
		MenuItemEliminar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnPersona.add(MenuItemEliminar);
		
		JMenuItem MenuItemListar = new JMenuItem("Listar");
		MenuItemListar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnPersona.add(MenuItemListar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	
	public void cambiarVisibilidad(boolean estado) {
        setVisible(true);
    }

}
