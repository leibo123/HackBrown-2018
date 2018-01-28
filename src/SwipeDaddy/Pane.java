package SwipeDaddy;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Pane {
	
	private BorderPane _pane;
	private VBox _vBox;
	private Button _needButton;
	private Button _haveButton;
	
	
	public Pane() {
		_pane = new BorderPane();
		_pane.setStyle("-fx-background-color: moccasin");
		
		
		this.loadPane();
		
		

	}
	
	public BorderPane getPane() {
		return _pane;
	}
	
	public void loadPane() {
		_vBox = new VBox();
		_pane.setCenter(_vBox);
		_vBox.setSpacing(80);

		_needButton = new Button("NEED");
		_needButton.setFont(new Font("Georgia", 50));
		_needButton.setStyle("-fx-background-color: darkorange");
		_needButton.setPrefWidth(300);
		_needButton.setPrefHeight(150);
		_needButton.setOnAction(new ClickHandler());
	
		
		_haveButton = new Button("HAVE");
		_haveButton.setFont(new Font("Georgia", 50));
		_haveButton.setStyle("-fx-background-color: gold");
		_haveButton.setPrefWidth(300);
		_haveButton.setPrefHeight(150);
		_vBox.setAlignment(Pos.CENTER);
		_vBox.getChildren().addAll(_needButton, _haveButton);
		
	}
	
	public void loadPane2() {
		_vBox = new VBox();
		_pane = new BorderPane();
		_pane.setCenter(_vBox);
		_vBox.setSpacing(20);
		CheckBox refectory = new CheckBox("Sharpe Refectory");
		CheckBox dub = new CheckBox("Verney-Wooley");
		CheckBox andrews = new CheckBox("Andrews Commons");
		CheckBox blue = new CheckBox("Blue Room");
		CheckBox ivy = new CheckBox("Ivy Room");
		CheckBox jo = new CheckBox("Josiah's");
		//refectoryBox.setAlignment(Pos.TOP_CENTER);
		_vBox.getChildren().addAll(refectory, dub, andrews, blue, ivy, jo);

		
		
	}
	
	private class ClickHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			_pane.getChildren().remove(_vBox);
			Pane.this.loadPane2();
			event.consume();
		}
	}
	
	
}