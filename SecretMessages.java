//This is a Java program that allows the user to enter a message or more and select a secret key between -25 and 25. The program
//uses the letters A through Z, a through z, and digits 0 through 9. Messages can be encrypted or decrypted as needed.
//@author Cole Cagle
//@version 04/26/2022

//Tells the program to take input from the keyboard.
import java.util.Scanner;

//Creates the class.
public class SecretMessages {
	//Creates the main method.
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a message to encode/decode: ");
		//This variable holds the user input.
		String message = scan.nextLine();
		//This variable will hold the altered string.
		String output = "";
		//Allows the user to choose their own key.
		System.out.println("Enter a secret key (-25 to 25): ");
		int keyVal = Integer.parseInt(scan.nextLine());
		char key = (char) keyVal;
		//Allows the user to enter multiple messages if wanted.
		while (message.length() > 0) {
			//Uses the Caesar cipher to encode/decode messages.
			for (int i = 0; i < message.length(); i++) {
				char input = message.charAt(i);
				//Keeps the cipher between capital letters A through Z.
				if (input >= 'A' && input <= 'Z') {
					input += key;
					if (input > 'Z')
						input -= 26;
					if (input < 'A')
						input += 26;
				}
				//Keeps the cipher between lowercase letters a through z.
				else if (input >= 'a' && input <= 'z') {
					input += key;
					if (input > 'z')
						input -= 26;
					if (input < 'a')
						input += 26;
				}
				//Keeps the cipher between digits 0 through 9.
				else if (input >= '0' && input <= '9') {
					input += (keyVal % 10);
					if (input > '9')
						input -= 10;
					if (input < '0')
						input += 10;
				}
				output += input;
			}
			//Displays the reversed string or vice-versa.
			System.out.println(output);
			//Loops the process again if the user has more messages to enter.
			output = "";
			System.out.println("\nEnter a message to encode/decode: ");
			message = scan.nextLine();
			System.out.println("Enter a secret key (-25 to 25): ");
			keyVal = Integer.parseInt(scan.nextLine());
			key = (char) keyVal;
		}
		//Closes the input/output to avoid resource leaks.
		scan.close();
	}

}