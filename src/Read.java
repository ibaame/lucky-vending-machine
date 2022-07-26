
import java.util.Scanner;
public class Read {
	
	// read String from user
	public static String String() {
		Scanner in = new Scanner(System.in);
		String txt = in.next();
		return txt;
	}
	
	// read Integer from user
	public static int Int() {
		Scanner in = new Scanner(System.in);
		int number = in.nextInt();
		return number;
	}
}
