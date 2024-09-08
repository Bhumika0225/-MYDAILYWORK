import java.util.*;

public class QuizApplication {

    public static void main(String[] args) {
        Map<Integer, Question> quiz = new HashMap<>();
        
        
        quiz.put(1, new Question("What is national game of India?", 
                new String[]{"A.Cricket","B.Hockey", "C.India do not have any national game"},"C"));
        quiz.put(2, new Question("What  is 99/0?", 
                new String[]{"A.1","B.0","C.Infinity"},"B"));

        startQuiz(quiz, 10); 
    }

    
    public static void startQuiz(Map<Integer, Question> quiz, int timeLimit) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        for (Map.Entry<Integer, Question> entry : quiz.entrySet()) {
            Question question = entry.getValue();
            System.out.println("Q" + entry.getKey() + ": " + question.questionText);

            for (String option : question.options) {
                System.out.println(option);
            }

            long startTime = System.currentTimeMillis();
            System.out.print("Select your answer (within " + timeLimit + " seconds): ");
            String userAnswer = null;

           
            while (System.currentTimeMillis() - startTime < timeLimit * 1000) {
                if (scanner.hasNext()) {
                    userAnswer = scanner.nextLine();
                    break;
                }
            }

            if (userAnswer == null) {
                System.out.println("Time's up! Moving to the next question...");
            } else {
                
                if (userAnswer.equalsIgnoreCase(question.correctAnswer)) {
                    score++;
                }
            }
        }

      
        System.out.println("Quiz over! Your final score is: " + score + "/" + quiz.size());
        scanner.close();
    }
}

class Question {
    String questionText;
    String[] options;
    String correctAnswer;

    public Question(String questionText, String[] options, String correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
}
