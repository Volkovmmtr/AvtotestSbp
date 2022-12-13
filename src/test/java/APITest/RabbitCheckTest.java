package APITest;

import lombok.SneakyThrows;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.resful.booker.messagebrokers.rabbitmq.Reader;
import ru.resful.booker.messagebrokers.rabbitmq.Sender;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@Tag("MessageBroker")
public class RabbitCheckTest {

    @SneakyThrows
    @Test
    public void test() {
        String msg = RandomStringUtils.random(14,true,false);

        Sender.sendMessage("newQueue",msg);
        List<String> messages = Reader.read("newQueue",false);

        assertThat(messages, hasItem(msg));
    }

}