package wtunic29.veterinariacitas;

import javax.swing.JButton;
import javax.swing.JFrame;
import vistas.FormularioCitas;
import vistas.HistorialMedico;
import vistas.ListadoCitas;

/**
 *
 * @author poeta
 */

public class MenuPrincipal extends JFrame{
    
    public MenuPrincipal() {
        
        setTitle("Menú Principal - Veterinaria");
        setSize(400, 300);
        setLocationRelativeTo(null); // Centrar ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Botón 1: Agendar Cita
        JButton btnCita = new JButton("Agendar Cita");
        btnCita.setBounds(100, 30, 200, 40);
        btnCita.addActionListener(e -> new FormularioCitas());
        add(btnCita);

        // Botón 2: Ver Listado de Citas
        JButton btnListado = new JButton("Listado de Citas");
        btnListado.setBounds(100, 80, 200, 40);
        btnListado.addActionListener(e -> new ListadoCitas());
        add(btnListado);

        // Botón 3: Ver Historial Médico (simulado)
        JButton btnHistorial = new JButton("Historial Médico");
        btnHistorial.setBounds(100, 130, 200, 40);
        btnHistorial.addActionListener(e -> new HistorialMedico());
        add(btnHistorial);

        // Botón 4: Salir
        JButton btnSalir = new JButton("Salir");
        btnSalir.setBounds(100, 180, 200, 40);
        btnSalir.addActionListener(e -> System.exit(0));
        add(btnSalir);

        setVisible(true);
    }
}
