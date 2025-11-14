package br.com.ecommerce.algoritmos.ordenacao;

import br.com.ecommerce.model.Produto;
import java.util.ArrayList;

public class InsertionSort {
    public static void ordenarPorAvaliacao(ArrayList<Produto> lista) {
        if (lista == null || lista.size() < 2) {
            return;
        }

        int n = lista.size();

        for (int i = 1; i < n; i++) {
            Produto chave = lista.get(i);

            int j = i - 1;
            while (j >= 0 && lista.get(j).getAvaliacao() > chave.getAvaliacao()) {
                lista.set(j + 1, lista.get(j));
                j = j - 1;
            }
            lista.set(j + 1, chave);
        }
    }
}
