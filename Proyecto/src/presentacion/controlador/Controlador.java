package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import presentacion.vista.panelAgregarPersona;
import presentacion.vista.panelEliminarPersona;
import presentacion.vista.VentanaPrincipal;

public class Controlador  implements ActionListener  {
	private VentanaPrincipal ventanaPrincipal;
	private panelAgregarPersona pnlAgregarPersona;
	private panelEliminarPersona pnlEliminarPersona;
	
	public Controlador(VentanaPrincipal vista)
	{
		//Guardo todas las instancias que recibo en el constructor
		this.ventanaPrincipal = vista;
		
		//Instancio los paneles
		this.pnlAgregarPersona = new panelAgregarPersona();
		this.pnlEliminarPersona = new panelEliminarPersona();
		
		//Eventos menu del Frame principal llamado Ventana
		this.ventanaPrincipal.getMnAgregar().addActionListener(a->EventoClickMenu_AbrirPanel_AgregarPersona(a));
		
	}
	
	//EventoClickMenu abrir PanelAgregarPersonas
	public void  EventoClickMenu_AbrirPanel_AgregarPersona(ActionEvent a)
	{		
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlAgregarPersona);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}
	
	public void inicializar()
	{
		this.ventanaPrincipal.setVisible(true);;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
