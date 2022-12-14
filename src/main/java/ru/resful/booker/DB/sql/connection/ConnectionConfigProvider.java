package ru.resful.booker.DB.sql.connection;

import lombok.Getter;
import org.aeonbits.owner.ConfigFactory;
import ru.resful.booker.DB.DBConfig;

public class ConnectionConfigProvider {

    @Getter
    private final static DBConfig config = ConfigFactory.newInstance().create(DBConfig.class);
}
