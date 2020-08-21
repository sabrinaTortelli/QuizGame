package br.univali.tortelli.inputsAndOutputs;

import java.io.*;

/**
 * Classe que grava os dados em uma arquivo com o nome do jogador
 */
public class Output {
    private int totalOfPoints;
    private int wrongAnswers;
    private int rightAnswers;
    private int numberOfQuestions;
    private int answeredQuestions;
    private String fileName;

    /**
     * Construtor
     * @param totalOfPoints total de pontos do jogo
     * @param wrongAnswers respostas erradas
     * @param rightAnswers respostas certas
     * @param numberOfQuestions número de questões respondidas
     * @param fileName nome do arquivo ou sessão
     */
    public Output(int totalOfPoints, int wrongAnswers, int rightAnswers, int numberOfQuestions, String fileName) {
        this.totalOfPoints = totalOfPoints;
        this.wrongAnswers = wrongAnswers;
        this.rightAnswers = rightAnswers;
        this.numberOfQuestions = numberOfQuestions;
        this.fileName = fileName;
        answeredQuestions = wrongAnswers + rightAnswers;
    }

    /**
     * Grava os dados em um arquivo
     * @param name nome que será criado o arquivo (nome do jogador)
     */
    public void playerWriter(String name) {
        String nameOfFile = name + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nameOfFile, true))){
            writer.write("Arquivo: " + fileName);
            writer.newLine();
            writer.write("Número de questões na sessão : " + numberOfQuestions );
            writer.newLine();
            writer.write("Número de questões respondidas no jogo : " + answeredQuestions);
            writer.newLine();
            writer.write("Número de questões certas respondidas no jogo : " + rightAnswers);
            writer.newLine();
            writer.write("Número de questões erradas respondidas no jogo : " + wrongAnswers);
            writer.newLine();
            writer.write("Total de pontos no jogo : " + totalOfPoints);
            writer.newLine();
            writer.newLine();
        } catch (FileNotFoundException e){
            System.out.println("Erro na abertura do arquivo");
        } catch (IOException e){
            System.out.println("Erro de execução");
        }
    }

}
