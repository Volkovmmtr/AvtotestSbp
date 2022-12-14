package APITest.testExtentions;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import lombok.Getter;
import org.junit.jupiter.api.BeforeAll;

public class DBInjector {
    @Getter
    private static Injector injector;

    @BeforeAll
    public static void inject(){
        Module module = new DBInjectorModule();
        injector = Guice.createInjector(module);
    }
}
