package org.template.exemploPagamento.depois;

public abstract class Pagamento {
    private double valor;
    private Gateway gateway;

    public Pagamento(double valor, Gateway gateway) {
        this.valor = valor;
        this.gateway = gateway;
    }

    // Esse é o template method (é isso que define o padrão. A jogada de extender a classe é herança (que não tem necessariamente a ver com o padrão)
    // Aqui ele utiliza métodos que ainda serão implementados (ou sobrescritos) pelas subclasses.
    // Dessa forma, realiza cobrança é diferente para cada subclasse, apesar de estar definida na classe pai.
    // Outro fato é que o Template Method causa uma inversão de dependência, pois quem chama os métodos da classe filha é a classe pai.
    // Veja que calcular desconto é um metodo implementado na classe filha.
    // Princípio de OOP: abstrações não podem depender de detalhes, e sim os detalhes depender das abstrações.
    protected boolean realizaCobranca() { return getGateway().cobrar(getValor() + calcularTaxa() - calcularDesconto()); }

    protected abstract double calcularDesconto();
    protected double calcularTaxa() { return 0; }

    public Gateway getGateway() { return gateway; }
    public double getValor() { return valor; }
}
