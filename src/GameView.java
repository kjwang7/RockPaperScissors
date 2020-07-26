/**
 * View of the Game.
 */

//import java.awt.BorderLayout;
//import java.awt.Component;
//import java.awt.GridBagLayout;
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
		//selectLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
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
		//jRadioButtonRock.setVerticalAlignment(SwingConstants.CENTER);
		//jRadioButtonPaper.setVerticalAlignment(SwingConstants.CENTER);
		//jRadioButtonScissors.setVerticalAlignment(SwingConstants.CENTER);
		
		groupUserSelection.add(jRadioButtonRock);
		groupUserSelection.add(jRadioButtonPaper);
		groupUserSelection.add(jRadioButtonScissors);
		
		playButton = new JButton("Play!");
		
		//gamePanel.add(selectLabel);
		//radioButtonPanel.add(jRadioButtonRock, BorderLayout.CENTER);
		//radioButtonPanel.add(jRadioButtonPaper, BorderLayout.CENTER);
		//radioButtonPanel.add(jRadioButtonScissors, BorderLayout.CENTER);
		radioButtonPanel.add(jRadioButtonRock);
		radioButtonPanel.add(jRadioButtonPaper);
		radioButtonPanel.add(jRadioButtonScissors);
		//radioButtonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		playPanel.add(playButton);
		
		gamePanel.add(selectLabelPanel);
		//gamePanel.add(radioButtonPanel, BorderLayout.CENTER);
		gamePanel.add(radioButtonPanel);
		gamePanel.add(playPanel);
		//gamePanel.add(playButton);
		
		this.add(gamePanel);

	}
	
	public int getUserSelection(){
		//return Integer.parseInt(firstNumber.getText());
		ButtonModel bM = groupUserSelection.getSelection();
		if (bM!=null) {
			String s = bM.getActionCommand();
			//System.out.println("getActionCommand"+s);
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

	public void showGameResult(int userSelection, int computerSelection, int gameResult) {
		//System.out.println(gameResult);

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
	
	void addGameListener(ActionListener listenForPlayButton){
		//System.out.println("Hello");
		playButton.addActionListener(listenForPlayButton);
		
	}
	
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
