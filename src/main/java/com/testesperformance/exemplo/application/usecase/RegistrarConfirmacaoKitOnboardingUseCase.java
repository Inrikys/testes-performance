package com.testesperformance.exemplo.application.usecase;

import com.testesperformance.exemplo.application.domain.Zupper;
import com.testesperformance.exemplo.application.ports.in.RegistrarConfirmacaoKitOnboardingInputPort;

public class RegistrarConfirmacaoKitOnboardingUseCase implements RegistrarConfirmacaoKitOnboardingInputPort {

    @Override
    public void executar(Zupper zupper) {
        System.out.println(zupper.getNome() + " recebeu o kit de boas vindas!!");
    }
}
