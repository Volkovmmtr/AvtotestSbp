package APITest;

import APITest.requests.GetToken;
import io.qameta.allure.okhttp3.AllureOkHttp3;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.time.Duration;

public class Api {
    public static GetToken getToken;

    static {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .callTimeout(Duration.ofSeconds(10))
                .connectTimeout(Duration.ofSeconds(10))
                .readTimeout(Duration.ofSeconds(10))
                .addInterceptor(new AllureOkHttp3()) //подключение Allure
                .build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://restful-booker.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())//mvn
                .addConverterFactory(ScalarsConverterFactory.create())//mvn
                .client(client)
                .build();

        getToken = retrofit.create(GetToken.class);
    }
}
