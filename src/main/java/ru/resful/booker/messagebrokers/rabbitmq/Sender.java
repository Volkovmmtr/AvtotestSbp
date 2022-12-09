package ru.resful.booker.messagebrokers.rabbitmq;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import lombok.SneakyThrows;

import java.nio.charset.StandardCharsets;

import static ru.resful.booker.messagebrokers.rabbitmq.ConnectionProvider.getConnection;

public class Sender {

    @SneakyThrows
    public static void sendMessage(String queue, String message) {
        Channel channel = getConnection();
        channel.queueDeclare(queue, false, false, false, null);
        channel.basicPublish("", queue, null, message.getBytes());
    }
}
