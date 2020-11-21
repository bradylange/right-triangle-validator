package exceptions;

/*
 * Developer: Brady Lange
 * Course: Object-Oriented Programming - CSIS 235
 * Class: NegativeNumberException
 * Language: Java
 * Date: 12/15/17
 * Description: This class contains attributes related to an input that is negative.
 */

// This class throws an exception when a users input is negative and is an Exception 
@SuppressWarnings("serial")
public class NegativeNumberException extends Exception 									// Is an Exception 
{
// ------------------- Default Constructor -------------------
	// Default Constructor that details the input cannot be a negative number 
	public NegativeNumberException() 
	{
		super("Cannot be a negative number.");											// Exception message 
	}
// ------------------- End Default Constructor -------------------
} // End of class NegativeNumberException
