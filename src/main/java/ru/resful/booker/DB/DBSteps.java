package ru.resful.booker.DB;


import ru.resful.booker.DB.models.NamePOJO;

import java.util.List;

public class DBSteps {

    //private static final DBDao dbDao = DBModule.provideDB().onDemand(DBDao.class);

    public static List<NamePOJO> getById(Integer id){
        return DBModule.provideDB().withExtension(DBDao.class, query -> query.getNameById(id));
    }
}
