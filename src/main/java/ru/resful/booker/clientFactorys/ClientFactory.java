package ru.resful.booker.clientFactorys;

import io.qameta.allure.okhttp3.AllureOkHttp3;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import ru.resful.booker.APIClients.UserClient;
import ru.resful.booker.auth.TokenRepo;
import ru.resful.booker.models.UserModel;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ClientFactory {
    private final static String BASE_URL = "https://restful-booker.herokuapp.com/";

    public static UserClient anonimClient() {

        OkHttpClient client = new OkHttpClient();
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        setConfig(builder);
        builder.build();

        return getBaseRetrofit(client).create(UserClient.class);
    }

    /*
    public static UserClient authenticatedClient(UserModel user) {

        OkHttpClient client = new OkHttpClient();
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(
                chain -> {
                    Request newRequest = chain.request().newBuilder()
                            .addHeader("Authorization", "Bearer " + TokenRepo.getToken(user))
                            .build();
                    return chain.proceed(newRequest);
                }
        );

        setConfig(builder);
        builder.build();


        return getBaseRetrofit(client).create(UserClient.class);
    }
     */
    public static UserClient authenticatedClientBasic(UserModel user) {

        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        setConfig(builder);
        builder.addInterceptor(chain -> {
            Request newRequest = chain.request().newBuilder()
                    .addHeader("Authorization", Credentials.basic(user.getUsername(), user.getPassword())).build();
            return chain.proceed(newRequest);
        });

        return getBaseRetrofit(builder.build()).create(UserClient.class);
    }

    public static UserClient authenticatedClientTokenInCookie(UserModel user) {

        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        //todo cookieJar
        builder.addInterceptor(chain -> {
            Request newRequest = chain.request().newBuilder().addHeader("Cookie", "token:" + TokenRepo.getToken(user)).build();
            return chain.proceed(newRequest);
        });

        setConfig(builder);
        builder.build();


        return getBaseRetrofit(builder.build()).create(UserClient.class);
    }

    private static void setConfig(OkHttpClient.Builder b) {

        b.callTimeout(Duration.ofSeconds(10))
                .connectTimeout(Duration.ofSeconds(10))
                .readTimeout(Duration.ofSeconds(10))
                .addInterceptor(new AllureOkHttp3()); //подключение Allure
    }

    private static Retrofit getBaseRetrofit(OkHttpClient client) {
        return new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())//mvn
                .addConverterFactory(ScalarsConverterFactory.create())//mvn
                .client(client).build();
    }

    public static UserClient create(UserModel user){
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.readTimeout(10, TimeUnit.SECONDS);
        builder.connectTimeout(5, TimeUnit.SECONDS);


        builder.addInterceptor(chain -> {
            Request request = chain.request().newBuilder()
                    .addHeader("Authorization", Credentials.basic(user.getUsername(), user.getPassword())).build();
            return chain.proceed(request);
        });


        OkHttpClient client = builder.build();

        Retrofit retrofit =
                new Retrofit.Builder().baseUrl(BASE_URL).client(client)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

        return retrofit.create(UserClient.class);
    }
}
