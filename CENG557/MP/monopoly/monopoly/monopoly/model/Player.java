package monopoly.model;
import becker.util.IView;

import java.util.ArrayList;

import becker.io.TextInput;
import monopoly.model.Board;
import monopoly.model.Card;
import monopoly.model.Square;;

public abstract class Player extends Object
{
   private static int startingcash = 1500;
   private IView[] views = new IView[1];
   private int numViews = 0;
   private static Dice dice;
   private String name;
   private Board board;
   private Square location;
   private boolean jailchecker;
   private boolean isbankrupt=false;
   private int countDouble;
   private int cash;
   private int ID;
   protected Card JailBreakCard;
   protected ArrayList<Card> cards = new ArrayList<Card>();
   protected ArrayList<Square> allpropertys = new ArrayList<Square>();
   private Monopoly Game;
   
   public Player(String name,int ID, Board board, Monopoly mGame) {
	    this.name = name;
	    this.ID = ID;
	    this.board = board;
	    this.cash = startingcash;
	    this.location = board.getStartSquare();
	    this.jailchecker = false;
	    this.countDouble = 0;
	    this.setGame(Game);
	  }

	public Monopoly getGame() {
		return Game;
	}
	
	public void setGame(Monopoly Game) {
		this.Game = Game;
	}

	
   public boolean canPay(int amount) {
	    return cash >= amount;
	  }
   
   public void makeBankrupt() {
	   
	   this.isbankrupt=true;
	   
   }
   
   public void addCardtoDeck(Card card) {
		cards.add(card);
	}

   
   public boolean isBankrupt() {
	   
	 return isbankrupt;
	   
   }
   
   public int reduceCash(int money)
   {
	   if (canPay(money)) {
		      cash = cash - money;
		      return cash;
		    } else {
		    	makeBankrupt();
		    }
	return cash;
   }
   
   public void addCash(int money) {
	    cash = cash + money;
	  }
   
   private void determineDiceType()
   {
      /* Only needs to be called if we have not initialized dice. */
      if(Player.dice == null)
      {  TextInput in = new TextInput();

         System.out.print("Do you want to debug? ");
         /* Get input from the user to determine whether debugging or not. */
         if (in.readLine().trim().equalsIgnoreCase("y"))
         {  
         }
         else
         {  
         }
         in.close();
      }

   }

   public String[] getOwnedPropertyNames()
   {  
	   return Board.getProperties(this);
   }


   public String getName()
   {  
    return name;
   }
   
   public Board getBoard()
   {  
    return board;
   }

   public Square getLocation()
   {  
    return location;
   }

   public int getID()
   {  
    return ID;
   }

   public int getBalance()
   {  
    return cash;
   }

   public int getNetWorth()
   {  
	   int value = 0;
	   for (Square psquare : allpropertys) {
		      value += psquare.getPrice();
		    }
		    return value;
   }

   public boolean canBuySquare(Square square)
   {   
	   if(square.getOwner() == null && canPay(square.getPrice())) {
			  return true;
		  }else {
			  return false;
		  }
   }
   
   public boolean canBuyOccupiedSquare(Square square)
   {  
	  if(square.requestBuy(this) && canPay(square.getPrice())) {
		  return true;
	  }else {
		  return false;
	  }

   }

   public void buyHouse(Square square)
   {  
	   int price = square.getPrice();
	   if (canBuySquare(square)) {
		      // buy
		      square.setOwner(this);
		      reduceCash(price);
		    }
	   System.out.print("Sorry u cant buy this square !! low cash");
   }

   public void buyOccupiedSquare(Square square)
   {  
	   int price = square.getPrice();
	   if (canBuyOccupiedSquare(square)) {
		      // buy
		      square.setOwner(this);
		      reduceCash(price);
		    }
	   System.out.print("Sorry u cant buy this square !! low cash");
   }


   protected void advanceToken(int howFar)
   {  

   }

   protected abstract void makeMove(int stepsize,Boolean direction);

   public abstract boolean buyrequest (PropertySquare psquare); 

   public int getBoardPosition()
   {  
 return 0;
   }

   

   public void addView(IView aView)
   {  
	   
   }

   protected void updateAllViews()
   {  
   }


   public String toString()
   {  return null;
   }

public void sendToJail() {
	jailchecker = true;
    Square oldloc = location;
    location = board.getGoToJailSquare();
    location.landedOn(this);
}
   
}
