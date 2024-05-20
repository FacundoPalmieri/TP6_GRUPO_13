package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import presentacion.vista.VentanaPrincipal;

public class Controlador  implements ActionListener  {
	private VentanaPrincipal ventanaPrincipal;
	
	public Controlador(VentanaPrincipal vista)
	{
		//Guardo todas las instancias que recibo en el constructor
		this.ventanaPrincipal = vista;
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
