package monopoly.model;

import monopoly.model.Player;

public abstract class Card {

	protected String description = null;
	
	protected Deck deck;

	public abstract void executeCard(Player player);
	
	public String getDescription() {
		return description;
	}
	
	public Deck getDeck() {
		return deck;	
	}
}
