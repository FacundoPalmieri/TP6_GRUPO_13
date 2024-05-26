package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import entidad.Persona;
import negocioImpl.PersonaNegocio;
import presentacion.vista.panelAgregarPersona;
import presentacion.vista.panelModificarPersona;
import presentacion.vista.panelEliminarPersona;
import presentacion.vista.panelListarPersona;
import presentacion.vista.VentanaPrincipal;

public class Controlador implements ActionListener  {
	private VentanaPrincipal ventanaPrincipal;
	private panelModificarPersona pnlModificarPersona;
	private panelEliminarPersona pnlEliminarPersona;
	private PersonaNegocio personaNegocio;
	private ArrayList<Persona> listaPersonas;
	
	public Controlador(VentanaPrincipal vista, PersonaNegocio personaNegocio)
	{
		//Guardo todas las instancias que recibo en el constructor
		this.ventanaPrincipal = vista;
		this.personaNegocio = personaNegocio;
		
		//Eventos menu del Frame principal llamado Ventana
		this.ventanaPrincipal.getMnAgregar().addActionListener(a->EventoClickMenu_AbrirPanel_AgregarPersona(a));
		this.ventanaPrincipal.getMenuEliminar().addActionListener(s->EventoClickMenu_AbrirPanel_EliminarPersona(s));
		this.ventanaPrincipal.getMenuModificar().addActionListener(s->EventoClickMenu_AbrirPanel_ModificarPersona(s));
		this.ventanaPrincipal.getMenuListar().addActionListener(s->EventoClickMenu_AbrirPanel_ListarPersona(s));
		//this.pnlModificarPersona.getBtnModificar().addActionListener(e -> modificarPersonaSeleccionada());
	}
	
	
    public ArrayList<Persona> listarPersonas() {
        ArrayList<Persona> personas = personaNegocio.ListarPersonas();
        return personas;
    }
	
    
	//EventoClickMenu abrir PanelAgregarPersonas
	public void  EventoClickMenu_AbrirPanel_AgregarPersona(ActionEvent a)
	{		
		panelAgregarPersona pnlAgregarPersona= new panelAgregarPersona();
		pnlAgregarPersona.btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try {
				if(!(pnlAgregarPersona.textFieldNombre.getText().isEmpty() || pnlAgregarPersona.textFieldApellido.getText().isEmpty() || pnlAgregarPersona.textFieldDni.getText().isEmpty())) {
					pnlAgregarPersona.persona.setNombre(pnlAgregarPersona.textFieldNombre.getText());
					pnlAgregarPersona.persona.setApellido(pnlAgregarPersona.textFieldApellido.getText());
					pnlAgregarPersona.persona.setDni(pnlAgregarPersona.textFieldDni.getText());
					int filas = pnlAgregarPersona.personaDao.AgregarPersona(pnlAgregarPersona.persona);
					
					if(filas == 1) {
					JOptionPane.showMessageDialog(null, "Persona agregada correctamente");
					pnlAgregarPersona.textFieldNombre.setText("");
					pnlAgregarPersona.textFieldApellido.setText("");
					pnlAgregarPersona.textFieldDni.setText("");
					}
					else {
						JOptionPane.showMessageDialog(null, "No se pudo agregar la persona");
					}	
		              
			    } else if(pnlAgregarPersona.textFieldNombre.getText().isEmpty()) {
		            throw new Exception("Debe completar el nombre");
		            
		          } else if (pnlAgregarPersona.textFieldApellido.getText().isEmpty()) {
		        		throw new Exception("Debe completar el apellido");
		        		
		        	} else {
		        	   throw new Exception("Debe completar el DNI");
		        	} 
			} catch (SQLException ex) {
	                   ex.printStackTrace();
	                   if (ex.getErrorCode() == 1062) { // Código de error de clave duplicada en MySQL
	                       JOptionPane.showMessageDialog(null, "DNI ya registrado en Base de Datos");
	                   } else {
	                       JOptionPane.showMessageDialog(null, "Error de base de datos: " + ex.getMessage());
	                   }
			   } catch (Exception ex) {
			          JOptionPane.showMessageDialog(null, ex.getMessage());
			        }
			}
		});
		
		pnlAgregarPersona.btnAceptar.setBounds(110, 102, 89, 23);
		pnlAgregarPersona.panel.add(pnlAgregarPersona.btnAceptar);
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
		pnlModificarPersona = new panelModificarPersona();
		ventanaPrincipal.getContentPane().removeAll();
		cargarPersonas();
		pnlModificarPersona.list.setSelectedIndex(0);
		Persona personaSeleccionada = pnlModificarPersona.list.getSelectedValue();
		pnlModificarPersona.txtNombre.setText(personaSeleccionada.getNombre());
		pnlModificarPersona.txtApellido.setText(personaSeleccionada.getApellido());
		pnlModificarPersona.txtDni.setText(personaSeleccionada.getDni());
		pnlModificarPersona.list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                	Persona personaSeleccionada = pnlModificarPersona.list.getSelectedValue();
                	pnlModificarPersona.txtNombre.setText(personaSeleccionada.getNombre());
            		pnlModificarPersona.txtApellido.setText(personaSeleccionada.getApellido());
            		pnlModificarPersona.txtDni.setText(personaSeleccionada.getDni());
                }
            }
        });;
		pnlModificarPersona.btnModificar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		modificarPersonaSeleccionada(personaSeleccionada);
        	}
        });
		ventanaPrincipal.getContentPane().add(pnlModificarPersona);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}
	
	
	public void  EventoClickMenu_AbrirPanel_ListarPersona(ActionEvent s)
	{	
		panelListarPersona pnlListarPersona = new panelListarPersona();
		pnlListarPersona.tableModel.setRowCount(0);
		listaPersonas = personaNegocio.ListarPersonas();
		
		for (Persona listaPersonas : listaPersonas) {
			pnlListarPersona.tableModel.addRow(new Object[]{listaPersonas.getNombre(), listaPersonas.getApellido(), listaPersonas.getDni()});
        }
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlListarPersona);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}
	
	
	public void inicializar()
	{
		this.ventanaPrincipal.setVisible(true);;
	}
	
	
	public void cargarPersonas() {
		pnlModificarPersona.listModel.clear();
        ArrayList<Persona> personas = listarPersonas();
        for (Persona persona : personas) {
        	pnlModificarPersona.listModel.addElement(persona);
        }
    }
	
	
	public void eliminarPersona(Persona persona) {
	        boolean eliminado = personaNegocio.EliminarPersona(persona);
	        if (eliminado) {
	        	JOptionPane.showMessageDialog(null, "La persona ha sido eliminada correctamente.");
	        	pnlEliminarPersona.cargarPersonas();
	            listaPersonas = personaNegocio.ListarPersonas(); // ***Agregar esta línea***
	        } else {
	            System.out.println("Error al eliminar la persona.");
	        }
	    }
	
	
	 public void modificarPersonaSeleccionada(Persona personaSeleccionada) {
	        if (personaSeleccionada != null) {
	            String nuevoNombre = pnlModificarPersona.getNuevoNombre();
	            String nuevoApellido = pnlModificarPersona.getNuevoApellido();
	            String nuevoDNI = pnlModificarPersona.getNuevoDNI();
	            personaSeleccionada.setNombre(nuevoNombre);
	            personaSeleccionada.setApellido(nuevoApellido);
	            personaSeleccionada.setDni(nuevoDNI);
	            int filasAfectadas = personaNegocio.ModificarPersona(personaSeleccionada);
	            if (filasAfectadas > 0) {
	                JOptionPane.showMessageDialog(null, "La persona ha sido modificada correctamente.");
	                cargarPersonas();
	            } else {
	                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar modificar la persona.", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        }
	    }


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
