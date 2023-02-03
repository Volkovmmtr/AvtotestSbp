package ru.resful.booker.messagebrokers.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Reader {

    public static List<String> getAllMessagesFromTopic(String topicName, int partitionNum) {
        List<String> values = new ArrayList<>();
        KafkaPropertiesProvider.getGetterProps();
        try (KafkaConsumer<Long, String> consumer = new KafkaConsumer<>(KafkaPropertiesProvider.getGetterProps())) {
            List<TopicPartition> tps = Collections.singletonList(new TopicPartition(topicName ,partitionNum));
            consumer.assign(tps);
            consumer.seekToBeginning(tps);
            ConsumerRecords<Long, String> consumerRecords = consumer.poll(
                    //todo
                    Integer.parseInt(KafkaPropertiesProvider.getSenderProps().get("readRequestTimeout").toString())            );
            if (!consumerRecords.isEmpty()) {
                consumerRecords.iterator().forEachRemaining((cr)-> values.add(cr.value()));
            }
        }
        return values;
    }

}
