package br.com.ecommerce.algoritmos.ordenacao;

import br.com.ecommerce.model.Produto;
import java.util.ArrayList;

public class MergeSort {
    public static void ordenarPorNome(ArrayList<Produto> lista) {
        if (lista == null || lista.size() < 2) {
            return;
        }
        mergeSortPorNome(lista, 0, lista.size() - 1);
    }

    private static void mergeSortPorNome(ArrayList<Produto> lista, int esquerda, int direita) {
        if (esquerda < direita) {
            int meio = (esquerda + direita) / 2;
            mergeSortPorNome(lista, esquerda, meio);
            mergeSortPorNome(lista, meio + 1, direita);
            mergePorNome(lista, esquerda, meio, direita);
        }
    }

    private static void mergePorNome(ArrayList<Produto> lista, int esquerda, int meio, int direita) {
        int n1 = meio - esquerda + 1;
        int n2 = direita - meio;

        ArrayList<Produto> listaEsquerda = new ArrayList<>(n1);
        ArrayList<Produto> listaDireita = new ArrayList<>(n2);

        for (int i = 0; i < n1; i++) listaEsquerda.add(lista.get(esquerda + i));
        for (int j = 0; j < n2; j++) listaDireita.add(lista.get(meio + 1 + j));

        int i = 0, j = 0, k = esquerda;

        while (i < n1 && j < n2) {
            if (listaEsquerda.get(i).getNome().compareTo(listaDireita.get(j).getNome()) <= 0) {
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
