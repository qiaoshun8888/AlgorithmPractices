package chapter8;

public class GameFactory {

	public enum GameType {
		PokerGame, BlackJackGame;
	}
	
	public static CardGame createGame(GameType gt) {
		if (gt == GameType.PokerGame) {
			return new PokerGame();
		}
		else if (gt == GameType.BlackJackGame) {
			return new BlackJackGame();
		}
		else {
			return null;
		}
	}
}

class CardGame {
	
	public CardGame() {
		
	}
}

class PokerGame extends CardGame {
	
	public PokerGame() {
		
	}
}

class BlackJackGame extends CardGame {
	
	public BlackJackGame() {
		
	}
}