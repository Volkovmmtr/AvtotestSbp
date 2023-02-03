package APITest;

import APITest.testExtentions.DBInjector;
import com.google.inject.Key;
import com.google.inject.name.Names;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.resful.booker.DB.DBConnection;
import ru.resful.booker.DB.nosql.mongo.DBNosqlSteps;

public class CheckMongo extends DBInjector {

    private DBNosqlSteps DBsteps;

    @BeforeEach
    public void preconditions(){
        DBsteps = new DBNosqlSteps(
                DBInjector.getInjector().getInstance(Key.get(DBConnection.class, Names.named("Mongo"))),
                "local"
        );
    }

    @SneakyThrows
    @Test
    public void test() {
        DBsteps.getById(1);

    }

}
