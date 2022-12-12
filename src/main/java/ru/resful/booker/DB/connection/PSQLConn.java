package ru.resful.booker.DB.connection;

import com.google.inject.Singleton;
import lombok.Getter;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.postgres.PostgresPlugin;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

@Singleton
public class PSQLConn implements DBConnection{

    @Getter
    public Jdbi jdbi = setConnection();

    private Jdbi setConnection() {
        return Jdbi.create(ConnectionConfigProvider.getConfig().getPsqlUrl(),
                        ConnectionConfigProvider.getConfig().getPsqlUsername(),
                        ConnectionConfigProvider.getConfig().getPsglPassword())
                .installPlugin(new PostgresPlugin())
                .installPlugin(new SqlObjectPlugin());
    }
}
