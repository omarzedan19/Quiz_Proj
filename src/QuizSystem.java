import java.util.*;
public class QuizSystem {
    private static Map<String, Integer> scores = new HashMap<>();

    public static void main(String[] args) {
        List<Question> allQuestions = populateQuestions();
        Quiz quiz = generateRandomQuiz(allQuestions);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMainMenu();
            int choice = scanner.nextInt(3);

            switch (choice) {
                case 1:
                    startQuiz(scanner, quiz);
                    break;
                case 2:
                    displayResults();
                    break;
                case 3:
                    System.out.println("Exiting Quiz System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static List<Question> populateQuestions() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Which programming language is known as the 'mother of all languages'?", Arrays.asList("Java", "C", "Assembly"), 1));
        questions.add(new Question("What is the largest planet in our solar system?", Arrays.asList("Mars", "Jupiter", "Saturn"), 1));
        questions.add(new Question("Who is the author of 'To Kill a Mockingbird'?", Arrays.asList("J.K. Rowling", "Harper Lee", "George Orwell"), 1));
        questions.add(new Question("What is the capital of Australia?", Arrays.asList("Sydney", "Canberra", "Melbourne"), 1));
        questions.add(new Question("In which year was the Eiffel Tower completed?", Arrays.asList("1889", "1901", "1925"), 0));
        questions.add(new Question("Which country is known as the 'Land of the Rising Sun'?", Arrays.asList("China", "Japan", "South Korea"), 1));
        questions.add(new Question("What is the chemical symbol for gold?", Arrays.asList("Au", "Ag", "Fe"), 0));
        questions.add(new Question("Who painted 'Starry Night'?", Arrays.asList("Pablo Picasso", "Vincent van Gogh", "Claude Monet"), 1));
        questions.add(new Question("Which continent is the Sahara Desert located in?", Arrays.asList("Asia", "Africa", "South America"), 1));
        questions.add(new Question("Who developed the theory of relativity?", Arrays.asList("Isaac Newton", "Albert Einstein", "Galileo Galilei"), 1));



        return questions;
    }

    private static Quiz generateRandomQuiz(List<Question> allQuestions) {
        if (allQuestions.size() < 10) {
            throw new IllegalArgumentException("Insufficient questions for the quiz");
        }

        List<Question> randomQuestions = new ArrayList<>();
        Collections.shuffle(allQuestions);

        for (int i = 0; i < 10; i++) {
            randomQuestions.add(allQuestions.get(i));
        }

        return new Quiz(randomQuestions);
    }


    private static void displayMainMenu() {
        System.out.println("1. Start Quiz");
        System.out.println("2. Display Results");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void startQuiz(Scanner scanner, Quiz quiz) {
        System.out.print("Enter your name: ");
        String playerName = scanner.next();

        QuizTaker quizTaker = new QuizTaker(playerName);
        quizTaker.takeQuiz(quiz);
    }

    private static void displayResults() {
        System.out.println("Quiz Results:");
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
