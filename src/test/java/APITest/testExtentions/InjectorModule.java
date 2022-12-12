package APITest.testExtentions;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.name.Names;
import org.junit.jupiter.api.BeforeAll;
import ru.resful.booker.DB.connection.DBConnection;
import ru.resful.booker.DB.connection.OracleConn;
import ru.resful.booker.DB.connection.PSQLConn;

public class InjectorModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(DBConnection.class).annotatedWith(Names.named("Oracle")).to(OracleConn.class).in(Scopes.SINGLETON);
        bind(DBConnection.class).annotatedWith(Names.named("Postgres")).to(PSQLConn.class).in(Scopes.SINGLETON);
    }


}
