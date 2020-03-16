package monopoly.model;
import java.util.*;
import becker.util.IView;


public abstract class Square extends Object
{
   private IView[] views = new IView[1];
   private int numViews = 0;
   private String name;
   private Player ownerplayer;

public Square(String name) {

}

public String getName()
   {  
    return null;
   }

   public String getDescription()
   {  
 return null;
   }

   public Player getOwner() {
	   return ownerplayer;
   }
   
   public abstract void setOwner(Player player);
   
   public int getPrice() {
	   return 1000;
   }
   
   public Boolean requestBuy(Player player) {
	   return null;
   }


   public Player[] getPlayers()
   {  
    return null;
   }


   public void addView(IView aView)
   {  
   }

   protected synchronized void updateAllViews()
   {  
   }

protected abstract void landedOn(Player player);
   

   

}
