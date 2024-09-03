package com.cleanarchitecture.exemplo.adapters.out;

import com.cleanarchitecture.exemplo.adapters.out.producer.message.ZupperRegistradoMessage;
import com.cleanarchitecture.exemplo.application.domain.Zupper;
import com.cleanarchitecture.exemplo.application.ports.out.NotificarNovoZupperOutputPort;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class NotificarNovoZupperAdapter implements NotificarNovoZupperOutputPort {

    private final KafkaTemplate<String, ZupperRegistradoMessage> kafkaTemplate;

    public NotificarNovoZupperAdapter(KafkaTemplate<String, ZupperRegistradoMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void notificar(Zupper novoZupper) {
        ZupperRegistradoMessage zupperRegistradoMessage = new ZupperRegistradoMessage(novoZupper);
        kafkaTemplate.send("tp-novo-zupper", zupperRegistradoMessage);
    }
}
