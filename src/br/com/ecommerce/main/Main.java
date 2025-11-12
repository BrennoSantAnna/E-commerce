package br.com.ecommerce.main;

import br.com.ecommerce.model.Produto;
import br.com.ecommerce.data.Estoque;

public class Main {
    public static void main(String[] args) {
        Produto p1 = new Produto(1, "Notebook", "Eletronicos", 10, 3599.00, 4.6);
        Produto p2 = new Produto(2, "Mouse", "Eletronicos", 15, 247.00, 4.1);
        Produto p3 = new Produto(3, "Monitor", "Eletronicos", 5, 1599.00, 4.9);

        Estoque estoque = new Estoque();
        estoque.adicionarProduto(p1);
        estoque.adicionarProduto(p2);
        estoque.adicionarProduto(p3);
        estoque.listarTodosOsProdutos();
        estoque.removerProduto(2);
        estoque.listarTodosOsProdutos();
    }
}
