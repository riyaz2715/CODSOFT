import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class quiz {

    private static final int QUESTION_TIME_LIMIT = 10; // time limit in seconds
    private static final Scanner scanner = new Scanner(System.in);
    private static Timer timer;
    private static boolean answered;
    private static String userAnswer;

    // Array of questions
    private static String[][] questions = {
        {"What is the capital of France?", "Paris"},
        {"What is 2 + 2?", "4"},
        {"What is the capital of Japan?", "Tokyo"}
    };

    public static void main(String[] args) {
        System.out.println("Welcome to the Quiz!");

        int score = 0;

        for (String[] question : questions) {
            System.out.println(question[0]);
            startTimer();

            // Wait for the user to answer or the timer to run out
            while (!answered) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Stop the timer
            timer.cancel();
            timer.purge();

            if (userAnswer != null && userAnswer.equalsIgnoreCase(question[1])) {
                System.out.println("Correct!");
                score++;
            } else if (userAnswer != null) {
                System.out.println("Wrong! The correct answer is: " + question[1]);
            } else {
                System.out.println("Time's up! The correct answer is: " + question[1]);
            }

            answered = false; // Reset for next question
            userAnswer = null; // Reset for next question
        }

        System.out.println("Quiz over! Your score is: " + score + "/" + questions.length);
    }

    private static void startTimer() {
        answered = false;
        userAnswer = null;
        timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                answered = true;
                System.out.println("\nTime's up!");
            }
        };

        timer.schedule(task, QUESTION_TIME_LIMIT * 1000);

        // Start a thread to read user input
        new Thread(() -> {
            userAnswer = scanner.nextLine();
            answered = true;
            timer.cancel();
            timer.purge();
        }).start();
    }
}
