package monopoly.model;
import java.util.*;
import becker.io.*;
import becker.util.Test;


public class Monopoly extends Object
{ 
   private List<Player> players;
   private List<Square> squares;
   public Monopoly()
   {  super();
      
   }

   public void loadGame(String fileName)
   {  
   }

   

   public void playGame()
   {  
   }


   public List<Square>  getNumSquares()
   {  
	   return squares;
   }

   public List<Player> getNumPlayers() {
	    return players;
	  }

   public Square getSquare(int boardPosition)
   {  
    return null;
   }

   public Square getSquare(String name)
   {  
    return null;
   }

   public Player getPlayer(int id)
   {  
    return null;
   }


   public String toString()
   {  return null;
   }

   public static void main(String[] args)
   {
      Monopoly m = new Monopoly();
      Square sq = m.getSquare(0);
      Test.ckEquals("Name of Go", "Go", sq.getName());

      Player pl = m.getPlayer(0);
      Test.ckEquals("1st player id", 0, pl.getID());;

      sq = m.getSquare(0);
      Test.ckEquals("Num players on square", 4, sq.getPlayers().length);

      sq = m.getSquare(1);
      Test.ckEquals("First prop name", "Mediterranean Ave", sq.getName());
      Test.ckEquals("Num players on first prop", 0, sq.getPlayers().length);

      sq = m.getSquare(m.getNumSquares().size()-1);
      Test.ckEquals("Last prop name", "Boardwalk", sq.getName());
      Test.ckEquals("Num players on last prop", 0, sq.getPlayers().length);

      pl = m.getPlayer(0);
      Test.ckEquals("initial net worth", 1500, pl.getNetWorth());
      Test.ckEquals("initial balance", 1500, pl.getBalance());
      Test.ckEquals("initial num owned prop", 0, pl.getOwnedPropertyNames().length);

      pl.advanceToken(1);
      Square op = m.getSquare(pl.getBoardPosition());
      
      Test.ckEquals("occupied square name", "Mediterranean Ave", op.getName());
      Test.ckEquals("can buy occuppied square", true, pl.canBuyOccupiedSquare(op));
      pl.buyOccupiedSquare(op);
      Test.ckEquals("can buy purchased square (f)", false, pl.canBuyOccupiedSquare(op));
      Test.ckEquals("balance after purchase", 1440, pl.getBalance());
      Test.ckEquals("net worth after purchase", 1500, pl.getNetWorth());

      m = new Monopoly();
      m.loadGame("../testGame1.txt");
      sq = m.getSquare("Baltic Ave");
      Test.ckEquals("prop name read from file", "Baltic Ave", sq.getName());
      pl = m.getPlayer(0);
      Test.ckEquals("player name read from file", "Fred", pl.getName());
      Test.ckEquals("owned prop 1", "Reading RR", pl.getOwnedPropertyNames()[0]);
      Test.ckEquals("owned", "Baltic Ave", pl.getOwnedPropertyNames()[1]);

      System.out.println("Done testing.");
   }
   
}



