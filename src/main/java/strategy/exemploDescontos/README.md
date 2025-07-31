### **Desafio de Design Pattern: Sistema de Descontos para E-commerce**

#### O Cenário

Você é o(a) desenvolvedor(a) principal de um novo sistema de e-commerce para a "GamerZone", uma loja online de produtos gamers. O time de marketing está muito criativo e planeja lançar novos tipos de promoções e descontos constantemente (Dia do Gamer, Black Friday, Cupom de Influenciador, etc.).

#### O Problema

Atualmente, o cálculo de desconto está dentro da classe `CarrinhoDeCompras` com um método cheio de `if-else` que verifica o tipo de promoção ativa. Toda vez que o marketing cria uma nova regra de desconto, um(a) desenvolvedor(a) precisa alterar essa classe, adicionar mais um `if` e reimplantar o sistema. Isso é lento, arriscado e viola o Princípio Aberto/Fechado (a classe deve ser aberta para extensão, mas fechada para modificação).

#### Seu Desafio

Sua missão é refatorar o sistema de cálculo de descontos, utilizando o padrão **Strategy**, para que a adição de novas regras de desconto seja fácil, rápida e não exija modificações no código central do carrinho de compras.

### Requisitos

#### 1. Classes de Modelo
Crie as classes básicas que representarão os dados do sistema:

- **`Produto.java`**: Deve ter pelo menos os atributos `nome` (String) e `preco` (double).
- **`Compra.java`**: Deve conter uma lista de `Produto` e um método `getValorTotal()` que calcula a soma dos preços de todos os produtos na lista.

#### 2. A Interface `Strategy`
Crie uma interface que definirá o contrato para todas as estratégias de desconto.

- **`EstrategiaDeDesconto.java`**: Deve ter um único método, como `double aplicarDesconto(Compra compra)`. Este método receberá uma `Compra` e retornará o valor **do desconto** a ser aplicado.

#### 3. Estratégias Concretas
Implemente pelo menos três tipos diferentes de estratégias de desconto.

- **`DescontoPercentual.java`**: Implementa `EstrategiaDeDesconto`. Deve receber um percentual no construtor (ex: 10 para 10%) e o método `aplicarDesconto` deve retornar o valor correspondente a esse percentual sobre o valor total da compra.
- **`DescontoValorFixo.java`**: Implementa `EstrategiaDeDesconto`. Deve receber um valor fixo no construtor (ex: 50.0 para R$ 50,00 de desconto). O método `aplicarDesconto` retorna esse valor, mas não pode ser maior que o valor total da compra (o desconto não pode negativar o total).
- **`DescontoCupom.java`**: Implementa `EstrategiaDeDesconto`. Esta é um pouco mais complexa. Ela deve receber um código de cupom no construtor. Internamente, ela deve ter um `Map` estático ou privado que associa códigos de cupom a valores de desconto (ex: "GAMER15" -> 15.0, "NATAL50" -> 50.0). O método `aplicarDesconto` verifica se o cupom recebido é válido e retorna o desconto correspondente.

#### 4. A Classe `Contexto`
Esta é a classe que usará as estratégias.

- **`CalculadoraDeDescontos.java`**:
  - Deve ter um método `setEstrategia(EstrategiaDeDesconto estrategia)`.
  - Deve ter um método `calcularValorComDesconto(Compra compra)` que:
    1. Chama o método `aplicarDesconto` da estratégia atual.
    2. Subtrai o valor do desconto do valor total da compra.
    3. Retorna o preço final.

---

### Como o Sistema Deve Funcionar (Exemplo de `main`)

Seu `main` deve demonstrar a flexibilidade do sistema, mostrando como é fácil trocar a estratégia de desconto e recalcular o valor final.

```java
public class Main {
    public static void main(String[] args) {
        // 1. Configuração inicial
        Produto mouseGamer = new Produto("Mouse Gamer RGB", 350.00);
        Produto tecladoMecanico = new Produto("Teclado Mecânico", 550.00);

        Compra compra = new Compra();
        compra.adicionarProduto(mouseGamer);
        compra.adicionarProduto(tecladoMecanico);

        System.out.println("Valor total da compra: R$" + compra.getValorTotal()); // Deve ser 900.0
        System.out.println("-------------------------------------");

        CalculadoraDeDescontos calculadora = new CalculadoraDeDescontos();

        // 2. Aplicando a primeira estratégia: Desconto de 10%
        calculadora.setEstrategia(new DescontoPercentual(10));
        double precoFinal1 = calculadora.calcularValorComDesconto(compra);
        System.out.println("Preço com 10% de desconto: R$" + precoFinal1); // Deve ser 810.0

        // 3. Trocando de estratégia: Desconto fixo de R$100
        calculadora.setEstrategia(new DescontoValorFixo(100));
        double precoFinal2 = calculadora.calcularValorComDesconto(compra);
        System.out.println("Preço com R$100 de desconto fixo: R$" + precoFinal2); // Deve ser 800.0

        // 4. Trocando de estratégia: Cupom inválido
        calculadora.setEstrategia(new DescontoCupom("CUPOMINVALIDO"));
        double precoFinal3 = calculadora.calcularValorComDesconto(compra);
        System.out.println("Preço com cupom inválido: R$" + precoFinal3); // Deve ser 900.0

        // 5. Trocando de estratégia: Cupom válido
        calculadora.setEstrategia(new DescontoCupom("GAMER15")); // Supondo que GAMER15 dá R$15 de desconto
        double precoFinal4 = calculadora.calcularValorComDesconto(compra);
        System.out.println("Preço com cupom GAMER15: R$" + precoFinal4); // Deve ser 885.0
    }
}
```

### Desafio Bônus

1.  **Sem Desconto:** Crie uma estratégia `SemDesconto` que implementa a interface mas sempre retorna `0.0` no método `aplicarDesconto`. Use-a como a estratégia padrão na `CalculadoraDeDescontos`.
2.  **Desconto Progressivo:** Crie uma `DescontoProgressivo` onde o percentual de desconto aumenta com o valor da compra (ex: 5% para compras até R\$500, 10% para compras acima de R\$500).
3.  **Refatorando com Lambdas:** Para as estratégias mais simples (como a `DescontoPercentual`), é possível usar lambdas e uma classe `Map` para registrar as estratégias, evitando a criação de múltiplas classes pequenas? Pesquise sobre como o padrão Strategy pode ser implementado de forma mais funcional.

Boa sorte e divirta-se codificando!