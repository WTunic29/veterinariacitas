package modelo;

import patrones.state.EstadoCita;

/**
 *
 * @author poeta
 */
public class Cita {
    private String id;
    private String idMascota;
    private String idVeterinario;
    private String fecha;
    private String hora;
    private EstadoCita estadoCita;
    private String estado;

    // Constructor vacío
    public Cita() {}

    // Constructor completo
    public Cita(String id, String idMascota, String idVeterinario, String fecha, String hora, String estado) {
        this.id = id;
        this.idMascota = idMascota;
        this.idVeterinario = idVeterinario;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(String idMascota) {
        this.idMascota = idMascota;
    }

    public String getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(String idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public void setEstadoCita(EstadoCita estadoCita) {
        this.estadoCita = estadoCita;
        this.estado = estadoCita.getClass().getSimpleName().replace("Estado", ""); // ej. Agendada
    }
    
}