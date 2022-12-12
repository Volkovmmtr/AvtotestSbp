package ru.resful.booker.messagebrokers.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;
import lombok.Getter;
import lombok.SneakyThrows;
import ru.resful.booker.messagebrokers.ConfigProvider;

public class ConnectionProvider {

    @Getter
    private static final Channel connection = setConn();

    @SneakyThrows
    public static Channel setConn(){
        ConnectionFactory conn = new ConnectionFactory();
        conn.setHost(ConfigProvider.getMessageConfigProps().getRabbitMQURL());
        return conn.newConnection().createChannel();
    }

}
