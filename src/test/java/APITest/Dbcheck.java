package APITest;

import APITest.testExtentions.DBInjector;
import com.google.inject.Key;
import com.google.inject.name.Names;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.resful.booker.DB.DBSteps;
import ru.resful.booker.DB.connection.DBConnection;


public class Dbcheck extends DBInjector{

    private DBSteps dbSteps;
    @BeforeEach
    public void preconditions(){
        dbSteps = new DBSteps(
                DBInjector.getInjector().getInstance(Key.get(DBConnection.class, Names.named("Postgres")))
        );
    }

    @SneakyThrows
    @Test
    public void test() {
        //DBSteps.getById(1).getId();
        dbSteps.getById(1).getName();
    }

}
