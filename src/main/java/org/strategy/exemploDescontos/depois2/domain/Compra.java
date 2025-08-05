package org.strategy.exemploDescontos.depois2.domain;

import java.util.ArrayList;
import java.util.List;

public class Compra {
    private List<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
    }

    public double getValorTotal() {
        return this.produtos.stream().mapToDouble(Produto::getPreco).sum();
    }
}
