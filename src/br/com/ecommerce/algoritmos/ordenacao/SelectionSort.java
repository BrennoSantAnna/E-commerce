package br.com.ecommerce.algoritmos.ordenacao;

import br.com.ecommerce.model.Produto;
import java.util.ArrayList;

public class SelectionSort {
    public static void ordenarPorQuantidade(ArrayList<Produto> lista) {
        if (lista == null || lista.size() < 2) {
            return;
        }

        int n = lista.size();

        for (int i = 0; i < n - 1; i++) {
            int indiceDoMenor = i;

            for (int j = i + 1; j < n; j++) {
                if (lista.get(j).getQuantidade() < lista.get(indiceDoMenor).getQuantidade()) {
                    indiceDoMenor = j;
                }
            }

            if (indiceDoMenor != i) {
                Produto temp = lista.get(indiceDoMenor);
                lista.set(indiceDoMenor, lista.get(i));
                lista.set(i, temp);
            }
        }
    }
}
