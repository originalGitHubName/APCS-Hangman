import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.GridLayout;


public class HangmanGui extends JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField wordInProgress;
	private JLabel gallows;
	private JLabel livesLeft;
	
	
	

	/**
	 * Create the frame.
	 */
	public HangmanGui(int numLivesLeft, String blanks) {
		setBounds(100, 100, 1600, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("AP CS Hangman");
		getContentPane().setLayout(new GridLayout(1, 1, 0, 0));// 1 by 1 grid says as large as possible
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 10));
		getContentPane().add(panel);
		
		
		
		wordInProgress = new JTextField();
		wordInProgress.setFont(new Font("SansSerif", Font.PLAIN, 12));
		updateWordInProgress(blanks);
		panel.add(wordInProgress);
		wordInProgress.setColumns(15);
		
		gallows = new JLabel("");
		gallows.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(gallows);
		
		JLabel livesLeftLabel = new JLabel("Lives left:");
		livesLeftLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(livesLeftLabel);
		
		
		
		livesLeft = new JLabel("");
		livesLeft.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(livesLeft);
		setImage(numLivesLeft);
		
		
		ButtonGroup numPlayers = new ButtonGroup();
		JRadioButton onePlayerButton = new JRadioButton("1 player", true);
		JRadioButton twoPlayerButton = new JRadioButton("2 players", false);
		numPlayers.add(onePlayerButton );
		numPlayers.add(twoPlayerButton);
		
		JLabel label = new JLabel("<html><center>"+"Select"+"<br>"+"number of players"+"</center></html>");
		panel.add(label);
		panel.add(onePlayerButton);
		panel.add(twoPlayerButton);
		
		
		JButton btnNewButton = new JButton("<html><center>"+"Start"+"<br>"+"new game"+"</center></html>");
		panel.add(btnNewButton);
		
		JButton giveUpButton = new JButton("I give up");
		panel.add(giveUpButton);
		
		
		JButton exitButton = new JButton("Exit");
		panel.add(exitButton);
		
		
		
		String [] keys = {"q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "a","s","d","f","g","h",
				"j","k","l","-", "z","x","c","v","b","n","m"};
		JComponent[] keyButtons = new JComponent[keys.length];
		int nextButtonIndex = 0;
		for (int i=0; i < keys.length; i++) {
			boolean fakeButton = (keys[i].equals("-"));
			if (!fakeButton) {
			keyButtons[nextButtonIndex]= new JButton(keys[i]);
			((JButton)keyButtons[nextButtonIndex]).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			}
			else
			{
				keyButtons[nextButtonIndex]= new JLabel("");
			}
			panel.add(keyButtons[nextButtonIndex]);
			nextButtonIndex++;
		}
		
		
		
		//calling program should setVisible(true)

	}
	
	public void updateWordInProgress(String wordWithUnderscores) {
		String result = "";
		boolean first = true;
		for (int i = 0; i < wordWithUnderscores.length(); i++) {
			if (!first) {
				result += ' ';
			}
			else {
				first = false;
			}
			result += wordWithUnderscores.charAt(i);
		}
		wordInProgress.setText(result);
	}

	private void setImage(int numLivesLeft) {
		BufferedImage img = null;
		// TODO choose image based on num lives left
		try {
			img = ImageIO.read(new URL(
			        "https://upload.wikimedia.org/wikipedia/commons/8/8b/Hangman-0.png"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageIcon icon = null;
		if (!(img == null)) {
			icon = new ImageIcon(img);
		}
		if (!(icon == null)) {
		gallows.setIcon(icon);
		}
		livesLeft.setText("" + numLivesLeft);
	}
	
}
