package com.testesperformance.exemplo.adapters.in.web;

import jakarta.annotation.PreDestroy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.event.EventListenerList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@RestController
@RequestMapping("/memory-leak-safe")
public class MemoryLeakSafeController {

    // Lista estática que acumula os parâmetros recebidos de cada chamada ao endpoint
    // Variáveis estáticas são armazenadas na Metaspace com objeto na Heap
    // Referencia -> Metaspace
    // Obj -> Heap
    private static final List<String> dataStore = new ArrayList<>();

    private EventListenerList listenerList = new EventListenerList();

    // Má prática usar variáveis estáticas para dados dinâmicos
    @GetMapping("/lista-estatica")
    public String memoryLeakListaEstatica(@RequestParam String data) {

        dataStore.add(data);

        // Simula um processamento com sleep, apenas para ilustrar algum processamento
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return "Data added!";
    }

    @GetMapping("/closable-aberto")
    public String readFile() throws IOException {

        String filePath = new ClassPathResource("mocks/buscarEnderecoPeloCepResponse.json").getURI().toString();

        // try-with-resources -> Garante que depois da execução, o objeto será fechado
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }

            return content.toString();

        } catch (Exception e) {
            return "Erro ao ler o arquivo: " + e.getMessage();
        }

    }

    @GetMapping("/lista-muito-grande")
    public String causeObjectLeak(@RequestParam int tamanhoLista) {

        if (tamanhoLista > 100) {
            return "Tamanho máximo excedido";
        }

        // Se criar uma lista com tamanho desejado, vai evitar demais realocações
        List<String> list = new ArrayList<>(tamanhoLista);

        String base = "Object ";
        for (int i = 0; i < tamanhoLista; i++) {
            // Está usando a String criada antes para evitar múltiplas instâncias
            list.add(base + i);
        }
        return "Created " + tamanhoLista + " objects!";
    }

    // Pode ser evitado implementando uma estrategia de remoção automática
    // ou remover assim que não forem mais necessários
    @GetMapping("/listeners-nunca-removidos")
    public String addListener(@RequestParam String eventName) {
        listenerList.add(EventListener.class, new EventListener() {
            public void onEvent() {
                System.out.println("Event triggered: " + eventName);
            }
        });
        return "Listener adicionado!";
    }

    // Método para remover todos os listeners antes da destruição do bean MemoryLeakController
    @PreDestroy
    public void removeAllListeners() {
        for (EventListener listener : listenerList.getListeners(EventListener.class)) {
            listenerList.remove(EventListener.class, listener);
        }
    }


    // Pode ser evitado com timeout com tempo esperado com folga
    @GetMapping("/funcao-async-sem-fim")
    public String causeAsyncLeak() {

        CompletableFuture<Void> future = performAsyncTask();

        try {
            future.get(20, TimeUnit.SECONDS);
            System.out.println("Função assíncrona rodou dentro do tempo esperado");
        } catch (TimeoutException | InterruptedException | ExecutionException exception) {
            future.cancel(true);
            System.out.println("Função assíncrona demorou demais!");
            System.out.println(exception.getMessage());
        }

        return "Função assíncrona rodando!";
    }

    @Async
    private CompletableFuture<Void> performAsyncTask() {
        while (true) {
            // Loop infinito simulando uma tarefa que nunca termina
        }
    }

    class Node {
        Node next;
    }

    // Evitar referência circular
    // Muito cuidado ao implementar chain of responsibility por conta desse problema
    @GetMapping("/referencia-circular")
    public String causeCircularReferenceLeak(@RequestParam int size) {
        Node first = new Node();
        Node current = first;
        for (int i = 0; i < size; i++) {
            current.next = new Node();
            current = current.next;
        }

        // Não criar referência circular
        // current.next = first;


        return "Created a linked list of size " + size + " without circular reference";
    }

}
