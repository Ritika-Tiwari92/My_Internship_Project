package Saiket_Internship.Task4;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {

        // 🎨 ANSI color codes for colorful console output
        final String RESET = "\u001B[0m";
        final String RED = "\u001B[31m";
        final String GREEN = "\u001B[32m";
        final String YELLOW = "\u001B[33m";
        final String BLUE = "\u001B[34m";
        final String CYAN = "\u001B[36m";
        final String PURPLE = "\u001B[35m";

        // Create Random and Scanner objects
        Random random = new Random(); // creates an obj of Random class to generrate a random number
        Scanner sc = new Scanner(System.in); // creates an obj of Scanner class to take user input

        int guess; // variable to store the current guess
        int attempts = 0; // counts how many times the player tried guessing
        int randomNumber = random.nextInt(1, 11); // generates random number between 1–10

        // Game Title
        System.out.println(PURPLE + "🎯 Welcome to the Number Guessing Game! 🎯" + RESET);
        System.out.println(BLUE + "Guess a number between 1 and 10:" + RESET);

        // Game Loop
        do {
            System.out.print(CYAN + "👉 Enter your guess: " + RESET);
            guess = sc.nextInt(); // take user input
            attempts++; // increase attempt count

            if (guess < randomNumber) {
                System.out.println(YELLOW + "⚠️ TOO LOW!! TRY AGAIN" + RESET);
            } else if (guess > randomNumber) {
                System.out.println(RED + "🚫 TOO HIGH!! TRY AGAIN" + RESET);
            } else {
                System.out.println(GREEN + "✅ Correct!! The number was " + randomNumber + RESET);
                System.out.println(PURPLE + "🎉 Number of attempts: " + attempts + RESET);
            }

        } while (guess != randomNumber); // loop continue until the player guess the correct number

        System.out.println(GREEN + "🏆 You Won the Game! 🏆" + RESET);
    }
}
