package ru.resful.booker.DB;


import lombok.AllArgsConstructor;
import org.jdbi.v3.core.Jdbi;
import ru.resful.booker.DB.models.NamePOJO;

import java.util.List;

@AllArgsConstructor
public class DBSteps {


    //todo организация степов с бд
    //тест, использующий обе бд
    private Jdbi jdbi;
    /*
     Jdbi psql = DBModule.providePsqlDB();
     Jdbi oracle = DBModule.provideOracleDB();
     */
    public NamePOJO getById(Integer id){
        return jdbi.withExtension(DBDao.class, query -> query.getNameById(id)).get(0);
    }

    public NamePOJO getByIds(Integer id){
        return jdbi.withExtension(DBDao.class, query -> query.getNameByIds(id)).get(0);
    }

}
