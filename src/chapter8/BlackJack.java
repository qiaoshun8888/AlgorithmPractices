package chapter8;

import java.util.ArrayList;

public class BlackJack {

}

class BlackJackCard extends Card {

	public BlackJackCard(int v, Suit s) {
		super(v, s);
	}

	@Override
	public int value() {
		if (isAce()) return 1;
		else if (faceValue >= 11 && faceValue <= 13) return 10;
		else return faceValue;
	}
	
	public int minValue() {
		if (isAce()) return 1;
		else return value();
	}
	
	public int maxValue() {
		if (isAce()) return 11;
		else return value();
	}
	
	public boolean isAce() {
		return faceValue == 1;
	}
	
	public boolean isFacedCard() {
		return faceValue >= 11 && faceValue <= 13;
	}
	
}

class BlackJackHand extends Hand {
	
	public int score() {
		ArrayList<Integer> scores = possibleScores();
		int maxUnder = Integer.MIN_VALUE;
		int minOver = Integer.MAX_VALUE;
		
		for (int score : scores) {
			if (score > 21 && score < minOver) {
				minOver = score;
			}
			else if (score <= 21 && score > maxUnder) {
				maxUnder = score;
			}
		}
		
		return maxUnder == Integer.MIN_VALUE ? minOver : maxUnder;
	}
	
	private ArrayList<Integer> possibleScores() {
		// ...
		return null;
	}
	
	public boolean busted() {
		return score() > 21;
	}
	
	public boolean is21() {
		return score() == 21;
	}
	
	public boolean isBlackJack() {
		// ...
		return false;
	}
}

