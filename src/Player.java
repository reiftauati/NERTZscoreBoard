import java.util.Scanner;


public class Player {
	String name;
	int points;
	
	public Player(){
		setName();
		points = 0;
	}
	
	public void setName(){
		Scanner s = new Scanner(System.in);
		this.name = s.next();
		Main.roster.add(this);
	}
	
	public void addPoints(int p){
		points += p;
	}
	
	public void minusPoints(int p){
		points -= p;
	}
	
	public boolean isWinner(){
		boolean win = points >= 100 ? true : false;
		//if(win) System.out.println("there is a winner");
		return win;
	}
	
	public void reset(){
		this.points = 0;
	}

	
	public static void doCelebration(String name){
		for(int i = 0; i < 1000000; i++){
			if(i%5 == 0) System.out.print("     ");
			if(i%30 == 0) { System.out.println("\n"); }
			if(i%25 == 0) { System.out.println("******************************WINNER****************************************"); }
			System.out.print(name + " ");
		}
		
		
		
	}
}


