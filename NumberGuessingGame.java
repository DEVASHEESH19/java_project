import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        int totalScore = 0;  // Initialize the user's total score
        int roundsPlayed = 0;  // Track the number of rounds played
        Scanner scanner = new Scanner(System.in);

        while (true) {
            roundsPlayed++;
            // Generate a random number between 1 and 100
            Random random = new Random();
            int secretNumber = random.nextInt(100) + 1;
            int attemptsLeft = 10;  // Limit the number of attempts to 10
            int attemptsTaken = 0;  // Track the number of attempts used

            System.out.println("\nWelcome to the Number Guessing Game!");
            System.out.println("Round " + roundsPlayed + ": I have selected a random number between 1 and 100.");
            System.out.println("You have " + attemptsLeft + " attempts to guess the correct number.");

            boolean guessedCorrectly = false;
            while (attemptsLeft > 0) {
                // Prompt the user for a guess
                System.out.print("Enter your guess (" + attemptsLeft + " attempts left): ");
                int guess = scanner.nextInt();
                attemptsLeft--;
                attemptsTaken++;

                // Compare the guess to the secret number
                if (guess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else if (guess > secretNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You've guessed the number correctly in " + attemptsTaken + " attempts!");
                    // Award points based on the number of attempts taken
                    int pointsEarned = Math.max(0, 10 - attemptsTaken);  // Bonus points (max 10 points)
                    totalScore += pointsEarned;
                    System.out.println("You earned " + pointsEarned + " points this round.");
                    guessedCorrectly = true;
                    break;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts! The correct number was " + secretNumber + ".");
            }

            // Ask the user if they want to play another round
            System.out.print("\nDo you want to play again? (yes/no): ");
            String playAgain = scanner.next().trim().toLowerCase();
            if (!playAgain.equals("yes")) {
                System.out.println("\nThanks for playing! You played " + roundsPlayed + " rounds and earned a total of " + totalScore + " points!");
                break;
            }
        }

        scanner.close();
    }
}
