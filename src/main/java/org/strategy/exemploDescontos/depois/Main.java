package org.strategy.exemploDescontos.depois;

import org.strategy.exemploDescontos.depois.domain.Compra;
import org.strategy.exemploDescontos.depois.domain.Produto;
import org.strategy.exemploDescontos.depois.strategy.Cupom;
import org.strategy.exemploDescontos.depois.strategy.DescontoCupom;
import org.strategy.exemploDescontos.depois.strategy.DescontoFixo;
import org.strategy.exemploDescontos.depois.strategy.DescontoPercentual;

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
        double precoFinal1 = calculadora.calcular(compra);
        System.out.println("Preço com 10% de desconto: R$" + precoFinal1); // Deve ser 810.0

        // 3. Trocando de estratégia: Desconto fixo de R$100
        calculadora.setEstrategia(new DescontoFixo(100));
        double precoFinal2 = calculadora.calcular(compra);
        System.out.println("Preço com R$100 de desconto fixo: R$" + precoFinal2); // Deve ser 800.0

        // 4. Trocando de estratégia: Cupom válido
        calculadora.setEstrategia(new DescontoCupom(Cupom.GAMER15)); // Supondo que GAMER15 dá R$15 de desconto
        double precoFinal4 = calculadora.calcular(compra);
        System.out.println("Preço com cupom GAMER15: R$" + precoFinal4); // Deve ser 885.0
    }
}
