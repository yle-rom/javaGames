import java.util.Scanner;

public class PrisonerGame {

	public static void main(String args[]) {
		String keepPlaying = "y";
		Scanner myObj = new Scanner(System.in);
		System.out.println("Do you want to play 1. Human vs Computer, or 2. Computer vs Computer?");
		int choice = myObj.nextInt();
		GameRounds round = new GameRounds("Player 1", "Player 2", choice);
		while (!keepPlaying.equals("n")) {
			round.playRound();
			round.printScore();
			System.out.println("Do you want to play another round?");
			keepPlaying = myObj.next();
		}
		if (round.winner() == null) {
			System.out.println("No winner");
		} else {
			System.out.println("Player " + round.winner() + " has won the game");
		}
	}
}
