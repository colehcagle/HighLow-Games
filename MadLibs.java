
/**
 * This is a Java program that allows the user to play the game, MadLibs. The program will prompt the user for nouns, adjectives, verbs, etc to create the MadLib.
 *
 * @author Cole Cagle
 * @version 04/25/2022
 */
//Tells the program to take input from the keyboard.
import java.util.Scanner;

//Creates the class.
public class MadLibs {
    //Creates the main method.
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        //Allows the user to play again.
        String playAgain = "";
        String noun1 = "";
        String verb1 = "";
        String verb2 = "";
        String noun2 = "";
        String noun3 = "";
        String adj1 = "";
        String verb3 = "";
        String verb4 = "";
        String adj2 = "";
        String noun4 = "";
        System.out.println("Enter a noun: ");
        noun1 = scan.next();
        System.out.println("Enter a verb: ");
        verb1 = scan.next();
        System.out.println("Enter another verb: ");
        verb2 = scan.next();
        System.out.println("Enter a noun: ");
        noun2 = scan.next();
        System.out.println("Enter another noun: ");
        noun3 = scan.next();
        System.out.println("Enter an adjective: ");
        adj1 = scan.next();
        System.out.println("Enter a verb: ");
        verb3 = scan.next();
        System.out.println("Enter another verb: ");
        verb4 = scan.next();
        System.out.println("Enter an adjective: ");
        adj2 = scan.next();
        System.out.println("Enter a noun: ");
        noun4 = scan.next();
        System.out.println("The " + noun1 + " were " + verb1 + " after their ");
        System.out.println(verb2 + " twirling " + noun2 + " through the crisp night air. ");
        System.out.println("Every " + noun3 + " in the forest wore a new coat of ");
        System.out.println(adj1 + " white. Daybreak came softly " + verb3 + " through ");
        System.out.println("the woods and " + verb4 + " as its rays " + adj2 + " stretched ");
        System.out.println("across the snowy " + noun4 + ".");
        //Output to ask if user wants to play the game again.
        System.out.println("Do you want to play again (y/n)?");
        playAgain = scan.next();
        //If y is entered, user wants to play again.
        while (playAgain.equalsIgnoreCase("y"));
        //If n is entered, user wants to quit playing.
        System.out.println("Thank you for playing!");
        scan.close();
        }
    }
