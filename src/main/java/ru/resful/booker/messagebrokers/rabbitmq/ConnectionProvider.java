package ru.resful.booker.messagebrokers.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;
import lombok.SneakyThrows;
import ru.resful.booker.messagebrokers.ConfigProvider;

public class ConnectionProvider {

    @SneakyThrows
    public static Channel getConnection(){
        ConnectionFactory conn = new ConnectionFactory();
        conn.setHost(ConfigProvider.getMessageConfigProps().getRabbitMQURL());
        return conn.newConnection().createChannel();
    }

}
