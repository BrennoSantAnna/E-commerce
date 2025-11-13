package br.com.ecommerce.main;

import br.com.ecommerce.algoritmos.ordenacao.BubbleSort;
import br.com.ecommerce.model.Produto;
import br.com.ecommerce.data.Estoque;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Produto p1 = new Produto(1, "Notebook", "Eletronicos", 10, 3599.00, 4.6);
        Produto p2 = new Produto(2, "Mouse", "Eletronicos", 15, 247.00, 4.1);
        Produto p3 = new Produto(3, "Monitor", "Eletronicos", 5, 1599.00, 4.9);
        Produto p4 = new Produto(4, "Perfume", "Beleza", 30, 85.00, 3.7);
        Produto p5 = new Produto(5, "Banana", "Frutas", 20, 2.99, 3.9);

        Estoque estoque = new Estoque();
        estoque.adicionarProduto(p1);
        estoque.adicionarProduto(p2);
        estoque.adicionarProduto(p3);
        estoque.adicionarProduto(p4);
        estoque.adicionarProduto(p5);

        System.out.println("\n--- Teste de ordenação ---");
        System.out.println("\n*** Lista original (Ordem de cadastro) ***");
        estoque.listarTodosOsProdutos();

        System.out.println("\n*** Lista ordenada por preço (Bubble sort) ***");
        estoque.listarProdutosOrdenadosPorPreco();

        System.out.println("\n*** Lista original (verificando integridade) ***");
        estoque.listarTodosOsProdutos();
    }
}
