import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

// The Controller coordinates interactions
// between the View and Model

public class GameController {

	private GameView view1;
	private GameModel model1;

	public GameController(GameView view1, GameModel model1) {
		this.view1 = view1;
		this.model1 = model1;

		// Tell the View that when ever the calculate button
		// is clicked to execute the actionPerformed method
		// in the CalculateListener inner class

		this.view1.addGameListener(new GameListener());
	}

	class GameListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			//System.out.println("Hello");
			int userSelection = 0;

			// Surround interactions with the view with
			// a try block in case numbers weren't
			// properly entered

			//try{

				userSelection = view1.getUserSelection();

				Random ran = new Random();
				int computerSelection = ran.nextInt(3)+1;
				
				model1.setGameResult(userSelection, computerSelection);
				int gameResult = model1.getGameResult();

				view1.showGameResult(userSelection, computerSelection, gameResult);

			//}

			//catch(NumberFormatException ex){

			//	System.out.println(ex);

			//	view1.displayErrorMessage("You Need to Enter 2 Integers");

			//}

		}

	}

}


