package monopoly.model;

import java.util.ArrayList;

public abstract class Deck {
	public static final int CHANCE_DECK_TYPE = 0;
	public static final int COM_CHEST_TYPE = 1;
	private static final int NUMBER_OF_SHAKES = 100;
	private ArrayList<Card> deck = new ArrayList<Card>();
	private int deckType;
	private String name;


	protected Deck(String name) {
		this.name = name;
		loadCards();
		shakeCards();
	}
	

	protected abstract void loadCards();

	public Card getTopCard() {
		return deck.remove(0);
		
	}


	public void returnCard(Card card) {
		deck.add(card);
	}

	protected void shakeCards() {
		for(int i = 0; i<NUMBER_OF_SHAKES;i++){
			int max = deck.size();
			int from = (int) (Math.random() * max);
			int to = (int) (Math.random() * max);
			Card fromCard = deck.get(from);
			Card toCard = deck.get(to);
			deck.set(to, fromCard);
			deck.set(from, toCard);
		}
		
		
	}

	public ArrayList<Card> getDeck() {
		return deck;
	}


	public int getDeckType() {
		return deckType;
	}

	public void setDeckType(int deckType) {
		this.deckType = deckType;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}