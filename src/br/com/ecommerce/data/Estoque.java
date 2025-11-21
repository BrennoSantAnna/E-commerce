package br.com.ecommerce.data;

import br.com.ecommerce.algoritmos.busca.BuscaBinaria;
import br.com.ecommerce.algoritmos.ordenacao.*;
import br.com.ecommerce.model.Produto;
import java.util.ArrayList;

/**
 * Controlador de Dados
 * Responsável por gerenciar a lista em memória e integrar os algoritmos de ordenação e busca
 */
public class Estoque {
    private ArrayList<Produto> listaDeProdutos;

    public Estoque() {
        this.listaDeProdutos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        // 1. Validação de integridade
        if (existeProdutoComCodigo(produto.getCodigo())) {
            System.out.println("ERRO: Já existe um produto cadastrado com o código " + produto.getCodigo() + ".");
            System.out.println("Operação cancelada para manter a integridade do estoque.");
            return; // Interrompe o método aqui. O produto NÃO é adicionado.
        }
        // 2. Se passou na validação, adiciona.
        this.listaDeProdutos.add(produto);
        System.out.println("Produto '" + produto.getNome() + "' adicionado ao estoque!");
    }

    private boolean existeProdutoComCodigo(int codigo) {
        for (Produto p : this.listaDeProdutos) {
            if (p.getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }

    public void removerProduto(int codigoParaRemover) {
        Produto produtoParaRemover = null;
        // Busca linear simples para remoção
        for (Produto p : this.listaDeProdutos) {
            if (p.getCodigo() == codigoParaRemover) {
                produtoParaRemover = p;
                break;
            }
        }
        if (produtoParaRemover != null) {
            this.listaDeProdutos.remove(produtoParaRemover);
            System.out.println("Sucesso: Produto '" + produtoParaRemover.getNome() + "' removido.");
        } else {
            System.out.println("Erro: Produto com código " + codigoParaRemover + " não encontrado.");
        }
    }

    /**
     * Implementa a Busca Binária integrando a ordenação prévia
     * Cria uma cópia da lista para não alterar a ordem original de cadastro dos produtos
     */
    public Produto buscarProdutoPorCodigoBuscaBinaria(int codigoBuscado) {
        ArrayList<Produto> listaCopiada = new ArrayList<>(this.listaDeProdutos);
        MergeSort.ordenarPorCodigo(listaCopiada);
        return BuscaBinaria.buscar(listaCopiada, codigoBuscado);
    }

    // Busca Linear, usada para comparações parciais de texto
    public ArrayList<Produto> buscarPorNome(String nomeBuscado) {
        ArrayList<Produto> listaDeResultados = new ArrayList<>();
        for (Produto p : this.listaDeProdutos) {
            if (p.getNome().toLowerCase().contains(nomeBuscado.toLowerCase())) {
                listaDeResultados.add(p);
            }
        }
        return listaDeResultados;
    }

    public ArrayList<Produto> buscarPorCategoria(String categoria) {
        ArrayList<Produto> resultado = new ArrayList<>();
        for (Produto p : listaDeProdutos) {
            if (p.getCategoria().equalsIgnoreCase(categoria)) resultado.add(p);
        }
        return resultado;
    }

    // --- Métodos de listagem com ordenação ---
    // Nota: Todos criam cópias da lista para preservar a integridade dos dados originais
    public void listarTodosOsProdutos() {
        if (verificarEstoqueVazio()) return;
        exibirLista(this.listaDeProdutos, "Ordem de Cadastro");
    }

    public void listarProdutosOrdenadosPorPreco() {
        if (verificarEstoqueVazio()) return;
        ArrayList<Produto> listaCopiada = new ArrayList<>(this.listaDeProdutos);
        BubbleSort.ordenarPorPreco(listaCopiada);
        exibirLista(listaCopiada, "Preço");
    }

    public void listarProdutosOrdenadosPorQuantidade() {
        if (verificarEstoqueVazio()) return;
        ArrayList<Produto> listaCopiada = new ArrayList<>(this.listaDeProdutos);
        SelectionSort.ordenarPorQuantidade(listaCopiada);
        exibirLista(listaCopiada, "Quantidade");
    }

    public void listarProdutosOrdenadosPorAvaliacao() {
        if (verificarEstoqueVazio()) return;
        ArrayList<Produto> listaCopiada = new ArrayList<>(this.listaDeProdutos);
        InsertionSort.ordenarPorAvaliacao(listaCopiada);
        exibirLista(listaCopiada, "Avaliação");
    }

    public void listarProdutosOrdenadosPorNome() {
        if (verificarEstoqueVazio()) return;
        ArrayList<Produto> listaCopiada = new ArrayList<>(this.listaDeProdutos);
        MergeSort.ordenarPorNome(listaCopiada);
        exibirLista(listaCopiada, "Nome (Alfabética)");
    }

    // Helper method para evitar repetição de código
    private boolean verificarEstoqueVazio() {
        if (this.listaDeProdutos.isEmpty()) {
            System.out.println("O estoque está vazio. Nada para ordenar.");
            return true;
        }
        return false;
    }

    private void exibirLista(ArrayList<Produto> lista, String criterio) {
        System.out.println("\n--- Lista de Produtos (Ordenada por " + criterio + ") ---");
        for (Produto p : lista) {
            System.out.println(p);
        }
        System.out.println("------------------------------------------------------------------------------------------------");
    }
    public ArrayList<Produto> getListaDeProdutos() { return this.listaDeProdutos; }
}
