package monopoly.model;

import monopoly.model.Player;


public class MoveStepCard extends Card {
	private int nSteps;
	
	public MoveStepCard (String description, Deck deck, int nSteps){
		this.description = description;
		this.deck = deck;
		this.nSteps = nSteps;
	} 
	

	public void executeCard(Player player) {
		// if nSteps > 0 then direction is forwards otherwise backwards
		boolean forward = (nSteps > 0);
		player.makeMove(nSteps, forward);
		
		deck.returnCard(this);

	}

}
