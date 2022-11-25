package APITest.requests;

import APITest.models.responces.TestResponseModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface BaseAPI {

    @GET("/testSuc")
    @Headers("Content-Type: application/json")
    Call<TestResponseModel> getSuccess ();
}
