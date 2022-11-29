package ru.resful.booker.APIClients;

import retrofit2.Call;
import retrofit2.http.*;
import ru.resful.booker.models.BookingModel;

public interface BookingClient {

    @GET("/booking")
    Call<BookingModel> getBookingIDs();

    @GET("/booking")
    //пеередать null если параметр не отправляется
    Call<BookingModel> getBookingIDsFilter(@Query("firstname") String firstname,
                                           @Query("lastname") String lastname);


    @PUT("/booking/{id}")
    Call<BookingModel> editBook(@Path("id") int bookId, @Body BookingModel bookingModel);
}
