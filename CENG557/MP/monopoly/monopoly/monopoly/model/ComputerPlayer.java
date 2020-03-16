package monopoly.model;


 
/** A subclass of Player for a computer player */
public class ComputerPlayer extends Player
{
   

   public ComputerPlayer(String name, int ID, Board board, Monopoly mGame) {
		super(name, ID, board, mGame);
		// TODO Auto-generated constructor stub
	}



@Override
protected void makeMove(int stepsize, Boolean direction) {
	// TODO Auto-generated method stub
	
}



@Override
public boolean buyrequest(PropertySquare psquare) {
	// TODO Auto-generated method stub
	return false;
}
   
}
