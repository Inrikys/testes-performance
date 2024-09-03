package com.cleanarchitecture.exemplo.application.usecase;

import com.cleanarchitecture.exemplo.application.domain.Endereco;
import com.cleanarchitecture.exemplo.application.domain.Zupper;
import com.cleanarchitecture.exemplo.application.exception.ZupperJaExistenteException;
import com.cleanarchitecture.exemplo.application.ports.in.RegistrarZupperInputPort;
import com.cleanarchitecture.exemplo.application.ports.out.BuscarEnderecoPeloCepOutputPort;
import com.cleanarchitecture.exemplo.application.ports.out.NotificarNovoZupperOutputPort;
import com.cleanarchitecture.exemplo.application.ports.out.RegistrarZupperOutputPort;
import com.cleanarchitecture.exemplo.application.ports.out.VerificarExistenciaZupperOutputPort;

public class RegistrarZupperUseCase implements RegistrarZupperInputPort {

    private final RegistrarZupperOutputPort registrarZupperOutputPort;

    private final BuscarEnderecoPeloCepOutputPort buscarEnderecoPeloCepOutputPort;

    private final NotificarNovoZupperOutputPort notificarNovoZupperOutputPort;

    private final VerificarExistenciaZupperOutputPort verificarExistenciaZupperOutputPort;

    public RegistrarZupperUseCase(RegistrarZupperOutputPort registrarZupperOutputPort, BuscarEnderecoPeloCepOutputPort buscarEnderecoPeloCepOutputPort, NotificarNovoZupperOutputPort notificarNovoZupperOutputPort, VerificarExistenciaZupperOutputPort verificarExistenciaZupperOutputPort) {
        this.registrarZupperOutputPort = registrarZupperOutputPort;
        this.buscarEnderecoPeloCepOutputPort = buscarEnderecoPeloCepOutputPort;
        this.notificarNovoZupperOutputPort = notificarNovoZupperOutputPort;
        this.verificarExistenciaZupperOutputPort = verificarExistenciaZupperOutputPort;
    }

    public Zupper executar(Zupper novoZupper, String cep, String numero) {

        boolean isZupperCadastrado = verificarExistenciaZupperOutputPort.isZupperCadastrado(novoZupper.getEmail());

        if (isZupperCadastrado) {
            throw new ZupperJaExistenteException("Zupper com o email: " + novoZupper.getEmail() + " já está cadastrado");
        }

        Endereco endereco = this.buscarEnderecoPeloCepOutputPort.buscar(cep);
        novoZupper.setEndereco(endereco, numero);

        Zupper zupperRegistrado = this.registrarZupperOutputPort.registrar(novoZupper);
        this.notificarNovoZupperOutputPort.notificar(zupperRegistrado);

        return zupperRegistrado;
    }
}
