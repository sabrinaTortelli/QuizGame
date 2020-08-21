package br.univali.tortelli.run;

import br.univali.tortelli.inputsAndOutputs.Files;
import br.univali.tortelli.questions.Questions;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe de apoio ao jogo
 */

public class Run {
    private Files run = new Files();
    private int totalOfPoints;
    private int wrongAnswers;
    private int rightAnswers;

    /**
     * Roda as perguntas
     * @param numberOfQuestions numero de questões que o jogador escolheu
     * @param questions array de questões
     * @return retorna o total de pontos do jogo
     */
    public int runQuestions(int numberOfQuestions, ArrayList<Questions> questions){
        Scanner answer = new Scanner(System.in);
        ArrayList<Questions> shuffledQuestion = run.getShuffleQuestions(questions);
        for(int i = 0; i<numberOfQuestions; i++){
            System.out.println(shuffledQuestion.get(i).toString());
            System.out.println("Digite uma resposta ou digite 'Passar' para passar a questão" );
            String playeranswer = answer.nextLine();
            int points = shuffledQuestion.get(i).checkPlayerAnswer(playeranswer);
            if(points<0){
                wrongAnswers ++;
                System.out.println("Você errou a questão!");
                System.out.println();
            } else if(points>0) {
                rightAnswers ++;
                System.out.println("Parabéns, você acertou a questão!");
                System.out.println();
            }
            totalOfPoints = totalOfPoints + points;
        }
        return totalOfPoints;
    }

    /**
     * Mostra o resultado da sessão
     * @param file arquivo ou sessão escolhida
     */
    public void result(String file){
        System.out.println("Sessão jogada: " + run.getFileName(file));
        System.out.println("Número de respostas certas: " + rightAnswers);
        System.out.println("Número de respostas erradas: "+ wrongAnswers);
        System.out.println("Total de pontos no jogo: "+ totalOfPoints);
    }

    /**
     * @return retorna questões respondidas corretamente
     */
    public int getRightAnswers() {
        return rightAnswers;
    }

    /**
     * @return retorna questões respondidas incorretamente
     */
    public int getWrongAnswers() {
        return wrongAnswers;
    }
}
