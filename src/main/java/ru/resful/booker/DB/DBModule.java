package ru.resful.booker.DB;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import org.jdbi.v3.postgres.PostgresPlugin;
import org.jdbi.v3.core.Jdbi;
import org.aeonbits.owner.ConfigFactory;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

public class DBModule {

    //private final static DBConfig config = ConfigFactory.newInstance().create(DBConfig.class, System.getProperties());

    private DBConfig provideDBConfig() {
        return ConfigFactory.newInstance().create(DBConfig.class, System.getProperties());
    }

    public static Jdbi provideDB() {

        return Jdbi.create("jdbc:postgresql://localhost:5432/postgres", "postgres", "password123")
                .installPlugin(new PostgresPlugin())
                .installPlugin(new SqlObjectPlugin());
    }
}
