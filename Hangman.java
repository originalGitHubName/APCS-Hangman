import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        char playing = ' ';
        String letter;
        String gameMode;
        Scanner scan = new Scanner(System.in); // Sets up scanner
        do {
            System.out.print("\033[H\033[2J"); // Clears terminal
            System.out.println(
                    "If you would like to play 2 players have one player enter a word for the other to guess. If not enter 1.");
            gameMode = scan.next().toLowerCase().trim();
            System.out.print("\033[H\033[2J"); // Clears terminal
            HangmanGame hangmanGame = new HangmanGame(gameMode); // Sets up hangman
            letter = scan.next().toLowerCase(); // Gets input in all lowercase
            while (true) {
                hangmanGame.isGuessed(letter); // Check input
                hangmanGame.complete(); // Check if/why game over
                if (hangmanGame.gameOver) {
                    break; // if gameover stop game
                }
                letter = scan.next().toLowerCase(); // Gets input in all lowercase
            }
            System.out.println("To play again press y"); // Prints text
            playing = scan.next().toLowerCase().charAt(0); // Get first letter of input
        } while (playing == 'y'); // Play again
        System.out.println("Bye"); // Prints bye
        scan.close(); // Closes input
    }
}