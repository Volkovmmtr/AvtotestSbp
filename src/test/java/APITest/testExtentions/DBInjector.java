package APITest.testExtentions;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import lombok.Getter;
import org.junit.jupiter.api.BeforeAll;
import ru.resful.booker.DB.connection.DBConnection;

public class DBInjector {
    @Getter
    private static Injector injector;

    @BeforeAll
    public static void inject(){
        Module module = new InjectorModule();
        injector = Guice.createInjector(module);
    }
}
