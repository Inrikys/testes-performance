package com.testesperformance.exemplo;

import com.testesperformance.exemplo.adapters.out.producer.message.ZupperRegistradoEnderecoMessage;
import com.testesperformance.exemplo.adapters.out.producer.message.ZupperRegistradoMessage;
import com.testesperformance.exemplo.adapters.out.repository.ZupperRepository;
import com.testesperformance.exemplo.adapters.out.repository.entity.ZupperEntity;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@DirtiesContext
@EmbeddedKafka(topics = {"tp-novo-zupper"})
public class ReceberConfirmacaoPocTest {

    private static final String TOPICO = "tp-novo-zupper";
    @Autowired
    private EmbeddedKafkaBroker embeddedKafkaBroker;

    @Autowired
    private ZupperRepository zupperRepository;

    /**
     * @link ref -> https://github.com/Kevded/integration-test-spring-kafka-with-embedded-kafka-consumer-and-producer/blob/master/src/test/java/com/example/integrationtestspringkafka/service/ConsumerServiceIntegrationTest.java
     */
    @Test
    public void receberMensagem_QuandoProducerEnviarMensagem_DeveReceberMensagemEProcessar() throws ExecutionException, InterruptedException {
        // GIVEN
        ZupperRegistradoMessage exampleDTO = this.getMock();

        // simulation consumer
        Map<String, Object> producerProps = KafkaTestUtils.producerProps(embeddedKafkaBroker.getBrokersAsString());

        Producer<String, ZupperRegistradoMessage> producerTest = new KafkaProducer(producerProps, new StringSerializer(), new JsonSerializer<ZupperRegistradoMessage>());

        // WHEN
        producerTest.send(new ProducerRecord(TOPICO, "", exampleDTO));

        // THEN
        CountDownLatch latch = new CountDownLatch(1);
        latch.await(60, TimeUnit.SECONDS);

//        var exampleEntityList = zupperRepository.findAll();
//        assertEquals(1, exampleEntityList.size());
//        ZupperEntity firstEntity = exampleEntityList.get(0);
//
//        assertEquals(exampleDTO.getNome(), firstEntity.getNome());
//        producerTest.close();
    }

    private ZupperRegistradoMessage getMock() {

        ZupperRegistradoEnderecoMessage enderecoMessage = ZupperRegistradoEnderecoMessage.builder()
                .cep("1312312")
                .uf("SP")
                .bairro("teste")
                .numero("123")
                .complemento("teste")
                .logradouro("reste")
                .localidade("ersaasd")
                .build();

        return ZupperRegistradoMessage.builder()
                .id(1l)
                .email("teste@gmail.com")
                .nome("teste-kafka")
                .sobrenome("consumer")
                .dataNascimento(LocalDate.now())
                .celular("11941112312")
                .endereco(enderecoMessage)
                .build();

    }

}
