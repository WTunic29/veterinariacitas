package validador;

import dao.CitaDao;
import java.time.LocalDate;
import java.util.List;
import modelo.Cita;

/**
 *
 * @author poeta
 */
public class ValidadorCitas {
    
    private final CitaDao citaDao;

    public ValidadorCitas(CitaDao citaDao) {
        this.citaDao = citaDao;
    }

    public boolean esFechaValida(String fecha) {
        try {
            LocalDate citaFecha = LocalDate.parse(fecha);
            return !citaFecha.isBefore(LocalDate.now());
        } catch (Exception e) {
            return false;
        }
    }

    public boolean hayConflicto(String fecha, String hora, String idVeterinario) {
        List<Cita> citas = citaDao.listarTodas();
        for (Cita c : citas) {
            if (c.getFecha().equals(fecha) &&
                c.getHora().equals(hora) &&
                c.getIdVeterinario().equals(idVeterinario)) {
                return true;
            }
        }
        return false;
    }
    
}
