public class Hangman {
	static final int livesPerGame = 5;

	public static void main(String[] args) {
		HangmanGui frame = null;
		try {
			frame = new HangmanGui(livesPerGame, "");
			frame.setVisible(true);
		} catch (Exception e) {
			System.out.println("Error setting up GUI "+ e.getMessage());
			e.printStackTrace();
		}
		char letter;

		do {
			//TODO, Moshe, wait here until they say New Game (maybe confirm or give up first)
			
			HangmanGame hangmanGame = new HangmanGame(frame, livesPerGame); // Sets up hangman
			frame.initGameGui(livesPerGame, hangmanGame.getWord());

			//TODO maybe make playOneGame a separate method
			while (true) {
				letter = frame.getNextChar();
				if (!Character.isLetter(letter)) {
					continue;
				}
				hangmanGame.isGuessed(letter, frame); // Check input
				hangmanGame.complete(frame); // Check if/why game over
				if (hangmanGame.isGameOver()) {
					break; // if gameover stop game
				}
			}
		} while (true); // Only close when they say quit or close 
	}

}
