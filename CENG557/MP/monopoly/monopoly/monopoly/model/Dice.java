package monopoly.model;


public class Dice extends Object
{
   private static int dicevaluemax = 6;
   public Dice()
   {  super();
   }

   public int getRoll()
   {  return (int) ((Math.random() * dicevaluemax) + 1);
   }
   
}
