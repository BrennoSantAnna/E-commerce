# Sistema de Controle de Armazém em Java
Este é um projeto acadêmico desenvolvido para a disciplina de **Estrutura de Dados e Análise de Algoritmos**.
O objetivo é simular um sistema de controle de estoque para um armazém logístico de e-commerce, aplicando na
prática diversos algoritmos de busca e ordenação.

O sistema é executado inteiramente via console e permite gerenciar o cadastro de produtos e realizar pesquisas 
e ordenações com base em múltiplos critérios.

## Tech Stack
[![My Skills](https://skillicons.dev/icons?i=java)](https://skillicons.dev)
## Funcionalidades
O sistema permite ao usuário realizas as seguintes ações através de um menu interativo no console:
* **Adicionar produtos**: Cadastrar novos produtos no estoque 
(com código, nome, categoria, quantidade, preço e avaliação).


* **Remover produtos**: Excluir produtos do estoque com base em seu código.


* **Listar todos os produtos**: Exibir todos os produtos na ordem em que foram cadastrados.


* **Buscar produtos (com 2 algoritmos)** 
* 1. **Busca Linear**: Por nome (parcial) ou por categoria (exata).
* 2. **Busca Binária**: Por código do produto (precedida por uma ordenação com MergeSort).


* **Listar produtos ordenados (com 4 algoritmos)**:
* 1. Ordenação por **Preço** (usando _Bubble Sort_).
* 2. Ordenação por **Quantidade** (usando _Selection Sort_).
* 3. Ordenação por **Avaliação** (usando _Insertion Sort_).
* 4. Ordenação por **Nome** (alfabética, usando _Merge Sort_).

## Implementação Técnica
O foco do projeto foi a aplicação e análise de estruturas de dados e algortimos clássicos.

### Estrutura de Dados
* ```javaArrayList<Produto>```: A estrutura de dados principal para armazenar o estoque em memória.
Foi escolhida por sua flexibilidade (tamanho dinâmico) em vez de um Array simples.

### Algoritmos Implementados
Todos os algoritmos de busca e ordenação foram implementados manualmente (```.java```) como parte dos 
requisitos do projeto.
1. #### Algoritmos de Busca
* **Busca Linear**: Implementada nos métodos ```buscarPorNome``` e ```buscarPorCategoria```.
* **Busca Binária**: Implementada no método ```buscarProdutoPorCodigoBuscaBinaria```

2. #### Algoritmos de Ordenação
   Para garantir a segurança dos dados originais, todos os métodos de ordenação criam uma **cópia** 
da lista de estoque e ordenam apenas a cópia.
* ```Bubble Sort```: Usado para ordenar por **Preço**.
* ```Selection Sort```: Usado para ordenar por **Quantidade**.
* ```Insertion Sort```: Usado para ordenar por **Avaliação**.
* ```Merge Sort```: Usado para ordenar por **Nome** (alfabeticamente) e por **Código**.

## Como Executar
Este projeto é um aplicativo de console e não requer bibliotecas externas.
1. Clone o repositório:
```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   cd seu-repositorio
```
2. Navegue até a pasta ```src``` e compile todos os arquivos ```.java```:
```bash
   javac br/com/seuprojeto/main/Main.java br/com/seuprojeto/model/Produto.java ... (etc.)
```
ou
```bash
   javac */*/*.java */*/*/*.java
```
3. Execute a classe ```Main``` a partir da pasta ```src```:
```bash
   java br.com.com.seuprojeto.main.Main
```
4. O menu interativo será exibido no console.

## Estrutura de Pacotes
O projeto foi organizado em pacotes para separar as responsabilidades (Separação de Concerns):
```bash
   src/
├── br/com/seuprojeto/
│   ├── main/
│   │   └── Main.java             // Ponto de entrada (inicia o menu)
│   │
│   ├── model/
│   │   └── Produto.java          // Classe de entidade (POJO)
│   │
│   ├── data/
│   │   └── Estoque.java          // Gerenciador (adiciona, remove, chama algoritmos)
│   │
│   ├── view/
│   │   └── MenuConsole.java      // Lógica do menu e interação com usuário
│   │
│   └── algoritmos/
│       ├── busca/
│       │   └── BuscaBinaria.java
│       │   └── (Busca Linear está em Estoque.java)
│       └── ordenacao/
│           ├── BubbleSort.java
│           ├── SelectionSort.java
│           ├── InsertionSort.java
│           └── MergeSort.java
```