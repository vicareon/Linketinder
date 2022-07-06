package emailmicroservice

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.kafka.clients.consumer.ConsumerRecords
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import java.time.Duration

@Service
class EmailSubscriber {
    @Autowired
    CandidatoRepository candidatoRepository

    @Autowired
    EmailService emailService

    Properties properties = new Properties()
    KafkaConsumer<String, String> consumer

    EmailSubscriber(){
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.0.4:9092")
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName())
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName())
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "group1")
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest")

        consumer = new KafkaConsumer<String, String>(properties)

    }

    void escutarTopico() throws Exception{
        consumer.subscribe(Arrays.asList("Email"))
        EmailDetails details = new EmailDetails("teste@teste.com", "Nova vaga disponível no banco de dados", "Alerta de vaga")

        while(true){
            try{
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(200))
                for(ConsumerRecord<String, String> record : records){
                    println(record.value())
                    Thread.sleep(500)
                    emailService.sendSimpleMail(details)
                }
            } catch(Exception e){
                e.printStackTrace()
            }
        }
    }
}