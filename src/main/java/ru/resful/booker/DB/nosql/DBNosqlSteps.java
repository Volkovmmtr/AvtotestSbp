package ru.resful.booker.DB.nosql;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import ru.resful.booker.DB.DBConnection;
import ru.resful.booker.DB.nosql.models.NameModel;

public class DBNosqlSteps {

    private final MongoClient client;
    private MongoDatabase db;

    public DBNosqlSteps(DBConnection connection, String dbname) {
        this.client = connection.getConnection();
        this.db = this.client.getDatabase(dbname);
    }

    public void setDb(String dbname) {
        this.db = client.getDatabase(dbname);
    }

    public NameModel getById(Integer id) {
        return new DBDao().getById(db, id);
    }
}
