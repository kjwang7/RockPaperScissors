/**
 * Model for the Rock Paper Scissors game
 * @author Kevin
 *
 */
public class GameModel {

		private int gameResult;
		
		/**
		 * Set gameResult to +1 if user defeats computer. -1 if computer defeats user. 0 if tie. 2 beats 1. 3 beats 2. 1 beats 3.
		 * @param userSelection User selected value: one of 1 -- For Rock 2 -- For Paper 3 -- For Scissors
		 * @param computerSelection Computer generated value: one of 1 -- For Rock 2 -- For Paper 3 -- For Scissors
		 */
		public void setGameResult(int userSelection, int computerSelection) {
			if (userSelection == 1) {
				if (computerSelection == 1) {
					gameResult = 0;
				}
				else if (computerSelection == 2) {
					gameResult = -1;
				}
				else { // computerSelection == 3
					gameResult = 1;
				}
			}
			else if (userSelection == 2) {
				if (computerSelection == 1) {
					gameResult = 1;
				}
				else if (computerSelection == 2) {
					gameResult = 0;
				}
				else { // computerSelection == 3
					gameResult = -1;
				}				
			}
			else if (userSelection == 3) {
				if (computerSelection == 1) {
					gameResult = -1;
				}
				else if (computerSelection == 2) {
					gameResult = 1;
				}
				else { // computerSelection == 3
					gameResult = 0;
				}
			}
			else { // Invalid userSelection
				gameResult = -2;
			}
		}
		
		/**
		 * Get the game result
		 * @return game result
		 */
		public int getGameResult(){
			return gameResult;
		}	
	
}
