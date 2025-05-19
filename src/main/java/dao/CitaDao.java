/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import modelo.Cita;

/**
 *
 * @author poeta
 */
public interface CitaDao {
    
    void insertar(Cita cita);
    List<Cita> listarTodas();
    Cita buscarPorId(String id);
    void actualizar(Cita cita);
    void eliminar(String id);
    void cancelarCita(String id);
    
}
