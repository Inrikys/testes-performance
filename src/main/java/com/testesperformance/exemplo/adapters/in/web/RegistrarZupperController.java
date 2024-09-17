package com.testesperformance.exemplo.adapters.in.web;

import com.testesperformance.exemplo.adapters.in.web.request.RegistrarZupperRequest;
import com.testesperformance.exemplo.adapters.in.web.response.RegistrarZupperResponse;
import com.testesperformance.exemplo.application.domain.Zupper;
import com.testesperformance.exemplo.application.ports.in.RegistrarZupperInputPort;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/zuppers")
public class RegistrarZupperController {

    private final RegistrarZupperInputPort registrarZupperInputPort;

    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrarZupperController.class);

    public RegistrarZupperController(RegistrarZupperInputPort registrarZupperInputPort) {
        this.registrarZupperInputPort = registrarZupperInputPort;
    }

    @PostMapping
    public ResponseEntity<RegistrarZupperResponse> registrar(@Valid @RequestBody RegistrarZupperRequest request, UriComponentsBuilder uriComponentsBuilder) {

        Zupper novoZupper = request.toZupper();

        LOGGER.info("Iniciando registro de novo Zupper");

        Zupper zupperRegistrado = registrarZupperInputPort.executar(novoZupper, request.getCep(), request.getNumero());

        RegistrarZupperResponse registrarZupperResponse = new RegistrarZupperResponse(zupperRegistrado);

        URI location = uriComponentsBuilder.path("/zuppers/{id}").buildAndExpand(zupperRegistrado.getId()).toUri();
        return ResponseEntity.created(location).body(registrarZupperResponse);
    }

}
