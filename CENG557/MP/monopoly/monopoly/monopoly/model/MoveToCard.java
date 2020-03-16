package monopoly.model;

import monopoly.model.Board;
import monopoly.model.Square;
import monopoly.model.Player;

public class MoveToCard extends Card {
	private static int firstsquare = 0;
	private static int cleansquares = 40;
	public static int jailcontroller = -1;
	// The square number in the default board used for determining alternative square in case of other configurations
	private int squareNumber; 
	private boolean forward = true; // direction of the move
	

	public MoveToCard (String description, Deck deck, int squareNumber){
		this(description, deck, squareNumber, true);		
	}
	

	public MoveToCard (String description, Deck deck, int squareNumber, boolean forward){
		this.description = description;
		this.deck = deck;
		this.squareNumber = squareNumber;
		this.forward = forward;
	}
	
	@Override
	public void executeCard(Player player) {
		Board board = player.getBoard();
		Square current = player.getLocation();
		Square destination = null;
		destination = getSquare(board);
		
		int nsteps = board.StepCalculator(current, destination);
		player.makeMove(nsteps, true);
		deck.returnCard(this);
		
	}


	private Square getSquare(Board board){
		// check for start square
		if (squareNumber == firstsquare){
			return board.getSquare(0);
		}
		
		// check for jail square 
		if (squareNumber == jailcontroller){
			return board.getGoToJailSquare();
		}
		
		int defSquareNumber = (board.getNumberSquares()) * (squareNumber-1) / (cleansquares);
		Square defSquare = board.getSquare(defSquareNumber);
		
		return defSquare;
	}

}
