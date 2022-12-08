package ru.resful.booker.messagebrokers.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;
import lombok.SneakyThrows;

public class ConnectionProvider {

    @SneakyThrows
    public static Channel getConnection(){
        ConnectionFactory conn =new ConnectionFactory();
        conn.setHost("localhost");
        return conn.newConnection().createChannel();
    }

}
