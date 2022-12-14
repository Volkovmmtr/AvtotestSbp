package ru.resful.booker.DB.nosql.connection;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import ru.resful.booker.DB.DBConnection;
import ru.resful.booker.DB.sql.connection.ConnectionConfigProvider;

public class MongoConn implements DBConnection {

    private final MongoClient mongo = setConnection();
    @Override
    public MongoClient getConnection() {
        return mongo;
    }

    private MongoClient setConnection(){
         return MongoClients.create(ConnectionConfigProvider.getConfig().getMongoUrl());
    }

}
