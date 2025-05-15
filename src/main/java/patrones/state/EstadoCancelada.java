package patrones.state;

import modelo.Cita;

/**
 *
 * @author poeta
 */
public class EstadoCancelada implements EstadoCita {
    
    @Override
    public void gestionar(Cita cita) {
        cita.setEstado("Cancelada");
    }
    
}