package ru.resful.booker.DB.connection;

import com.google.inject.Singleton;
import lombok.Getter;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

@Singleton
public class OracleConn implements DBConnection {

    @Getter
    public Jdbi jdbi = setConnection();

    private Jdbi setConnection() {
        return Jdbi.create(ConnectionConfigProvider.getConfig().getOracleUrl(),
                        ConnectionConfigProvider.getConfig().getOracleName(),
                        ConnectionConfigProvider.getConfig().getOraclePassword())
                .installPlugin(new SqlObjectPlugin());
    }
}
