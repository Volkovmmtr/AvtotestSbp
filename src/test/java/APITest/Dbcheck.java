package APITest;

import APITest.testExtentions.DBInjector;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.resful.booker.DB.DBSteps;
import ru.resful.booker.DB.connection.DBConnection;


public class Dbcheck extends DBInjector{

    private DBSteps dbSteps;
    @BeforeEach
    public void preconditions(){
        DBConnection connection = DBInjector.getInjector().getInstance(DBConnection.class);
        dbSteps = new DBSteps(connection);
    }

    @SneakyThrows
    @Test
    public void test() {
        //DBSteps.getById(1).getId();
        dbSteps.getById(1).getName();
    }

}
