import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;


public class HangmanGui extends JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the frame.
	 */
	public HangmanGui() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("AP CS Hangman");
		
		JButton btnNewButton = new JButton("New Game");
		getContentPane().add(btnNewButton, BorderLayout.SOUTH);
		
		//calling program should setVisible(true)

	}

}
