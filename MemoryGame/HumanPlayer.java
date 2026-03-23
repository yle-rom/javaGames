import java.util.Scanner;

class HumanPlayer
{
	private String humanName;
	private int humanPoints = 0;
	
	//constructor
	public HumanPlayer(String name){
		this.humanName = name;
	}
	
	//play
	public void play(Board myBoard){
		System.out.print("\n");
		Scanner input = new Scanner(System.in);
		int position1 = 0;
		int position2 = 0;
		System.out.print("Input the first position : ");
		position1 = input.nextInt();
		while(!myBoard.containsCard(position1)){
			position1 = input.nextInt();
		}
		System.out.print("Input the second position : ");
		position2 = input.nextInt();
		while(!myBoard.containsCard(position2) || position1 == position2){
			position2 = input.nextInt();
		}	
		myBoard.openPositions(position1,position2);
		int card1 = myBoard.getCard(position1);
		int card2 = myBoard.getCard(position2);
		if(card1 == card2){humanPoints+=1;}
	}
		
	//accessor method
	public int getPoints(){
		return humanPoints;
	}
	
	//toString
	public String toString(){
		return humanName;
	}
}
