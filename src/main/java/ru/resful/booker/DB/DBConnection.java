package ru.resful.booker.DB;

import org.jdbi.v3.core.Jdbi;

public interface DBConnection {

    <T> T getConnection();
}
