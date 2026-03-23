import java.util.Scanner;

public class HumanPlayer extends Player {
	
	public HumanPlayer(String names) {
		super(names);
		this.name=names;
	}
	
	public int selectNumber(){
		Scanner myObj = new Scanner(System.in);
		int number=0;
		while(number<1 || number>5){
			System.out.println("Give a number between 1 and 5:");
			number=myObj.nextInt();
		}
		return number;
	}
}