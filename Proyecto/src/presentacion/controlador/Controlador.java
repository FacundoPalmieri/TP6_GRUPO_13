package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import entidad.Persona;
import negocioImpl.PersonaNegocio;
import presentacion.vista.panelAgregarPersona;
import presentacion.vista.panelModificarPersona;
import presentacion.vista.panelEliminarPersona;
import presentacion.vista.panelListarPersona;
import presentacion.vista.VentanaPrincipal;

public class Controlador implements ActionListener  {
	private VentanaPrincipal ventanaPrincipal;
	private panelAgregarPersona pnlAgregarPersona;
	private panelModificarPersona pnlModificarPersona;
	private panelEliminarPersona pnlEliminarPersona;
	private panelListarPersona pnlListarPersona;
	private PersonaNegocio personaNegocio;
	private ArrayList<Persona> listaPersonas;
	
	public Controlador(VentanaPrincipal vista, PersonaNegocio personaNegocio)
	{
		//Guardo todas las instancias que recibo en el constructor
		this.ventanaPrincipal = vista;
		this.personaNegocio = personaNegocio;
		
		//Instancio los paneles
		this.pnlAgregarPersona = new panelAgregarPersona();
		this.pnlModificarPersona = new panelModificarPersona();
		this.pnlEliminarPersona = new panelEliminarPersona(this);
		this.pnlListarPersona = new panelListarPersona();
		
		//Eventos menu del Frame principal llamado Ventana
		this.ventanaPrincipal.getMnAgregar().addActionListener(a->EventoClickMenu_AbrirPanel_AgregarPersona(a));
		this.ventanaPrincipal.getMenuEliminar().addActionListener(s->EventoClickMenu_AbrirPanel_EliminarPersona(s));
		this.ventanaPrincipal.getMenuModificar().addActionListener(s->EventoClickMenu_AbrirPanel_ModificarPersona(s));
		this.ventanaPrincipal.getMenuListar().addActionListener(s->EventoClickMenu_AbrirPanel_ListarPersona(s));
		
	}
	
    public ArrayList<Persona> listarPersonas() {
        ArrayList<Persona> personas = personaNegocio.ListarPersonas();
        return personas;
    }
	
	//EventoClickMenu abrir PanelAgregarPersonas
	public void  EventoClickMenu_AbrirPanel_AgregarPersona(ActionEvent a)
	{		
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlAgregarPersona);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}
	public void  EventoClickMenu_AbrirPanel_EliminarPersona(ActionEvent s)
	{		
		ventanaPrincipal.getContentPane().removeAll();
        pnlEliminarPersona.cargarPersonas();
		ventanaPrincipal.getContentPane().add(pnlEliminarPersona);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}
	
	public void  EventoClickMenu_AbrirPanel_ModificarPersona(ActionEvent s)
	{		
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlModificarPersona);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}
	
	public void  EventoClickMenu_AbrirPanel_ListarPersona(ActionEvent s)
	{		
		listaPersonas=personaNegocio.ListarPersonas();
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlListarPersona);
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
