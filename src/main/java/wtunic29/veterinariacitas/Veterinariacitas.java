package wtunic29.veterinariacitas;

import javax.swing.SwingUtilities;

/**
 *
 * @author poeta
 */
public class Veterinariacitas {

    public static void main(String[] args) {
        
        javax.swing.SwingUtilities.invokeLater(() -> {
            new seguridad.Login(); // Comienza con el login
        });
        
    }
}
