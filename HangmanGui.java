import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Font;


public class HangmanGui extends JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField wordInProgress;
	

	/**
	 * Create the frame.
	 */
	public HangmanGui() {
		setBounds(100, 100, 900, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("AP CS Hangman");
		
		JButton btnNewButton = new JButton("Start New Game");
		getContentPane().add(btnNewButton, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		ButtonGroup numPlayers = new ButtonGroup();
		JRadioButton onePlayerButton = new JRadioButton("1 player", true);
		//panel.add(radioButton);
		
		JRadioButton twoPlayerButton = new JRadioButton("2 players", false);
		numPlayers.add(onePlayerButton);
		numPlayers.add(twoPlayerButton);
		
		wordInProgress = new JTextField();
		wordInProgress.setFont(new Font("SansSerif", Font.PLAIN, 26));
		wordInProgress.setText("p _ r _ _ l _");
		panel.add(wordInProgress);
		wordInProgress.setColumns(15);
		
		JButton giveUpButton = new JButton("I give up");
		panel.add(giveUpButton);
		panel.add(onePlayerButton);
		panel.add(twoPlayerButton);
		//panel.add(rdbtnNewRadioButton);
		String [] topRow = {"q", "w", "e", "r", "t", "y", "u", "i", "o", "p"};
		JButton[] topRowButtons = new JButton[topRow.length];
		for (int i=0; i < topRow.length; i++) {
			topRowButtons[i]= new JButton(topRow[i]);
			topRowButtons[i].setHorizontalAlignment(SwingConstants.LEFT);
			topRowButtons[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			panel.add(topRowButtons[i]);
		}
		
		
		
		//calling program should setVisible(true)

	}

}
