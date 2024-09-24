# Testes de performance

- [x] Criar aplicação Hexagonal
- [x] Criar endpoint de cadastrar
- [x] Criar endpoint de buscar lista paginada
- [x] Criar endpoint de detalhar
- [x] Criar endpoint de deletar
- [x] Acrescentar logs de cenários felizes
- [x] Criar tratamento de exceptions
- [x] Acrescentar logs de cenários com falhas
- [x] Configurar arquivo logback
- [ ] Rodar testes de performance e verificar saúde da JVM

# Objetivos complementares
obs: estou com problemas para configurar docker, então por enquanto vou testar usando visualVM

- [ ] Configurar Prometheus
- [ ] Criar docker-compose com container de Grafana
- [ ] Adicionar métricas de JVM
- [ ] Criar alertas com métricas de JVM
- [ ] Adicionar métricas de negócio
- [ ] Criar alertas com métricas de negócio


# Útil para testes locais

## Modificar memória da JVM

Caso nenhum comando não seja passado, a JVM decide pelo hardware do computador que está rodando a aplicação

### Modificar Heap
java -Xms256m -Xmx512m -jar exemplo-0.0.1-SNAPSHOT.jar

### Modificar Metaspace
java -XX:MaxMetaspaceSize=1024m -jar exemplo-0.0.1-SNAPSHOT.jar

### Heap e Metaspace
java -Xms256m -Xmx512m -XX:MaxMetaspaceSize=1024m -jar exemplo-0.0.1-SNAPSHOT.jar


# GC - Garbage Collector
java -XX:+UseG1GC -jar exemplo-0.0.1-SNAPSHOT.jar  # Default a partir do java 9  

java -XX:+UseParallelGC -jar exemplo-0.0.1-SNAPSHOT.jar   # Default no java 8

java -XX:+UseZGC -jar exemplo-0.0.1-SNAPSHOT.jar  

### Habilitar logs GC
java -Xlog:gc*:file/var/log/app-gc.log -jar exemplo-0.0.1-SNAPSHOT.jar

# Troubleshooting

Configurações interessantes para infraestrutura dockerizada, onde ao finalizar uma aplicação, sobe uma nova instância automaticamente
obs: Alguns autores dizem que não é recomendado, mas depende de cada aplicação
### Terminar uma aplicação em caso de OutOfMemoryError
java -XX:+ExitOnOutOfMemoryError -jar exemplo-0.0.1-SNAPSHOT.jar

### Terminar a aplicação em caso de erro de crash em caso de OutOfMemoryError
java -XX:+CrashOnOutOfMemoryError -jar exemplo-0.0.1-SNAPSHOT.jar


# Complementar
### Como rodar uma aplicação
java -jar exemplo-0.0.1-SNAPSHOT.jar

### Rodando uma aplicação passando propriedades de JVM via linha de comando
java -Duser.timezone=America/Sao_Paulo -jar exemplo-0.0.1-SNAPSHOT.jar

### Rodando propriedades de negócio para aplicação via linha de comando
java -Dexternal-services.mock.enabled=true -jar exemplo-0.0.1-SNAPSHOT.jar
