package modelo;

import patrones.state.EstadoCita;

/**
 *
 * @author poeta
 */
public class Cita {
    
    private String id, fecha, hora, estado, idVeterinario, idMascota;
    private EstadoCita estadoCita;

    public void setEstadoCita(EstadoCita estadoCita) {
        
        this.estadoCita = estadoCita;
        estadoCita.gestionar(this);
        
    }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    
}