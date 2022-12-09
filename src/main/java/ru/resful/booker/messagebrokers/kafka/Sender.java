package ru.resful.booker.messagebrokers.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.concurrent.ExecutionException;

public class Sender {

    public static void sendMessage(String topicName, String message) {
        try (Producer<Long, String> producer = new KafkaProducer<>(KafkaPropertiesProvider.getSenderProps())) {
            RecordMetadata recordMetadata = (RecordMetadata) producer.send(new ProducerRecord(topicName, message)).get();
            if (!recordMetadata.hasOffset()) throw new RuntimeException();
        } catch (RuntimeException e) {
            //todo добавить логирование действий?
            System.out.println("Error sending message " + message + "into topic " + topicName);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

}
