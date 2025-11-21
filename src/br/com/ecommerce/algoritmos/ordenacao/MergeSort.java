package br.com.ecommerce.algoritmos.ordenacao;

import br.com.ecommerce.model.Produto;
import java.util.ArrayList;

/**
 * Implementação do algoritmo MergeSort para odenação eficiente
 * Complexidade de tempo: O(n log n) em todos os casos (pior, médio e melhor)
 * Estratégia: Dividir para Conquistar (Divide and Conquer)
 */
public class MergeSort {

    /**
     * Ponto de entrada para ordenar a lista por Nome
     * Verifica se a lista precisa de ordenação antes de iniciar a recursão
     */
    public static void ordenarPorNome(ArrayList<Produto> lista) {
        // Cláusula de guarda: Listas vazias ou com 1 elemento já estão ordenadas
        if (lista == null || lista.size() < 2) {
            return;
        }
        mergeSortPorNome(lista, 0, lista.size() - 1);
    }

    /**
     * Método recursivo que divide a lista em sub-listas menores.
     */
    private static void mergeSortPorNome(ArrayList<Produto> lista, int esquerda, int direita) {
        if (esquerda < direita) {
            // Encontra o ponto médio para dividir a lista em duas metades
            int meio = (esquerda + direita) / 2;

            // Passo 1: Dividir (chamadas recursivas)
            mergeSortPorNome(lista, esquerda, meio);                // Metade da esquerda
            mergeSortPorNome(lista, meio + 1, direita);    // Metade da direita

            // Passo 2: Conquistar (mesclar as metades ordenadas)
            mergePorNome(lista, esquerda, meio, direita);
        }
    }

    /**
     * Mescla duas sub-listas ordenadas em uma única lista ordenada
     */
    private static void mergePorNome(ArrayList<Produto> lista, int esquerda, int meio, int direita) {
        // Tamanhos das duas sub-listas temporárias
        int n1 = meio - esquerda + 1;
        int n2 = direita - meio;

        // Criação de arrays temporários para evitar sobrescrita de dados durante a mesclagem
        ArrayList<Produto> listaEsquerda = new ArrayList<>(n1);
        ArrayList<Produto> listaDireita = new ArrayList<>(n2);

        // Copiando dados para os arrays temporários
        for (int i = 0; i < n1; i++) listaEsquerda.add(lista.get(esquerda + i));
        for (int j = 0; j < n2; j++) listaDireita.add(lista.get(meio + 1 + j));

        // Índices iniciais das sub-listas e da lista principal (k)
        int i = 0, j = 0, k = esquerda;

        // Comparação e inserção ordenada na lista principal
        while (i < n1 && j < n2) {
            // CompareTo <= 0 significa que o nome da esquerda vem antes ou é igual (alfabeticamente)
            if (listaEsquerda.get(i).getNome().compareTo(listaDireita.get(j).getNome()) <= 0) {
                lista.set(k, listaEsquerda.get(i));
                i++;
            } else {
                lista.set(k, listaDireita.get(j));
                j++;
            }
            k++;
        }
        // Copia os elementos restantes da esquerda, se houver
        while (i < n1) { lista.set(k++, listaEsquerda.get(i++)); }
        // Copia os elementos restantes da direita, se houver
        while (j < n2) { lista.set(k++, listaDireita.get(j++)); }
    }

    // -- Lógica análoga para ordenação por código (Usada para Busca Binária)
    public static void ordenarPorCodigo(ArrayList<Produto> lista) {
        if (lista == null || lista.size() < 2) {
            return;
        }
        mergeSortPorCodigo(lista, 0, lista.size() - 1);
    }

    private static void mergeSortPorCodigo(ArrayList<Produto> lista, int esquerda, int direita) {
        if (esquerda < direita) {
            int meio = (esquerda + direita) / 2;
            mergeSortPorCodigo(lista, esquerda, meio);
            mergeSortPorCodigo(lista, meio + 1, direita);
            mergePorCodigo(lista, esquerda, meio, direita);
        }
    }

    private static void mergePorCodigo(ArrayList<Produto> lista, int esquerda, int meio, int direita) {
        int n1 = meio - esquerda + 1;
        int n2 = direita - meio;

        ArrayList<Produto> listaEsquerda = new ArrayList<>(n1);
        ArrayList<Produto> listaDireita = new ArrayList<>(n2);

        for (int i = 0; i < n1; i++) listaEsquerda.add(lista.get(esquerda + i));
        for (int j = 0; j < n2; j++) listaDireita.add(lista.get(meio + 1 + j));

        int i = 0, j = 0, k = esquerda;

        while (i < n1 && j < n2) {
            if (listaEsquerda.get(i).getCodigo() <= listaDireita.get(j).getCodigo()) {
                lista.set(k, listaEsquerda.get(i));
                i++;
            } else {
                lista.set(k, listaDireita.get(j));
                j++;
            }
            k++;
        }
        while (i < n1) { lista.set(k++, listaEsquerda.get(i++)); }
        while (j < n2) { lista.set(k++, listaDireita.get(j++)); }
    }
}
