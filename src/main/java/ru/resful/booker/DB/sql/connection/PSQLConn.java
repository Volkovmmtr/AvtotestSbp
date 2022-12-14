package ru.resful.booker.DB.sql.connection;

import com.google.inject.Singleton;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.postgres.PostgresPlugin;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import ru.resful.booker.DB.DBConnection;

@Singleton
public class PSQLConn implements DBConnection {

    private final Jdbi jdbi = setConnection();

    public Jdbi getConnection(){
        return jdbi;
    }

    private Jdbi setConnection() {
        return Jdbi.create(ConnectionConfigProvider.getConfig().getPsqlUrl(),
                        ConnectionConfigProvider.getConfig().getPsqlUsername(),
                        ConnectionConfigProvider.getConfig().getPsglPassword())
                .installPlugin(new PostgresPlugin())
                .installPlugin(new SqlObjectPlugin());
    }
}
