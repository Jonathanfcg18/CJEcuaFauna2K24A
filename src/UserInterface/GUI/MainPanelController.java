package UserInterface.GUI;

import javax.swing.*;

import UserInterface.CustomerControl.ComponentFactory;

import java.awt.*;

public class MainPanelController extends JFrame {

    private JPanel mainPanel;
    private CardLayout cardLayout;

    // Añadir referencias directas a los componentes
    private JLabel cjLCedula, cjLNombres;

    public MainPanelController() {
        initComponents();
    }

    private void initComponents() {
        setTitle("EcuaFauna 2K24A");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Etiquetas y campos de texto
        cjLCedula = addLabelAndField("Cedula:", 50, 20, 250, 30, 220, 20, 300, 30);
        cjLNombres = addLabelAndField("Nombres:", 50, 60, 250, 30, 220, 60, 300, 30);

        cjLCedula.setText("050479479-3");
        cjLNombres.setText("Jonathan Cuasapaz");

        addTextLabel("Hormiguero Virtual", 30, 140, 200, 20);

        // Crear los diferentes paneles que se manejarán
        //JPanel testHuellaPanel = new TestHuella();
        //JPanel datosChoferPanel = new JPanel(); // Este es un placeholder para datos chofer

        // Añadir los paneles al mainPanel con una clave para identificarlos
        //mainPanel.add(testHuellaPanel, "TestHuellaPanel");
        //mainPanel.add(datosChoferPanel, "DatosChoferPanel");

        // Configurar el panel principal en el JFrame
        add(mainPanel, BorderLayout.CENTER);

        // Mostrar el panel inicial
        cardLayout.show(mainPanel, "TestHuellaPanel");
    }

    private JLabel addLabelAndField(String labelText, int labelX, int labelY, int labelW, int labelH, int fieldX,
            int fieldY, int fieldW, int fieldH) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        label.setBounds(labelX, labelY, labelW, labelH);
        add(label);

        JPanel roundedPanel = ComponentFactory.createRoundedPanel(new Color(192, 192, 192), 20, 20, true);
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
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainPanelController().setVisible(true);
        });
    }
}
