import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

// The Controller coordinates interactions
// between the View and Model

public class GameController {

	private GameView theView;
	private GameModel theModel;

	public GameController(GameView theView, GameModel theModel) {
		this.theView = theView;
		this.theModel = theModel;

		// Tell the View that when ever the calculate button
		// is clicked to execute the actionPerformed method
		// in the CalculateListener inner class

		this.theView.addGameListener(new GameListener());
	}

	class GameListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			//System.out.println("Hello");
			int userSelection = 0;

			// Surround interactions with the view with
			// a try block in case numbers weren't
			// properly entered

			//try{

				userSelection = theView.getUserSelection();

				Random ran = new Random();
				int computerSelection = ran.nextInt(3)+1;
				
				theModel.setGameResult(userSelection, computerSelection);
				int gameResult = theModel.getGameResult();

				theView.showGameResult(userSelection, computerSelection, gameResult);

			//}

			//catch(NumberFormatException ex){

			//	System.out.println(ex);

			//	theView.displayErrorMessage("You Need to Enter 2 Integers");

			//}

		}

	}

}


