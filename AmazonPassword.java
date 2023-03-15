package AmazonPassword;
import java.io.*;
import java.util.Scanner;
public class AmazonPassword {
	/*
	 * Ramatoulaye Kebe
	 * program evaluates passwords
	 * and determines whether they're valid or not 
	 * Based on a specific criterion
	 */
public static void main(String[] args) throws Exception {
	Scanner inFile = new Scanner(new File
			("amazonPasswords.txt"));
	PrintWriter outFile = new PrintWriter("myOutput05.txt");
	boolean isCorrect;
	String myPassword;

	outFile.println("Ramatoulaye Kebe");
	outFile.println("Program #5");
	outFile.println();
	
	while(inFile.hasNextLine()) {
		myPassword = inFile.nextLine();
		outFile.print("\"" + myPassword.trim()+ "\" ");
	isCorrect = isValid(myPassword);
	if(isCorrect) {
		outFile.println("is valid.");
		}
	else {
		outFile.println("is invalid.");
		}
	}
	outFile.println();
	outFile.println("End of program.");
	
	inFile.close();
	outFile.close();
}
/*
 * isValid method receives a string userPassword as parameter 
 * and evaluates it
 * determining whether it's valid or not 
 * based on a specific criterion
 * method returns a boolean variable isCorrect
 */
public static boolean isValid(String userPassword) {
	boolean isCorrect = true;
	String checkSymbol = "@*#%?!";
	int p = userPassword.indexOf(" ");
	int countSpace = 0;
	int countUpperCase =0;
	int countLowerCase = 0;
	int countDigit = 0;
	int countSymbol = 0; 
	
	//password should be at least 8 characters
	if((userPassword.length() - 1) < 8) {
		return isCorrect = false;
		}
	/*
	 * needs to contain at least : 
	 * one upper case letter 
	 * one lower case letter
	 * and one digit
	 */
	for(int i = 0; i < userPassword.length(); i++) {

		if(Character.isUpperCase(userPassword.charAt(i))) {
			countUpperCase++;
		}
		if(Character.isLowerCase(userPassword.charAt(i))) {
			countLowerCase++;
		}
		if(Character.isDigit(userPassword.charAt(i))) {
			countDigit++;
		}
	}
	if(countUpperCase < 1 
			|| countLowerCase < 1 
			|| countDigit < 1) {
		return isCorrect = false;
	}
	
		//password may not contain a blank
		while(p != -1) { //there's a space
			countSpace++;
			p = userPassword.indexOf(" ", p + 1);
		}
		if(countSpace >= 1) {
			return isCorrect = false;
		}
		
		//needs to contain at least one symbol
		for(int i = 0; i < userPassword.length(); i++) {
			for(int j = 0; j < checkSymbol.length(); j++) {
				if(checkSymbol.charAt(j) == userPassword.charAt(i)) {
					countSymbol++;
				}
			}
		}
		if(countSymbol < 1) {
			return isCorrect = false;
		}
	return isCorrect;
}
}
