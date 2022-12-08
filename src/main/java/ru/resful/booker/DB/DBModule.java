package ru.resful.booker.DB;

import org.jdbi.v3.postgres.PostgresPlugin;
import org.jdbi.v3.core.Jdbi;
import org.aeonbits.owner.ConfigFactory;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

public class DBModule {

    private final static DBConfig config = ConfigFactory.newInstance().create(DBConfig.class);

    public static Jdbi providePsqlDB() {
        return Jdbi.create(config.getPsqlUrl(),config.getPsqlUsername(),config.getPsglPassword())
                .installPlugin(new PostgresPlugin())
                .installPlugin(new SqlObjectPlugin());
    }

    public static Jdbi provideOracleDB() {
        return Jdbi.create(config.getOracleUrl(),config.getOracleName(),config.getOraclePassword())
                .installPlugin(new SqlObjectPlugin());
    }
}
