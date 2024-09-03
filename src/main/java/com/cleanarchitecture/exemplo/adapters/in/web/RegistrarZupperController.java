package com.cleanarchitecture.exemplo.adapters.in.web;

import com.cleanarchitecture.exemplo.adapters.in.web.request.RegistrarZupperRequest;
import com.cleanarchitecture.exemplo.adapters.in.web.response.RegistrarZupperResponse;
import com.cleanarchitecture.exemplo.application.domain.Zupper;
import com.cleanarchitecture.exemplo.application.ports.in.RegistrarZupperInputPort;
import jakarta.validation.Valid;
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

    public RegistrarZupperController(RegistrarZupperInputPort registrarZupperInputPort) {
        this.registrarZupperInputPort = registrarZupperInputPort;
    }

    @PostMapping
    public ResponseEntity<RegistrarZupperResponse> registrar(@Valid @RequestBody RegistrarZupperRequest request, UriComponentsBuilder uriComponentsBuilder) {

        Zupper novoZupper = request.toZupper();
        Zupper zupperRegistrado = registrarZupperInputPort.executar(novoZupper, request.getCep(), request.getNumero());

        RegistrarZupperResponse registrarZupperResponse = new RegistrarZupperResponse(zupperRegistrado);

        URI location = uriComponentsBuilder.path("/zuppers/{id}").buildAndExpand(zupperRegistrado.getId()).toUri();
        return ResponseEntity.created(location).body(registrarZupperResponse);
    }

}
