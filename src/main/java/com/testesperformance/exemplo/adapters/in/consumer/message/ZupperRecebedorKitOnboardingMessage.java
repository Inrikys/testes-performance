package com.testesperformance.exemplo.adapters.in.consumer.message;

import com.testesperformance.exemplo.application.domain.Zupper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ZupperRecebedorKitOnboardingMessage {

    private Long id;

    private String nome;

    private String sobrenome;

}
