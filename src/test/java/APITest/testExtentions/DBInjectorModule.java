package APITest.testExtentions;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.name.Names;
import ru.resful.booker.DB.DBConnection;
import ru.resful.booker.DB.nosql.mongo.connection.MongoConn;
import ru.resful.booker.DB.sql.connection.OracleConn;
import ru.resful.booker.DB.sql.connection.PSQLConn;

public class DBInjectorModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(DBConnection.class).annotatedWith(Names.named("Oracle")).to(OracleConn.class).in(Scopes.SINGLETON);
        bind(DBConnection.class).annotatedWith(Names.named("Postgres")).to(PSQLConn.class).in(Scopes.SINGLETON);
        bind(DBConnection.class).annotatedWith(Names.named("Mongo")).to(MongoConn.class).in(Scopes.SINGLETON);
    }


}
