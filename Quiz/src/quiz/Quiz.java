package quiz;

import java.util.Scanner;

public class Quiz {

	public static void main(String[] args) {

		Scanner input2 = new Scanner(System.in);

		String choice;
		QuizMethods quiz = new QuizMethods();

		System.out.println("Welcome to Algonquin student quiz \n\n"
				+ "You will get 6 questions, 3 open questions & 3 multiple choice questions\n\n"
				+ "Let's start with open questions, "
				+ "\n\n" + "The answer is a one word or a letter, "
						+ "\n\nGood luck!\n");

		do {
			quiz.askQuestions();
			quiz.displayScore();

			System.out.println("would you like to play again? Type 'yes' or 'no'");
			choice = input2.nextLine();
		} while (choice.equalsIgnoreCase("yes"));

		if (choice.equalsIgnoreCase("no")) {
			System.out.println("I guess you didn't enjoy the quiz...Goodbye!");
		}
		input2.close();

	}
}
