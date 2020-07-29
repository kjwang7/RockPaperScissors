/**
 * View for the Rock Paper Scissors game
 * @author Kevin
 *
 */

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GameView extends JFrame {
	
	JLabel selectLabel;
	
	JRadioButton jRadioButtonRock;
	JRadioButton jRadioButtonPaper;
	JRadioButton jRadioButtonScissors;
	
	ButtonGroup groupUserSelection;
	
	JButton playButton;
	
	/**
	 * Constructor
	 */
	public GameView() {
		JPanel gamePanel = new JPanel();
		gamePanel.setLayout(new GridLayout(3, 0));
		
		JPanel selectLabelPanel = new JPanel();
		
		JPanel radioButtonPanel = new JPanel();
		radioButtonPanel.setLayout(new GridLayout(1,3));
		
		JPanel playPanel = new JPanel();
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 400);
		
				
		selectLabel = new JLabel("Make a selection, then Play!");
		
		selectLabelPanel.add(selectLabel, JLabel.CENTER);

		groupUserSelection = new ButtonGroup();
		
		jRadioButtonRock = new JRadioButton();
		jRadioButtonRock.setText("Rock");
		jRadioButtonRock.setActionCommand("Rock");
		jRadioButtonPaper = new JRadioButton();
		jRadioButtonPaper.setText("Paper");
		jRadioButtonPaper.setActionCommand("Paper");
		jRadioButtonScissors = new JRadioButton();
		jRadioButtonScissors.setText("Scissors");
		jRadioButtonScissors.setActionCommand("Scissors");
		
		jRadioButtonRock.setHorizontalAlignment(SwingConstants.CENTER);
		jRadioButtonPaper.setHorizontalAlignment(SwingConstants.CENTER);
		jRadioButtonScissors.setHorizontalAlignment(SwingConstants.CENTER);
		
		groupUserSelection.add(jRadioButtonRock);
		groupUserSelection.add(jRadioButtonPaper);
		groupUserSelection.add(jRadioButtonScissors);
		
		playButton = new JButton("Play!");
		
		radioButtonPanel.add(jRadioButtonRock);
		radioButtonPanel.add(jRadioButtonPaper);
		radioButtonPanel.add(jRadioButtonScissors);
		
		playPanel.add(playButton);
		
		gamePanel.add(selectLabelPanel);
		gamePanel.add(radioButtonPanel);
		gamePanel.add(playPanel);
		
		this.add(gamePanel);

	}
	
	/**
	 * Get the user selection
	 * @return an Integer indicating the selection. 1 for Rock. 2 for Paper. 3 for Scissors.
	 */
	public int getUserSelection(){
		ButtonModel bM = groupUserSelection.getSelection();
		if (bM!=null) {
			String s = bM.getActionCommand();
			if (s.equals("Rock")) {
				return 1;
			}
			else if (s.equals("Paper")) {
				return 2;
			}
			else if (s.equals("Scissors")) {
				return 3;
			}
		}
		return 0;
	}

	/**
	 * Show the game result.
	 * @param userSelection user selection
	 * @param computerSelection computer selection
	 * @param gameResult game result
	 */
	public void showGameResult(int userSelection, int computerSelection, int gameResult) {

		String s = "You chose " + encodedSelection(userSelection) + "\n" + "Computer chose " + encodedSelection(computerSelection) + "\n";

		if (gameResult >= -1) {

			if (gameResult == 1) {
				s += "You won!";
			}
			else if (gameResult == -1) {
				s += "You lost.";
			}
			else { // gameResult == 0
				s += "Tie.";
			}
			JOptionPane.showMessageDialog(this, s);
		}
		else {
			JOptionPane.showMessageDialog(this, "Please make a selection to play.");
		}

		groupUserSelection.clearSelection();

	}
	
	/**Add action listener to the play button
	 * 
	 * @param listenForPlayButton
	 */
	void addGameListener(ActionListener listenForPlayButton){
		playButton.addActionListener(listenForPlayButton);
		
	}
	
	/**
	 * Return the encoded string of user selection. Rock for 1. Paper for 2. Scissors for 3
	 * @param i user selection
	 * @return
	 */
	private static String encodedSelection(int i) {
		if (i == 1) {
			return "Rock";
		}
		else if (i == 2) {
			return "Paper";
		}
		else if (i == 3) {
			return "Scissors";
		}
		else {
			return "";
		}
	}

}
