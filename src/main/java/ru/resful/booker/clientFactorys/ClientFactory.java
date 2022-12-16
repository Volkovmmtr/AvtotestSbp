package ru.resful.booker.clientFactorys;

import io.qameta.allure.okhttp3.AllureOkHttp3;
import lombok.SneakyThrows;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.jaxb.JaxbConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import ru.resful.booker.APIClients.EndpointProvider;
import ru.resful.booker.auth.TokenRepo;
import ru.resful.booker.models.universal.UserModel;

import java.time.Duration;

public class ClientFactory {
    private final static String BASE_URL = "https://restful-booker.herokuapp.com/";

    // Магия ретрофита
    public static EndpointProvider getClient(ConverterType converter) {
        // создаём экземпляр сконфигурированного OkHttp билдера
        OkHttpClient.Builder okHttpBuilder = getConfiguredHttpBuilder();
        // Создаём клиента Retrofit инкапсулирующего OkHttp клиента (okHttpBuilder.build())
        return getBaseRetrofit(okHttpBuilder.build(), converter)
                // Клиенту передаём описание API в вформате интерфейса
                .create(EndpointProvider.class);
    }

    @SneakyThrows
    public static EndpointProvider getClient(UserModel user, Boolean useToken, ConverterType converter) {
        OkHttpClient.Builder okHttpBuilder = getConfiguredHttpBuilder();
        // создаём перехватчика и добавляем в клиент OkHttp. Роль перехватчика - это добавление в хедера авторизации по методы BaseAuth
        String token;
        if (useToken) token = TokenRepo.getToken(user) ;
        else {
            token = null;
        }
        okHttpBuilder.addInterceptor(chain -> {
            Request newRequest = chain.request().newBuilder()
                    .addHeader(

                            useToken ? "Cookie" : "Authorization" ,
                            useToken ?  "token=" + token : Credentials.basic(user.getUsername(), user.getPassword())

                    )
                    .build();
            return chain.proceed(newRequest);
        });
        return getBaseRetrofit(okHttpBuilder.build(), converter)
                .create(EndpointProvider.class); // в этой строке самый смак
        //ретрофит генерирует реализацию RequestBody на основе переданного ему интерфейса
        //+ читаемость -строки кода
    }

    // Шаг первый
    //Тут ничего интересного, настраивается OkHttpClient
    //Задаем таймауты и подключаем перехвадчик Аллюра
    private static OkHttpClient.Builder getConfiguredHttpBuilder() {
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient().newBuilder();
        okHttpBuilder.callTimeout(Duration.ofSeconds(10))
                .connectTimeout(Duration.ofSeconds(10))
                .readTimeout(Duration.ofSeconds(10))
                // обавляем перехватчики, (логи, модификация запроса)
                .addInterceptor(new AllureOkHttp3()); //подключение Allure
        return okHttpBuilder;
    }

    //Настраивается Retrofit
    private static Retrofit getBaseRetrofit(OkHttpClient httpClient, ConverterType converter) {
        //тут начинается магия Ретрофита

        Retrofit.Builder b = new Retrofit.Builder().baseUrl(BASE_URL) //задаем базовый УРЛ для всех запросов (OkHttp так не может, все запросы конфигурируются ручками)
                //todo XML есть смысл прикручивать?
                //Поорядок конвертеров имеет значение. Примитивы следует добавлять до других конвертеров
                .addConverterFactory(ScalarsConverterFactory.create());//mvn ответ\запрос ответа в виде строки

        switch (converter){
            case XML:
                b.addConverterFactory(JaxbConverterFactory.create());
                break;
            case JSON:
                b.addConverterFactory(GsonConverterFactory.create());
                break;
            default:
                throw new RuntimeException("Converter not set");
        }

        return b.client(httpClient).build();
    }

}
