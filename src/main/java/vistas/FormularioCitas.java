package vistas;

import javax.swing.*;
import org.bson.Document;
import com.mongodb.client.MongoCollection;
import dao.CitaDao;
import dao.CitaDaoMongo;
import modelo.Cita;
import modelo.ConexionMongoDB;
import validador.ValidadorCitas;

/**
 *
 * @author poeta
 */
public class FormularioCitas extends JFrame {
    
    private JTextField txtMascotaId, txtVeterinarioId, txtFecha, txtHora;
    private JButton btnAgendar;

    public FormularioCitas() {
        
        setTitle("Agendar Cita Médica");
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblMascota = new JLabel("ID Mascota:");
        lblMascota.setBounds(30, 30, 100, 25);
        add(lblMascota);

        txtMascotaId = new JTextField();
        txtMascotaId.setBounds(150, 30, 200, 25);
        add(txtMascotaId);

        JLabel lblVeterinario = new JLabel("ID Veterinario:");
        lblVeterinario.setBounds(30, 70, 100, 25);
        add(lblVeterinario);

        txtVeterinarioId = new JTextField();
        txtVeterinarioId.setBounds(150, 70, 200, 25);
        add(txtVeterinarioId);

        JLabel lblFecha = new JLabel("Fecha (YYYY-MM-DD):");
        lblFecha.setBounds(30, 110, 150, 25);
        add(lblFecha);

        txtFecha = new JTextField();
        txtFecha.setBounds(180, 110, 170, 25);
        add(txtFecha);

        JLabel lblHora = new JLabel("Hora (HH:MM):");
        lblHora.setBounds(30, 150, 100, 25);
        add(lblHora);

        txtHora = new JTextField();
        txtHora.setBounds(150, 150, 200, 25);
        add(txtHora);

        btnAgendar = new JButton("Agendar");
        btnAgendar.setBounds(130, 200, 120, 30);
        add(btnAgendar);

        btnAgendar.addActionListener(e -> agendarCita());

        setVisible(true);
    }

    private void agendarCita() {
        String idMascota = txtMascotaId.getText();
        String idVet = txtVeterinarioId.getText();
        String fecha = txtFecha.getText();
        String hora = txtHora.getText();

        CitaDao dao = new CitaDaoMongo();
        ValidadorCitas validador = new ValidadorCitas(dao);

        if (!validador.esFechaValida(fecha)) {
            JOptionPane.showMessageDialog(this, "Fecha inválida o anterior a hoy.");
            return;
        }

        if (validador.hayConflicto(fecha, hora, idVet)) {
            JOptionPane.showMessageDialog(this, "Conflicto: ya existe una cita en esa fecha y hora.");
            return;
        }

        Cita cita = new Cita();
        cita.setIdMascota(idMascota);
        cita.setIdVeterinario(idVet);
        cita.setFecha(fecha);
        cita.setHora(hora);
        cita.setEstado("Agendada");

        dao.insertar(cita);
        JOptionPane.showMessageDialog(this, "Cita agendada exitosamente.");
    }
}