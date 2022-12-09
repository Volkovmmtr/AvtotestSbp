package APITest;

import lombok.SneakyThrows;
import org.apache.commons.lang3.RandomStringUtils;
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

public class KafkaCheck {

    @SneakyThrows
    @Test
    public void test() {

        String msg = RandomStringUtils.random(14,true,false);

        Sender.sendMessage("test.topic",msg);
        List<String> messages = Reader.getAllMessagesFromTopic("test.topic");

        assertThat(messages, hasItem(msg));
    }

}
