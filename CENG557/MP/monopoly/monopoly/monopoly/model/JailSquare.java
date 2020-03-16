package monopoly.model;

import monopoly.model.Player;

public class JailSquare extends Square {

  public JailSquare(String name) {
    super(name);
  }


  public void landedOn(Player player) {
    player.sendToJail();
  }

@Override
public void setOwner(Player player) {
	
}

}
