package monopoly.model;


import monopoly.model.Player;


public class CashCard extends Card {
	private int amount = 0;

	public CashCard (String description, int amount, Deck deck){
		this.description = description;
		this.amount = amount;
		this.deck = deck;
		
	}

	
	public void executeCard(Player player) {
		if (amount<0){
			player.reduceCash(-amount);
		} else {
			player.addCash(amount);
		}
		
		deck.returnCard(this);
	}


}
