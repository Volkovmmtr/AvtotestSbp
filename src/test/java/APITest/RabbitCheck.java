package APITest;

import lombok.SneakyThrows;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import ru.resful.booker.messagebrokers.rabbitmq.Reader;
import ru.resful.booker.messagebrokers.rabbitmq.Sender;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class RabbitCheck {

    @SneakyThrows
    @Test
    public void test() {
        Sender.sendMessage("newQueue","spam");
        Sender.sendMessage("newQueue","text");
        Sender.sendMessage("newQueue","spam");
        List<String> messages = Reader.read("newQueue");

        assertThat(messages, iterableWithSize(3));
        assertThat(messages, hasItem("text"));
    }

}
