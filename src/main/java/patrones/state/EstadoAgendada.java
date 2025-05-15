/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patrones.state;

import modelo.Cita;

/**
 *
 * @author poeta
 */
public class EstadoAgendada implements EstadoCita {
    
    @Override
    public void gestionar(Cita cita) {
        cita.setEstado("Agendada");
    }
    
}