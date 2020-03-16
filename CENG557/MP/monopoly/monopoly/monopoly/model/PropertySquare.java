package monopoly.model;


import monopoly.model.Player;


public abstract class PropertySquare extends Square {
  private static double mortgagerate = 0.5;
  private static double resetmortgagerate = 0.6;
  private int price;
  private Player owner;
  private boolean mortgage;
  private boolean groupcheck = false;

  public PropertySquare(String name,int price) {
    super(name);
    this.price = price;
  }


  public void setOwner(Player player) {
    owner = player;
  }

 
  public int getPrice() {
    return price;
  }

  public int getMortgagePrice() {
    return (int) (price * mortgagerate);
  }


  public int getResetMortgagePrice() {
    return (int) (price * resetmortgagerate);
  }


  public boolean isMortgage() {
    return mortgage;
  }


  public void setMortgage(boolean mortgage) {
    this.mortgage = mortgage;
  }


  public boolean canBeMortgaged() {
    return !isMortgage();
  }
  
  public int getValue() {
    int value = 0;
    if (owner != null) {
      value = getPrice();
    }
    return value;
  }

  public void clear() {
    owner = null;
    mortgage = false;
  }

  public void landedOn(Player player) {
    if (owner == null) {
      // attempt to purchase
      player.buyrequest(this);
    } else if (owner != player) {
      payRent(player);
    }
  }

  // player pays rent for this property to owner
  private void payRent(Player player) {
    if (!isMortgage()) {
      int rent = 500;
      int reducedrent = player.reduceCash(rent);
      owner.addCash(reducedrent);
    }
  }


  public abstract int getRent(int rolltotal);


  public String getInfo() {
    String os = "-";
    if (owner != null) {
      os = owner.getName();
    }
    return getName() + "\n" + getPrice() + "\neigenaar: ";
  }




 
}
