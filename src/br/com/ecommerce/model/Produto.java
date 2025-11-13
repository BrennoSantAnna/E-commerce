package br.com.ecommerce.model;

public class Produto {
    private int codigo;
    private String nome;
    private String categoria;
    private int quantidade;
    private double preco;
    private double avaliacao;

    public Produto(int codigo, String nome, String categoria, int quantidade, double preco, double avaliacao) {
        this.codigo = codigo;
        this.nome = nome;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.preco = preco;
        this.avaliacao = avaliacao;
    }

    public int getCodigo() {
        return codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome() {
        this.nome = nome;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria() {
        this.categoria = categoria;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade() {
        this.quantidade = quantidade;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco() {
        this.preco = preco;
    }
    public double getAvaliacao() {
        return avaliacao;
    }
    public void setAvaliacao() {
        this.avaliacao = avaliacao;
    }

    @Override
    public String toString() {
        return String.format(
                "Código: %d, Nome: '%s', Categoria: '%s', Qtd: %d, Preço: R$ %.2f, Avaliação: %.1f",
                codigo, nome, categoria, quantidade, preco, avaliacao
        );
    }
}
