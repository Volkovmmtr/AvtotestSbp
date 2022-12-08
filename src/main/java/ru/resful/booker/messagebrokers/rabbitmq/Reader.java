package ru.resful.booker.messagebrokers.rabbitmq;

import com.rabbitmq.client.*;
import lombok.SneakyThrows;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static ru.resful.booker.messagebrokers.rabbitmq.ConnectionProvider.getConnection;

public class Reader {


    @SneakyThrows
    public static List<String> read(String queue) {
        Channel channel = getConnection();

        List<String> messages = new ArrayList<String>();

        final DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            messages.add(message);
        };

        channel.basicConsume(queue, true, deliverCallback, consumerTag -> {});

        channel.basicConsume(queue, true, deliverCallback, new CancelCallback() {
            public void handle(String consumerTag) throws IOException {
            }});

        return messages;
    }
}