package org.strategy.exemploDescontos;

import org.strategy.exemploDescontos.depois2.descontos.Cupom;
import org.strategy.exemploDescontos.depois2.descontos.DescontoCupom;
import org.strategy.exemploDescontos.depois2.descontos.DescontoFixo;
import org.strategy.exemploDescontos.depois2.descontos.DescontoPercentual;
import org.strategy.exemploDescontos.depois2.domain.Produto;
import org.strategy.exemploDescontos.depois2.domain.Compra;

public class Main {
    public static void main(String[] args) {
        Produto produto1 = new Produto("Produto 1", 100);
        Produto produto2 = new Produto("Produto 2", 200);
        Produto produto3 = new Produto("Produto 3", 300);
        Produto produto4 = new Produto("Produto 4", 400);

        Compra compra1 = new Compra();
        compra1.adicionarProduto(produto1);
        compra1.adicionarProduto(produto2);
        CalculadoraDeDesconto calculadora1 = new CalculadoraDeDesconto(compra1, new DescontoCupom(Cupom.GAMER15));
        System.out.println("Valor com desconto CUPOM GAMER15: " + calculadora1.calcular());

        Compra compra2 = new Compra();
        compra2.adicionarProduto(produto2);
        compra2.adicionarProduto(produto3);
        CalculadoraDeDesconto calculadora2 = new CalculadoraDeDesconto(compra1, new DescontoFixo(100));
        System.out.println("Valor com desconto FIXO: " + calculadora2.calcular());

        Compra compra3 = new Compra();
        compra3.adicionarProduto(produto3);
        compra3.adicionarProduto(produto4);
        CalculadoraDeDesconto calculadora3 = new CalculadoraDeDesconto(compra1, new DescontoPercentual(20));
        System.out.println("Valor com desconto PERCENTUAL: " + calculadora3.calcular());
    }
}
