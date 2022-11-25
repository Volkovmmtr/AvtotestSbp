package APITest.requests;

import APITest.models.requests.User;
import APITest.models.responces.TokenModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface GetToken {

    @POST("/auth")
    @Headers("Content-Type: application/json")
    Call<TokenModel> getToken(@Body User user);
}
