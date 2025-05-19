package wtunic29.veterinariacitas;

import javax.swing.JButton;
import javax.swing.JFrame;
import vistas.FormularioCitas;
import vistas.FormularioMascotas;
import vistas.GestionVet;
import vistas.HistorialMedico;
import vistas.ListadoCitas;

/**
 *
 * @author poeta
 */

public class MenuPrincipal extends JFrame {

    public MenuPrincipal() {

        setTitle("Menú Principal - Veterinaria");
        setSize(420, 450);
        setLocationRelativeTo(null); // Centrar ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JButton btnCita = new JButton("Agendar Cita");
        btnCita.setBounds(100, 30, 200, 40);
        btnCita.addActionListener(e -> new FormularioCitas());
        add(btnCita);

        JButton btnListado = new JButton("Listado de Citas");
        btnListado.setBounds(100, 80, 200, 40);
        btnListado.addActionListener(e -> new ListadoCitas());
        add(btnListado);

        JButton btnHistorial = new JButton("Historial Médico");
        btnHistorial.setBounds(100, 130, 200, 40);
        btnHistorial.addActionListener(e -> new HistorialMedico());
        add(btnHistorial);

        JButton btnVeterinario = new JButton("Gestión Veterinario");
        btnVeterinario.setBounds(100, 180, 200, 40);
        btnVeterinario.addActionListener(e -> new GestionVet());
        add(btnVeterinario);

        JButton btnMascotas = new JButton("Gestión Mascotas");
        btnMascotas.setBounds(100, 230, 200, 40);
        btnMascotas.addActionListener(e -> new FormularioMascotas());
        add(btnMascotas);

        JButton btnSalir = new JButton("Salir");
        btnSalir.setBounds(100, 280, 200, 40);
        btnSalir.addActionListener(e -> System.exit(0));
        add(btnSalir);

        setVisible(true);
    }
}