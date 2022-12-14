package ru.resful.booker.DB.sql;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import ru.resful.booker.DB.sql.models.NamePOJO;
import ru.resful.booker.DB.sql.models.mappers.NameMapper;

import java.util.List;

public interface DBDao {

    //разница только в именах таблицы и полей
    //если бы они были идентичны, то второго метода здесь бы небыло
    @SqlQuery("SELECT id, name " +
            "FROM newtable " +
            "WHERE id=:id")
    @RegisterRowMapper(NameMapper.class)
    List<NamePOJO> getById(@Bind("id") Integer id);

    @SqlQuery("SELECT A_ID, A_NAME " +
            "FROM AUTHORS " +
            "WHERE A_ID=:id")
    @RegisterRowMapper(NameMapper.class)
    List<NamePOJO> getByIds(@Bind("id") Integer id);



}
