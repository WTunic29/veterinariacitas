package vistas;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author poeta
 */
public class HistorialMedico extends JFrame {

    public HistorialMedico() {
        
        setTitle("Historial Médico (Simulado)");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JTextArea area = new JTextArea();
        area.setText("""
            Mascota: Luna
            Última consulta: 2025-04-20
            Diagnóstico: Vacunación y revisión general.
            Observaciones: Salud estable.

            Mascota: Max
            Última consulta: 2025-03-15
            Diagnóstico: Otitis leve.
            Tratamiento: Gotas y control a 7 días.
        """);
        area.setEditable(false);

        add(new JScrollPane(area));
        setVisible(true);
    }
   
}
