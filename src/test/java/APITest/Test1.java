package APITest;

import APITest.models.requests.User;
import APITest.models.responces.TokenModel;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import retrofit2.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

public class Test1 {
    private User adm = new User("admin","password123");
    @SneakyThrows
    @Test
    public void test(){
        Response<TokenModel> model = Api.getToken.getToken(adm).execute();
        assertThat(model.body().getToken(), notNullValue());
        //TestResponseModel model1 = Api.baseAPI.getSuccess().execute().body();
    }
}
