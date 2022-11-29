package ru.resful.booker.APIClients.booker;

import retrofit2.Call;
import retrofit2.http.*;
import ru.resful.booker.models.BookingModel;

public interface BookingClient {
    @Headers({"Accept: application/json"})
    @GET("/booking")
    Call<BookingModel> getBookingIDs();

    @GET("/booking")
    //пеередать null если параметр не отправляется
    Call<BookingModel> getBookingIDsFilter(@Query("firstname") String firstname,
                                           @Query("lastname") String lastname);


    @PUT("/booking/{id}")
    @Headers({"Accept: application/json"})
    Call<BookingModel> editBook(@Path("id") int bookId, @Body BookingModel bookingModel);
}
