

import java.util.ArrayList;

public class Player {

	private ArrayList<String> prizes;
	private ArrayList<Integer> worths;
	private ArrayList<Integer> spends;
	
	private String name;
	private boolean storeIsEmpty;
	private int totalWorth ;
	private int totalSpend;
	
	private int CPen ;
	private int CBook;
	private int CDVD ;
	private int CMouse;
	private int CKeyboard;
	
	
	
	//  default
	public Player() {
		name = null;
		// size store
		
		this.prizes = new ArrayList<>();
		this.worths = new ArrayList<>();
		this.spends = new ArrayList<>();
		storeIsEmpty = true;
		
		totalWorth = 0;
		totalSpend = 0;
		CPen = 0;
		CBook = 0;
		CDVD = 0;
		CMouse = 0;
		CKeyboard = 0;
	}

	
	// check if name is null or empty
	public boolean isNameNull() {
		return name == null;
	}
	
	// get and set name of player
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	
	// get and set check store is empty
	public void setStoreIsEmpty(boolean storeIsEmpty) {
		this.storeIsEmpty = storeIsEmpty;
	}

	public boolean getStoreIsEmpty() {
		return storeIsEmpty;
	}
	
	// set and get prizes and worths 
	public int getTotalWorth() {
		totalWorth = 0 ;
		for(int worth : worths)
			totalWorth += worth;
		return totalWorth;
	}
	
	public void setPrizesWorths(int check, String prize, int worth) {
		if(check == 0) {
			prizes.clear();
			worths.clear();
			totalWorth = 0;
			setStoreIsEmpty(true);
		}
		else {
			prizes.add(prize);
			worths.add(worth);
			setStoreIsEmpty(false);
		}
	}

	
	// get and set spend
	public int getTotalSpend() {
		totalSpend = 0;
		for(int spend : spends)
			totalSpend += spend;
		return totalSpend;
	}

	public void setTotalSpend(int spent) {
		if(spent == 0) {
			spends.clear();
			totalSpend = 0;
		}
		else
			spends.add(spent);
	}
	
	
	@Override
	public String toString() {	
		String listPrizes = "";
		if(getStoreIsEmpty())
			listPrizes  = "\t- No Prize" ;
		else {
			for(int i = 0 ; i < prizes.size() ; i++) 
				listPrizes += "\t- " + prizes.get(i) + ", $" + worths.get(i)+ "\n";
		}
		return listPrizes;
	}	
	
	
	/* ------------------------------------------------- details spent -------------------------------------------------- */
	// get details cost 
	public void  getDetails() {

		System.out.println(" -------------------------------");
		System.out.println("|     Prize     | try   | spent |");
		System.out.println(" -------------------------------");
		System.out.println("| Pen      (1$) | "+ (getCPen())   +"\t| $"+ getCPen() + "\t|");
		System.out.println("| Book     (2$) | "+ (getCBook()/2)+"\t| $"+ getCBook() + "\t|");
		System.out.println("| DVD      (3$) | "+ (getCDVD()/3) +"\t| $"+ getCDVD() + "\t|");
		System.out.println("| Mouse    (4$) | "+ (getCMouse()/4) +"\t| $"+ getCMouse() + "\t|");
		System.out.println("| Keyboard (5$) | "+ (getCKeyboard()/5)+"\t| $"+ getCKeyboard() + "\t|");
		System.out.println(" -------------------------------");
		
	}
	
	public void setDetails(int cost) {
		if(cost == 1)
			CPen++;
		else if(cost == 2)
			CBook += 2;
		else if(cost == 3)
			CDVD += 3;
		else if(cost == 4)
			CMouse += 4;
		else if(cost == 5)
			CKeyboard +=5;
	}
	
	// set and get cost pen
	private int getCPen() {
		return CPen;
	}
	
	public void setCPen(int CPen) {
		this.CPen = CPen;
	}
	
	
	// set and get cost book
	private int getCBook() {
		return CBook;
	}
	
	public void setCBook(int CBook) {
		this.CBook = CBook;
	}
	
	
	// set and get cost DVD
	private int getCDVD(){
		return CDVD;
	}
	
	public void setCDVD(int CDVD) {
		this.CDVD = CDVD;
	}
	
	
	// set and get cost Mouse
	private int getCMouse() {
		return CMouse;
	}
	
	public void setCMouse(int CMouse) {
		this.CMouse = CMouse;
	}
	

	// set and get cost keyboard
	private int getCKeyboard() {
		return CKeyboard;
	}
	
	public void setCKeyboard(int CKeyboard) {
		this.CKeyboard = CKeyboard;
	}
	

}

