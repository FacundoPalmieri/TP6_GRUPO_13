package main;
import dao.PersonaDao;
import entidad.Persona;
import presentacion.controlador.Controlador;
import presentacion.vista.VentanaPrincipal;

public class Principal {

	public static void main(String[] args) {
		VentanaPrincipal ventana = new VentanaPrincipal();
		Controlador controlador = new Controlador(ventana);
		controlador.inicializar();
	
    }

	}


