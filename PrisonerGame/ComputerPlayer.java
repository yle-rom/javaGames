import java.util.concurrent.ThreadLocalRandom;

public class ComputerPlayer extends Player {
	
	public ComputerPlayer(String names) { 
		super(names);
		this.name = names;
	}
	
	public int selectNumber(){
		int rand = ThreadLocalRandom.current().nextInt(1,6);
		return rand;
	}
}