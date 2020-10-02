import java.util.Scanner;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
public class scores {

	public static void main(String[] args)  {

		Scanner input = new Scanner(System.in);
		HashMap<String, Integer> scores = new HashMap<String, Integer>();
		boolean exit = false;
		//call methods in appropriate order
		//get players first

		getPlayers(input, scores);

		do {
			System.out.println();
			System.out.println("Enter name to add points: ");
			String playerName = input.next();
			// check if name entered is in map
			if(scores.containsKey(playerName) == false) {
				System.out.println("Name is not valid.");
				continue;
			}
			
			System.out.println("How many points would you like to add?");
			int points = input.nextInt();

			if(scores.get(playerName) + points >= 10000) {
				System.out.println();
				System.out.println(playerName + " wins!!");
				exit = true;
			}
			else {// Give player option to see scoring rules
				if(points == 1234) {
					System.out.println();
					printScoringRules(input);
				}
				else {
					addPoints(input, scores, playerName, points);
				}
			}
			
		}while(exit != true);


	}
	/**
	 * Get's the names of the players from the user
	 * @param input
	 */

	public static void getPlayers(Scanner input, HashMap<String, Integer> scores) {

		System.out.println("Enter number of players that are playing: ");
		int numPlayers = input.nextInt();
		for(int i = 0; i<numPlayers; i++) {
			System.out.println("Enter name: ");
			String playerName = input.next();
			scores.put(playerName, 0);	
		}
		System.out.println();
		Set<Map.Entry<String, Integer>> entrySet = scores.entrySet();
		for (Entry<String, Integer> entry : entrySet) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}

	}

	public static void addPoints(Scanner input, HashMap<String, Integer> scores, String playerName, int points) {

		//add to points to corresponding value
		int value = scores.get(playerName);
		int newPoints = value + points;
		System.out.println();

		//replace new points with old
		scores.put(playerName, newPoints);
		//print map
		Set<Map.Entry<String, Integer>> entrySet = scores.entrySet();
		for (Entry<String, Integer> entry : entrySet) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}

	}
	
	public static void printScoringRules(Scanner input) {
		
		System.out.printf("%-20s%1s%-25s\n", "Fives = 50 pts", "| ", "4 of any number = 1,000 pts");
		System.out.printf("%-20s%1s%-25s\n","Ones = 100 pts","| ","5 of any number = 2,000 pts");
		System.out.printf("%-20s%1s%-25s\n","Three 1s = 300 pts","| ","6 of any number = 3,000 pts");
		System.out.printf("%-20s%1s%-25s\n","Three 2s = 200 pts","| ","1-6 straight = 1,500 pts");
		System.out.printf("%-20s%1s%-25s\n","Three 3s = 300 pts","| ","Three pairs = 1,500");
		System.out.printf("%-20s%1s%-25s\n","Three 4s = 400 pts","| ","Four of any number with a pair = 1,500");
		System.out.printf("%-20s%1s%-25s\n","Three 5s = 500 pts","| ","Two triplets = 2,500");
		System.out.printf("%-20s%1s\n","Three 6s = 600 pts","| ");
	}

}
