package main;


import presentacion.controlador.Controlador;
import presentacion.vista.VentanaPrincipal;

public class main {

	public static void main(String[] args) {
		VentanaPrincipal ventana = new VentanaPrincipal();
		Controlador controlador = new Controlador(ventana);
		controlador.inicializar();
		
				
		
		
	}

}
