package com.testesperformance.exemplo.adapters.in.web;

import com.testesperformance.exemplo.adapters.in.web.response.DetalharZupperResponse;
import com.testesperformance.exemplo.application.domain.Zupper;
import com.testesperformance.exemplo.application.ports.in.DetalharZupperInputPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zuppers")
public class DetalharZupperController {

    private DetalharZupperInputPort detalharZupperInputPort;

    public DetalharZupperController(DetalharZupperInputPort detalharZupperInputPort) {
        this.detalharZupperInputPort = detalharZupperInputPort;
    }

    @GetMapping("/{zupperId}")
    public ResponseEntity<DetalharZupperResponse> detalhar(@PathVariable Long zupperId) {
        Zupper zupper = detalharZupperInputPort.executar(zupperId);
        return ResponseEntity.ok(new DetalharZupperResponse(zupper));
    }
}
