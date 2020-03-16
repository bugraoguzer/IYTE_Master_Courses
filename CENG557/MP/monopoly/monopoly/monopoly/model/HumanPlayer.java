package monopoly.model;

public class HumanPlayer extends Player
{
   public HumanPlayer(String name, int ID, Board board, Monopoly mGame) {
		super(name, ID, board, mGame);
		// TODO Auto-generated constructor stub
	}

private boolean takingTurn = false;

   public synchronized void finishMove()
   {  this.notify();
   }

   public boolean isTakingTurn()
   {  return this.takingTurn;
   }
   
protected void makeMove(int stepsize, Boolean direction) {
	// TODO Auto-generated method stub
	
}

public boolean buyrequest(PropertySquare psquare) {
	// TODO Auto-generated method stub
	return false;
}
   
}
