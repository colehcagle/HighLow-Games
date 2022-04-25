
/**
 * This is a Java program that is a guessing game called High-Low. The user will simply attempt to guess the randomly generated number between -100 and 100. The program will also
 * count how many tries it took to guess the number and output the result to the user.
 *
 * @author Cole Cagle
 * @version 04/25/2022
 */
//Tells the program to take input from the keyboard.
import java.util.Scanner;

//Creates the class.
public class HighLow {
    //Creates the main method.
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        //Allows the user to play the game again.
        String playAgain = "";
        do {
            //Creates a randomly generated value between -100 and 100.
            int num = (int)(Math.random() * 200 - 100);
            int guess = 0;
            int count = 0;
            //While loop that outputs if the input was too high, too low, or correct.
            while (guess != num) {
                System.out.println("Guess a number between -100 and 100: ");
                guess = scan.nextInt();
                count++;
                if (guess < num)
                    System.out.println(guess + " is too low! Try again!");
                else if (guess > num)
                    System.out.println(guess + " is too high! Try again!");
                else
                    System.out.println(guess + " is correct! You win! It took you " + count + " tries!");
            }
            //Output to ask if user wants to play the game again.
            System.out.println("Do you want to play again (y/n)?");
            playAgain = scan.next();
        }
        //If y is entered, user wants to play again.
        while (playAgain.equalsIgnoreCase("y"));
        //If n is entered, user wants to quit playing.
        System.out.println("Thank you for playing!");
        scan.close();
    }
}
