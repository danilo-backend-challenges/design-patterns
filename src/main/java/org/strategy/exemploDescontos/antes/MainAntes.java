/**
 * Os Problemas Desta Abordagem
1. Violação do Princípio Aberto/Fechado: Se o time de marketing inventar o "Desconto de Black Friday"
   (que dá 25% de desconto), você teria que modificar a classe CarrinhoDeCompras, adicionando um novo
    else if. O ideal seria apenas adicionar uma nova classe DescontoBlackFriday sem tocar no código existente.

2. Baixa Coesão: A classe CarrinhoDeCompras tem muitas responsabilidades. Ela gerencia a compra e também conhece a fundo
   todas as regras de desconto existentes. A lógica de desconto deveria ser uma responsabilidade separada.

3. Dificuldade para Testar: Para testar a lógica do desconto de cupom, você precisa criar uma Compra, Produtos, e um
   CarrinhoDeCompras inteiro. Seria muito mais fácil se você pudesse testar a classe DescontoCupom de forma isolada.

4. Complexidade Crescente: Com apenas 3 tipos de desconto, o método já está grande. Imagine com 10 ou 15. Ele se tornaria
   um "monstro" de if-else, difícil de ler e de manter.

 Este código funcional, porém rígido, é o ponto de partida perfeito para a refatoração proposta no desafio, onde cada if
 se tornará uma classe Strategy independente.
 */

package org.strategy.exemploDescontos.antes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// --- Classes de Modelo (iguais ao desafio) ---

class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }
}

class Compra {
    private List<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
    }

    public double getValorTotal() {
        return this.produtos.stream().mapToDouble(Produto::getPreco).sum();
    }
}


// --- Classe Central com a Lógica Problemática ---

class CarrinhoDeCompras {

    private Compra compra;

    // Um mapa de cupons hardcoded dentro da classe
    private static final Map<String, Double> CUPONS_VALIDOS = Map.of(
            "GAMER15", 15.0,
            "NATAL50", 50.0
    );

    public CarrinhoDeCompras(Compra compra) {
        this.compra = compra;
    }

    /**
     * Este é o método problemático. Ele precisa saber sobre todos os tipos de desconto.
     * @param tipoDesconto Uma String que define a lógica a ser usada.
     * @param valor O valor para o desconto (percentual, valor fixo ou código do cupom).
     * @return O preço final após o desconto.
     */
    public double calcularPrecoFinal(String tipoDesconto, Object valor) {
        double valorTotal = compra.getValorTotal();
        double descontoCalculado = 0.0;

        // O bloco if-else-if que se tornará um problema para manter.
        if ("PERCENTUAL".equalsIgnoreCase(tipoDesconto)) {
            double percentual = (double) valor;
            descontoCalculado = valorTotal * (percentual / 100.0);
            System.out.println("Aplicando desconto PERCENTUAL de " + percentual + "%");

        } else if ("FIXO".equalsIgnoreCase(tipoDesconto)) {
            descontoCalculado = (double) valor;
             System.out.println("Aplicando desconto FIXO de R$" + descontoCalculado);
             // Regra de negócio: o desconto não pode ser maior que o valor total
            if (descontoCalculado > valorTotal) {
                descontoCalculado = valorTotal;
            }

        } else if ("CUPOM".equalsIgnoreCase(tipoDesconto)) {
            String cupom = (String) valor;
            System.out.println("Tentando aplicar o CUPOM '" + cupom + "'");
            // Lógica do cupom está toda aqui dentro
            if (CUPONS_VALIDOS.containsKey(cupom)) {
                descontoCalculado = CUPONS_VALIDOS.get(cupom);
            } else {
                 System.out.println("Cupom inválido!");
                descontoCalculado = 0.0;
            }

        } else {
            System.out.println("Nenhum desconto aplicado.");
            // Se o tipo for nulo ou desconhecido, não há desconto.
        }

        return valorTotal - descontoCalculado;
    }
}


// --- Classe org.Main para Demonstrar o Uso ---
public class MainAntes {
    public static void main(String[] args) {
        Produto mouseGamer = new Produto("Mouse Gamer RGB", 350.00);
        Produto tecladoMecanico = new Produto("Teclado Mecânico", 550.00);

        Compra compra = new Compra();
        compra.adicionarProduto(mouseGamer);
        compra.adicionarProduto(tecladoMecanico);

        CarrinhoDeCompras carrinho = new CarrinhoDeCompras(compra);

        System.out.println("Valor total da compra: R$" + compra.getValorTotal());
        System.out.println("==============================================");

        // Cenário 1: Desconto de 10%
        double precoFinal1 = carrinho.calcularPrecoFinal("PERCENTUAL", 10.0);
        System.out.println("Preço final: R$" + precoFinal1);
        System.out.println("----------------------------------------------");

        // Cenário 2: Desconto fixo de R$100
        double precoFinal2 = carrinho.calcularPrecoFinal("FIXO", 100.0);
        System.out.println("Preço final: R$" + precoFinal2);
        System.out.println("----------------------------------------------");

        // Cenário 3: Cupom Válido
        double precoFinal3 = carrinho.calcularPrecoFinal("CUPOM", "GAMER15");
        System.out.println("Preço final: R$" + precoFinal3);
        System.out.println("----------------------------------------------");

        // Cenário 4: Cupom Inválido
        double precoFinal4 = carrinho.calcularPrecoFinal("CUPOM", "CUPOMINVALIDO");
        System.out.println("Preço final: R$" + precoFinal4);
    }
}
