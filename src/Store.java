
import java.util.ArrayList;

public class Store {
	
	private ArrayList<String> prizeWon;
	private ArrayList<Integer> prizeWorth;
	private int index;
	
	private String prize;
	private int worth;
	
	// -1 is mean no Prize
	public Store() {
		this.prizeWon = new ArrayList<>();
		this.prizeWorth = new ArrayList<>();
		index = -1;	
	}
	
	// pass index for Prizes and price worth
	public Store(int index) {
		this.index = index;
		this.prizeWon = new ArrayList<>();
		this.prizeWorth = new ArrayList<>();
	}
	
	// store Prizes and set prize
	public void PrizeWon() {
		int index = this.index;
		index--;
		prizeWon.add("Pen");
		prizeWon.add("Book");
		prizeWon.add("DVD");
		prizeWon.add("Mouse");
		prizeWon.add("Keyboard");
		prize = prizeWon.get(index);
	}
	
	// store Price worth and set worth
	public void PrizeWorth() {
		int index = this.index;
		index--;
		prizeWorth.add(10);
		prizeWorth.add(20);
		prizeWorth.add(30);
		prizeWorth.add(40);
		prizeWorth.add(50);
		worth = prizeWorth.get(index);
	}
	
	// get Prize from store
	public String getPrize() {
		return prize;
	}
	
	// get Worth from store
	public int getWorth() {
		return worth;
	}
}
