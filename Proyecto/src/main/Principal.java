package main;
import negocioImpl.PersonaNegocio;
import presentacion.controlador.Controlador;
import presentacion.vista.VentanaPrincipal;

public class Principal {

	public static void main(String[] args) {
		VentanaPrincipal ventana = new VentanaPrincipal();
		PersonaNegocio personaNegocio = new PersonaNegocio();
		Controlador controlador = new Controlador(ventana,personaNegocio);
		controlador.inicializar();
	
    }

	}


