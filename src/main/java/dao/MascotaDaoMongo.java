package dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.List;
import modelo.ConexionMongoDB;
import modelo.Mascota;
import org.bson.Document;

/**
 *
 * @author poeta
 */
public class MascotaDaoMongo implements MascotaDao {
    
    private final MongoCollection<Document> coleccion;

    public MascotaDaoMongo() {
        this.coleccion = ConexionMongoDB.getDatabase().getCollection("mascotas");
    }

    @Override
    public void insertar(Mascota m) {
        Document doc = new Document("id", m.getId())
            .append("nombre", m.getNombre())
            .append("especie", m.getEspecie())
            .append("raza", m.getRaza())
            .append("idDueño", m.getIdDueño());
        coleccion.insertOne(doc);
    }

    @Override
    public List<Mascota> listar() {
        
        List<Mascota> lista = new ArrayList<>();
        
        for (Document d : coleccion.find()) {
            
            lista.add(new Mascota(
                d.getString("id"),
                d.getString("nombre"),
                d.getString("especie"),
                d.getString("raza"),
                d.getString("idDueño")
            ));
            
        }
        
        return lista;
    }

    @Override
    public Mascota buscarPorId(String id) {
        Document d = coleccion.find(Filters.eq("id", id)).first();
        return (d != null) ? new Mascota(
            d.getString("id"),
            d.getString("nombre"),
            d.getString("especie"),
            d.getString("raza"),
            d.getString("idDueño")
        ) : null;
    }

    @Override
    public void actualizar(Mascota m) {
        coleccion.updateOne(Filters.eq("id", m.getId()),
            new Document("$set", new Document("nombre", m.getNombre())
                .append("especie", m.getEspecie())
                .append("raza", m.getRaza())
                .append("idDueño", m.getIdDueño())));
    }

    @Override
    public void eliminar(String id) {
        coleccion.deleteOne(Filters.eq("id", id));
    }
    
}
