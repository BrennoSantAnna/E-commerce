package br.com.ecommerce.view;

import br.com.ecommerce.model.Produto;
import br.com.ecommerce.data.Estoque;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe responsável pela interação com o usuário
 * Gerencia inputs e chama os métodos do controlador (estoque)
 */
public class MenuConsole {
    private Estoque estoque;
    private Scanner scanner;

    public MenuConsole() {
        this.estoque = new Estoque();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcao;
        // Loop infinito para manter o menu ativo até o usuário decidir sair
        while (true) {
            exibirMenu();
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                // Tratamento de erro para evitar crash se o usuário digitar letras
                System.out.println("Erro: Por gentileza, informe um número válido.");
                opcao = -1;
            }
            processarOpcao(opcao);
        }
    }

    private void exibirMenu() {
        System.out.println("\n=== SISTEMA DE CONTROLE DE ESTOQUE ===");
        System.out.println("1. Adicionar produto | 2. Remover produto | 3. Busca Binária (Código)");
        System.out.println("4. Busca Nome | 5. Busca Categoria | 6. Listar Todos os Produtos");
        System.out.println("=== ORDENAÇÕES ===");
        System.out.println("7. Preço | 8. Quantidade | 9. Avaliação | 10. Nome");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private void processarOpcao(int opcao) {
        switch (opcao) {
            case 1: adicionarProduto(); break;
            case 2: removerProduto(); break;
            case 3: buscarPorCodigo(); break;
            case 4: buscarPorNome(); break;
            case 5: buscarPorCategoria(); break;
            case 6: estoque.listarTodosOsProdutos(); break;
            case 7: estoque.listarProdutosOrdenadosPorPreco(); break;
            case 8: estoque.listarProdutosOrdenadosPorQuantidade(); break;
            case 9: estoque.listarProdutosOrdenadosPorAvaliacao(); break;
            case 10: estoque.listarProdutosOrdenadosPorNome(); break;
            case 0:
                System.out.println("Saindo do sistema... Até logo!");
                scanner.close();
                System.exit(0);
                break;
            default:
                if (opcao != -1) System.out.println("Opção inválida. Tente novamente.");
        }
        System.out.print("\nPressione Enter para continuar...");
        scanner.nextLine();
    }

    private void adicionarProduto() {
        System.out.println("\n--- Adicionar novo produto ---");
        try {
            // Conversão explícita de tipos para garantir a integridade do modelo
            System.out.print("Digite o Código (número): ");
            int codigo = Integer.parseInt(scanner.nextLine());

            System.out.print("Digite o Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Digite a Categoria: ");
            String categoria = scanner.nextLine();

            System.out.print("Digite a Quantidade (número): ");
            int quantidade = Integer.parseInt(scanner.nextLine());

            System.out.print("Digite o Preço (ex: 59.90): ");
            double preco = Double.parseDouble(scanner.nextLine());

            System.out.print("Digite a Avaliação (ex: 4.5): ");
            double avaliacao = Double.parseDouble(scanner.nextLine());

            Produto p = new Produto(codigo, nome, categoria, quantidade, preco, avaliacao);
            estoque.adicionarProduto(p);

        } catch (NumberFormatException e) {
            System.out.println("Erro de entrada: Certifique-se de usar ponto (.) para decimais e apenas números onde solicitado.");
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }

    private void removerProduto() {
        System.out.print("Digite o Código para remover: ");
        try {
            estoque.removerProduto(Integer.parseInt(scanner.nextLine()));
        } catch (NumberFormatException e) { System.out.println("Erro: Código inválido"); }
    }

    private void buscarPorCodigo() {
        System.out.print("Digite o Código: ");
        try {
            int codigo = Integer.parseInt(scanner.nextLine());
            Produto p = estoque.buscarProdutoPorCodigoBuscaBinaria(codigo);
            System.out.println(p != null ? "Encontrado: " + p : "Não encontrado.");
        } catch (NumberFormatException e) { System.out.println("Erro: O código deve ser um número"); }
    }

    private void buscarPorNome() {
        System.out.print("Nome: ");
        listarResultado(estoque.buscarPorNome(scanner.nextLine()));
    }

    private void buscarPorCategoria() {
        System.out.print("Categoria: ");
        listarResultado(estoque.buscarPorCategoria(scanner.nextLine()));
    }

    private void listarResultado(ArrayList<Produto> lista) {
        if (lista.isEmpty()) System.out.println("Nenhum registro encontrado.");
        else for (Produto p : lista) System.out.println(p);
    }
}
