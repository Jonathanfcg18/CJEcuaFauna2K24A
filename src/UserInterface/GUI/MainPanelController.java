package UserInterface.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import UserInterface.CustomerControl.CJComponentFactory;
import java.awt.*;
import java.sql.*;
import java.util.Vector;

public class MainPanelController extends JFrame {

    private JPanel mainPanel;
    private CardLayout cardLayout;
    private JLabel cjLCedula, cjLNombres;
    private JTable cjHormigaTable;
    private JScrollPane tableScrollPane;

    public MainPanelController() {
        initComponents();
    }

    private void initComponents() {
        setTitle("EcuaFauna 2K24A");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(700, 600);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.setLayout(null); // Using absolute positioning

        // Etiquetas y campos de texto
        cjLCedula = addLabelAndField("Cedula:", 50, 20, 250, 30, 220, 20, 300, 30);
        cjLNombres = addLabelAndField("Nombres:", 50, 60, 250, 30, 220, 60, 300, 30);

        cjLCedula.setText("050479479-3");
        cjLNombres.setText("Jonathan Cuasapaz");

        addTextLabel("Hormiguero Virtual", 30, 140, 200, 20);

        // Configurar la tabla
        setupTable();

        // Configurar el panel principal en el JFrame
        add(mainPanel, BorderLayout.CENTER);
    }

    private JLabel addLabelAndField(String labelText, int labelX, int labelY, int labelW, int labelH, int fieldX,
            int fieldY, int fieldW, int fieldH) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        label.setBounds(labelX, labelY, labelW, labelH);
        add(label);

        JPanel roundedPanel = CJComponentFactory.createRoundedPanel(new Color(192, 192, 192), 20, 20, true);
        roundedPanel.setBounds(fieldX, fieldY, fieldW, fieldH);
        JLabel fieldLabel = new JLabel("Texto aquí");
        fieldLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        roundedPanel.add(fieldLabel);
        add(roundedPanel);

        return fieldLabel; // Devolver la referencia del JLabel para actualizar los datos luego
    }

    private JLabel addTextLabel(String labelText, int labelX, int labelY, int labelW, int labelH) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setBounds(labelX, labelY, labelW, labelH);
        add(label);
    
        return label; // Devolver la referencia del JLabel para actualizar los datos luego
    }

    private void setupTable() {
        // Definir los nombres de las columnas
        String[] columnNames = {"ID", "Sexo", "Provincia", "Tipo", "GenoAlimento", "IngestaNativa", "Estado"};

        // Crear el modelo de la tabla usando CJComponentFactory
        DefaultTableModel tableModel = CJComponentFactory.createTableModel(columnNames);
        cjHormigaTable = CJComponentFactory.createTable(tableModel);

        // Crear un JScrollPane y añadir la tabla a él
        tableScrollPane = CJComponentFactory.createScrollPane(cjHormigaTable);
        tableScrollPane.setBounds(50, 200, 600, 150); // Ajustar la posición y tamaño según sea necesario

        mainPanel.add(tableScrollPane);

        // Llenar la tabla con datos de la base de datos
        populateTable();
    }

    private void populateTable() {
        String sql = "SELECT * FROM CJHormiga";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:DataBase//CJEcuFauna.sqlite");
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            DefaultTableModel model = (DefaultTableModel) cjHormigaTable.getModel();

            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                row.add(rs.getInt("IdCJHormiga"));
                row.add(rs.getInt("IdCJSexo")); // Considera usar una función para convertir ID a nombre
                row.add(rs.getInt("IdCJProvincia")); // Considera usar una función para convertir ID a nombre
                row.add(rs.getString("Tipo"));
                row.add(rs.getString("GenoAlimento"));
                row.add(rs.getString("IngestaNativa"));
                row.add(rs.getString("Estado").equals("A") ? "VIVA" : "MUERTA");

                model.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainPanelController().setVisible(true);
        });
    }
}
