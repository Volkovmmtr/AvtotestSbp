package APITest;

import lombok.SneakyThrows;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
/*
import ru.resful.booker.messagebrokers.rabbitmq.Reader;
import ru.resful.booker.messagebrokers.rabbitmq.Sender;

 */
import ru.resful.booker.messagebrokers.kafka.Reader;
import ru.resful.booker.messagebrokers.kafka.Sender;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Tag("MessageBroker")
public class KafkaCheckTest {

    @SneakyThrows
    @Test
    public void test() {
        Thread.sleep(15000);
        String msg = RandomStringUtils.random(14,true,false);

        Sender.sendMessage("test.topic",msg);
        List<String> messages = Reader.getAllMessagesFromTopic("test.topic");

        assertThat(messages, hasItem(msg));
    }

}
