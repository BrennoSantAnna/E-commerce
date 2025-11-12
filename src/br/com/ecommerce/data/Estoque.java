package br.com.ecommerce.data;

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
