package APITest;

import io.qameta.allure.okhttp3.AllureOkHttp3;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.time.Duration;

public class Api {
    public static BaseAPI baseAPI;

    static {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .callTimeout(Duration.ofSeconds(10))
                .connectTimeout(Duration.ofSeconds(10))
                .readTimeout(Duration.ofSeconds(10))
                .addInterceptor(new AllureOkHttp3()) //подключение Allure
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://127.0.0.1:8090")
                .addConverterFactory(GsonConverterFactory.create())//mvn
                .addConverterFactory(ScalarsConverterFactory.create())//mvn
                .client(client)
                .build();

        baseAPI = retrofit.create(BaseAPI.class);
    }
}
