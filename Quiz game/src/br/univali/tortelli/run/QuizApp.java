package br.univali.tortelli.run;

import br.univali.tortelli.inputsAndOutputs.Files;
import br.univali.tortelli.inputsAndOutputs.Input;
import br.univali.tortelli.inputsAndOutputs.Output;
import br.univali.tortelli.questions.Questions;

import java.util.ArrayList;

/**
 * Classe que roda o jogo
 */

public class QuizApp {
    private String name;
    private String files;
    private ArrayList<Questions> questions = new ArrayList<>();
    private int numberOfQuestions;
    private boolean read;
    private int totalOfPoints;

    /**
     * método que roda o jogo
     */
    public void QuizApp() {
        System.out.println("------------ Quiz App ------------");
        Input player = new Input();
        Files session = new Files();
        Run game = new Run();
        this.name = player.getPlayer();
        do {
            files = player.askFiles();
            numberOfQuestions = player.askNumberOfQuestions(files);
            questions = session.fileOptions(files);
            totalOfPoints = game.runQuestions(numberOfQuestions, questions);
            game.result(files);
            Output write = new Output(totalOfPoints, game.getWrongAnswers(), game.getRightAnswers(), numberOfQuestions, files);
            write.playerWriter(this.name);
            read = player.askNewSession();
        } while (read);
    }
}
