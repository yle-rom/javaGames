public abstract class Player {
	String name;
	int rounds;
	int points=0;
	
	public Player(String names) { 
		this.name = names;
	}
	
	public abstract int selectNumber();
	
	public int play(Player other) {  
		
		while (points<=26){
			int othernumber=other.selectNumber();
			points += othernumber;
			int thisnumber=this.selectNumber();
			points+=thisnumber;
			System.out.println("Player "+this.getName()+" selected:"+thisnumber);
			System.out.println("Player "+other.getName()+" selected:"+othernumber);
			System.out.println(this.getName()+" has "+points+" points.");
		}
		return points;
		}
	
	public String declareWinner(Player other) { 
		if(this.getRounds()>other.getRounds()){return this.getName();}
		else if(other.getRounds()>this.getRounds()){return other.getName();}
		else{return null;}
	}
	
	public String toString() {
		return this.getName();
	}
	
	public String getName(){
		return name;
	}
	
	public int getRounds(){
		return rounds;
	}
	
	public int getPoints(){
		return points;
	}
	
	public void resetPoints(){
		points=0;
	}
	
	public void addWin() {
		rounds+=1;
	}
}