package APITest;

import lombok.SneakyThrows;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.resful.booker.APIClients.EndpointProvider;
import ru.resful.booker.APIClients.booker.DefaultHeaders;
import ru.resful.booker.auth.UserProvider;
import ru.resful.booker.auth.Users;
import ru.resful.booker.clientFactorys.ClientFactory;
import ru.resful.booker.clientFactorys.ConverterType;
import ru.resful.booker.modelGenerators.BookingGenerator;
import ru.resful.booker.models.universal.BookingModel;
import ru.resful.booker.models.responce.WrappedBookingModel;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.resful.booker.APIClients.booker.DefaultHeaders.XML_HEADER;


@Tag("API")
public class EditBookXMLTest {

    //тут у меня вопрос по jupiter
    //Если в классе будет несколько тестов, то у всех будут свои экземпляры?
    private final Map<String, String> header = XML_HEADER;
    EndpointProvider client = ClientFactory.getClient(UserProvider.getUserByName(Users.ADMIN_ROLE),
            true, ConverterType.XML);

    @SneakyThrows
    @Test
    public void test() {
        WrappedBookingModel oldBook = client.addBook(BookingGenerator.getNewBook(), header).execute().body();

        BookingModel newBook = BookingGenerator.getNewBook();
        client.editBook(oldBook.getBookingid(), newBook, header)
                .execute();

        BookingModel editedBook = client.getBookById(oldBook.getBookingid(), header).execute().body();

        //todo сравнения объектов стоит отдельно вынести и сравнивать по конкретным полям
        assertThat(newBook.getBookingdates(), Matchers.samePropertyValuesAs(editedBook.getBookingdates()));
        assertThat(newBook.setBookingdates(null), Matchers.samePropertyValuesAs(editedBook.setBookingdates(null)));
    }

}
