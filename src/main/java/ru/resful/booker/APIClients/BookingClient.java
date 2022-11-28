package ru.resful.booker.APIClients;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.resful.booker.models.BookingModel;

public interface BookingClient {

    @GET("/booking")
    Call<BookingModel> getBookingIDs();

    @GET("/booking")
    //пеередать null если параметр не отправляется
    Call<BookingModel> getBookingIDsFilter(@Query("firstname") String firstname,
                                           @Query("lastname") String lastname);
}
