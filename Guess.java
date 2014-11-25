package q2;

import java.util.Scanner;
import java.util.Random;

/**
 * <p>Hi-Lo guessing game with numbers. The program will pick a number between 1
 * and 100 then ask for user input. The program will then report to the user
 *  whether he or she is correct or the guess is high or low. The game
 *  will continue until the
 * user wishes to stop.</p>
 *
 * @author Tseng, Chih
 * @version 1.0
 */
public class Guess {
    /**
     * <p>This is the main method (entry point) that gets called by the JVM.</p>
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        final int hi = 100;
        final int lo = 1;
        int guess;
        int numGuesses = 0;
        int winningValue;
        String input;
        String yes = "yes";
        

        Random gen = new Random();
        Scanner scan = new Scanner(System.in);

        winningValue = gen.nextInt(hi + lo);

        do {
            System.out.println("Guess a number between 1 and 100:");
            guess = scan.nextInt();
            numGuesses++;
            if ((guess < lo) || (guess > hi)) {
                throw new IllegalArgumentException("Invalid guess");
            }
            if (guess == winningValue) {
                System.out.println("Congratulations! You won!");
                System.out.println("You have guessed " + numGuesses 
                        + " times.");
            } else if (guess < winningValue) {
                System.out.println("Incorrect, your guess is low.");
            } else if (guess > winningValue) {
                System.out.println("Incorrect, your guess was too high");
            }
            System.out.println("Would you like to try again?(yes/no)");
            input = scan.next();
        }
        while (input.equalsIgnoreCase(yes));
        
        System.out.println("Thank you for playing, goodbye.");

        scan.close();
    }

};
