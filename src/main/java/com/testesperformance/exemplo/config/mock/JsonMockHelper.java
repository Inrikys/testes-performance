package com.testesperformance.exemplo.config.mock;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonMockHelper {

    public static <T> T readJsonFromFile(String filePath, Class<T> clazz) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.registerModule(new JavaTimeModule());

        Path path = Paths.get(new ClassPathResource("mocks/" + filePath).getURI());
        String jsonContent = new String(Files.readAllBytes(path));

        return objectMapper.readValue(jsonContent, clazz);
    }
}
