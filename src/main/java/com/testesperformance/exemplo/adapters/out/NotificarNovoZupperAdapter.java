package com.testesperformance.exemplo.adapters.out;

import com.testesperformance.exemplo.adapters.out.producer.message.ZupperRegistradoMessage;
import com.testesperformance.exemplo.application.domain.Zupper;
import com.testesperformance.exemplo.application.ports.out.NotificarNovoZupperOutputPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class NotificarNovoZupperAdapter implements NotificarNovoZupperOutputPort {

    private final KafkaTemplate<String, ZupperRegistradoMessage> kafkaTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(NotificarNovoZupperAdapter.class);

    public NotificarNovoZupperAdapter(KafkaTemplate<String, ZupperRegistradoMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void notificar(Zupper novoZupper) {
        ZupperRegistradoMessage zupperRegistradoMessage = new ZupperRegistradoMessage(novoZupper);

        LOGGER.info("Notificando outros sistemas que um novo zupper foi registrado...");

        kafkaTemplate.send("tp-novo-zupper", zupperRegistradoMessage);
    }
}
