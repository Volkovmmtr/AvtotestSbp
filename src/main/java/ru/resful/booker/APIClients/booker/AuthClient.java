package ru.resful.booker.APIClients.booker;

import ru.resful.booker.models.TokenModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import ru.resful.booker.models.UserModel;

public interface AuthClient {

    @POST("/auth")
    @Headers("Content-Type: application/json")
    Call<TokenModel> getToken(@Body UserModel user);
}
