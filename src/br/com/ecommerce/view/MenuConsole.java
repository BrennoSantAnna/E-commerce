package br.com.ecommerce.view;

import br.com.ecommerce.model.Produto;
import br.com.ecommerce.data.Estoque;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuConsole {
    private Estoque estoque;
    private Scanner scanner;

    public MenuConsole() {
        this.estoque = new Estoque();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcao;

        while (true) {
            exibirMenu();

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Erro: Por gentileza, informe um número válido.");
                opcao = -1;
            }
            processarOpcao(opcao);
        }
    }

    private void exibirMenu() {
        System.out.println("\n--- Sistema de Controle de Estoque ---");
        System.out.println("1. Adicionar produto");
        System.out.println("2. Remover produto (por código)");
        System.out.println("3. Buscar produto por Código (Busca Binária)");
        System.out.println("4. Buscar produto por Nome (Busca Linear)");
        System.out.println("5. Buscar produto por Categoria (Busca Linear)");
        System.out.println("6. Listar todos os produtos (Ordem de cadastro)");
        System.out.println("--- Listar ordenado por ---");
        System.out.println("7. Preço (BubbleSort)");
        System.out.println("8. Quantidade (SelectionSort)");
        System.out.println("9. Avaliação (InsertionSort)");
        System.out.println("10. Nome (MergeSort)");
        System.out.println("-----------------------------------------------");
        System.out.println("0. Sair do sistema");
        System.out.print("\nEscolha uma opção: ");
    }

    private void processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                adicionarProduto();
                break;
            case 2:
                removerProduto();
                break;
            case 3:
                buscarPorCodigo();
                break;
            case 4:
                buscarPorNome();
                break;
            case 5:
                buscarPorCategoria();
                break;
            case 6:
                estoque.listarTodosOsProdutos();
                break;
            case 7:
                estoque.listarProdutosOrdenadosPorPreco();
                break;
            case 8:
                estoque.listarProdutosOrdenadosPorQuantidade();
                break;
            case 9:
                estoque.listarProdutosOrdenadosPorAvaliacao();
                break;
            case 10:
                estoque.listarProdutosOrdenadosPorNome();
                break;
            case 0:
                System.out.println("Saindo do sistema... Até logo!");
                scanner.close();
                System.exit(0);
                break;
            default:
                if (opcao != -1) {
                    System.out.println("Opção inválida. Tente novamente.");
                }
                break;
        }
        System.out.print("\nPressione Enter para continuar...");
        scanner.nextLine();
    }

    private void adicionarProduto() {
        System.out.println("\n--- Adicionar novo produto ---");

        try {
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

            Produto novoProduto = new Produto(codigo, nome, categoria, quantidade, preco, avaliacao);

            estoque.adicionarProduto(novoProduto);

        } catch (NumberFormatException e) {
            System.out.println("Erro de entrada: Código, quantidade, preço e avaliação devem ser números válidos.");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao adicionar o produto: " + e.getMessage());
        }
    }

    private void removerProduto() {
        System.out.println("\n--- Remover produto ---");
        System.out.print("Digite o Código do produto a remover: ");

        try {
            int codigo = Integer.parseInt(scanner.nextLine());
            estoque.removerProduto(codigo);
        } catch (NumberFormatException e) {
            System.out.println("Erro: O código deve ser um número.");
        }
    }

    private void buscarPorCodigo() {
        System.out.println("\n--- Buscar por Código (Busca Binária) ---");
        System.out.print("Digite o Código do produto: ");

        try {
            int codigo = Integer.parseInt(scanner.nextLine());
            Produto resultado = estoque.buscarProdutoPorCodigoBuscaBinaria(codigo);

            if (resultado != null) {
                System.out.println("Produto encontrado: " + resultado);
            } else {
                System.out.println("Produto com código " + codigo + " não encontrado.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro: O código deve ser um número");
        }
    }

    private void buscarPorNome() {
        System.out.println("\n--- Buscar por Nome (Busca Linear) ---");
        System.out.print("Digite o Nome (ou parte) do produto: ");
        String nome = scanner.nextLine();

        ArrayList<Produto> resultados = estoque.buscarPorNome(nome);

        if (resultados.isEmpty()) {
            System.out.println("Nenhum produto encontrado com o nome '" + nome + "'.");
        } else {
            System.out.println("Produtos encontrados (" + resultados.size() + "):");
            for (Produto p : resultados) {
                System.out.println(p);
            }
        }
    }

    private void buscarPorCategoria() {
        System.out.println("\n--- Buscar por Categoria (Busca Linear) ---");
        System.out.print("Digite a Categoria do produto: ");
        String categoria = scanner.nextLine();

        ArrayList<Produto> resultados = estoque.buscarPorCategoria(categoria);

        if (resultados.isEmpty()) {
            System.out.println("Nenhum produto encontrado na categoria '" + categoria + "'.");
        } else {
            System.out.println("Produtos encontrados (" + resultados.size() + "):");
            for (Produto p : resultados) {
                System.out.println(p);
            }
        }
    }
}
