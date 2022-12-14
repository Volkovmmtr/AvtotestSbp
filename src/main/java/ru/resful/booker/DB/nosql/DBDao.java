package ru.resful.booker.DB.nosql;

import com.google.gson.Gson;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import ru.resful.booker.DB.nosql.models.NameModel;

public class DBDao {

    public NameModel getById(MongoDatabase db, Integer id){
         return new Gson().fromJson(
                 db.getCollection("newtable")
                         .find(com.mongodb.client.model.Filters.eq("id",id)).first().toJson(),
                 NameModel.class);
    }
}
