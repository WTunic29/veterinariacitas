/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import modelo.HistorialMedico;

/**
 *
 * @author poeta
 */
public interface HistorialMedicoDao {
    void registrar(HistorialMedico historial);
    List<HistorialMedico> consultarPorMascota(String idMascota);
}
