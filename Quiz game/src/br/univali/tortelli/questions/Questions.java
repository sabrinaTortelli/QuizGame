package br.univali.tortelli.questions;

/**
 * Classe abstrata de questões
 */
public abstract class Questions {
    private QuestionsType type;
    private int questionPoints;
    private String question;
    private String answer;

    /**
     * Construtor
     * @param type tipo de questão
     * @param questionPoints pontos da questão
     * @param question pergunta
     * @param answer resposta
     */
    public Questions(QuestionsType type, int questionPoints, String question, String answer){
        this.type = type;
        this.questionPoints = questionPoints;
        this.question = question;
        this.answer = answer;
    }

    /**
     * @return retorna pontos da questão
     */
    public int getQuestionPoints() {
        return questionPoints;
    }

    /**
     * @return retorna resposta
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * @return  retorna pergunta
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Checa se a resposta do jogador é igual a resposta da pergunta
     * @param playerAnswer resposta do jogador
     * @return retorna valor das questões respondidas
     */
    public int checkPlayerAnswer(String playerAnswer) {
        int answerPoint = 0;
        boolean rightAnswer = getAnswer().equalsIgnoreCase(playerAnswer);
        if (playerAnswer.equalsIgnoreCase("passar")) {
            return answerPoint;
        }
        if (rightAnswer) {
            return answerPoint + getQuestionPoints();
        }
        return answerPoint - getQuestionPoints();
    }
}
