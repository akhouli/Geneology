package Graphics;

import java.util.ArrayList;

import Logic.Tree;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TreeScreen extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		/**
		 * creating the button to go back to the previous page/startpage
		 */
		Button back = new Button("back");
		back.setLayoutX(10);
		back.setLayoutY(820);
		EventHandler<MouseEvent> backEvent = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Text startText = new Text("startscreen");
				startText.setX(400);
				startText.setY(400);
				Group startgroup = new Group(startText);
				Scene startscreen = new Scene(startgroup, 1100, 850);
				primaryStage.setScene(startscreen);
				
			}
		};
		back.addEventFilter(MouseEvent.MOUSE_CLICKED, backEvent);
		
		/**
		 * creating the button to go to the helppage
		 */
		Button help = new Button("help");
		help.setLayoutX(10);
		help.setLayoutY(780);
		EventHandler<MouseEvent> helpEvent = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Text startText = new Text("helpscreen");
				startText.setX(400);
				startText.setY(400);
				Group startgroup = new Group(startText);
				Scene startscreen = new Scene(startgroup, 1100, 850);
				primaryStage.setScene(startscreen);
				
			}
		};
		help.addEventFilter(MouseEvent.MOUSE_CLICKED, helpEvent);

		/**
		 * creating the textbox that shows the information about a person when the person is selected
		 */
		int y = 100;
		int ydiff = 30;
		
		//the actual box
		Rectangle textbox = new Rectangle(200, ydiff*9, Color.PALEGREEN);
		textbox.setX(15);
		textbox.setY(y-ydiff);
		textbox.setStrokeWidth(5);
		textbox.setStroke(Color.BLACK);
		
		//the 'firstname' text that is always displayed
		int xLabels = 20;
		Text firstname = new Text("Firstname: " );
		firstname.setX(xLabels);
		firstname.setY(y);
		firstname.setFont(Font.font("System Regular", FontWeight.BOLD, 11));
		
		//the 'lastname' text that is always displayed
		Text lastname = new Text("Lastname: " );
		lastname.setX(xLabels);
		lastname.setY(y+ydiff);
		lastname.setFont(Font.font("System Regular", FontWeight.BOLD, 11));
		
		//the 'gender' text that is always displayed
		Text gender = new Text("Gender: " );
		gender.setX(xLabels);
		gender.setY(y+ydiff*2);
		gender.setFont(Font.font("System Regular", FontWeight.BOLD, 11));
		
		//the birth date text that is always displayed
		Text birthdate = new Text("Born on: " );
		birthdate.setX(xLabels);
		birthdate.setY(y+ydiff*3);
		birthdate.setFont(Font.font("System Regular", FontWeight.BOLD, 11));
		
		//the birth place text that is always displayed
		Text birthplace = new Text("Born in: ");
		birthplace.setX(xLabels);
		birthplace.setY(y+ydiff*4);
		birthplace.setFont(Font.font("System Regular", FontWeight.BOLD, 11));
		
		//the death date text that is always displayed
		Text deathdate = new Text("Died on: ");
		deathdate.setX(xLabels);
		deathdate.setY(y+ydiff*5);
		deathdate.setFont(Font.font("System Regular", FontWeight.BOLD, 11));
		
		//the death place text that is always displayed
		Text deathplace = new Text("Died in: ");
		deathplace.setX(xLabels);
		deathplace.setY(y+ydiff*6);
		deathplace.setFont(Font.font("System Regular", FontWeight.BOLD, 11));
		
		//the 'biography' text that is always displayed
		Text bio = new Text("Biography: ");
		bio.setX(xLabels);
		bio.setY(y+ydiff*7);
		bio.setFont(Font.font("System Regular", FontWeight.BOLD, 11));
		
		
		/**
		 * creating the fields where the attributes of a person will be displayed
		 */
		int xDisplayText = 100;
		
		// firstname
		Text firstnameText = new Text("");
		firstnameText.setX(xDisplayText);
		firstnameText.setY(y);
		
		//lastname
		Text lastnameText = new Text("");
		lastnameText.setX(xDisplayText);
		lastnameText.setY(y+ydiff);
		
		//gender
		Text genderText = new Text("");
		genderText.setX(xDisplayText);
		genderText.setY(y+ydiff*2);
		
		//birth date
		Text birthdateText = new Text("");
		birthdateText.setX(xDisplayText);
		birthdateText.setY(y+ydiff*3);
		
		//birth place
		Text birthplaceText = new Text("");
		birthplaceText.setX(xDisplayText);
		birthplaceText.setY(y+ydiff*4);
		
		//death date
		Text deathdateText = new Text("");
		deathdateText.setX(xDisplayText);
		deathdateText.setY(y+ydiff*5);
		
		//death place
		Text deathplaceText = new Text("");
		deathplaceText.setX(xDisplayText);
		deathplaceText.setY(y+ydiff*6);
		
		//biography
		Text bioText = new Text("");
		bioText.setX(xLabels);
		bioText.setY(y+ydiff*7.7);
		
		/**
		 * creating the button to alter the selected person
		 */
		Button alterPersonButton = new Button("Alter this person's information");
		alterPersonButton.setLayoutX(xLabels);
		alterPersonButton.setLayoutY(y + ydiff*8.5);
		alterPersonButton.setMinWidth(190);
//		alterPersonButton.setAlignment(Pos.BASELINE_LEFT);
		EventHandler<MouseEvent> alterPersonEvent = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Text addSiteText = new Text(100, 200, "add node screen");
				Group addGroup = new Group(addSiteText);
				Scene addscreen = new Scene(addGroup, 1100, 850);
				primaryStage.setScene(addscreen);
				
			}
		};
		alterPersonButton.addEventFilter(MouseEvent.MOUSE_CLICKED, alterPersonEvent);
		
		/**
		 * creating the button to delete the selected person
		 */
		Button deletePersonButton = new Button("Delete this person");
		deletePersonButton.setLayoutX(xLabels);
		deletePersonButton.setLayoutY(y + ydiff*13.5);
		deletePersonButton.setMinWidth(190);
		EventHandler<MouseEvent> deletePersonEvent = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				//TO DO
				
			}
		};
		deletePersonButton.addEventFilter(MouseEvent.MOUSE_CLICKED, deletePersonEvent);
		
		/**
		 * creating the buttons to add new nodes
		 */
		
		//add a parent node
		Button addParentButton = new Button("Add Parent");
		addParentButton.setLayoutX(xLabels);
		addParentButton.setLayoutY(y + ydiff*9.5);
		addParentButton.setMinWidth(190);
		EventHandler<MouseEvent> addParentEvent = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Text addSiteText = new Text(100, 200, "add node screen");
				Group addGroup = new Group(addSiteText);
				Scene addscreen = new Scene(addGroup, 1100, 850);
				primaryStage.setScene(addscreen);
				
			}
		};
		addParentButton.addEventFilter(MouseEvent.MOUSE_CLICKED, addParentEvent);
		
		//add a child node
		Button addChildButton = new Button("Add Child");
		addChildButton.setLayoutX(xLabels);
		addChildButton.setLayoutY(y + ydiff*10.5);
		addChildButton.setMinWidth(190);
		EventHandler<MouseEvent> addChildEvent = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Text addSiteText = new Text(100, 200, "add node screen");
				Group addGroup = new Group(addSiteText);
				Scene addscreen = new Scene(addGroup, 1100, 850);
				primaryStage.setScene(addscreen);
				
			}
		};
		addChildButton.addEventFilter(MouseEvent.MOUSE_CLICKED, addChildEvent);
		
		//add a spouse
		Button addSpouseButton = new Button("Add Spouse");
		addSpouseButton.setLayoutX(xLabels);
		addSpouseButton.setLayoutY(y + ydiff*11.5);
		addSpouseButton.setMinWidth(190);
		EventHandler<MouseEvent> addSpouseEvent = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Text addSiteText = new Text(100, 200, "add node screen");
				Group addGroup = new Group(addSiteText);
				Scene addscreen = new Scene(addGroup, 1100, 850);
				primaryStage.setScene(addscreen);
				
			}
		};
		addSpouseButton.addEventFilter(MouseEvent.MOUSE_CLICKED, addSpouseEvent);
		
		//add a sibling
		Button addSiblingButton = new Button("Add Sibling");
		addSiblingButton.setLayoutX(xLabels);
		addSiblingButton.setLayoutY(y + ydiff*12.5);
		addSiblingButton.setMinWidth(190);
		EventHandler<MouseEvent> addSiblingEvent = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Text addSiteText = new Text(100, 200, "add node screen");
				Group addGroup = new Group(addSiteText);
				Scene addscreen = new Scene(addGroup, 1100, 850);
				primaryStage.setScene(addscreen);
				
			}
		};
		addSiblingButton.addEventFilter(MouseEvent.MOUSE_CLICKED, addSiblingEvent);
		
		/**
		 * adding all of the above elements into the Group
		 */
		Group root = new Group(back, help, textbox, firstname, lastname, gender, birthdate, birthplace, deathdate, deathplace, bio, firstnameText, lastnameText, genderText, birthdateText, birthplaceText, deathdateText,
				deathplaceText, bioText, addParentButton, addChildButton, addSpouseButton, addSiblingButton, deletePersonButton, alterPersonButton);

		
		/**
		 * creating the test nodes. Will have to be removed once the DB is added
		 */
		Tree Lilly = new Tree("Lilly", "Schwarzenbach", false, "19-11-1995", "Riggisberg", 1);
		Tree Felix = new Tree("Felix", "Schwarzenbach", true, "17-02-1959", "Wädenswil", 1);
		Tree Susanna = new Tree("Susanna", "Schwarzenbach", false, "30-06-1963", "Bern", 1);
		Tree Fanny = new Tree("Fanny", "Schwarzenbach", false, "04-05-1995", "Jegenstorf", 1);
		Tree Fritz = new Tree("Fritz", "Schwarzenbach", true, "21-10-1925", "Zürich", 1, "09-06-2018", "Bern");
		Tree Hedi = new Tree("Hedi", "Schwarzenbach", false, "21-11-1925", "Wädenswil", 1, "12-04-1973", "Davos");
		Tree Hans = new Tree("Hans", "Moser", true, "16-03-1931", "Krauchthal", 1, "14-08-2015", "Bäriswil");
		Tree Käthi = new Tree("Käthi", "Moser", false, "21-03-1936", "Hindelbank", 1);
		Tree Hasi = new Tree("Hasi", "Schwarzenbach", true, "31-07-1953", "Wädenswil", 1);
		Tree Heidi = new Tree("Heidi", "Stähli", false, "31-07-1955", "Wädenswil", 1);
		
		Lilly.addParent(Felix);
		Felix.addSpouse(Susanna);
//		Susanna.addChild(Fanny);
		Felix.addParent(Fritz);
		Felix.addParent(Hedi);
		Susanna.addParent(Hans);
		Susanna.addParent(Käthi);
		Lilly.setBiography("Learning Java");
		ArrayList<Tree> trees = new ArrayList<>();
		trees.add(Lilly);
		trees.add(Felix);
		trees.add(Susanna);
//		trees.add(Fanny);  
//		trees.add(Fritz);
//		trees.add(Hedi);
//		trees.add(Hans);
//		trees.add(Käthi);
		
		/**
		 * for every node, a Button is created
		 */
		for(Tree t : trees) {
			Button treebutton = new Button(t.getFirstName());
			treebutton.setShape(new Circle(10));
			treebutton.setStyle("-fx-background-color: #98FB98; -fx-border-width: 2px;-fx-border-color: #006400");
			treebutton.setMinSize(50, 40);
//			treebutton.setMaxSize(90, 30);
			if(t.getChildren() != null && t.getMale()) {
				treebutton.setLayoutX(610-50);
			}
			else if(t.getChildren() != null) {
				treebutton.setLayoutX(610+50);
			}
			else {
				treebutton.setLayoutX(610);
			}
			treebutton.setLayoutY(425+(t.getTreeLevel()*50));
			EventHandler<MouseEvent> nodeEvent = new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
//					treebutton.setStyle("-fx-background-color: #EEE8AA");
					firstnameText.setText(t.getFirstName());
					lastnameText.setText(t.getLastName());
					birthdateText.setText(t.getBirthDate());
					birthplaceText.setText(t.getBirthPlace());
					deathdateText.setText(t.getDeathDate());
					deathplaceText.setText(t.getDeathPlace());
					bioText.setText(t.getBiography());
					if(t.getMale()) {
						genderText.setText("male");
					}
					else {
						genderText.setText("female");
					}
				}
			};
			treebutton.addEventFilter(MouseEvent.MOUSE_CLICKED, nodeEvent);
			root.getChildren().add(treebutton);
		}

		Scene scene = new Scene(root, 1100, 850);
		scene.setFill(Color.MEDIUMSEAGREEN);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
public static void main(String[] args) {
		launch();
	}
}
