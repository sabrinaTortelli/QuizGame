package br.univali.tortelli.inputsAndOutputs;

import br.univali.tortelli.questions.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Classe que manipula arquivos
 */
public class Files {
    private ArrayList<Questions> questions = new ArrayList<>();
    private String fileName;
    private int totalOfQuestions;

    /**
     * Sorteia questões aleatoriamente
     * @param questions array de questões do arquivo
     * @return retorna o array de questões
     */
    public ArrayList<Questions> getShuffleQuestions(ArrayList<Questions> questions) {
        Collections.shuffle(questions);
        return questions;
    }

    /**
     * Resgata o total de questões do arquivo escolhido
     * @param file arquivo escolhido pelo jogador
     * @return retorna o total de questões
     */
    public int getTotalOfQuestions(String file) {
        try{
            Scanner fileManipulation = new Scanner(new File(file));
            fileManipulation.nextLine();
            this.totalOfQuestions = Integer.parseInt(fileManipulation.nextLine());
            fileManipulation.close();
        } catch (FileNotFoundException e) {
            System.out.println("Erro na abertura do programa");
        }
        return totalOfQuestions;
    }

    /**
     * Obtem o título do arquivo escolhido
     * @param file arquivo escolhido pelo jogador
     * @return retorna o título do aquivo escolhido
     */
    public String getFileName(String file) {
        try {
            Scanner fileManipulation = new Scanner(new File(file));
            this.fileName = fileManipulation.nextLine();
            fileManipulation.close();
        } catch (FileNotFoundException e){
            System.out.println("Arquivo não encontrado");
        }
        return fileName;
    }

    /**
     * Manipula as questões dentro do arquivo
     * @param file arquivo escolhido pelo jogador
     * @return retorna um array de questões
     */
    public ArrayList<Questions> fileOptions(String file){
        try {
            Scanner fileManipulation = new Scanner(new File(file));
            fileManipulation.nextLine();
            fileManipulation.nextLine();
            while (fileManipulation.hasNext()) {
                String[] line = fileManipulation.nextLine().split(" ");
                switch (line[0]) {
                    case "RC": {
                        int questionPoints = Integer.parseInt(line[1]);
                        String question = fileManipulation.nextLine();
                        String answer = fileManipulation.nextLine();
                        RC newQuestion = new RC(QuestionsType.RC, questionPoints, question, answer);
                        questions.add(newQuestion);
                        break;
                    }
                    case "VF": {
                        int questionPoints = Integer.parseInt(line[1]);
                        String question = fileManipulation.nextLine();
                        String answer = fileManipulation.nextLine();
                        VF newQuestion = new VF(QuestionsType.VF, questionPoints, question, answer);
                        questions.add(newQuestion);
                        break;
                    }
                    case "ME": {
                        int questionPoints = Integer.parseInt(line[1]);
                        String question = fileManipulation.nextLine();
                        int optionsNumbers = Integer.parseInt(fileManipulation.nextLine());
                        String[] options = new String[optionsNumbers];
                        for (int i = 0; i < optionsNumbers; i++) {
                            options[i] = "\n" + fileManipulation.nextLine();
                        }
                        String answer = fileManipulation.nextLine();
                        ME newQuestion = new ME(QuestionsType.ME, questionPoints, question, answer, options, optionsNumbers);
                        questions.add(newQuestion);
                        break;
                    }
                }
            }
            fileManipulation.close();
        } catch (FileNotFoundException e){
            System.out.println("Erro na abertura do programa");
        }
        return questions;
    }
}
