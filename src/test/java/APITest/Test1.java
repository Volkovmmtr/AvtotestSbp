package APITest;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import retrofit2.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class Test1 {

    @SneakyThrows
    @Test
    public void test(){
        Response<TestResponseModel> model = Api.baseAPI.getSuccess().execute();
        assertThat(model.body().getValue(), equalTo("Success!"));
        //TestResponseModel model1 = Api.baseAPI.getSuccess().execute().body();
    }
}
