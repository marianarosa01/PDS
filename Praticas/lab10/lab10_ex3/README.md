# PROBLEMA
Para que possa consumir um determinado conteúdo, um consumidor manda uma mensagem a todos os produtores de maneira a descobrir qual deles produz o conteúdo que este procura. Como seria de esperar, esta resolução não é eficiente. Se tivermos inúmeros produtores e consumidores o código demora imenso tempo a ser executado. 

# SOLUÇÃO

Assim, surge a classe Mediator como solução a este problema. Esta funciona como um intermediário que separa senders e receivers. Tanto produtores como consumidores são acoplados exclusivamente ao Mediator que gere adequadamente as ligações, os registos e envios de mensagens.

# RECURSOS/FONTES

Slides da disciplina
https://refactoring.guru/design-patterns/mediator
https://sourcemaking.com/design_patterns/mediator

