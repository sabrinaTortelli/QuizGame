package br.univali.tortelli.questions;

/**
 * Classe de Verdadeiro e Falso herdada da classe Questões
 */
public class VF extends Questions {

    /**
     * Construtor
     * @param type tipo da questão (ME)
     * @param questionPoints pontos da questão
     * @param question pergunta
     * @param answer resposta
     */
    public VF(QuestionsType type, int questionPoints, String question, String answer){
        super(type, questionPoints, question, answer);
    }

    /**
     * Método que sobrescreve to String para a saída de dados
     * @return retorna a saída para o jogador
     */
    @Override
    public String toString(){
        return "Questão: " + getQuestion() + "\n" + "Pontos da Questão: " + getQuestionPoints() + "\n";
    }
}