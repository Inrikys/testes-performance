package com.testesperformance.exemplo.adapters.in.web;

import com.testesperformance.exemplo.application.ports.in.ExcluirZupperInputPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zuppers")
public class ExcluirZupperController {

    private final ExcluirZupperInputPort excluirZupperInputPort;

    private static final Logger LOGGER = LoggerFactory.getLogger(ExcluirZupperController.class);

    public ExcluirZupperController(ExcluirZupperInputPort excluirZupperInputPort) {
        this.excluirZupperInputPort = excluirZupperInputPort;
    }


    @DeleteMapping("/{zupperId}")
    public ResponseEntity<Void> excluir(@PathVariable Long zupperId) {

        LOGGER.info("Iniciando exclusão de Zupper...");

        excluirZupperInputPort.executar(zupperId);
        return ResponseEntity.noContent().build();
    }
}
