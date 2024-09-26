package com.testesperformance.exemplo.adapters.in.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.testesperformance.exemplo.adapters.out.producer.message.ZupperRegistradoMessage;
import com.testesperformance.exemplo.adapters.out.repository.ZupperRepository;
import com.testesperformance.exemplo.adapters.out.repository.entity.ZupperEntity;
import com.testesperformance.exemplo.application.exception.ZupperNaoExisteException;
import com.testesperformance.exemplo.application.ports.in.RegistrarConfirmacaoKitOnboardingInputPort;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceberConfirmacaoKitOnboardingAdapter {

    private final RegistrarConfirmacaoKitOnboardingInputPort registrarConfirmacao;

    private final ZupperRepository zupperRepository;

    public ReceberConfirmacaoKitOnboardingAdapter(RegistrarConfirmacaoKitOnboardingInputPort registrarConfirmacao, ZupperRepository zupperRepository) {
        this.registrarConfirmacao = registrarConfirmacao;
        this.zupperRepository = zupperRepository;
    }

    @KafkaListener(topics = "tp-novo-zupper", groupId = "cafe-fullstack")
    public void receberMensagem(String zupperRegistradoMessageJson) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        ZupperRegistradoMessage zupperRegistradoMessage = objectMapper.readValue(zupperRegistradoMessageJson, ZupperRegistradoMessage.class);

        System.out.println(zupperRegistradoMessage);

        ZupperEntity zupperEntity = zupperRepository
                .findById(zupperRegistradoMessage.getId()).orElseThrow(() -> new ZupperNaoExisteException("Zupper não existente na base de dados"));

        this.registrarConfirmacao.executar(zupperEntity.toZupper());
    }

}
