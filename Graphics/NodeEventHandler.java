package Graphics;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import Logic.Tree;

public class NodeEventHandler implements EventHandler<MouseEvent> {
	ToggleGroup tg;
	Group root;
	Stage stage;
	
	public NodeEventHandler(Tree t, Stage stage, Group root, ToggleGroup tg) {
		this.stage = stage;
		this.root = root;
		this.tg = tg;
	}
		public void handle(MouseEvent event) {
			System.out.println(root.getChildren());
//			ToggleButton selected = (ToggleButton) tg.getSelectedToggle();
			ObservableList<Toggle> tgs = tg.getToggles();
			for(Toggle t : tgs) {
				ToggleButton current = (ToggleButton) t;
				if(current.isSelected()) {
					if(current.getStyle() == "-fx-background-color: #87CEFA; -fx-border-width: 2px;-fx-border-color: #006400") {
						current.setStyle("-fx-background-color: #87CEFA; -fx-border-width: 3px;-fx-border-color: #EEE8AA");
					}
					else if(current.getStyle() == "-fx-background-color: #FFB6C1; -fx-border-width: 2px;-fx-border-color: #006400"){
						current.setStyle("-fx-background-color: #FFB6C1; -fx-border-width: 3px;-fx-border-color: #EEE8AA");
//						treebutton.setStyle("-fx-background-color: #FFB6C1; -fx-border-width: 2px;-fx-border-color: #006400");
					}
//					current.setStyle("-fx-background-color: #EEE8AA; -fx-border-width: 2px;-fx-border-color: #006400");
				}
//				Color.gold
				else {
//					System.out.println(current.getStyle());
					if(current.getStyle() == "-fx-background-color: #87CEFA; -fx-border-width: 3px;-fx-border-color: #EEE8AA") {
						current.setStyle("-fx-background-color: #87CEFA; -fx-border-width: 2px;-fx-border-color: #006400");
					}
					else if(current.getStyle() == "-fx-background-color: #FFB6C1; -fx-border-width: 3px;-fx-border-color: #EEE8AA"){
						current.setStyle("-fx-background-color: #FFB6C1; -fx-border-width: 2px;-fx-border-color: #006400");
//						treebutton.setStyle("-fx-background-color: #FFB6C1; -fx-border-width: 2px;-fx-border-color: #006400");
					}
//					current.setStyle("-fx-background-color: #98FB98; -fx-border-width: 2px;-fx-border-color: #006400");
				}
			}
//			firstnameText.setText(t.getFirstName());
//			lastnameText.setText(t.getLastName());
//			birthdateText.setText(t.getBirthDate());
//			birthplaceText.setText(t.getBirthPlace());
//			deathdateText.setText(t.getDeathDate());
//			deathplaceText.setText(t.getDeathPlace());
//			bioText.setText(t.getBiography());
//			if(t.getMale()) {
//				genderText.setText("male");
//			}
//			else {
//				genderText.setText("female");
//			}
//			treebutton.setSelected(true);
//			treebutton.setStyle("-fx-background-color: #EEE8AA");

		}
	


}
