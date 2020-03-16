package monopoly.model;

import monopoly.model.Player;

public class RailroadSquare extends PropertySquare {

  private int baserent;
  private Player owner;

  public RailroadSquare(String name, int price, int baserent) {
    super(name, price);
    this.baserent = baserent;
  }

  public int getRent(int rolltotal) {
    if (isMortgage()) {
      return 0;
    }
    return 500;
  }

  

  public void setOwner(Player player) {
	  this.owner = player;
	    }
  
  public void landedOn(Player player) {
	 
	    }
	  
}
