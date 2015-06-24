import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	
	static int players;
	static ArrayList<Player> roster = new ArrayList<Player>();
		
	public static void main(String[] args) {
		gameSetup();
		play();
		finalResults();
		while(true){
			endGame();
		}
		
		
	}
	
	public static void endGame(){
		System.out.println("\n\n\ndo you want to play again with the same players? yes/no");
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		if(input.toLowerCase().equals("yes")){
			for(Player p : roster){
				p.reset();
			}
			play();
			finalResults();
			endGame();
		} else {
			roster.clear();
			gameSetup();
			play();
			finalResults();
			endGame();
		}
	}
	
	public static void gameSetup(){
		Scanner s = new Scanner(System.in);
		System.out.println("Welcome to Nertz!");
		//get the number of players
		System.out.println("How many players?");
		players = s.nextInt();
		
		//create the players, add them to the roster
		for(int i = 0; i< players; i++){
			int num = i+1;
			System.out.println("enter name of player #" + num);
			Player p = new Player();
		}
		System.out.println("Game begin!!! Happy Nertzing!");
	}
	
	public static void play(){
		Scanner s = new Scanner(System.in);
		boolean winnerFound = false;
		boolean flag = false;
		String winnersName = null;
		int games = 1;
		int maxPoints = 0;
		while(true){
			System.out.println("GAME " + games + " scoresheet: ");
			for(Player p : roster){	
				System.out.println("How many points did " + p.name + " have?");
				int points = s.nextInt();
				p.addPoints(points);
				System.out.println(points + " points added! for " + p.name + "\n\n");
				winnerFound = p.isWinner();
				
				if(winnerFound) { flag = true; maxPoints = p.points; winnersName = p.name; }
				if(p.points > maxPoints) { winnersName = p.name; }
			}
			System.out.println("All the points have been added!");
			for(Player p : roster){
				System.out.println(p.name + " has " + p.points + " points");
			}
			System.out.println("\n");
		games++;
		if(flag){ break; }
		}
	}
	
	public static void finalResults(){
		System.out.println("#########THE FINAL RESULTS ARE IN!############\n\n\n");
		int min = 3000;
		int max = -3000;
		String bigWinner = null;
		String bigLoser = null;
		for(Player p : roster){
			if(p.points >= max) { max = p.points; bigWinner = p.name; }
			if(p.points <= min) { min = p.points; bigLoser = p.name; }
			System.out.println(p.name + ": " + p.points + " POINTS");
		}
		System.out.println("the BIG WINNER was " + bigWinner + " with " + max + " POINTS");
		System.out.println("the BIG LOSER was " + bigLoser + " with " + min + " POINTS");
		System.out.println("hit enter to begin celebrations!");
		Scanner s = new Scanner(System.in);
		s.nextLine();
		Player.doCelebration(bigWinner);
	}

}
