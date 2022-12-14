package ru.resful.booker.DB.sql;


import org.jdbi.v3.core.Jdbi;
import ru.resful.booker.DB.DBConnection;
import ru.resful.booker.DB.sql.models.NamePOJO;

public class DBSqlSteps {

    private Jdbi connect;

    public DBSqlSteps(DBConnection connection){
        this.connect = connection.getConnection();
    }

    public NamePOJO getById(Integer id){
        return connect.withExtension(DBDao.class, query -> query.getById(id)).get(0);
    }

}
