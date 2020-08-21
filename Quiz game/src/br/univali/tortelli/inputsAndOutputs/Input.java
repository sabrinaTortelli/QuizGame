package br.univali.tortelli.inputsAndOutputs;

import br.univali.tortelli.menu.Menu;
import java.util.Scanner;

/**
 * Classe de entrada dos dados do jogo
 */

public class Input {
    private String firstName;
    private String lastName;
    private String option;
    private int numberOfQuestions = 0;
    private int totalOfQuestions = 0;

    /**
     * Pergunta o nome do jogador e transforma para caixa alta
     * @return retorna o nome do jogador em caixa alta
     */
    public String getPlayer() {
        Scanner name = new Scanner(System.in).useDelimiter("\r\n");
        System.out.println("Qual seu primeiro nome?");
        this.firstName = name.nextLine().toUpperCase();
        System.out.println("Qual seu último nome?");
        this.lastName = name.nextLine().toUpperCase();
        return this.firstName + " " + this.lastName;
    }

    /**
     * Pergunta para o jogador qual arquivo ou sessão deseja jogar
     * @return retorna o arquivo escolhido
     */
    public String askFiles() {
        Scanner op = new Scanner(System.in).useDelimiter("\r\n");
        Menu menu = new Menu();
        do {
            System.out.println("Escolha um arquivo de temas para começar o jogo:");
            menu.showListOfFiles();
            this.option = op.nextLine();
            if (this.option.equalsIgnoreCase("modularizacao.txt") ||
                    (this.option.equalsIgnoreCase("heterogeneas.txt")) ||
                    (this.option.equalsIgnoreCase("alocacao.txt")) ||
                    (this.option.equalsIgnoreCase("classes.txt")) ||
                    (this.option.equalsIgnoreCase("heranca.txt"))){
                return this.option;
            } else{
                System.out.println("Digite um arquivo válido");
            }
        } while (true);
    }

    /**
     * Método que pergunta se o jogador deseja jogar nova sessão ou arquivo
     * @return retorna Verdadeiro se o jogador quiser jogar um novo jogo e Falso se o jogador não quiser jogar novamente
     */
    public boolean askNewSession() {
        String readed;
        Scanner read = new Scanner(System.in);
        do {
            System.out.println("Gostaria de escolher uma nova sessão? (s/n)");
            readed = read.nextLine();
            if (readed.equalsIgnoreCase("s")){
                return true;
            } else if(readed.equalsIgnoreCase("n")){
                System.out.println("Fim de jogo");
                return false;
            }
        } while (!readed.equalsIgnoreCase("s") || !readed.equalsIgnoreCase("n"));
        return false;
    }

    /**
     * Pergunta pro jogador quantas questões deseja jogar na sessão
     * @param session arquivo de perguntas
     * @return retorna número de questões de o jogador escolheu
     */
    public int askNumberOfQuestions(String session) {
        Files file = new Files();
        totalOfQuestions = file.getTotalOfQuestions(session);
        int numberOfQuestions = 0;
        do {
            try {
                Scanner op = new Scanner(System.in);
                System.out.println("Quantas questões deseja jogar? (Número máximo: " + totalOfQuestions + " )");
                numberOfQuestions = op.nextInt();
                if (numberOfQuestions > totalOfQuestions || numberOfQuestions <= 0) {
                    System.out.println("Digite um número de questões válido");
                }
            } catch (NumberFormatException e) {
                System.out.println("Digite apenas números");
            }
        } while (numberOfQuestions > totalOfQuestions || numberOfQuestions <= 0) ;
        this.numberOfQuestions = numberOfQuestions;
        return this.numberOfQuestions;
    }
}


