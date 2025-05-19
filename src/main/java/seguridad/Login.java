package seguridad;

import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author poeta
 */

public class Login extends JFrame {
    
    private JTextField usuario;
    private JPasswordField clave;
    private JButton btnLogin;

    public Login() {
        
        setTitle("Login");
        setSize(300, 200);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(30, 30, 80, 25);
        add(lblUsuario);

        usuario = new JTextField();
        usuario.setBounds(100, 30, 150, 25);
        add(usuario);

        JLabel lblClave = new JLabel("Clave:");
        lblClave.setBounds(30, 70, 80, 25);
        add(lblClave);

        clave = new JPasswordField();
        clave.setBounds(100, 70, 150, 25);
        add(clave);

        btnLogin = new JButton("Ingresar");
        btnLogin.setBounds(100, 110, 100, 30);
        add(btnLogin);

        btnLogin.addActionListener(e -> verificar());

        setVisible(true);
    }

    private void verificar() {
        String user = usuario.getText();
        String pass = new String(clave.getPassword());

        HashMap<String, String> credenciales = new HashMap<>();
        credenciales.put("veterinario", "1234");
        credenciales.put("admin", "admin");

        if (credenciales.containsKey(user) && credenciales.get(user).equals(pass)) 
        {
            JOptionPane.showMessageDialog(this, "Acceso concedido: " + user);
            dispose();
            new wtunic29.veterinariacitas.MenuPrincipal();
            }
        
        else {
            JOptionPane.showMessageDialog(this, "Credenciales inválidas");
        }
        
    }
    
}
