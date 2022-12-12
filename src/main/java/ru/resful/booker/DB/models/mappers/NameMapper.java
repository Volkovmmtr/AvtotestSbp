package ru.resful.booker.DB.models.mappers;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;
import ru.resful.booker.DB.models.NamePOJO;

import java.sql.ResultSet;
import java.sql.SQLException;

//чтобы использовать один маппер для нескольких бд, то имена таблицы и полей должны совпадать
//из области фантастики?
public class NameMapper implements RowMapper<NamePOJO> {

    /*
    public NamePOJO map(ResultSet rs, StatementContext ctx) throws SQLException {
        return new NamePOJO(rs.getInt("id"), rs.getString("name"));
    }
     */

    public NamePOJO map(ResultSet rs, StatementContext ctx) throws SQLException {
        return new NamePOJO(rs.getInt("A_ID"), rs.getString("A_NAME"));
    }
}
