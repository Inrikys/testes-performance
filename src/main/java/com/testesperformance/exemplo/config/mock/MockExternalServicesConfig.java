package com.testesperformance.exemplo.config.mock;

import com.testesperformance.exemplo.adapters.out.client.BuscarEnderecoPeloCepClient;
import com.testesperformance.exemplo.adapters.out.client.response.BuscarEnderecoPeloCepResponse;
import com.testesperformance.exemplo.adapters.out.repository.ZupperRepository;
import com.testesperformance.exemplo.adapters.out.repository.entity.ZupperEntity;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;

@Configuration
public class MockExternalServicesConfig {

    @Bean
    @Conditional(MockExternalServicesCondition.class)
    public BuscarEnderecoPeloCepClient buscarEnderecoPeloCepClient() throws IOException {

        BuscarEnderecoPeloCepClient mock = Mockito.mock(BuscarEnderecoPeloCepClient.class);
        BuscarEnderecoPeloCepResponse responseMock = JsonMockHelper.readJsonFromFile("buscarEnderecoPeloCepResponse.json", BuscarEnderecoPeloCepResponse.class);

        Mockito.when(mock.buscar(ArgumentMatchers.anyString())).thenReturn(responseMock);

        return mock;
    }

//    @Bean
//    @Conditional(MockExternalServicesCondition.class)
//    public ProducerFactory producerFactory() {
//        return Mockito.mock(ProducerFactory.class);
//    }
//
//    @Bean
//    @Conditional(MockExternalServicesCondition.class)
//    public KafkaTemplate kafkaTemplate() {
//        return Mockito.mock(KafkaTemplate.class);
//    }
//
//    @Bean
//    @Conditional(MockExternalServicesCondition.class)
//    public ZupperRepository zupperRepository() throws IOException {
//
//        ZupperRepository mock = Mockito.mock(ZupperRepository.class);
//
//        ZupperEntity responseMock = JsonMockHelper.readJsonFromFile("zupperEntity.json", ZupperEntity.class);
//
//        Mockito.when(mock.existsByEmail(Mockito.anyString())).thenReturn(false);
//        Mockito.when(mock.save(any(ZupperEntity.class))).thenReturn(responseMock);
//
//        return mock;
//    }
}
