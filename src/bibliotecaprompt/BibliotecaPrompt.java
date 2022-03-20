package bibliotecaprompt;

import java.util.Scanner;

/**
 *
 * @author lipe
 */
public class BibliotecaPrompt {

    private static Scanner teclado;
    private static Scanner teclado2;
    private static Scanner teclado3;
    private static int posicaoStatus;
    private static int posicaoStatus2;
    private static Scanner teclado4;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Chamando função de criar a tela inicial.
        telaInicial();
    }

    public static int getPosicaoStatus2() {
        return posicaoStatus2;
    }

    public static void setPosicaoStatus2(int posicaoStatus2) {
        BibliotecaPrompt.posicaoStatus2 = posicaoStatus2;
    }

    public static int getPosicaoStatus() {
        return posicaoStatus;
    }

    public static void setPosicaoStatus(int posicaoStatus) {
        BibliotecaPrompt.posicaoStatus = posicaoStatus;
    }

    public static void telaInicial() {
        // Criando tela inicial
        System.out.println("===========================================");
        System.out.println("1. Consultar Livros");
        System.out.println("2. Cadastrar Livros");
        System.out.println("3. Alugar/Devolver Livros");
        System.out.println("4. Sair");
        System.out.println("===========================================");

        // Chamando a função que da as opções (FUnção OpcoesLivros() está na pasta
        // Opcoes.java)
        OpcoesLivros();

    }

    public static void CadastrarLivro() {
        teclado4 = new Scanner(System.in);
        int comprimento = Livros.Livro.length;

        // Verificando os espaços em branco do array para adicionar o novo livro
        String control;
        int posicao = 0;

        for (int i = 0; i < comprimento; i++) {
            control = Livros.Livro[i];
            if ("".equals(control)) {
                posicao = i;
                break;
            }
        }

        // Adicionando novos livros ao sistema
        System.out.println("===========================================");
        boolean c = true;
        while (c == true) {
            System.out.print("Digite o nome do livro: ");
            String NovoLivro = teclado4.nextLine();
            int controlador = NovoLivro.length();

            // Verificando se o usuário digitou um nome válido
            if (controlador < 5) {
                System.out.print("Nome muito pequeno, ");
            } else {
                // for2
                Livros.Livro[posicao] = NovoLivro;
                Livros.Status[posicao] = "Disponível";
                System.out.println("Livro Cadastrado com sucesso!");

                System.out.println("===========================================");
                System.out.println("1. Cadastrar novo Livro");
                System.out.println("2. Voltar a tela inicial");
                boolean a = true;

                // Laço para verificar se o usuário selecionou uma opção válida
                while (a == true) {
                    System.out.print("Escolha uma opção: ");
                    int OPCAO = teclado4.nextInt();

                    switch (OPCAO) {
                        case 1 -> {
                            a = false;
                            c = false;
                            CadastrarLivro();
                        }
                        case 2 -> {
                            a = false;
                            c = false;
                            telaInicial();
                        }
                        default -> {
                            System.out.println("Opção inválida !");
                            System.out.println("===========================================");
                            System.out.println("1. Cadastrar novo Livro");
                            System.out.println("2. Voltar a tela inicial");
                        }
                    }
                }
            }
        }

    }

    public class Livros {
        // Criando os arrays de livro e disponibilidade
        static String[] Livro = { "Harry potter", "Narnia", "Senhor dos anéis", "Historia ",
                "Java como programar", "Java ", "Moby Dick",
                "Como não programar em java", "JavaScript cangaceiro ",
                "Programação em C#", "O Hobbit: A Guerra dos 5 Exércicitos", "", "", "", "", "" };

        static String[] Status = { "Disponível", "Disponível", "Disponível", "Disponível", "Disponível",
                "Disponível", "Disponível", "Disponível", "Disponível", "Disponível", "Disponível", "",
                "", "", "", "" };
    }

    public static void DevolverLivros() {
        teclado3 = new Scanner(System.in);

        boolean a = true;
        int comprimento = Livros.Livro.length;

        String control;
        int posicao = 0;
        setPosicaoStatus(0);
        int contador = 0;
        int id = 0;

        // Verificando se o array tem espaços em branco
        for (int i = 0; i < comprimento; i++) {
            control = Livros.Livro[i];
            if ("".equals(control)) {
                posicao = i;
                break;
            }
        }
        // Verificando se o array tem espaços em branco
        for (int i = 0; i < comprimento; i++) {
            control = Livros.Status[i];
            if ("".equals(control)) {
                setPosicaoStatus(i);
                break;
            }
        }

        // Opções
        System.out.println("===========================================");
        System.out.println("O que deseja fazer?");
        System.out.println("1. Alugar Livro");
        System.out.println("2. Devolver Livro");
        System.out.println("3. Voltar a Tela Inicial");
        System.out.println("===========================================");

        boolean d = true;
        while (d == true) {
            System.out.print("Escolha uma opção: ");
            int opt = teclado3.nextInt();
            // Switch Para tomada de decisão
            switch (opt) {
                case 1 -> {
                    // Percorrendo o array e imprimindo os livros na tela
                    while (a == true) {
                        System.out.println(
                                "======================================================================================");
                        System.out.println("Livros Disponíveis: ");
                        for (int i = 0; i < posicao; i++) {
                            if ("Disponível".equals(Livros.Status[i])) {
                                contador += 1;
                                if (i < 9) {
                                    System.out.printf("%n 0%s - %-36s Status do Livro: -> %s", (i + 1), Livros.Livro[i],
                                            Livros.Status[i]);
                                } else {
                                    System.out.printf("%n %s - %-36s Status do Livro: -> %s", (i + 1), Livros.Livro[i],
                                            Livros.Status[i]);
                                }
                            }
                            //
                        }
                        if (contador == 0) {
                            System.out.println("\n");
                            System.out.println("Nenhum livro encontrado.");
                        }
                        a = false;
                        System.out.println("\n");
                        System.out.println(
                                "======================================================================================");
                    }
                    // Função para trocar disponível para indisponível
                    boolean f = true;
                    while (f == true) {
                        int opcaoOk = 0;
                        System.out.println("0 - Deseja voltar a tela inicial?");
                        System.out.println("1 - Deseja Alugar um livro?");
                        System.out.print("Selecione uma opção: ");
                        opcaoOk = teclado3.nextInt();

                        switch (opcaoOk) {
                            case 0 -> {
                                telaInicial();
                                f = false;
                            }
                            case 1 -> {
                                System.out.print("Selecione o número do livro que deseja alugar: ");
                                id = teclado3.nextInt();
                            }
                            default ->
                                System.out.print("");
                        }

                        // Verificando se as opções são válidas
                        if (id <= 0 || id > Livros.Livro.length) {
                            System.out.println("Opção inválida!");
                            System.out.println("===========================================");
                        } else {
                            id--;
                            Livros.Status[id] = "Indisponível";
                            System.out.println("Livro alugado com sucesso!");

                            f = false;
                            boolean l = true;
                            int opcao = 0;
                            while (l == true) {
                                // Opções
                                System.out.println("===========================================");
                                System.out.println("O que deseja fazer?");
                                System.out.println("1. Alugar outro livro");
                                System.out.println("2. Voltar a página inicial");
                                System.out.println("===========================================");
                                System.out.print("Selecione uma opção: ");
                                opcao = teclado3.nextInt();
                                switch (opcao) {
                                    case 1 -> {
                                        DevolverLivros();
                                        l = false;
                                    }
                                    case 2 -> {

                                        telaInicial();
                                        l = false;
                                    }
                                    default ->
                                        System.out.print("Opção inválida!");
                                }
                            }
                        }
                    }

                    // Verificando se o usuário selecionou uma opção válida
                    d = false;
                }

                case 2 -> {
                    // Percorrendo o array e imprimindo os livros na tela
                    while (a) {
                        System.out.println(
                                "======================================================================================");
                        System.out.println("Livros Indisponíveis: ");
                        for (int i = 0; i < posicao; i++) {
                            if ("Indisponível".equals(Livros.Status[i])) {
                                contador += 1;
                                if (i < 9) {
                                    System.out.printf("%n 0%s - %-36s Status do Livro: -> %s", (i + 1), Livros.Livro[i],
                                            Livros.Status[i]);
                                } else {
                                    System.out.printf("%n %s - %-36s Status do Livro: -> %s", (i + 1), Livros.Livro[i],
                                            Livros.Status[i]);
                                }
                            }
                        }
                        if (contador == 0) {
                            System.out.println("\n");
                            System.out.println("Nenhum livro encontrado.");
                        }
                        a = false;
                        System.out.println("\n");
                        System.out.println(
                                "======================================================================================");
                    }
                    // Função para trocar indisponível para disponível
                    boolean f = true;
                    while (f == true) {
                        int opcaoOk = 0;
                        System.out.println("0 - Deseja voltar a tela inicial?");
                        System.out.println("1 - Deseja devolver um livro?");
                        System.out.print("Selecione uma opção: ");
                        opcaoOk = teclado3.nextInt();

                        switch (opcaoOk) {
                            case 0 -> {
                                telaInicial();
                                f = false;
                            }
                            case 1 -> {
                                System.out.print("Selecione o número do livro que deseja devolver: ");
                                id = teclado3.nextInt();
                            }
                            default ->
                                System.out.print("");
                        }

                        // Verificando se as opções são válidas
                        if (id <= 0 || id > Livros.Livro.length) {
                            System.out.println("Opção inválida!");
                            System.out.println("===========================================");
                        } else {
                            id--;
                            Livros.Status[id] = "Disponível";
                            System.out.println("Livro Devolvido com sucesso!");

                            f = false;
                            boolean l = true;
                            int opcao = 0;
                            while (l == true) {
                                // Opções
                                System.out.println("===========================================");
                                System.out.println("O que deseja fazer?");
                                System.out.println("1. Devolver outro livro");
                                System.out.println("2. Voltar a página inicial");
                                System.out.println("===========================================");
                                System.out.print("Selecione uma opção: ");
                                opcao = teclado3.nextInt();
                                switch (opcao) {
                                    case 1 -> {
                                        DevolverLivros();
                                        l = false;
                                    }
                                    case 2 -> {

                                        telaInicial();
                                        l = false;
                                    }
                                    default ->
                                        System.out.print("Opção inválida!");
                                }
                            }
                        }
                    }
                    d = false;
                }
                case 3 -> {
                    telaInicial();
                    d = false;
                }
                default ->
                    System.out.println("Opção inválida!");
            }
        }
    }

    // Criando função para chamar as funções
    public static void OpcoesLivros() {
        teclado2 = new Scanner(System.in);

        boolean c = true;
        // Verificando se o usuário selecionou uma opção válida
        while (c == true) {
            System.out.print("Escolha uma opção: ");
            int OPCAO = teclado2.nextInt();

            switch (OPCAO) {
                case 1 -> {
                    // Função VerLivros() vai para a pasta VerLivros.java
                    VerLivros();
                    c = false;
                }
                case 2 -> {
                    // Função CadastrarLivro() vai para a pasta CadastrarLivros.java
                    CadastrarLivro();
                    c = false;
                }
                case 3 -> {
                    // Função DevolverLivros() vai para a pasta Devolver.java
                    DevolverLivros();
                    c = false;
                }
                case 4 -> {
                    // Caso selecione o programa finaliza
                    System.out.println("Obrigado por usar nosso sistema!");
                    c = false;
                }
                default -> {
                    // Caso não selecione uma opção valida o laço se repete
                    System.out.println("Opção inválida !");
                    System.out.println("===========================================");
                }
            }
        }
    }

    public static void VerLivros() {
        teclado = new Scanner(System.in);

        boolean a = true;
        int comprimento = Livros.Livro.length;

        String control;
        int posicao = 0;
        setPosicaoStatus2(0);

        // Verificando se o array tem espaços em branco
        for (int i = 0; i < comprimento; i++) {
            control = Livros.Livro[i];
            if ("".equals(control)) {
                posicao = i;
                break;
            }
        }
        // Verificando se o array tem espaços em branco
        for (int i = 0; i < comprimento; i++) {
            control = Livros.Status[i];
            if ("".equals(control)) {
                setPosicaoStatus2(i);
                break;
            }
        }

        // Precorrendo o array e imprimindo os livros na tela
        while (a) {
            System.out
                    .println("======================================================================================");
            System.out.println("Livros disponíveis: ");
            for (int i = 0; i < posicao; i++) {
                if ("Disponível".equals(Livros.Status[i])) {
                    if (i < 9) {
                        System.out.printf("%n 0%s - %-36s Status do Livro: -> %s", (i + 1), Livros.Livro[i],
                                Livros.Status[i]);
                    } else {
                        System.out.printf("%n %s - %-36s Status do Livro: -> %s", (i + 1), Livros.Livro[i],
                                Livros.Status[i]);
                    }
                }
                a = false;
            }
            System.out.println("\n");
            System.out
                    .println("======================================================================================");
        }
        System.out.println("1. Voltar a tela inicial");
        System.out.println("2. Sair");
        boolean c = true;

        // Verificando se o usuário selecionou uma opção válida
        while (c == true) {
            System.out.print("Escolha uma opção: ");
            int OPCAO = teclado.nextInt();
            System.out.println("===========================================");
            switch (OPCAO) {
                case 1 -> {
                    c = false;
                    telaInicial();
                }
                case 2 -> {
                    c = false;
                    System.out.println("Obrigado por usar meu sistema!");
                    System.out.println("===========================================");
                }
                default -> {
                    System.out.println("Opção inválida");
                }
            }
        }
    }
}
