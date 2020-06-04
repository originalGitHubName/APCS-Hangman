public class Hangman {
	static final int livesPerGame = 5;

	public static void main(String[] args) {
		HangmanGui frame = null;
		try {
			frame = new HangmanGui(livesPerGame, "");
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		char letter;

		do {
			//TODO, Moshe, wait here until they say New Game
			
			HangmanGame hangmanGame = new HangmanGame(frame, livesPerGame); // Sets up hangman
			frame.initGameGui(livesPerGame, hangmanGame.getWord());

			while (true) {
				letter = frame.getNextChar();
				if (!Character.isLetter(letter)) {
					continue;
				}
				hangmanGame.isGuessed(letter, frame); // Check input
				hangmanGame.complete(frame); // Check if/why game over
				if (hangmanGame.gameOver) {
					break; // if gameover stop game
				}
			}
		} while (true); // Only close when they say quit or close 
	}

}
