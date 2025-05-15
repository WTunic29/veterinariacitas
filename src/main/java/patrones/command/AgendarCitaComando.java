package patrones.command;

import modelo.Cita;
import patrones.state.EstadoAgendada;

/**
 *
 * @author poeta
 */
public class AgendarCitaComando implements ComandoCita {
    
    private Cita cita;

    public AgendarCitaComando(Cita cita) {
        this.cita = cita;
    }

    @Override
    public void ejecutar() {
        cita.setEstadoCita(new EstadoAgendada());
        System.out.println("Cita agendada: " + cita.getFecha());
    }
    
}