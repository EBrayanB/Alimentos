import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame {
    private JTextField usuarioField;
    private JPasswordField contrasenaField;
    private JButton loginButton;
    private Sistema sistema;

    public Login(Sistema sistema) {
        this.sistema = sistema;  // Se pasa el sistema para usarlo en el Login

        // Elementos gráficos
        usuarioField = new JTextField(20);
        contrasenaField = new JPasswordField(20);
        loginButton = new JButton("Iniciar Sesión");

        // Layout
        setLayout(new FlowLayout());
        add(new JLabel("Usuario:"));
        add(usuarioField);
        add(new JLabel("Contraseña:"));
        add(contrasenaField);
        add(loginButton);

        // Acción del botón de login
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = usuarioField.getText();
                String contrasena = new String(contrasenaField.getPassword());

                // Validación de login (puedes mejorar esta lógica)
                if (usuario.equals("admin") && contrasena.equals("admin123")) {
                    JOptionPane.showMessageDialog(null, "Login exitoso");
                    new Interfaz(sistema);  // Se abre la siguiente interfaz
                    setVisible(false);  // Cierra el Login
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.");
                }
            }
        });

        // Configuración de la ventana
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Login(new Sistema());
    }
}

