package UserInterface.Form;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import UserInterface.CustomerControl.CJComponentFactory;
import UserInterface.GUI.MainPanelController;

public class CJLoginPanel extends JFrame {
    
    private JTextField userField;
    private JPasswordField passwordField;
    private JLabel messageLabel;

    public CJLoginPanel() {
        setLayout(null);
        
        setTitle("EcuaFauna 2K24A");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);

        addTextLabel("Inicio de Seción", 260, 40, 200, 20);

        JLabel userLabel = CJComponentFactory.createLabel("Usuario:");
        userLabel.setBounds(180, 90, 100, 30);
        add(userLabel);

        userField = CJComponentFactory.createTextField();
        userField.setBounds(240, 90, 150, 30);
        add(userField);

        JLabel passwordLabel = CJComponentFactory.createLabel("Clave:");
        passwordLabel.setBounds(180, 150, 100, 30);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(240, 150, 150, 30);
        add(passwordField);

        JButton loginButton = CJComponentFactory.createButton("Ingresar", new Color(0, 122, 204));
        loginButton.setBounds(250, 200, 130, 30);
        add(loginButton);

        messageLabel = CJComponentFactory.createLabel("");
        messageLabel.setBounds(50, 200, 250, 30);
        add(messageLabel);

        // Acción del botón de ingreso
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = userField.getText();
                String clave = new String(passwordField.getPassword());
        
                // Validar credenciales contra la base de datos
                if (validarCredenciales(usuario, clave)) {
                    mostrarMensajeExito();
                } else {
                    mostrarMensajeError();
                }
            }
        });
        
    }

    // Método para validar las credenciales contra la base de datos
    private boolean validarCredenciales(String usuario, String clave) {
        String url = "jdbc:sqlite:DataBase//CJEcuFauna.sqlite";  
        String sql = "SELECT * FROM CJAdministrador WHERE Usuario = ? AND Clave = ? AND Estado = 'A'";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, usuario);
            pstmt.setString(2, clave);
            ResultSet rs = pstmt.executeQuery();

            return rs.next();  // Devuelve true si existe un resultado, lo que significa que las credenciales son correctas

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void mostrarMensajeError() {
        messageLabel.setText("Usuario o clave incorrectos.");
        messageLabel.setForeground(Color.RED);
    }

    private void mostrarMensajeExito() {
        // Elimina todos los componentes actuales
        getContentPane().removeAll();

        // Añade el mensaje de éxito
        JLabel successLabel = CJComponentFactory.createLabel("Ingreso exitoso.");
        successLabel.setBounds(250, 50, 200, 30);
        successLabel.setForeground(new Color(0, 128, 0));
        add(successLabel);

        // Añade el botón de aceptar
        JButton acceptButton = CJComponentFactory.createButton("Aceptar", new Color(0, 122, 204));
        acceptButton.setBounds(250, 100, 100, 30);
        add(acceptButton);

        // Acción del botón aceptar
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainPanelController loginForm = new MainPanelController();
                loginForm.setVisible(true);
                dispose(); // Cierra la ventana de login
            }
        });

        // Refresca el panel para que los cambios sean visibles
        revalidate();
        repaint();
    }

    private JLabel addTextLabel(String labelText, int labelX, int labelY, int labelW, int labelH) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setBounds(labelX, labelY, labelW, labelH);
        add(label);
    
        return label; // Devolver la referencia del JLabel para actualizar los datos luego
    }
}
