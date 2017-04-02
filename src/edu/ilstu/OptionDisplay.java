package edu.ilstu;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This class contains methods to display messages to the user.
 * 
 * @author Christopher A Runyan
 */
public class OptionDisplay{
	/**
	 * Shows an invalid entry error message.
	 */
	static void displayInvalidEntryError(){
		JOptionPane.showMessageDialog(new JFrame(),
			    "Invalid number. Please enter a valid number.\n\nValid entries contain: \n"
			    + "- Integers\n- Negative values\n- Decimals\n- Scientific method (i.e. \"5.4e4\" for 54,000)",
			    "Invalid Input",
			    JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Shows a welcome message to the user with information on how to use the program.
	 */
	static void displayWelcomeMessage(){
		JOptionPane.showMessageDialog(new JFrame(),
			    "Enter desired value in text area of corresponding unit.\n\n"
			    + "Valid entries contain: \n"
			    + "- Integers\n- Negative values\n- Decimals\n- Scientific method (i.e. \"5.4e4\" for 54,000)",
			    "Welcome",
			    JOptionPane.PLAIN_MESSAGE);
	}
	
	/**
	 * Shows a critical error message to the user if a critical error occurs.
	 */
	static void displayCriticalErrorMessage(){
		JOptionPane.showMessageDialog(new JFrame(),
			    "A critical error has occurred and the program has terminated.",
			    "Critical Error",
			    JOptionPane.PLAIN_MESSAGE);
	}
}
