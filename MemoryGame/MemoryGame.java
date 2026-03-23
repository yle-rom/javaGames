import java.util.Scanner;

class MemoryGame
{
	public static void main(String[] args){
		Board myBoard = new Board(5);
		//computer = new ComputerPlayer("HAL",3);
		HumanPlayer human = new HumanPlayer("Ely");
		for( int i = 0; i < 10; i++){
			human.play(myBoard);
			System.out.print("\n");
		}
	}
}
