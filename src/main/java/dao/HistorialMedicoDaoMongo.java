package dao;

import modelo.HistorialMedico;
import modelo.ConexionMongoDB;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author poeta
 */
public class HistorialMedicoDaoMongo implements HistorialMedicoDao {
    private final MongoCollection<Document> coleccion;

    public HistorialMedicoDaoMongo() {
        this.coleccion = ConexionMongoDB.getDatabase().getCollection("historial_medico");
    }

    @Override
    public void registrar(HistorialMedico historial) {
        Document doc = new Document("idMascota", historial.getIdMascota())
            .append("idCita", historial.getIdCita())
            .append("diagnostico", historial.getDiagnostico())
            .append("tratamiento", historial.getTratamiento())
            .append("observaciones", historial.getObservaciones());
        coleccion.insertOne(doc);
    }

    @Override
    public List<HistorialMedico> consultarPorMascota(String idMascota) {
        List<HistorialMedico> lista = new ArrayList<>();
        for (Document d : coleccion.find(new Document("idMascota", idMascota))) {
            lista.add(new HistorialMedico(
                d.getString("idMascota"),
                d.getString("idCita"),
                d.getString("diagnostico"),
                d.getString("tratamiento"),
                d.getString("observaciones")
            ));
        }
        return lista;
    }
    
}
