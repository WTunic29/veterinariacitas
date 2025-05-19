package vistas;

import dao.HistorialMedicoDao;
import dao.HistorialMedicoDaoMongo;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author poeta
 */
public class HistorialMedico extends JFrame {
    private JTextField txtIdMascota, txtIdCita, txtDiagnostico, txtTratamiento;
    private JTextArea txtObservaciones, txtResultados;
    private JButton btnRegistrar, btnConsultar;

    private HistorialMedicoDao historialDAO = new HistorialMedicoDaoMongo();

    public HistorialMedico() {
        setTitle("Historial Médico - Veterinario");
        setSize(600, 500);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel lblMascota = new JLabel("ID Mascota:");
        lblMascota.setBounds(30, 20, 100, 25);
        add(lblMascota);

        txtIdMascota = new JTextField();
        txtIdMascota.setBounds(130, 20, 150, 25);
        add(txtIdMascota);

        JLabel lblCita = new JLabel("ID Cita:");
        lblCita.setBounds(300, 20, 100, 25);
        add(lblCita);

        txtIdCita = new JTextField();
        txtIdCita.setBounds(370, 20, 150, 25);
        add(txtIdCita);

        JLabel lblDiagnostico = new JLabel("Diagnóstico:");
        lblDiagnostico.setBounds(30, 60, 100, 25);
        add(lblDiagnostico);

        txtDiagnostico = new JTextField();
        txtDiagnostico.setBounds(130, 60, 390, 25);
        add(txtDiagnostico);

        JLabel lblTratamiento = new JLabel("Tratamiento:");
        lblTratamiento.setBounds(30, 100, 100, 25);
        add(lblTratamiento);

        txtTratamiento = new JTextField();
        txtTratamiento.setBounds(130, 100, 390, 25);
        add(txtTratamiento);

        JLabel lblObservaciones = new JLabel("Observaciones:");
        lblObservaciones.setBounds(30, 140, 120, 25);
        add(lblObservaciones);

        txtObservaciones = new JTextArea();
        JScrollPane scrollObs = new JScrollPane(txtObservaciones);
        scrollObs.setBounds(30, 170, 500, 80);
        add(scrollObs);

        btnRegistrar = new JButton("Registrar Historial");
        btnRegistrar.setBounds(100, 270, 180, 30);
        add(btnRegistrar);

        btnConsultar = new JButton("Consultar Historial");
        btnConsultar.setBounds(300, 270, 180, 30);
        add(btnConsultar);

        txtResultados = new JTextArea();
        JScrollPane scrollResultados = new JScrollPane(txtResultados);
        scrollResultados.setBounds(30, 320, 520, 120);
        add(scrollResultados);

        eventos();

        setVisible(true);
    }

    private void eventos() {
        btnRegistrar.addActionListener(e -> {
            modelo.HistorialMedico h = new modelo.HistorialMedico(
                txtIdMascota.getText(),
                txtIdCita.getText(),
                txtDiagnostico.getText(),
                txtTratamiento.getText(),
                txtObservaciones.getText()
            );
            historialDAO.registrar(h);
            JOptionPane.showMessageDialog(this, "Historial médico registrado.");
        });

        btnConsultar.addActionListener(e -> {
            txtResultados.setText("");
            List<modelo.HistorialMedico> lista = historialDAO.consultarPorMascota(txtIdMascota.getText());
            for (modelo.HistorialMedico h : lista) {
                txtResultados.append("Cita: " + h.getIdCita() + "\n");
                txtResultados.append("Diagnóstico: " + h.getDiagnostico() + "\n");
                txtResultados.append("Tratamiento: " + h.getTratamiento() + "\n");
                txtResultados.append("Observaciones: " + h.getObservaciones() + "\n");
                txtResultados.append("--------------------------------------\n");
            }
        });
    }
}
