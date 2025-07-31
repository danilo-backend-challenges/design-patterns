package strategy.exemploDescontos.depois.domain;

import java.util.ArrayList;
import java.util.List;

public class Compra {
    private List<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public double  getValorTotal() {
        return produtos.stream().mapToDouble(Produto::getPreco).sum();
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
