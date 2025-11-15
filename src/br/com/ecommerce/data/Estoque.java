package br.com.ecommerce.data;

import br.com.ecommerce.algoritmos.busca.BuscaBinaria;
import br.com.ecommerce.algoritmos.ordenacao.*;
import br.com.ecommerce.algoritmos.ordenacao.*;
import br.com.ecommerce.model.Produto;
import java.util.ArrayList;

public class Estoque {
    private ArrayList<Produto> listaDeProdutos;

    public Estoque() {
        this.listaDeProdutos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        this.listaDeProdutos.add(produto);
        System.out.println("Produto '" + produto.getNome() + "' adicionado ao estoque!");
    }

    public void removerProduto(int codigoParaRemover) {
        Produto produtoParaRemover = null;

        for (Produto p : this.listaDeProdutos) {
            if (p.getCodigo() == codigoParaRemover) {
                produtoParaRemover = p;
                break;
            }
        }

        if (produtoParaRemover != null) {
            this.listaDeProdutos.remove(produtoParaRemover);
            System.out.println("Produto removido: " + produtoParaRemover.getNome());
        } else {
            System.out.println("Produto com código " + codigoParaRemover + " não encontrado no estoque.");
        }
    }

    public Produto buscarProdutoPorCodigo(int codigo) {
        for (Produto p : this.listaDeProdutos) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }

    public Produto buscarProdutoPorCodigoBuscaBinaria(int codigoBuscado) {
        ArrayList<Produto> listaCopiada = new ArrayList<>(this.listaDeProdutos);
        MergeSort.ordenarPorCodigo(listaCopiada);
        Produto resultado = BuscaBinaria.buscar(listaCopiada, codigoBuscado);
        return resultado;
    }

    public ArrayList<Produto> buscarPorCategoria(String categoriaBuscada) {
        ArrayList<Produto> listaDeResultados = new ArrayList<>();

        for (Produto p : this.listaDeProdutos) {
            if (p.getCategoria().equals(categoriaBuscada)) {
                listaDeResultados.add(p);
            }
        }
        return listaDeResultados;
    }

    public ArrayList<Produto> buscarPorNome(String nomeBuscado) {
        ArrayList<Produto> listaDeResultados = new ArrayList<>();

        for (Produto p : this.listaDeProdutos) {
            if (p.getNome().toLowerCase().contains(nomeBuscado.toLowerCase())) {
                listaDeResultados.add(p);
            }
        }

        return listaDeResultados;
    }

    public void listarProdutosOrdenadosPorPreco() {
        if (this.listaDeProdutos.isEmpty()) {
            System.out.println("O estoque está vazio. Nada para ordenar.");
            return;
        }
        ArrayList<Produto> listaCopiada = new ArrayList<>(this.listaDeProdutos);
        BubbleSort.ordenarPorPreco(listaCopiada);

        System.out.println("\n--- Lista de Produtos (Ordenada por preço) ---");
        for (Produto p : listaCopiada) {
            System.out.println(p);
        }
        System.out.println("------------------------------------------------------------------------------------------------");
    }

        public void listarProdutosOrdenadosPorQuantidade() {
            if (this.listaDeProdutos.isEmpty()) {
                System.out.println("O estoque está vazio. Nada para ordenar.");
                return;
            }

        ArrayList<Produto> listaCopiada = new ArrayList<>(this.listaDeProdutos);
        SelectionSort.ordenarPorQuantidade(listaCopiada);

        System.out.println("\n--- Lista de Produtos (Ordenada por quantidade) ---");
        for (Produto p : listaCopiada) {
            System.out.println(p);
        }
        System.out.println("------------------------------------------------------------------------------------------------");
    }

    public void listarProdutosOrdenadosPorAvaliacao() {
        if (this.listaDeProdutos.isEmpty()) {
            System.out.println("O estoque está vazio. Nada para ordenar.");
            return;
        }

        ArrayList<Produto> listaCopiada = new ArrayList<>(this.listaDeProdutos);
        InsertionSort.ordenarPorAvaliacao(listaCopiada);

        System.out.println("\n--- Lista de produtos (ordenada por avaliação) ---");
        for (Produto p : listaCopiada) {
            System.out.println(p);
        }
        System.out.println("------------------------------------------------------------------------------------------------");
    }

    public void listarProdutosOrdenadosPorNome() {
        if (this.listaDeProdutos.isEmpty()) {
            System.out.println("O estoque está vazio. Nada para ordenar.");
            return;
        }

        ArrayList<Produto> listaCopiada = new ArrayList<>(this.listaDeProdutos);
        MergeSort.ordenarPorNome(listaCopiada);

        System.out.println("\n--- Lista de produtos (Ordenada por nome alfabetica) ---");
        for (Produto p : listaCopiada) {
            System.out.println(p);
        }
        System.out.println("------------------------------------------------------------------------------------------------");
    }

    public ArrayList<Produto> getListaDeProdutos() {
        return this.listaDeProdutos;
    }

    public void listarTodosOsProdutos() {
        System.out.println("\n--- Lista de Produtos no Estoque ---");

        if (this.listaDeProdutos.isEmpty()) {
            System.out.println("O estoque está vazio.");
            return;
        }

        for (Produto p : this.listaDeProdutos) {
            System.out.println(p);
        }
        System.out.println("------------------------------------------------------------------------------------------------");
    }
}
