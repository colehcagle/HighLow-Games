//This is a Java program that is a High-Low guessing game that expands on the code previously written. This program uses a GUI to create a better experience for the user.
//The user will attempt to guess a randomly generated value between -100 and 100. The program will also keep up with the amount of tries it takes the user to guess correctly.
//@author Cole Cagle
//@version 04/25/2022

//Allows the program to interact with the GUI.
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

//Creates the superclass.
public class GuessingGame extends JFrame {
	//Defines the variables located in the GUI.
	private JTextField txtGuess;
	private JLabel lblOutput;
	private int num;
	private int count = 0;
	
	//Creates a method to check the user's guesses.
	public void checkGuess() {
		//Holds the number the user enters in the text field from the GUI.
		String guessText = txtGuess.getText();
		//Increments every time a guess is made and keeps track of total guesses.
		count++;
		//Holds the output messages regarding the guess from the user.
		String message = "";
		//An exception catcher for bad data input from user.
		try {
		//Tells the program to search for an integer value.
		int guess = Integer.parseInt(guessText);
		//Checks the user entered value to the randomly generated number.
		if (guess < num)
			message = guess + " is too low! Try again!";
		else if (guess > num)
			message = guess + " is too high! Try again!";
		else {
			message = guess + " is correct! You won in " + count + " tries! Let's play again!";
			//Starts a new game upon a correct guess.
			newGame();
		} 
	} catch (Exception e) {
		message = "Enter a whole number between -100 and 100.";
	} finally {
		//Updates the label in the GUI to display the output messages above.
		lblOutput.setText(message);
		//Automatically selects the input box on the GUI after making a guess.
		txtGuess.requestFocus();
		//Automatically selects all input in the input box on the GUI.
		txtGuess.selectAll();
	}
	}
	
	//Creates a method to generate a random number between -100 and 100.
	public void newGame() {
		num = (int)(Math.random() * 200 - 100);
	}
	
	//Creates a method for the GUI of the game.
	public GuessingGame() {
		setForeground(Color.WHITE);
		getContentPane().setBackground(Color.DARK_GRAY);
		//Creates the title of the GUI.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Cole Cagle's High-Low Guessing Game");
		getContentPane().setLayout(null);
		
		//Creates the header for the GUI.
		JLabel lblNewLabel = new JLabel("Cole Cagle's High-Low Guessing Game");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 30, 414, 35);
		getContentPane().add(lblNewLabel);
		
		//Creates a label for the GUI to specify the range.
		JLabel lblNewLabel_1 = new JLabel("Enter a number between -100 and 100:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(60, 95, 224, 25);
		getContentPane().add(lblNewLabel_1);
		
		//Creates the input box for the number guessed by the user.
		txtGuess = new JTextField();
		txtGuess.setHorizontalAlignment(SwingConstants.RIGHT);
		txtGuess.setBounds(294, 97, 60, 20);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);
		//Creates an event listener that lets user use the enter key to take action.
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		
		//Creates a button for the user to press to check their input to the randomly generated number.
		JButton btnNewButton = new JButton("Guess!");
		//Creates an event listener to take action when the button is clicked in the GUI.
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(177, 150, 89, 23);
		getContentPane().add(btnNewButton);
		
		//Creates a label that has instructions for the user.
		lblOutput = new JLabel("Enter a number above and click the button to guess.");
		lblOutput.setForeground(Color.WHITE);
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(60, 203, 306, 25);
		getContentPane().add(lblOutput);
	}

	//Creates the main method that tells the program how to start the game with the GUI.
	public static void main(String[] args) {
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(750,600));
		theGame.setVisible(true);
	}
}
