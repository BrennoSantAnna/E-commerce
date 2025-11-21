package br.com.ecommerce.algoritmos.busca;

import br.com.ecommerce.model.Produto;
import java.util.ArrayList;

/**
 * Implementação da Busca Binária
 * Complexidade de tempo: O(log n)
 * IMPORTANTE: Este algoritmo pressupõe que a lista já esteja ORDENADA pelo critério de busca
 */
public class BuscaBinaria {

    /**
     * Realiza a busca de um produto pelo código
     * @param listaOrdenadaPorCodigo A lista deve estar previamente ordenada por código
     * @param codigoBuscado O inteiro do código a ser encontrado
     * @return O objeto Produto se encontrado, ou null caso contrário
     */
    public static Produto buscar(ArrayList<Produto> listaOrdenadaPorCodigo, int codigoBuscado) {
        int esquerda = 0;
        int direita = listaOrdenadaPorCodigo.size() - 1;

        while (esquerda <= direita) {
            // Evita overflow ded inteiros em listas gigantes
            int meio = esquerda + (direita - esquerda) / 2;

            Produto produtoDoMeio = listaOrdenadaPorCodigo.get(meio);
            int codigoDoMeio = produtoDoMeio.getCodigo();

            if (codigoDoMeio == codigoBuscado) {
                return produtoDoMeio;
            }

            if (codigoBuscado < codigoDoMeio) {
                direita = meio - 1;
            } else {
                esquerda = meio + 1;
            }
        }
        return null; // Elemento não existe na lista
    }
}
