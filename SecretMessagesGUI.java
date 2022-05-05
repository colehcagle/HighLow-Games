//This is a program that expands on the previously created Secret Messages game. It expands by using a GUI that is user-friendly. Simply, type in a message and
//select a key between -25 and 25 to encrypt the message. Then, copy and paste the encrypted message and use the slider or text field to decrypt it. Click the
//button to encode or decode your message.
//@author Cole Cagle
//@version 05/04/2022

//Tells program to interact with GUI.
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JScrollPane;

//Creates the superclass.
public class SecretMessagesGUI extends JFrame {
	//Defines the variables.
	private JTextField txtKey;
	private JTextArea txtIn;
	private JTextArea txtOut;
	private JSlider slider;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	
	//Creates the encode method.
	public String encode( String message, int keyVal ) {
		String output = "";
		char key = (char) keyVal;
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
			return output;
	}
	
	//The constructor for the GUI.
	public SecretMessagesGUI() {
		getContentPane().setBackground(new Color(135, 206, 235));
		setTitle("Cole's Secret Message App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 564, 140);
		getContentPane().add(scrollPane);
		
		//Creates the input text display.
		txtIn = new JTextArea();
		scrollPane.setViewportView(txtIn);
		txtIn.setWrapStyleWord(true);
		txtIn.setLineWrap(true);
		txtIn.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 210, 564, 140);
		getContentPane().add(scrollPane_1);
		
		//Creates the output text display.
		txtOut = new JTextArea();
		scrollPane_1.setViewportView(txtOut);
		txtOut.setWrapStyleWord(true);
		txtOut.setLineWrap(true);
		txtOut.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
		
		//Creates the text field to hold the encryption/decryption key.
		txtKey = new JTextField();
		txtKey.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtKey.setText("3");
		txtKey.setBounds(264, 179, 44, 20);
		getContentPane().add(txtKey);
		txtKey.setColumns(10);
		
		//Creates the label for the text field.
		JLabel lblKey = new JLabel("Key:");
		lblKey.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKey.setBounds(217, 182, 46, 14);
		getContentPane().add(lblKey);
		
		//Creates the button to encode/decode.
		JButton btnEncDec = new JButton("Encode/Decode");
		btnEncDec.setBackground(new Color(169, 169, 169));
		//Creates an event listener for the button in the GUI.
		btnEncDec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Creates a try-catch block to handle bad user input.
				try {
					String message = txtIn.getText();
					int key = Integer.parseInt( txtKey.getText() );
					String output = encode( message, key );
					txtOut.setText( output );
				} catch (Exception ex) {
					//Displays an error message to user if encryption key is not a whole number.
					JOptionPane.showMessageDialog(null,
							"Please enter a whole number value for the encryption key.");
					txtKey.requestFocus();
					txtKey.selectAll();
				}
			}
		});
		btnEncDec.setBounds(318, 178, 151, 23);
		getContentPane().add(btnEncDec);
		
		//Creates a slider.
		slider = new JSlider();
		//Creates an event listener for the slider in the GUI.
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				txtKey.setText( "" + slider.getValue() );
				String message = txtIn.getText();
				int key = slider.getValue();
				String output = encode( message, key );
				txtOut.setText( output );
			}
		});
		slider.setValue(3);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(13);
		slider.setMinorTickSpacing(1);
		slider.setMinimum(-26);
		slider.setMaximum(26);
		slider.setPaintLabels(true);
		slider.setBackground(new Color(135, 206, 235));
		slider.setBounds(31, 162, 188, 37);
		getContentPane().add(slider);
	}
	
	//Creates the main method.
	public static void main(String[] args) {
		SecretMessagesGUI theApp = new SecretMessagesGUI();
		theApp.setSize(new java.awt.Dimension(600, 400));
		theApp.setVisible(true);
	}
}