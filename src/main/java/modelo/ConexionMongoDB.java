package modelo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;


/**
 *
 * @author poeta
 */
public class ConexionMongoDB {
    private static final String URI = "mongodb://localhost:27017";
    private static MongoDatabase database;

    public static MongoDatabase getDatabase() {
        if (database == null) {
            MongoClient client = MongoClients.create(URI);
            database = client.getDatabase("veterinariaDB");
        }
        return database;
    }
}
