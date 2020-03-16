package monopoly.model;

import java.util.List;

import monopoly.model.Player;

public class HappyBirthDayCard extends Card {
	
	private static int birthdaymoney = 10;

	public HappyBirthDayCard (String description, Deck deck){
		this.description = description;
		this.deck = deck;
	}

	@Override
	public void executeCard(Player player) {
		List<Player> players = player.getGame().getNumPlayers();
		int amount = 0;
		for (Player p:players){
			if(p!=player && !p.isBankrupt()){			
				p.reduceCash(birthdaymoney);
				amount = amount + birthdaymoney;
			}
		}
		player.addCash(amount);	
		
		deck.returnCard(this);

	}

}
