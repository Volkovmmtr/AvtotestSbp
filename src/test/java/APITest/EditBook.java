package APITest;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import ru.resful.booker.APIClients.UserClient;
import ru.resful.booker.clientFactorys.ClientFactory;
import ru.resful.booker.models.BookingModel;
import ru.resful.booker.models.UserModel;

import java.util.HashMap;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

public class EditBook {

    private static final UserModel adm = new UserModel("admin","password123");
    @SneakyThrows
    @Test
    public void test() {

        //UserClient client = ClientFactory.authenticatedClientBasic(adm);
        UserClient client = ClientFactory.authenticatedClientBasic(adm);

        Response<BookingModel> book = client.editBook(4633, new BookingModel()
                .setFirstname("gseg")
                .setLastname("Brogdrgdrwn")
                .setTotalprice(new Random().nextInt())
                .setDepositpaid(true)
                .setBookingdates(
                        new HashMap<String, String>(){{
                            put("checkin","2021-01-01");
                            put("checkout","20223-01-01");
                        }}
                )
                .setAdditionalneeds("Breakfast")
        ).execute();

        book.body();

    }

}