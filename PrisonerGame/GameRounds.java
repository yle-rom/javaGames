import java.lang.reflect.Array;

public class GameRounds{
	Player[] arr;
	int position=0;
	
	public GameRounds(String player1,String player2,int n){
		arr= new Player[2];
		if(n==1){
			arr[0]=new HumanPlayer(player1);
			arr[1]=new ComputerPlayer(player2);
		}
		else if(n==2){
			arr[0]=new ComputerPlayer(player1);
			arr[1]=new ComputerPlayer(player2);
		}
		else if(n==3){
			arr[0]=new HumanPlayer(player1);
			arr[1]=new HumanPlayer(player2);
		}
	}
	
	public void playRound(){
		System.out.println("Player "+arr[position].getName()+" turn");
		arr[position].play(arr[1-position]);
		if(arr[position].getPoints()>31) {
			System.out.println(arr[position].getName()+" busted!"); 
			arr[1-position].addWin();
		}
		else{
			System.out.println(" "); 
			System.out.println("Player "+arr[1-position].getName()+" turn"); 
			arr[1-position].play(arr[position]);
			if(arr[1-position].getPoints()>31) {
				System.out.println(arr[1-position].getName()+" busted!"); 
				arr[position].addWin();
			}
			else if(arr[1-position].getPoints()>arr[position].getPoints()) {
				System.out.println(arr[1-position].getName()+" won!"); 
				arr[1-position].addWin();
			}
			else {
				System.out.println(arr[position].getName()+" won!");
				arr[position].addWin();
			}
		}
		if(position==1) {position=0;}
		else{position=1;}
		arr[0].resetPoints();
		arr[1].resetPoints();
	}
	
	public void printScore(){
		System.out.println("Player "+arr[0].getName()+": "+arr[0].getRounds());
		System.out.println("Player "+arr[1].getName()+": "+arr[1].getRounds());
	}
	
	public String winner(){
		return arr[0].declareWinner(arr[1]);
	}
}
	