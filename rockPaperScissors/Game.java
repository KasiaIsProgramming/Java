//Katarzyna (Kasia) Gocal, June 26,2019, Game: rock paper scissors 
//declare three strings rock, paper and scissors
//declare 2 variables one for user's input one for computer generated choice
//use nested if statements to asses who won
//use random class
//play possibilities "R", "P", or "S" 
//Try and catch catching invalid string input

package rockPaperScissors;

import java.util.Scanner;
import java.util.Random;

public class Game {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in); // new scanner object for users input
		Scanner choiceInput = new Scanner(System.in); // new scanner object for "do you want to play"
		Random generator = new Random(); // new generator object

		String humanPlay = "", computerPlay = "";
		int choice=0;
		int randomInt; // variable for the random play

		System.out.println("Hello, let's play some Rock, Paper, Scifssors\n"
				+ "possible moves:\n Rock = r, Paper= p, and Scissors = s\n");
		
		do {
				System.out.println("Enter your play: ");
	
				try {
					humanPlay = input.nextLine();
					if (!(humanPlay.equals("r") || humanPlay.equals("p") || humanPlay.equals("s"))) {
						throw new Exception("You entered incorrect choice. Try Again!!!");
					} else {
						randomInt = generator.nextInt(3) + 1; // generate comp play
						// assign numbers to comp play
						if (randomInt == 1)
							computerPlay = "r";
						else if (randomInt == 2)
							computerPlay = "p";
						else if (randomInt == 3)
							computerPlay = "s";
						System.out.println("Computer play is: " + computerPlay);
						if (humanPlay.equals(computerPlay))
							System.out.println("It's a tie!");
						else if (humanPlay.equals("r")) {
							if (computerPlay.equals("s"))
								System.out.println("You win!!");
							else if (computerPlay.equals("p"))
								System.out.println("You lose!!");
						} else if (humanPlay.equals("s")) {
							if (computerPlay.equals("r"))
								System.out.println("You Lose!!");
							else if (computerPlay.equals("p"))
								System.out.println("You win!!");
						} else if (humanPlay.equals("p")) {
							if (computerPlay.equals("r"))
								System.out.println("You win!!");
							else if (computerPlay.equals("s"))
								System.out.println("You lose!!");
						}
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			
			
		System.out.println("Do You Want To Play Again?\n");
		System.out.print("Enter 1 for Yes or 0 For No : ");
			
							try {
								choice = choiceInput.nextInt();
								if (choice !=0 && choice !=1)
								throw new Exception("Dont u know digits? Enter 1 or 2");
								
							while (!(choice == 0) && !(choice == 1)) {
								System.out.println("try again: ");
								choiceInput.nextLine();
								System.out.println("Do You Want To Play Again?\n");
								System.out.print("Enter 1 for Yes or 0 For No : ");
								choice = choiceInput.nextInt();
																	}
							}
							catch(Exception msg){
								System.out.println(msg);
								choice = 0;
								}

		} while (choice == 1);
		if (choice == 0) {
			System.out.print("Hope to never see you again here");
		}


	}
}
