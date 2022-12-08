package APITest;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.resful.booker.DB.DBModule;
import ru.resful.booker.DB.DBSteps;


public class Dbcheck {

    private DBSteps dbSteps;
    @BeforeEach
    public void preconditions(){
        dbSteps = new DBSteps(DBModule.provideOracleDB());
    }

    @SneakyThrows
    @Test
    public void test() {
        //DBSteps.getById(1).getId();
        dbSteps.getByIds(1).getName();
    }

}
