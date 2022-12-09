package ru.resful.booker.messagebrokers.kafka;

import lombok.Getter;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import ru.resful.booker.messagebrokers.ConfigProvider;

import java.util.Properties;

public class KafkaPropertiesProvider {

    @Getter
    private static final Properties senderProps = setSenderProps();

    @Getter
    private static final Properties getterProps = setGetterProps();

    private static Properties setSenderProps(){
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, ConfigProvider.getMessageConfigProps().getKafkaURL());
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, ConfigProvider.getMessageConfigProps().getKafkaLongSerializer());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ConfigProvider.getMessageConfigProps().getKafkaStringSerializer());

        props.put("readRequestTimeout", ConfigProvider.getMessageConfigProps().getKafkaTimeout());
        return props;
    }

    private static Properties setGetterProps(){
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, ConfigProvider.getMessageConfigProps().getKafkaURL());
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, ConfigProvider.getMessageConfigProps().getKafkaLongDeserializer());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ConfigProvider.getMessageConfigProps().getKafkaStringDeserializer());

        props.put("readRequestTimeout", ConfigProvider.getMessageConfigProps().getKafkaTimeout());
        return props;
    }
}
