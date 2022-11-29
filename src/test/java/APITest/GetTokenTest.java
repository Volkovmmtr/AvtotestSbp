package APITest;

import ru.resful.booker.clientFactorys.ClientFactory;
import ru.resful.booker.models.UserModel;
import ru.resful.booker.models.TokenModel;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import retrofit2.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

public class GetTokenTest {
    private static final UserModel adm = new UserModel("admin","password123");
    @SneakyThrows
    @Test
    public void test(){
        Response<TokenModel> model = ClientFactory.authenticatedClientBasic(adm).getToken(adm).execute();
        assertThat(model.body().getToken(), notNullValue());
    }
}
