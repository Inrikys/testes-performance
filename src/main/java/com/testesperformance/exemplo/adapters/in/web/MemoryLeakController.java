package com.testesperformance.exemplo.adapters.in.web;

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

@RestController
@RequestMapping("/memory-leak")
public class MemoryLeakController {

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

        // Não fechar o BufferedReader causa acumulo de uso de memória
        // ele é um objeto que extends de Closeable, então pode ser utilizado um
        // try with resources nesse caso
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        StringBuilder content = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            content.append(line);
        }

        return content.toString();
    }

    @GetMapping("/lista-muito-grande")
    public String causeObjectLeak(@RequestParam int tamanhoLista) {
        // Uma solução seria limitar o tamanho que pode ser criado
        // para evitar alocação desnecessária
        // Se a lista é instânciada sem tamanho, ela vai criar uma lista nova
        // sempre que for realocar o tamanho
        List<String> list = new ArrayList<>();
        for (int i = 0; i < tamanhoLista; i++) {
            // Cria novos objetos em um loop, ocupando mais memória a cada chamada
            // Criando muitas Strings também -> ocupa mais memória
            list.add(new String("Object " + i));
        }
        return "Created " + tamanhoLista + " objects!";
    }

    @GetMapping("/listeners-nunca-removidos")
    public String addListener(@RequestParam String eventName) {
        listenerList.add(EventListener.class, new EventListener() {
            public void onEvent() {
                System.out.println("Event triggered: " + eventName);
            }
        });
        return "Listener adicionado!";
    }


    // Pode ser evitado com timeout com tempo esperado com folga
    @GetMapping("/funcao-async-sem-fim")
    public String causeAsyncLeak() {
        performAsyncTask();
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
        // Criando uma referência circular
        current.next = first;

        return "Created a circular linked list of size " + size;
    }

}
