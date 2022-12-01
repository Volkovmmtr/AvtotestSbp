package ru.resful.booker.clientFactorys;

import io.qameta.allure.okhttp3.AllureOkHttp3;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import ru.resful.booker.APIClients.EndpointProvider;
import ru.resful.booker.auth.TokenRepo;
import ru.resful.booker.models.UserModel;

import java.time.Duration;

public class ClientFactory {
    private final static String BASE_URL = "https://restful-booker.herokuapp.com/";

    public static EndpointProvider anonimClient() {
        OkHttpClient.Builder okHttpBuilder = getConfiguredHttpBuilder();

        return getBaseRetrofit(okHttpBuilder.build()).create(EndpointProvider.class);
    }

    public static EndpointProvider authenticatedClientBasic(UserModel user) {
        OkHttpClient.Builder okHttpBuilder = getConfiguredHttpBuilder();
        okHttpBuilder.addInterceptor(chain -> {
            Request newRequest = chain.request().newBuilder()
                    .addHeader("Authorization", Credentials.basic(user.getUsername(), user.getPassword()))
                    .build();
            return chain.proceed(newRequest);
        });

        return getBaseRetrofit(okHttpBuilder.build())
                .create(EndpointProvider.class); // в этой строке самый смак
        //ретрофит генерирует реализацию RequestBody на основе переданного ему интерфейса
        //+ читаемость -строки кода
    }

    public static EndpointProvider authenticatedClientTokenInCookie(UserModel user) {
        OkHttpClient.Builder okHttpBuilder = getConfiguredHttpBuilder();
        okHttpBuilder.addInterceptor(chain -> {
            Request newRequest = chain.request().newBuilder()
                    .addHeader("Cookie", "token=" + TokenRepo.getToken(user))
                    .build();
            return chain.proceed(newRequest);
        });

        return getBaseRetrofit(okHttpBuilder.build())
                .create(EndpointProvider.class);
    }

    //Тут ничего интересного, настраивается OkHttpClient
    //Задаем таймауты и подключаем перехвадчик Аллюра
    private static OkHttpClient.Builder getConfiguredHttpBuilder() {
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient().newBuilder();
        okHttpBuilder.callTimeout(Duration.ofSeconds(10))
                .connectTimeout(Duration.ofSeconds(10))
                .readTimeout(Duration.ofSeconds(10))
                .addInterceptor(new AllureOkHttp3()); //подключение Allure
        return okHttpBuilder;
    }


    private static Retrofit getBaseRetrofit(OkHttpClient httpClient) {
        //тут начинается магия Ретрофита
        return new Retrofit.Builder().baseUrl(BASE_URL) //задаем базовый УРЛ для всех запросов (OkHttp так не может, все запросы конфигурируются ручками)
                //todo XML есть смысл прикручивать?
                .addConverterFactory(GsonConverterFactory.create())//mvn ответ\запрос в виде экземпляра
                .addConverterFactory(ScalarsConverterFactory.create())//mvn ответ\запрос ответа в виде строки
                .client(httpClient).build();
    }

}
