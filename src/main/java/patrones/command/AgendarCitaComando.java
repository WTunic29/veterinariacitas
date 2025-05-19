package patrones.command;

import modelo.Cita;
import patrones.state.EstadoAgendada;

/**
 *
 * @author poeta
 */
public class AgendarCitaComando implements ComandoCita {
    private final Cita cita;

    public AgendarCitaComando(Cita cita) {
        this.cita = cita;
    }

    @Override
    public void ejecutar() {
        if (cita.getEstado() == null || cita.getEstado().isEmpty()) {
            cita.setEstadoCita(new EstadoAgendada());
        }
        System.out.println("Cita agendada: " + cita.getFecha() + " a las " + cita.getHora());
    }
}