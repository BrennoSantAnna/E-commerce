package br.com.ecommerce.algoritmos.ordenacao;

import br.com.ecommerce.model.Produto;
import java.util.ArrayList;

public class BubbleSort {
    public static void ordenarPorPreco(ArrayList<Produto> lista) {
        if (lista == null || lista.size() < 2) {
            return;
        }

        int n = lista.size();

        for (int i = 0; i < n - 1; i++) {
            boolean trocou = false;

            for (int j = 0; j < n - 1 - i; j++) {
                Produto prod1 = lista.get(j);
                Produto prod2 = lista.get(j + 1);

                if (prod1.getPreco() > prod2.getPreco()) {
                    lista.set(j, prod2);
                    lista.set(j + 1, prod1);
                    trocou = true;
                }
            }

            if (!trocou) {
                break;
            }
        }
    }
}
