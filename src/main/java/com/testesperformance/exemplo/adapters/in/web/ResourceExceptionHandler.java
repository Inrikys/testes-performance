package com.testesperformance.exemplo.adapters.in.web;


import com.testesperformance.exemplo.application.exception.ZupperJaExistenteException;
import com.testesperformance.exemplo.application.exception.ZupperNaoExisteException;
import com.testesperformance.exemplo.application.usecase.DetalharZupperUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResourceExceptionHandler.class);

    @ExceptionHandler(ZupperJaExistenteException.class)
    public ResponseEntity<String> zupperJaExistenteException(ZupperJaExistenteException exception) {
        LOGGER.error(exception.getMessage());
        return ResponseEntity.unprocessableEntity().body(exception.getMessage());
    }

    @ExceptionHandler(ZupperNaoExisteException.class)
    public ResponseEntity<String> zupperNaoExisteException(ZupperNaoExisteException exception) {
        LOGGER.error(exception.getMessage());
        return ResponseEntity.notFound().build();
    }

}
