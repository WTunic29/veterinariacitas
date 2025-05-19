package vistas;

import dao.MascotaDao;
import dao.MascotaDaoMongo;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.Mascota;

/**
 *
 * @author poeta
 */
public class FormularioMascotas extends JFrame {
    
    private JTextField txtId, txtNombre, txtEspecie, txtRaza, txtDueno;
    private JButton btnGuardar, btnBuscar, btnEliminar;
    private MascotaDao dao = new MascotaDaoMongo();

    public FormularioMascotas() {
        
        setTitle("Gestión de Mascotas");
        setSize(400, 300);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel l1 = new JLabel("ID:");
        l1.setBounds(20, 20, 100, 25); add(l1);
        txtId = new JTextField(); txtId.setBounds(120, 20, 200, 25); add(txtId);

        JLabel l2 = new JLabel("Nombre:");
        l2.setBounds(20, 50, 100, 25); add(l2);
        txtNombre = new JTextField(); txtNombre.setBounds(120, 50, 200, 25); add(txtNombre);

        JLabel l3 = new JLabel("Especie:");
        l3.setBounds(20, 80, 100, 25); add(l3);
        txtEspecie = new JTextField(); txtEspecie.setBounds(120, 80, 200, 25); add(txtEspecie);

        JLabel l4 = new JLabel("Raza:");
        l4.setBounds(20, 110, 100, 25); add(l4);
        txtRaza = new JTextField(); txtRaza.setBounds(120, 110, 200, 25); add(txtRaza);

        JLabel l5 = new JLabel("Dueño:");
        l5.setBounds(20, 140, 100, 25); add(l5);
        txtDueno = new JTextField(); txtDueno.setBounds(120, 140, 200, 25); add(txtDueno);

        btnGuardar = new JButton("Guardar"); btnGuardar.setBounds(20, 180, 100, 30); add(btnGuardar);
        btnBuscar = new JButton("Buscar"); btnBuscar.setBounds(130, 180, 100, 30); add(btnBuscar);
        btnEliminar = new JButton("Eliminar"); btnEliminar.setBounds(240, 180, 100, 30); add(btnEliminar);

        eventos();
        setVisible(true);
        
    }

    private void eventos() {
        
        btnGuardar.addActionListener(e -> {
            Mascota m = new Mascota(
                txtId.getText(),
                txtNombre.getText(),
                txtEspecie.getText(),
                txtRaza.getText(),
                txtDueno.getText()
            );
            
            dao.insertar(m);
            JOptionPane.showMessageDialog(this, "Mascota guardada");
        });

        btnBuscar.addActionListener(e -> {
            
            Mascota m = dao.buscarPorId(txtId.getText());
            if (m != null) {
                txtNombre.setText(m.getNombre());
                txtEspecie.setText(m.getEspecie());
                txtRaza.setText(m.getRaza());
                txtDueno.setText(m.getIdDueño());
                
            } 
            
            else {
                JOptionPane.showMessageDialog(this, "No encontrada");
            }
        });

        btnEliminar.addActionListener(e -> {
            dao.eliminar(txtId.getText());
            JOptionPane.showMessageDialog(this, "Mascota eliminada");
        });
        
    }
    
}
