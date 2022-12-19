package APITest;

import lombok.SneakyThrows;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.resful.booker.APIClients.booker.BookingClient;
import ru.resful.booker.auth.UserProvider;
import ru.resful.booker.auth.Users;
import ru.resful.booker.clientFactorys.ClientFactory;
import ru.resful.booker.clientFactorys.ConverterType;
import ru.resful.booker.modelGenerators.BookingGenerator;
import ru.resful.booker.models.universal.BookingModel;
import ru.resful.booker.models.responce.WrappedBookingModel;

import java.util.Map;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.resful.booker.APIClients.booker.DefaultHeaders.JSON_HEADER;
import static ru.resful.booker.APIClients.booker.DefaultHeaders.XML_HEADER;


@Tag("API")
public class EditBookTest {

    //тут у меня вопрос по jupiter
    //Если в классе будет несколько тестов, то у всех будут свои экземпляры?

    @SneakyThrows
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void test(Map<String, String> header, ConverterType converter) {
        BookingClient client = ClientFactory.getClient(UserProvider.getUserByName(Users.ADMIN_ROLE),
                true, converter);

        WrappedBookingModel oldBook = client.addBook(BookingGenerator.getNewBook(), header).execute().body();

        BookingModel newBook = BookingGenerator.getNewBook();
        client.editBook(oldBook.getBookingid(), newBook, header)
                .execute();

        BookingModel editedBook = client.getBookById(oldBook.getBookingid(), header).execute().body();

        //todo сравнения объектов стоит отдельно вынести и сравнивать по конкретным полям
        assertThat(newBook.getBookingdates(), Matchers.samePropertyValuesAs(editedBook.getBookingdates()));
        assertThat(newBook.setBookingdates(null), Matchers.samePropertyValuesAs(editedBook.setBookingdates(null)));
    }

    private static Stream<Arguments> testDataProvider(){
        return Stream.of(
                Arguments.of(XML_HEADER, ConverterType.XML),
                Arguments.of(JSON_HEADER, ConverterType.JSON)
        );
    }

}
