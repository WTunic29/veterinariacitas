/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.util.*;
import modelo.Cita;
import modelo.ConexionMongoDB;
import org.bson.Document;
import org.bson.conversions.Bson;


/**
 *
 * @author poeta
 */

public class CitaDaoMongo implements CitaDao {

    private final MongoCollection<Document> coleccion;

    public CitaDaoMongo() {
        this.coleccion = ConexionMongoDB.getDatabase().getCollection("citas");
    }

    @Override
    public void insertar(Cita cita) {
        Document doc = new Document("id", cita.getId())
                .append("idMascota", cita.getIdMascota())
                .append("idVeterinario", cita.getIdVeterinario())
                .append("fecha", cita.getFecha())
                .append("hora", cita.getHora())
                .append("estado", cita.getEstado());
        coleccion.insertOne(doc);
    }

    @Override
    public List<Cita> listarTodas() {
        List<Cita> citas = new ArrayList<>();
        for (Document doc : coleccion.find()) {
            citas.add(documentoACita(doc));
        }
        return citas;
    }

    @Override
    public Cita buscarPorId(String id) {
        Document doc = coleccion.find(Filters.eq("id", id)).first();
        return (doc != null) ? documentoACita(doc) : null;
    }

    @Override
    public void actualizar(Cita cita) {
        Bson filtro = Filters.eq("id", cita.getId());
        Bson actualizacion = Updates.combine(
                Updates.set("fecha", cita.getFecha()),
                Updates.set("hora", cita.getHora()),
                Updates.set("estado", cita.getEstado())
        );
        coleccion.updateOne(filtro, actualizacion);
    }

    @Override
    public void eliminar(String id) {
        coleccion.deleteOne(Filters.eq("id", id));
    }

    @Override
    public void cancelarCita(String id) {
        coleccion.updateOne(Filters.eq("id", id), Updates.set("estado", "Cancelada"));
    }

    private Cita documentoACita(Document doc) {
        Cita c = new Cita();
        c.setId(doc.getString("id"));
        c.setIdMascota(doc.getString("idMascota"));
        c.setIdVeterinario(doc.getString("idVeterinario"));
        c.setFecha(doc.getString("fecha"));
        c.setHora(doc.getString("hora"));
        c.setEstado(doc.getString("estado"));
        return c;
    }
}
