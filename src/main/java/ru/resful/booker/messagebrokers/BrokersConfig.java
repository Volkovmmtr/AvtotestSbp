package ru.resful.booker.messagebrokers;

import org.aeonbits.owner.Config;

@Config.Sources({"file:./src/main/resources/messageBroker.properties"})

public interface BrokersConfig extends Config{

    @Config.Key("rabbitmq.host")
    String getRabbitMQURL();

    @Config.Key("kafka.host")
    String getKafkaURL();

    @Config.Key("kafka.long_serializer")
    String getKafkaLongSerializer();
    @Config.Key("kafka.long_deserializer")
    String getKafkaLongDeserializer();

    @Config.Key("kafka.string_serializer")
    String getKafkaStringSerializer();

    @Config.Key("kafka.string_deserializer")
    String getKafkaStringDeserializer();

    @Config.Key("kafka.timeout")
    String getKafkaTimeout();

}
