package ru.resful.booker.DB;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import ru.resful.booker.DB.models.NamePOJO;
import ru.resful.booker.DB.models.mappers.NameMapper;

import java.util.List;

public interface DBDao {

    @SqlQuery("SELECT id, name " +
            "FROM public.newtable " +
            "WHERE id=:id")
    @RegisterRowMapper(NameMapper.class)
    List<NamePOJO> getNameById(@Bind("id") Integer id);
}
