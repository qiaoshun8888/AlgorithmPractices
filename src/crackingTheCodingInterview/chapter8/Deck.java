package crackingTheCodingInterview.chapter8;

import java.util.ArrayList;


public class Deck<T extends Card> {
	private ArrayList<T> cards;
	private int dealtIndex = 0;
	
	public void setDeckOfCards(ArrayList<T> deckOfCards) {
		// ...
	}
	
	public void shuffle() {
		// ...
	}
	
	public int remainningCards() {
		return cards.size() - dealtIndex;
	}
	
	public T [] dealtHand(int num) {
		// ...
		return null;
	}
	
	public T dealCard() {
		// ...
		return null;
	}
}

class Hand<T extends Card> {
	
	protected ArrayList<T> cards = new ArrayList<T>();
	
	public int score() {
		int score = 0;
		for (T c : cards) {
			score += c.value();
		}
		return score;
	}
	
	public void addCard(T c) {
		cards.add(c);
	}
}

abstract class Card {
	private boolean available = true;
	
	protected int faceValue; // 2~10 J(11) Q(12) K(13) A(1)
	protected Suit suit;
	
	public Card(int v, Suit s) {
		faceValue = v;
		suit = s;
	}
	
	public abstract int value();
	
	public Suit suit() {
		return suit;
	}
	
	public boolean isAvailable() {
		return available;
	}
	
	public void markUnavailable() {
		available = false;
	}
	
	public void markAvailable() {
		available = true;
	}
}

class Suit {
	public enum SuitType {
		Club, Diamond, Heart, Spade;
	}
	private int value;
	private Suit(int v) {
		value = v;
	}
	public int getValue() {
		return value;
	}
	public static Suit getSuitFromValue (int value) {
		// ...
		return null;
	}
}

