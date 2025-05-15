package patrones.observer;

/**
 *
 * @author poeta
 */
public class DueñoObservador implements Observador {
    
    private String nombre;

    public DueñoObservador(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void actualizar(String mensaje) {
        System.out.println(nombre + " recibió: " + mensaje);
    }
}
