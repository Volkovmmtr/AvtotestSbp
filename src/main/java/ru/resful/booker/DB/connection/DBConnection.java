package ru.resful.booker.DB.connection;

import org.jdbi.v3.core.Jdbi;

public interface DBConnection {

    Jdbi getJdbi();
}
