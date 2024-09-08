//-------------------------------------------TASK 1--------------------------------------------------------

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int r = 0; // rounds
        int s = 0; // score
        String PlayAgain;
        System.out.println("Welcome to the Guessing Game..! Lets Play");
        do {
            r++;
            int number = random.nextInt(100) + 1;
            int MaximumAttempt = 5;
            int Attempts = 0;
            boolean Correctly_Guessed = false;
            System.out.println(
                    "\nRounds" + r + "you have" + MaximumAttempt + "attempts to guess the number b/w 1 to 100");
            while (Attempts < MaximumAttempt) {
                System.out.println("Enter your Guess :");
                int guess = scanner.nextInt();
                Attempts++;
                if (guess == number) {
                    System.out.println("Number is Correct..You Won..!");
                    s++;
                    Correctly_Guessed = true;
                    break;
                } else if (guess < number) {
                    System.out.println("Too Low..!try again");
                } else {
                    System.out.println("Too High..!try again");
                }
            }
            if (!Correctly_Guessed) {
                System.out.println("Out of Attempts number is  "+"  " + number + " "+"  Bettter Luck Next Time..!");
            }
            System.out.println("Your current Score is " + s);
            System.out.println("Wanna Play Againnn..?(Yes/No) :");
            PlayAgain = scanner.next();
        }

        while (PlayAgain.equalsIgnoreCase("Yes"));
        System.out.println("Thanks for Playing...!");
        System.out.println("Final Score: " + s + " rounds won out of " +"  " + r + "  " +" rounds played");
        scanner.close();
    }
}