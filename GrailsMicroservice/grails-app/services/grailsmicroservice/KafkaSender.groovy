package grailsmicroservice

import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
class KafkaSender {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    Properties properties = new Properties()
    KafkaProducer<String, String> producer

     KafkaSender(){
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName())
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName())
        producer = new KafkaProducer<>(properties)
    }

    void send(String message) {
        ProducerRecord<String, String> record = new ProducerRecord<>("Email", message)
        producer.send(record)
    }
}
