import java.util.Random;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerLimit = 1;
        int upperLimit = 100;
        int maxAttempts = 10;
        int score = 0;

        System.out.println("Welcome to the Guess the Number game!");

        boolean playAgain = true;
        while (playAgain) {
            int numberToGuess = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
            int attempts = 0;

            System.out.printf("I'm thinking of a number between %d and %d.%n", lowerLimit, upperLimit);

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess;
                try {
                    userGuess = scanner.nextInt();
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.nextLine();  // Clear the invalid input from the buffer
                    continue;
                }

                attempts++;

                if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try a higher number.");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high! Try a lower number.");
                } else {
                    System.out.printf("Congratulations! You guessed the number %d in %d attempts!%n", numberToGuess, attempts);
                    score++;
                    break;
                }
            }

            if (attempts >= maxAttempts) {
                System.out.printf("Sorry, you've reached the maximum number of attempts. The correct number was %d.%n", numberToGuess);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            if (!playAgainInput.equals("yes")) {
                System.out.printf("Your final score: %d%n", score);
                System.out.println("Thanks for playing!");
                playAgain = false;
            }
        }
        scanner.close();
    }
}
