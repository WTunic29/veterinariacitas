package patrones.observer;

import java.util.*;

/**
 *
 * @author poeta
 */
public class Notificador {
    
    private List<Observador> observadores = new ArrayList<>();

    public void agregar(Observador o) { 
        observadores.add(o); 
    }
    
    public void notificar(String mensaje) {
        for (Observador o : observadores) o.actualizar(mensaje);
    }
    
}
