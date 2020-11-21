package right_triangle_checker;

// Import libraries for the graphics on the application
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import exceptions.NegativeNumberException;

/*
 * Developer: Brady Lange
 * Course: Object-Oriented Programming - CSIS 235
 * Class: RightTriangleChecker
 * Language: Java
 * Date: 12/15/17
 * Description: This class contains attributes related to a right triangle and checks if users input can make a right triangle.
 */

// This class contains methods and handlers to a create a graphical user interface on checking if 3 sides of a triangle makes it a right triangle 
@SuppressWarnings("serial")
public class RightTriangleChecker extends JFrame 
{
	// Instance variables
	private static final int WIDTH = 500;													// Width of the application container
	private static final int HEIGHT = 500;													// Height of the application container 
	private JLabel sideOneL, sideTwoL, sideThreeL, resultL;									// Labels of the application
	private JTextField sideOneTF, sideTwoTF, sideThreeTF, resultTF;							// Text fields of the application
	private JButton checkB, exitB;															// Buttons of the application 
// ------------------- Default Constructor -------------------
	// Default Constructor
	public RightTriangleChecker() 
	{
		// Instantiate default properties 
		// Set the title of the application
		setTitle("Right Triangle Checker");
		
		// Labels on the form
		sideOneL = new JLabel("Enter the length of side one: ", SwingConstants.RIGHT);		// Set text to the right side of the text field 
		sideTwoL = new JLabel("Enter the length of side two: ", SwingConstants.RIGHT);		// Set text to the right side of the text field 
		sideThreeL = new JLabel("Enter the length of side three: ", SwingConstants.RIGHT);	// Set text to the right side of the text field 
		resultL = new JLabel("Right Triangle? ", SwingConstants.RIGHT);						// Set text to the right side of the text field 
		
		// Text Fields on the form
		sideOneTF = new JTextField(10);
		sideTwoTF = new JTextField(10);
		sideThreeTF = new JTextField(10);
		resultTF = new JTextField(10);
		resultTF.setEditable(false);

		// Buttons on the form
		checkB = new JButton("Check");														// Create Check button to perform main function of the application
		CheckButtonHandler cbHandler = new CheckButtonHandler();							// Set event handler for the Check button
		checkB.addActionListener(cbHandler);												// Add action listener 
		exitB = new JButton("Exit");														// Create Exit button to exit the application 
		ExitButtonHandler ebHandler = new ExitButtonHandler();								// Set event handler for the Exit button 
		exitB.addActionListener(ebHandler);													// Add action listener 
			
		// Container of the form 
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(5,2));												// Grid layout of the form 
		
		// Add elements into the application's form (graphics user interface)
		pane.add(sideOneL);																	// Add side one's label
		pane.add(sideOneTF);																// Add side one's text field
		pane.add(sideTwoL);																	// Add side two's label
		pane.add(sideTwoTF);																// Add side two's text field
		pane.add(sideThreeL);																// Add side three's label
		pane.add(sideThreeTF);																// Add side three's text field
		pane.add(resultL);																	// Add result's label
		pane.add(resultTF);																	// Add result's text field
		pane.add(checkB);																	// Add Check's button
		pane.add(exitB);																	// Add Exit's button 
		
		setSize(WIDTH, HEIGHT);																// Size of the application in width and height 
		setDefaultCloseOperation(EXIT_ON_CLOSE);											// Default close operations	 
		setVisible(true);																	// Make the graphic user interface form visible 
	}
// ------------------- End Default Constructor -------------------
	
// ------------------- Check Button Handler Class -------------------
	// Method that handles when the check button is clicked -- Validates if the triangle data is a right triangle
	public class CheckButtonHandler implements ActionListener
	{
// ------------------- Action Performed Method -------------------
		// Method that performs the action to be done once the button is clicked
		// Overrides ActionListener's method 
		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			// Local variables
			double sideOne = 0, sideTwo = 0, sideThree = 0;									// Sides
			boolean check = false;															// Stores if the triangle is a right triangle 
			
        	// Side one of the triangle
        	boolean sideOneDone = false;
        	do 																				// Make sure the user enters in an appropriate input, continue until they do
        	{
        		// Try block:
				try 
				{ 
					sideOne = Double.parseDouble(sideOneTF.getText());						// Get the input from side one's text field 
					if (sideOne <= 0) 														// Number input is negative, throw an exception
					{ 
						sideOneTF.setBackground(Color.red);									// Set side one's text field background to red to indicate error 
						throw new NegativeNumberException();								// Throw negative number exception 
					}
					sideOneTF.setBackground(Color.green);									// Correct input type, set side one's text field background to green to indicate success
					sideOneDone = true;														// Side one is finished 
				}
				// Catch blocks:
				catch (NegativeNumberException nne)											// Negative number input exception 
				{
					sideOneTF.setBackground(Color.red);										// Set side one's text field background color to red to indicate error 
					sideOneTF.setText(JOptionPane.showInputDialog(nne.toString()));			// Display negative number error to the user 
				}
				catch (NumberFormatException nfe)											// Non-numeric input exception
				{
					sideOneTF.setBackground(Color.red);										// Set side one's text field background color to red to indicate error 
					sideOneTF.setText(JOptionPane.showInputDialog(sideOneTF, "Invalid input:\nMust be a numeric value and cannot be null. \nEnter side one: ", 
							"Invalid Input", JOptionPane.ERROR_MESSAGE));					// Display not valid input error to the user 
				}
				
        	} while (!sideOneDone);															// Continue until the side one's input is correct 

			// Side two of the triangle
	        boolean sideTwoDone = false;													// Side two is not finished 														
			do 																				// Make sure the user enters in an appropriate input, continue until they do				
			{
				// Try block:
				try 																		
				{
					sideTwo = Double.parseDouble(sideTwoTF.getText());						// Get side two's text input 
					if (sideTwo <= 0) 														// Number input is negative, throw an exception
					{
						sideTwoTF.setBackground(Color.red);									// Set background color of side two's text  field to red to indicate error
						throw new NegativeNumberException();								// Throw negative number exception
					}
					sideTwoTF.setBackground(Color.green);									// Correct input type, change side two's text field background color to green to indicate success
					sideTwoDone = true;														// Side two is finished
				}
				// Catch blocks:
				catch (NegativeNumberException nne)											// Negative number input exception 
				{
					sideTwoTF.setBackground(Color.red);										// Set background color of side two's text field to red to indicate an error
					sideTwoTF.setText(JOptionPane.showInputDialog(nne.toString()));			// Display negative number error to the user 
				}
				catch (NumberFormatException nfe)											// Non-numeric input exception
				{
					sideTwoTF.setBackground(Color.red);										// Set background color of side two's text field to red to indicate error
					sideTwoTF.setText(JOptionPane.showInputDialog(sideOneTF, "Invalid input:\nMust be a numeric value and cannot be null. \nEnter side two: ", 
							"Invalid Input", JOptionPane.ERROR_MESSAGE));					// Display not valid input error to the user 
				}
				
			} while (!sideTwoDone);															// Continue until the side two's input is correct

			// Side three of the triangle
			boolean sideThreeDone = false;
			do 																				// Make sure the user enters in an appropriate input, continue until they do
			{
				// Try block:
				try 
				{
					sideThree = Double.parseDouble(sideThreeTF.getText());					// Get the side three's text input 
					if (sideThree <= 0) 													// Number input is negative, throw an exception
					{ 
						sideThreeTF.setBackground(Color.red);								// Set background color of side three's text field to red to indicate an error
						throw new NegativeNumberException();								// Throw negative number exception 
					}
					sideThreeTF.setBackground(Color.green);									// Correct input type, change side three's text field background color to green to indicate success
					sideThreeDone = true;													// Side three is finished 
				}
				// Catch blocks:
				catch (NegativeNumberException nne)											// Negative number input exception 
				{
					sideThreeTF.setBackground(Color.red);									// Set background color of side three's text field to red to indicate error
					sideThreeTF.setText(JOptionPane.showInputDialog(nne.toString()));		// Display negative number error to the user 
				}
				catch (NumberFormatException nfe)											// Non-numeric input exception
				{
					sideThreeTF.setBackground(Color.red);									// Set background color of side three's text field to red to indicate error
	            	sideThreeTF.setText(JOptionPane.showInputDialog(sideOneTF, "Invalid input:\nMust be a numeric value and cannot be null. \nEnter side three: ", 
							"Invalid Input", JOptionPane.ERROR_MESSAGE));					// Display not valid input error to the user 
				}
				
			} while (!sideThreeDone);														// Continue until the side three's input is correct 
				
			// Make the sides squared
			sideOne = Math.pow(sideOne, 2);
			sideTwo = Math.pow(sideTwo, 2);
			sideThree = Math.pow(sideThree, 2);
			
			// Check if the sides possess right triangle traits
			if ((sideOne + sideTwo) == sideThree || (sideThree + sideTwo) == sideOne || (sideThree + sideOne) == sideTwo)	// Sides make a right triangle
			{
				resultTF.setFont(new Font("Times New Roman", Font.BOLD, 40));				// Set result text field's font	
				resultTF.setBackground(Color.green);										// Change result text field's background color to green to indicate the triangle is a right triangle 
				check = true;
			}
			else 																			// Sides do not make a right triangle 
			{ 
				resultTF.setFont(new Font("Slab Serifs", Font.BOLD, 50));					// Set result text field's font
				resultTF.setBackground(Color.red);											// Change result text field's background color to red to indicate the triangle is not a right triangle
				check = false;
			}
			
	    	resultTF.setText(String.valueOf(check));										// Print the answer to result text field if it is a right triangle
		} 
// ------------------- End Action Performed Method -------------------
	}
// ------------------- End Check Button Handler Class -------------------
	
// ------------------- Exit Button Handler Class -------------------
	// Method that handles when the exit button is clicked -- Closes the application
	public class ExitButtonHandler implements ActionListener
	{
// ------------------- Action Performed Method -------------------
		// Method that performs the action to be done once the button is clicked
		// Overrides ActionListener's method 
		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			System.exit(0);																	// Exit the application														
		} 
// ------------------- End Action Performed Method -------------------	
	} 
// ------------------- End Exit Button Handler Class -------------------
	
// ------------------- Main Method -------------------
	// Method that compiles and runs the program 
	public static void main(String [] args)
	{
		System.out.println("***************************************** Right Triangle Checker: *******************************************");
		// Instantiate the right triangle checker object
		@SuppressWarnings("unused")
		RightTriangleChecker rightTriangleApp = new RightTriangleChecker();
		System.out.println("Successful build.");
		System.out.println("*********************************************************************************************\n");
	}
// ------------------- End Main Method -------------------
} // End of class RightTriangleChecker
	
	


