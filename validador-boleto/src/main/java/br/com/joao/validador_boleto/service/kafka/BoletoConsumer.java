package br.com.joao.validador_boleto.service.kafka;

import br.com.joao.avro.Boleto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class BoletoConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(BoletoConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topico-boleto}", groupId = "${spring.kafka.consumer.group-id}")
    public void consomeBoleto(Boleto boleto){
        LOGGER.info(String.format("Consumindo mensagem -> %s", boleto));
    }

}
