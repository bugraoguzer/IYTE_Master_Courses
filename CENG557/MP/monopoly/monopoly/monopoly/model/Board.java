package monopoly.model;

import java.util.List;

public class Board {
	private List<Square> squares;
	
	public Square getStartSquare(){
		return null;
		
	}
	
	  public Board(List<Square> squares) {
		    this.squares = squares;
		  }
	
	  public int StepCalculator(Square from, Square to){
		  int step = (squares.indexOf(to) - squares.indexOf(from) ) % (squares.size()-1);
		  return step;
	  }

	public static String[] getProperties(Player player) {
		return null;
	}
	
	  public int getNumberSquares() {
		    return squares.size();
		  }
	  
	  public Square getSquare(int index) {
		    return squares.get(index);
		  }
	  
	  public Square getGoToJailSquare() {
		    for (Square sq : squares) {
				if (sq instanceof JailSquare) {
			      return sq;
			    }
			}
			return null;
		  }

}
