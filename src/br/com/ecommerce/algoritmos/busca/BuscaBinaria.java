package br.com.ecommerce.algoritmos.busca;

import br.com.ecommerce.model.Produto;
import java.util.ArrayList;

public class BuscaBinaria {
    public static Produto buscar(ArrayList<Produto> listaOrdenadaPorCodigo, int codigoBuscado) {
        int esquerda = 0;
        int direita = listaOrdenadaPorCodigo.size() - 1;

        while (esquerda <= direita) {
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
        return null;
    }
}
