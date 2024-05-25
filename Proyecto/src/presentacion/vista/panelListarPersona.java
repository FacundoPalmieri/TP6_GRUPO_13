package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class panelListarPersona extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTable table;
    public DefaultTableModel tableModel;

    public panelListarPersona() {
        super();
        initialize();
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

    
    public void show() {
        this.setVisible(true);
    }
}