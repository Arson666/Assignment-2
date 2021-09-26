//Class: CMSC203 CRN 24307 
//Program: Assignment #2 
//Instructor: Ping-Wei Tsai 
//Summary of Description: this program will receive a guess and report if the user’s guess is the random number that was generated.
//The application will narrow down the choices according to the user’s previous guesses and continue to prompt the user to enter a guess until the user guesses correctly 
//Due Date: 9/26/2021 
//Integrity Pledge: I pledge that I have completed the programming assignment independently. 
//I have not copied the code from a student or any source. 
//Student’s Name: Anna Downey 

import java.util.Scanner;

public class RandomNumberGuesser
{
	@SuppressWarnings("static-access")
	public static void main(String[] args)
	{
		//declare the variables
		int nextGuess;
		int highGuess;
		int lowGuess;
		int randNum;
		String answer = " ";
		boolean x;
		
		//declare the objects
		RNG obj = new RNG();
		Scanner sc = new Scanner(System.in);
		
		//do while loop that loops when user inputs yes
		do 
		{
			//resets count, low & high guesses, and generates new number
			lowGuess = 0;
			highGuess = 100;
			nextGuess = 0;
			obj.resetCount();
			randNum = RNG.rand();
			
			//ask user for input
			System.out.print("Please enter your first guess: \n");
			nextGuess = sc.nextInt();
			
			//do while loop that narrows down the the range of possible numbers with user input
			do
			{
				//if else statement that sets lowest range and highest range
				if(nextGuess > randNum)
				{
					System.out.println("Number of guesses is " + (obj.getCount() + 1));
					System.out.print("Your guess is too high\n");
					highGuess = nextGuess;
					System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess + "\n");
					
					//input validation do while loop
					do
					{
						nextGuess = sc.nextInt();
						x = RNG.inputValidation(nextGuess, lowGuess, highGuess);
					} while( x != true);
				}
				else
				{
					System.out.println("Number of guesses is " + (obj.getCount() + 1));
					System.out.print("Your guess is too low\n");
					lowGuess = nextGuess;
					System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess + "\n");
					
					//input validation do while loop
					do
					{
						nextGuess = sc.nextInt();
						x = RNG.inputValidation(nextGuess, lowGuess, highGuess);
					} while( x != true);
				}
			}while(nextGuess != randNum);
			
			//congratulate user and ask them if they want to play again with print statements
			System.out.print("Congratulations, you guessed correctly\n");
			System.out.print("Try again? (yes or no): ");
            answer = sc.next();
            System.out.print("\n");
		}while(answer.equalsIgnoreCase("yes"));
		
		//print name with statements, close scanner, and close program
		System.out.print("Anna Downey");
		sc.close();
		System.exit(0);
	}
}
