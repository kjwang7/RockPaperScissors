
public class MVCGame {

	public static void main(String[] args) {

		GameView view1 = new GameView();
        
    	GameModel model1 = new GameModel();
        
        GameController theController = new GameController(view1,model1);
        
        view1.setVisible(true);

	}

}
