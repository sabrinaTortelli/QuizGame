package br.univali.tortelli.questions;

/**
 * Classe de questões múltipla escolha herdada de Questões
 */
public class ME extends Questions{
    private String[] options;
    private int optionsNumbers;

    /**
     * Construtor
     * @param type tipo da questão (ME)
     * @param questionPoints pontos da questão
     * @param question pergunta
     * @param answer resposta
     * @param options opções da questão
     * @param optionsNumbers número de opções da questão
     */
    public ME(QuestionsType type, int questionPoints, String question, String answer, String[] options, int optionsNumbers){
        super(type, questionPoints, question, answer);
        this.options = options;
        this.optionsNumbers = optionsNumbers;

    }

    /**
     * Método que sobrescreve to String para a saída de dados
     * @return retorna a saída para o jogador
     */
    @Override
    public String toString(){
        return "Questão: " + getQuestion() + "\n" +
                "A) " + options[0].replace("\n", "") + "\n" +
                "B) " + options[1].replace("\n", "")  + "\n" +
                "C) " + options[2].replace("\n", "")  + "\n" +
                "D) " + options[3].replace("\n", "")  + "\n" +
                "Pontos da Questão: " + getQuestionPoints()+ "\n";
    }
}
