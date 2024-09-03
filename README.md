# Arquitetura Limpa

Seguindo a proposta de fazer uma segunda apresentação na agenda Café com Fullstack, separei aqui nesse repositório um template de um padrão de design de código chamado "Arquitetura Hexagonal" ou "Ports and Adapters".

A Arquitetura Hexagonal tem por padrão o dever de isolar o "core" da aplicação, ou seja, isolar aonde implementamos as regras de negócio, que será a parte mais estável da aplicação, dos "detalhes".

## Detalhes de uma aplicação.
Segundo o livro "Arquitetura Limpa", do autor Robert C. Martin, em uma aplicação existe a parte mais importante, que seriam as regras de negócio, e o restante seriam apenas detalhes.  

Segue alguns exemplos do que venha a ser considerado detalhe de acordo com as boas práticas de arquitetura descritas no livro.
- Banco de dados
- Framework
- Sistema operacional
- GUI (Graphical User Interface)
- Protocolo de comunicação

No começo de uma aplicação, acredito que seja difícil enxergar que essas coisas listas são apenas detalhes, pois no presente as stacks utilizadas parecem ser altamente estáveis. Para quem acompanhou a mudança rápida da técnologia que ocorreu dos anos 90 para cá já entendeu o porquê de considerar os itens listados como detalhes. Alguns de lá para cá ainda permanecem, como por exemplo banco de dados relacional (SQL), e outros nem tanto, como o uso de uma GUI acoplada a um sistema operacional, hoje em dia é mais comum interfaces web, que rodam no próprio navegador.

Por esse motivo, os conceitos apresentados no livro traz práticas para aumentar o tempo de vida útil de sua aplicação, e não acoplar regras de negócio com possíveis tecnologias que envelhecerão ao decorrer do avanço da tecnologia.

# Diagramas
No livro somos apresentados ao seguinte modelo:

![Diagrama da Arquitetura Limpa](https://blog.cleancoder.com/uncle-bob/images/2012-08-13-the-clean-architecture/CleanArchitecture.jpg)





# Referências
https://www.happycoders.eu/software-craftsmanship/hexagonal-architecture/
