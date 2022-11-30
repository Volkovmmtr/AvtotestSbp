package APITest;

import lombok.SneakyThrows;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.resful.booker.APIClients.EndpointProvider;
import ru.resful.booker.auth.UserProvider;
import ru.resful.booker.auth.Users;
import ru.resful.booker.clientFactorys.ClientFactory;
import ru.resful.booker.modelGenerators.BookingGenerator;
import ru.resful.booker.models.BookingModel;

import static org.hamcrest.MatcherAssert.assertThat;

public class EditBook {

    EndpointProvider client = ClientFactory.authenticatedClientTokenInCookie(
            UserProvider.getUserByName(Users.ADMIN_ROLE));

    //тут у меня вопрос по jupiter
    //Если в классе будет несколько тестов, то у всех будут свои экземпляры?
    BookingModel oldBook;

    @BeforeEach
    @SneakyThrows
    public void preconditions(){
        oldBook = client.addBook(BookingGenerator.getNewBook()).execute().body();
    }

    @SneakyThrows
    @Test
    public void test() {
        BookingModel newBook = BookingGenerator.getNewBook();
        client.editBook(oldBook.getId(), newBook)
                .execute();

        assertThat(newBook, Matchers.samePropertyValuesAs(client.getBookById(oldBook.getId()).execute().body()));
    }

}
