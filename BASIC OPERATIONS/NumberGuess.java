import java.util.Scanner;

class NumberGuess{
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

		//generate a random number less than 100
		int num = (int)(Math.random() * 100);	
		int guess_count = 1;
		int guess;

		System.out.print("Enter your guess [0 -99]: ");
		guess = input.nextInt();

		while(guess != num){
			if(guess > num){
				System.out.println("Try Lower!");
			}
			else {
				System.out.println("Try Higher!");
			}
			System.out.print("Enter your guess [0 -99]: ");
			guess = input.nextInt();
			guess_count += 1;
			
		}
	
		System.out.println("You found the answer (" + num + ")  in " + guess_count + " guesses!");
	}
			
}
