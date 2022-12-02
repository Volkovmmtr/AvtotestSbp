package APITest;

import com.google.gson.JsonObject;
import ru.resful.booker.APIClients.EndpointProvider;
import ru.resful.booker.auth.UserProvider;
import ru.resful.booker.auth.Users;
import ru.resful.booker.clientFactorys.ClientFactory;
import ru.resful.booker.models.UserModel;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import retrofit2.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

public class GetTokenTest {
    private static final UserModel adm = UserProvider.getUserByName(Users.ADMIN_ROLE);

    @SneakyThrows
    @Test
    public void test(){
        Response<String> model = ClientFactory.anonimClient().getToken(adm).execute();
        //assertThat(model.body().getToken(), notNullValue());
    }
}
