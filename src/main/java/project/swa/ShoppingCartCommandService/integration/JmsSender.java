package project.swa.ShoppingCartCommandService.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import project.swa.ShoppingCartCommandService.service.ShoppingCartDTO;

@Component
public class JmsSender {
    @Autowired
    private KafkaTemplate<String, ShoppingCartDTO> kafkaTemplate;

    @Value("${app.topic.customertopic}")
    private String topic;

    public void send(ShoppingCartDTO shoppingCartDTO){
        kafkaTemplate.send(topic, shoppingCartDTO);
    }
}
