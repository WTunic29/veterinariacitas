/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import modelo.Mascota;

/**
 *
 * @author poeta
 */
public interface MascotaDao {
    
    void insertar(Mascota mascota);
    List<Mascota> listar();
    Mascota buscarPorId(String id);
    void actualizar(Mascota mascota);
    void eliminar(String id);
    
}
