class ComputerPlayer
{
	private int n = 0;
	private String computerName;
	private int computerPoints = 0;
	private int[] computerMemory;
	
	//constructor
	public ComputerPlayer(String name,int n){
		this.n = n;
		this.computerName = name;
		computerMemory = new int[2*n];
		for(int i = 0; i<2*n; i++){
			computerMemory[i] = -1;
		}
	}
	
	//play
	public void play(Board myBoard){
		int a = myBoard.getRandomPosition();
		computerMemory[a] = myBoard.getCard(a);
		int b = myBoard.getRandomPosition(a);
		for(int i = 0; i < 2*n; i++){
			if(computerMemory[i] == computerMemory[a] && i!=a){
			b = i;
			}
		}
		computerMemory[b] = myBoard.getCard(b);
		myBoard.openPositions(a,b);
		if(computerMemory[a]==computerMemory[b]){computerPoints +=1;}
	}
	
	//accessor method
	public int getPoints(){
		return computerPoints;
	}
	
	//toString
	public String toString(){
		return computerName;
	}
}
