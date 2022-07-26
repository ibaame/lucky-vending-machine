
public class Game { 

	Player player = new Player();
	private String name ;

	public Game() {
		name = null;
	}
	
	// --------------------------------------------------- Play : menu contain 5 Options ---------------------------------------------------
	public void play() {
		boolean isNotExit = true;
		while(isNotExit) {
			
			menu();
			System.out.print("Choose an option: ");
			String choose = Read.String();
			
			if(choose.equals("1"))
				SetUpNewPlayer();
			else if(choose.equals("2") && player.isNameNull() == false)
				GuessAPrize();
			else if(choose.equals("3") && player.isNameNull() == false)
				WhatHaveIWonSoFar();
			else if(choose.equals("4"))
				DisplayGameHelp();
			else if(choose.equals("5"))
				isNotExit = Exit();
			else if((choose.equals("2") || choose.equals("3")) && player.isNameNull())
				System.out.println("\nMessage: Please Enter Your name before starting from Option (1)");
			else
				System.out.println("\nMessage: wrong Choose! Chooses from Option (1) to Option (5).\nPlease try again.");
		}	
	}
	
	// ---------------------------------------- Option(1) : Set Up new Player : Enter name of player : reset ----------------------------------------
	private void SetUpNewPlayer() {
		
		System.out.println("\n-------------------------------[Set Up New Player]--------------------------------\n");
		
		// check for set up new player
		String password = LuckyGuessGenerator.checkSetUpNewPlayer();
		System.out.println("Enter this password => " + password);
		System.out.print("=> ");
		String passwordFromPlayer = Read.String();
		
		if(passwordFromPlayer.equals(password)) {
			// set new player
			System.out.print("\nEnter Your name: ");
			name = Read.String();
			player.setName(name);
			player.setPrizesWorths(0,"No Prize",0);
			player.setTotalSpend(0);
			player.setCPen(0);
			player.setCBook(0);
			player.setCDVD(0);
			player.setCMouse(0);
			player.setCKeyboard(0);
		}
		else
			System.out.println("\nMassage: password is wrong, try again.");
	}
	
	// --------------------------------------------- Option(2) : Guess A Prize : between 1 - 5 --------------------------------------------- 
	private void GuessAPrize() {
		
		System.out.println("\n----------------------------------[Guess A Prize]---------------------------------\n");
		System.out.print("Guess a number between 1 - 5: ");
		String num = Read.String();
		
		if(num.equals("1") || num.equals("2") || num.equals("3") || num.equals("4") || num.equals("5")) {
			int number = Integer.parseInt(num); // convert to integer
			int randomNumber =  LuckyGuessGenerator.randomNumber(); // random number (1 - 5)
			System.out.println("\tYour Guess : " + number);
			System.out.println("\tMy Guess : " + randomNumber);
			player.setTotalSpend(number); // store spent 
			player.setDetails(number);  // set details for cost
			if(randomNumber == number) {
				Store store = new Store(number); // get prize and price worth from store
				store.PrizeWon();
				store.PrizeWorth();
				System.out.println("Congratulations! You have won a " + store.getPrize() + ", worth $" + store.getWorth()+  "." );
				player.setPrizesWorths(1,store.getPrize(), store.getWorth()); // store prize, worth
			}
			else
				System.out.println("\nSorry! You have won absolutely NOTHING!\nPlease try again.");
		}
		else
			System.out.println("\nMessage: your Guess must be number and between 1 - 5");
	}
	
	// --------------------------------------------- Option(3) : What Have I Won So Far ---------------------------------------------
	private void WhatHaveIWonSoFar() {
		
		System.out.println("\n-----------------------------[What Have I Won So Far?]-----------------------------\n");
		System.out.println("Player "  + player.getName() + " has won these prizes:");
		System.out.println(player.toString());
		player.getDetails();
		System.out.println("\nworth a total $" + player.getTotalWorth());
		System.out.println("Total amount spent is $" + player.getTotalSpend());
		
	}
	
	
	// ----------------------------------------------------- Option(4) : rules of game -----------------------------------------------------
	private void DisplayGameHelp() {

		System.out.println("\n---------------------------[Game Help / rules of game]----------------------------\n");
		System.out.println("Option (1):");
		System.out.println("\t- Enter Your name");
		System.out.println("\t- you can't start before enter your name");
		System.out.println("\t- if this option is chosen again after a player has already been set up\n"
                         + "\t  a \"new\" player is created (ie. with a new name, no prizes, $0 spent).");
		
		System.out.println("\nOption (2):");
		System.out.println("\t- Guess A Prize between 1 - 5 (1$ - 5$)");
		System.out.println("\t- If you guesses wrongly, you wins nothing and loses the money ($1-5)");
		System.out.println("\t- If you guess correctly, you will win something for the number entered ($1 - $5)\n");
		System.out.println(" ------------------ ----------- ------------- ---------------- ");
		System.out.println("| Number Generated | Price Won | Price Worth | Cost to player |");
		System.out.println(" ------------------ ----------- ------------- ---------------- ");
		System.out.println("| 1                | Pen       | $10         | $1             |");
		System.out.println(" ------------------ ----------- ------------- ---------------- ");
		System.out.println("| 2                | Book      | $20         | $2             |");
		System.out.println(" ------------------ ----------- ------------- ---------------- ");
		System.out.println("| 3                | DVD       | $30         | $3             |");
		System.out.println(" ------------------ ----------- ------------- ---------------- ");
		System.out.println("| 4                | Mouse     | $40         | $4             |");
		System.out.println(" ------------------ ----------- ------------- ---------------- ");
		System.out.println("| 5                | Keyboard  | $50         | $5             |");
		System.out.println(" ------------------ ----------- ------------- ---------------- ");

		System.out.println("\nOption (3):");
		System.out.println("\t- Information about your progress..");
		System.out.println("\t\t- Prizes");
		System.out.println("\t\t- Worth a total");
		System.out.println("\t\t- Total amoutn spent");
		
		System.out.println("\nOption (4):");
		System.out.println("\t- Game Help / rules of game (this option)");
		
		System.out.println("\nOption (5):");
		System.out.println("\t- exits the Game");
		
		System.out.println("\n==================================================================================");
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
	}
	
	// ----------------------------------------------------- Option(5) : Exit -----------------------------------------------------
	public boolean Exit() {
		System.out.println("\n-------------------------------------[Exit]---------------------------------------\n");
		System.out.println("Good luck next time, Good-Bye.");
		return false;
	}
	
	// -------------------------------------------------------- menu : view Options --------------------------------------------------------
	private void menu() {
		System.out.println("==================================================================================");
		System.out.println("\t\t\tWelcome to the Lucky Vending Machine");
		System.out.println("==================================================================================");
		System.out.println("(1) Set Up New Player");
		System.out.println("(2) Guess A Prize");
		System.out.println("(3) What Have I Won So Far?");
		System.out.println("(4) Display Game Help");
		System.out.println("(5) Exit Game");
	}
	
	
	
}
