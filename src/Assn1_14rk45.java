import java.util.Scanner;

/** Pig Game - 10183626 - 14rk45
 * Started 25th September 
 * @author Raasil K
 *
 */
public class main {
	//scanner class for inputs
	public static Scanner s = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//main method
		System.out.println("Welcome to the Pig Game!");
		System.out.println("-------------------------");

		String playername1 = promptPlayerName();
		String computer = "computer";
		int playerscore1 = 0;
		int computerscore = 0;
		while(playerscore1 < 100 && computerscore < 100) {
			printCurrentScore(playername1, playerscore1, computer, computerscore);
			int player1turnScore = playerTurn(playername1);
			playerscore1 += player1turnScore;
			int computerturnScore = computerRoll(computer);
			computerscore += computerturnScore;
		}
		printPigResults(playername1, playerscore1, computer, computerscore);
	}
		// print results and scores and who won
		private static void printPigResults(String playername1, int playerscore1, 
											String computer, int computerscore) {
		// TODO Auto-generated method stub
		System.out.println("***********************");
		if(playerscore1 > computerscore){
			System.out.println(playername1 + " WON!");
		}
			else {
				System.out.println(computer + " WON!");
			}
		}
		
		//print scores to keep players updated
		private static void printCurrentScore(String playername1, int playerscore1, 
											  String computer, int computerscore ) {
			System.out.println("---------------------------");
			System.out.println(playername1 + ":" + playerscore1);
			System.out.println(computer + ":" + computerscore);
		
			
		}
		// prompt for a name 
		private static String promptPlayerName() {
			System.out.println("Enter name: ");
			return s.nextLine();
			
			
		}
		//the mechanics behind the players turn, all rules added in
		private static int playerTurn(String playerName){
			System.out.println("----------------------------");
			System.out.println(playerName + "'s turn!");
			int turnScore = 0; //start off with a score of 0
			boolean playerRoll = true;
			while(playerRoll) { //playerroll is true, false when player picks 2 or gets a 0
				int randomRoll = (int)(6*Math.random()) + 1;
				int randomRoll2 = (int)(6*Math.random()) + 1; //random number from 1 to 6
				System.out.println("You rolled " + randomRoll + " and " + randomRoll2);
				if(randomRoll == 1 && randomRoll2 == 1){
					System.out.println("You got 25 points. Roll again");
					turnScore = turnScore + 25; //rules
				}
				
				else if(randomRoll == 1 || randomRoll == 1){
					System.out.println("You got 0 points this turn. oops");
				return 0;
				}
				else if(randomRoll == randomRoll2){
					turnScore = turnScore + (randomRoll * 2);
				}
				turnScore = turnScore + randomRoll + randomRoll2; //adding both dice to the score
				System.out.println(playerName + " has " + turnScore + " points");
				System.out.println("Do you want to roll again? yes (1) or no (2) ");
				int userChoice = s.nextInt();
				if(userChoice == 2){
					playerRoll = false; //player picks no and so its the computers turn
					computerRoll("computer");
				}
			}
			// return turn score
			System.out.println(playerName + " ended the turn with " + turnScore + " points");
			System.out.println("-----------------------------------------------------------");
			return turnScore; 
		}
		
		//mechanics behind autmoated computer rolls
		private static int computerRoll(String computer){
			System.out.println("----------------------------");
			System.out.println("computer turn!");
			int turnScore = 0;
			boolean computerRoll = true;
			while(computerRoll) {
				int randomRoll = (int)(6*Math.random()) + 1;
				int randomRoll2 = (int)(6*Math.random()) + 1;
				System.out.println("Computer rolled " + randomRoll + " and " + randomRoll2);
				if(randomRoll == 1 && randomRoll2 == 1){
					System.out.println("Computer got 25 points. Roll again");
					turnScore = turnScore + 25;
				}
				
				else if(randomRoll == 1 || randomRoll == 1){
					System.out.println("Computer got 0 points this turn. oops");
				return 0;
				}
				else if(randomRoll == randomRoll2){
					turnScore = turnScore + (randomRoll * 2); //rules
				}
				turnScore = turnScore + randomRoll + randomRoll2;
				System.out.println(computer + " has " + turnScore + " points");
				if (turnScore >= 40){
					computerRoll = false; //computer turn ends when they get 40 or equal to 40
				}
				
			// TODO Auto-generated method stub
			
				}
			return turnScore; //returns their score
			}
		}
	