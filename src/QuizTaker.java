import java.util.*;
public class QuizTaker {
    private String name;
    private Map<String, Integer> quizScores;

    public QuizTaker(String name) {
        this.name = name;
        this.quizScores = new HashMap<>();
    }

    public void takeQuiz(Quiz quiz) {
        System.out.println("Welcome, " + name + "! You will be presented with 10 random questions.");

        List<Integer> playerAnswers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        for (Question question : quiz.getQuestions()) {
            question.displayQuestion();
            System.out.print("Enter your answer (1-" + question.getOptions().size() + "): ");
            int answer = scanner.nextInt();
            playerAnswers.add(answer);
        }

        int score = quiz.scoreQuiz(playerAnswers);
        System.out.println("Your score: " + score);

        quizScores.put(name, score);
    }

    public Map<String, Integer> getQuizScores() {
        return quizScores;
    }
}
