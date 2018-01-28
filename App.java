package SwipeDaddy;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
    		Pane pane = new Pane();
		Scene scene = new Scene(pane.getPane(), Constants.SCENE_WIDTH,
			Constants.SCENE_HEIGHT);
		stage.setScene(scene);
		stage.setTitle("Swipe Daddy");
		stage.setX(200);
		stage.show();
		
		Stage testStage = new Stage();
		TestPane testPane = new TestPane();
		Scene testScene = new Scene(testPane.getPane(), Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
		testStage.setScene(testScene);
		testStage.setTitle("Test");
		testStage.setX(700);
		testStage.show();
		
    }

    public static void main(String[] argv) {
        launch(argv);
    }
}
