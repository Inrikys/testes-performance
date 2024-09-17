package com.testesperformance.exemplo.adapters.in.web;

import com.testesperformance.exemplo.adapters.in.web.response.DetalharZupperResponse;
import com.testesperformance.exemplo.application.domain.Zupper;
import com.testesperformance.exemplo.application.ports.in.DetalharZupperInputPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zuppers")
public class DetalharZupperController {

    private DetalharZupperInputPort detalharZupperInputPort;

    private static final Logger LOGGER = LoggerFactory.getLogger(DetalharZupperController.class);

    public DetalharZupperController(DetalharZupperInputPort detalharZupperInputPort) {
        this.detalharZupperInputPort = detalharZupperInputPort;
    }

    @GetMapping("/{zupperId}")
    public ResponseEntity<DetalharZupperResponse> detalhar(@PathVariable Long zupperId) {

        LOGGER.info("Iniciando detalhamento de Zupper...");

        Zupper zupper = detalharZupperInputPort.executar(zupperId);
        return ResponseEntity.ok(new DetalharZupperResponse(zupper));
    }
}
