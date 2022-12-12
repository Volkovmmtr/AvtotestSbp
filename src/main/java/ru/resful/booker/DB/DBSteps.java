package ru.resful.booker.DB;


import org.jdbi.v3.core.Jdbi;
import ru.resful.booker.DB.connection.DBConnection;
import ru.resful.booker.DB.models.NamePOJO;

public class DBSteps {

    public DBSteps(DBConnection connection){
        this.jdbi = connection.getJdbi();
    }

    //todo организация степов с бд
    //тест, использующий обе бд
    private Jdbi jdbi;


    public NamePOJO getById(Integer id){
        return jdbi.withExtension(DBDao.class, query -> query.getNameById(id)).get(0);
    }

}
