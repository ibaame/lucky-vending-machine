import java.security.SecureRandom;
public class LuckyGuessGenerator {
	
	// Generator random numbers 1 - 5
	private static int RandomNumber ; 
	
	public static int randomNumber() {
		SecureRandom random = new SecureRandom();
		RandomNumber = 1 + random.nextInt(5);
		return RandomNumber;
	}
	
	
	// Generator random password for set up new player
	public static String checkSetUpNewPlayer() {
		SecureRandom random = new SecureRandom();
		int randomNumber = 1000 + random.nextInt(9000);  // 1000 to 9999
		char randomChar = (char)(65 + random.nextInt(26)); // A to Z
		String randomCheck = String.valueOf( randomChar + "" + randomNumber  );
		return randomCheck;
		
	}

}
