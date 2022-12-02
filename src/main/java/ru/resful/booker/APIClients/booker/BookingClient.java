package ru.resful.booker.APIClients.booker;

import retrofit2.Call;
import retrofit2.http.*;
import ru.resful.booker.models.BookingModel;

import java.util.List;

public interface BookingClient{


    //Не перезаписывает заголовки, при наличии дубликатов они будут отправлены
    //так же можно передавать заголовки в параметрах запроса retrofit2.http.Header
    //Задаем параметры для OkHttp.Request (без ретрофита это пришлось бы делать для каждого нового экземпляра)
    @Headers({"Accept: application/json"})
    @GET("/booking")
    Call<List<BookingModel>> getBookingIDs();

    @GET("/booking")
    //пеередать null если параметр не отправляется
    //Если несколько параметров не передаётся, то автоматически Retrofut их не передаёт в запросе.
    // Response вернётся в формате List<BookingModel>
    // @Query анотация ретрофита - означает параметр, который должен быть указан в url запроса
    Call<List<BookingModel>> getBookingIDsFilter(@Query("firstname") String firstname,
                                           @Query("lastname") String lastname);
    @Headers({"Accept: application/json"})
    // @Path - подставновка в EdnPoint значения id
    @GET("/booking/{id}")
    Call<BookingModel> getBookById(@Path("id") String id);

    @PUT("/booking/{id}")
    @Headers({"Accept: application/json"})
    // @Body - анотация ретрофита - означает тело передаваемое в http запросе. Тело представляет собой модель
    // Модель конвертируется в JSON за счёт библиотеки gson, которая подключается на шаге конфигурироваия Клиента Retrofit
    Call<BookingModel> editBook(@Path("id") String bookId, @Body BookingModel book);

    @POST("booking")
    @Headers({"Accept: application/json", "Content-Type: application/json"})
    Call<BookingModel> addBook(@Body BookingModel book);
}
