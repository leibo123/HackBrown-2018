package SwipeDaddy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {

	private Stage mainstage;
	private Scene searchscene;
	private Scene sharescene;
	public Sharing demo = new Sharing();
	
	public HBox addHBox() {
	    HBox hbox = new HBox();
	    hbox.setPadding(new Insets(15, 12, 15, 12));
	    hbox.setSpacing(50);
	    //hbox.setStyle("-fx-background-color: #336699;");

	    Button buttonMenus = new Button("Menus");
	    buttonMenus.setPrefSize(100, 30);
	    buttonMenus.setOnAction(new EventHandler<ActionEvent>() {
	        @Override public void handle(ActionEvent e) {
	            mainstage.setScene(searchscene);
	        }
	    });
	    Button buttonSharing = new Button("Sharing");
	    buttonSharing.setPrefSize(100, 30);
	    buttonSharing.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override public void handle(ActionEvent e) {
	    		mainstage.setScene(sharescene);
	    	}
	    });
	    hbox.getChildren().addAll(buttonMenus, buttonSharing);
	    return hbox;
	}
	public VBox addMenuVBox() {
	    VBox vbox = new VBox();
	    vbox.setPadding(new Insets(10));
	    vbox.setSpacing(8);
	    
	    Text title = new Text("Sharpe Refectory");
	    title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
	    vbox.getChildren().add(title);

	    Text options[] = new Text[] {
	    	new Text("Chicken Cajun Pasta"),
	    	new Text("Curried Rice"),
	    	new Text("Chana Masala"),
	    	new Text("Sorry ran out of time to implement this! \nSee CSVReader.java and Menus.java")};

	    for (int i=0; i<4; i++) {
	        VBox.setMargin(options[i], new Insets(0, 0, 0, 8));
	        vbox.getChildren().add(options[i]);
	    }

	    return vbox;
	}
	
	public VBox addShareVBox() {
	    VBox vbox = new VBox();
	    vbox.setPadding(new Insets(10));
	    vbox.setSpacing(8);
	    
	    Text title = new Text("People looking for meal swipes");
	    title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
	    vbox.getChildren().add(title);

	    List<Button> options = new ArrayList<>();
	    List<String> eaterlist = new ArrayList<>();
	    eaterlist = demo.allEaterInfo();
	    for (String eater : eaterlist) {
	    	Button eaterselect = new Button(eater);
	    	eaterselect.setOnAction(new EventHandler<ActionEvent>() {
		    	@Override public void handle(ActionEvent e) {
		    		int index = eater.indexOf("-");
		    		String eatername = eater.substring(0, index);
		    		Eater eat = demo.getEater(eatername);
		    		Alert alert = new Alert(AlertType.CONFIRMATION);
		    		alert.setTitle(eat.getName());
		    		alert.setHeaderText(eat.getName() + "\n" + eat.getPreferences() + "\nLevel: " + eat.getLevel() + "\nInfo: " + eat.getInfo());
		    		alert.setContentText(eat.getComments() + "\nSwipe this user?");

		    		Optional<ButtonType> result = alert.showAndWait();
		    		if (result.get() == ButtonType.OK){
		    		    // ... user chose OK
			    		demo.removeEater(eatername);
			    		BorderPane newshareborder = new BorderPane();
			    		VBox sharevbox = addShareVBox();
			    		HBox sharehbox = addHBox();
			    		newshareborder.setTop(sharehbox);
			    		newshareborder.setCenter(sharevbox);
			    		Scene newsharescene = new Scene(newshareborder, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
			    		mainstage.setScene(newsharescene);
		    		} else {
		    		    // ... user chose CANCEL or closed the dialog
		    		}
		    		
		    	}
		    });
	    	options.add(eaterselect);
	    }

	    for (int i=0; i<options.size(); i++) {
	        VBox.setMargin(options.get(i), new Insets(0, 0, 0, 8));
	        vbox.getChildren().add(options.get(i));
	    }

	    return vbox;
	}
	
	public VBox startInfoBox() {
	    VBox vbox = new VBox();
	    vbox.setPadding(new Insets(10));
	    vbox.setSpacing(8);
	    
	    Text title = new Text("Swipe Daddy Demo");
	    title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
	    vbox.getChildren().add(title);

	    Text options[] = new Text[] {
	    	new Text("Use the top two buttons to try out the app's functionality."),
	    	new Text("In Menus, you can perform a search and filter on a portion of \n"
	    			+ " one of the Dining Hall's foods which have been loaded in via a CSV."),
	    	new Text("In Sharing, you can see a list of people who are requesting meal \n"
	    			+ " swipes and 'accept' their request from the POV of a swiper."),
	    	new Text("Please take a look at the UI prototype and the code's documentation \n"
	    			+ " for a more comprehensive view of functionality and UI/UX.")};

	    for (int i=0; i<4; i++) {
	        VBox.setMargin(options[i], new Insets(0, 0, 0, 8));
	        vbox.getChildren().add(options[i]);
	    }

	    return vbox;
	}
	
    @Override
    public void start(Stage stage) {
    	//initialize the main stage
    	mainstage = stage;
    	
    	//initialize the scene to demonstrate first launch start up page
    	BorderPane border = new BorderPane();
    	HBox hbox = addHBox();
    	border.setTop(hbox);
    	VBox startInfo = startInfoBox();
    	border.setCenter(startInfo);
		Scene scene = new Scene(border, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
		
		//Initialize scene to demonstrate menus and search/filter functionality
		BorderPane searchborder = new BorderPane();
		VBox searchvbox = addMenuVBox();
		HBox searchhbox = addHBox();
		searchborder.setTop(searchhbox);
		searchborder.setCenter(searchvbox);
		searchscene = new Scene(searchborder, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
		
		//Test the joining of users by adding some people looking for a swipe
		demo.addEater(new Eater("Sarah T.", new ArrayList<>()));
		demo.addEater(new Eater("David J.", Arrays.asList(Menus.ratty, Menus.jos, Menus.vdub)));
		demo.addEater(new Eater("Alex C.", Arrays.asList(Menus.andrews)));
		
		//Initialize scene to demonstrate sharing functionality
		BorderPane shareborder = new BorderPane();
		VBox sharevbox = addShareVBox();
		HBox sharehbox = addHBox();
		shareborder.setTop(sharehbox);
		shareborder.setCenter(sharevbox);
		sharescene = new Scene(shareborder, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
		
		//Set the initial scene of the main stage
		mainstage.setScene(scene);
		mainstage.setTitle("Swipe Daddy");
		mainstage.setX(200);
		mainstage.show();
		
		
		
//		Stage testStage = new Stage();
//		TestPane testPane = new TestPane();
//		Scene testScene = new Scene(testPane.getPane(), Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
//		testStage.setScene(testScene);
//		testStage.setTitle("Test");
//		testStage.setX(700);
//		testStage.show();
		
    }

    public static void main(String[] argv) {
        launch(argv);
    }
}
