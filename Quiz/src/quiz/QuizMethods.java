package quiz;

import java.util.Scanner;

public class QuizMethods 
{
	private int score;
	private String[] answer = new String[6];
	private int question = 0;
	Scanner input = new Scanner(System.in);
	
	public void askQuestions() 
	{
		System.out.println("QUESTION " + (question+1) + ". What colour is Algonquin's logo");
		getAnswer(question, ".*[Gg][Rr][Ee]{1,2}[Nn].*");
		
		System.out.println(
				"QUESTION " + (question+1) + ". How many levels your program has (wihtout co-op,) INPUT a WORD - not a numeric number");
		getAnswer(question, ".*[Ff][Oo][Uu][Rr].*");
		System.out.println("QUESTION " + (question+1) + ". In wchich building you can find Starbucks on campus");
		getAnswer(question, ".*[Ee].*");
		
		System.out.println("well done, now to the multiple choice questions:\n");
		System.out.println("QUESTION "  + (question+1) + ". What GPA do you have to have to be able to apply for co-op:\n"
				+ "a. 3.0\n"
				+ "b. 2.7\n"
				+ "c. 2.5\n"
				+ "d. 2.3 is fine\n");
		getAnswer(question, "[Bb]");

		System.out.println("QUESTION "  + (question+1) + ".  Can you eat or drink during Java Lab?\n"
				+ "a. Yes\n"
				+ "b. No\n"
				+ "c. Yes, if teacher approves\n"
				+ "d. Yes if no-one catches me\n");
		getAnswer(question, "[Bb]");
		
		System.out.println("QUESTION "  + (question+1) + ".  Can you sit in a meeting room without booking it first?\n"
				+ "a. Yes\n"
				+ "b. No\n"
				+ "c. Yes, If I pretend that no-one can see me\n"
				+ "d. Yes, if no-one catches me\n");
		getAnswer(question, "[Bb]");
	}
	
	private void getAnswer(int index, String regex) 
	{
		answer[index] = input.nextLine();
		if (answer[index].matches(regex)) {
			System.out.println("That's correct!\n");
			score++;}
			question++;	
	}
	
	public void displayScore() 
	{
		if (score >=5)
			System.out.println("good job! Your score is: " + score + " out of 6");
			else if (score>=3)
			System.out.println("you could do better.. Your score is: " + score + " out of 6");
			else if (score <3)
			System.out.println("not this time mate! Your score is: " + score + " out of 6\"\n\n");
		question = 0;
	}
	
}
