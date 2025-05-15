/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistas;

import com.mongodb.client.MongoCollection;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import modelo.ConexionMongoDB;
import org.bson.Document;

/**
 *
 * @author poeta
 */

public class ListadoCitas extends JFrame {
    
    private JTextArea area;

    public ListadoCitas() {
        
        setTitle("Listado de Citas");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        area = new JTextArea();
        area.setEditable(false);
        add(new JScrollPane(area));
        cargarCitas();
        setVisible(true);
        
    }

    private void cargarCitas() {
        
        MongoCollection<Document> citas = ConexionMongoDB.getDatabase().getCollection("citas");

        for (Document doc : citas.find()) {
            
            area.append("Mascota: " + doc.getString("idMascota") + "\n");
            area.append("Veterinario: " + doc.getString("idVeterinario") + "\n");
            area.append("Fecha: " + doc.getString("fecha") + " - Hora: " + doc.getString("hora") + "\n");
            area.append("Estado: " + doc.getString("estado") + "\n");
            area.append("--------------------------------------------------\n");
            
        }
        
    }
    
}
