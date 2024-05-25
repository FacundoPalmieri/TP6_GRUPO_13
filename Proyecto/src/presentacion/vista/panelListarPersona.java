package presentacion.vista;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import daoImpl.PersonaDaoImpl;
import entidad.Persona;

public class panelListarPersona extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
    private DefaultTableModel tableModel;
    private PersonaDaoImpl personaDao;

    public panelListarPersona() {
        super();
        initialize();
        personaDao = new PersonaDaoImpl(); 
        //cargarPersonas();
    }

    private void initialize() {
        this.setBounds(100, 100, 514, 455);
        this.setLayout(null);


        tableModel = new DefaultTableModel(new Object[]{"Nombre", "Apellido", "DNI"}, 0);

        table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(27, 11, 384, 189);
        this.add(scrollPane);
    }

    private void cargarPersonas() {
        List<Persona> personas = personaDao.listarPersonas("");
        for (Persona persona : personas) {
            tableModel.addRow(new Object[]{persona.getNombre(), persona.getApellido(), persona.getDni()});
        }
    }

    public void show() {
        this.setVisible(true);
    }
}