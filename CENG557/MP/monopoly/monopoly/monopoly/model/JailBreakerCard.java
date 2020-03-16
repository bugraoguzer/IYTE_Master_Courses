package monopoly.model;

import monopoly.model.Player;

public class JailBreakerCard extends Card {
	
	public JailBreakerCard (String description, Deck deck){
		this.description = description;
		this.deck = deck;
	}

	
	@Override
	public void executeCard(Player player) {
		player.addCardtoDeck(this);
	}

}
