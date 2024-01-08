import java.util.*;

public class Quiz {
    private List<Question> questions;

    public Quiz(List<Question> questions) {
        this.questions = questions;
    }

    public void displayQuiz() {
        for (Question question : questions) {
            question.displayQuestion();
        }
    }

    public int scoreQuiz(List<Integer> playerAnswers) {
        int score = 0;
        for (int i = 0; i < playerAnswers.size(); i++) {
            if (questions.get(i).isCorrectAnswer(playerAnswers.get(i))) {
                score++;
            }
        }
        return score;
    }

    public List<Question> getQuestions() {
        return questions;
    }

}
