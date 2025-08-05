# Padrão de Projeto: Strategy

**Definição**: define uma família de algoritmos, encapsula cada um deles e os torna intercambiáveis. O *Strategy* permite que o algoritmo varie independentemente dos clientes que o utilizam.

A **família de algoritmos** em questão se trata de qualquer serviço que possui uma lógica própria. Por exemplo, podemos considerar um ecommerce como aplicativo principal e a família de algoritmos sendo constituída de serviços que implementam a lógica de um frete. Digamos que existam 3 blocos de frete: ```Frete 1```, ```Frete 2```, ```Frete 3```. Cada um desses blocos possui um algoritmo próprio, apesar de pertencerem à mesma família de fretes.

O padrão *Strategy* **encapsula** cada uma das classes da família. Isso significa que as classes são independentes umas das outras e possuem as suas próprias lógicas.

Além disso, esse padrão torna as classes **intercambiáveis**. Seguindo o nosso exemplo, podemos imaginar que um cliente não se importa com qual dos 3 fretes o sistema irá utilizar: para ele, basta que o frete seja utilizado. Esse padrão garante que o cliente que utiliza a classe possa utilizar qualquer uma das 3 classes. 

Por fim, esse padrão permite que tanto as classes quanto o cliente mude sem que a comunicação entre eles sofra impacto.

## Na prática:
Imagine que estamos utilizando um sistema de ecommerce que possui 2 fretes: o comum e o expresso. Uma opção de implementação é criar uma classe ```Pedido``` com 2 métodos, cada um para um tipo de frete.

Agora, imagina que nosso ecommerce cresça e passamos a ter pedidos divididos por departamentos, onde cada tipo de pedido é diferente um do outro. Veja que nossa classe anterior não mais se aplica nesse caso e, para não termos que criar uma classe de pedido totalmente diferente para cada departamento, podemos criar uma classe abstrata de pedido com funcionalidades em comum e, para cada departamento, criar uma classe de pedido que estenda a nossa nova classe.

Novamente, imagina que nossa regra de negócio mudou e que o frete expresso não se aplica mais ao departamento de eletrônicos. Agora, temos um problema: PedidoEletronicos estende Pedido e, portanto, implementa o método de frete expresso. Para resolver esse problema, poderíamos tornar os métodos da classe Pedido abstratos e deixar a implementação para as classes filhas. Dessa forma, a classe de pedidos de eletronicos poderia lançar uma exceção ao calcular o frete expresso. No entanto, essa solução introduz duplicação no código, uma vez que o método de calcular frete comum seria duplicado em ambos os filhos.