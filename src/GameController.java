import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Controller for the Rock Paper Scissors game
 * @author Kevin
 *
 */

public class GameController {

	private GameView view1;
	private GameModel model1;

	/**
	 * Constructor
	 * @param view1 game view
	 * @param model1 game model
	 */
	public GameController(GameView view1, GameModel model1) {
		this.view1 = view1;
		this.model1 = model1;

		this.view1.addGameListener(new GameListener());
	}

	class GameListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			int userSelection = 0;

			userSelection = view1.getUserSelection();

			Random ran = new Random();
			int computerSelection = ran.nextInt(3)+1;

			model1.setGameResult(userSelection, computerSelection);
			int gameResult = model1.getGameResult();

			view1.showGameResult(userSelection, computerSelection, gameResult);

		}

	}

}


