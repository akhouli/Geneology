package Graphics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import Logic.Tree;
import Graphics.TreeScreenModel;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TreeScreen_3 extends Application{

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
//		EventHandler<MouseEvent> addChildEvent = new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent event) {
//				Text addSiteText = new Text(100, 200, "add node screen");
//				Group addGroup = new Group(addSiteText);
//				Scene addscreen = new Scene(addGroup, 1100, 850);
//				primaryStage.setScene(addscreen);
//				
//			}
//		};
		
		
		
//		primaryStage.setScene(ach.getAddChildScene());
		
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
		
		
//			Tree Lilly = new Tree("Lilly", "Schwarzenbach", false, "19-11-1995", "Riggisberg", 1);
//			Tree Felix = new Tree("Felix", "Schwarzenbach", true, "17-02-1959", "Wädenswil", 1);
//			Tree Susanna = new Tree("Susanna", "Schwarzenbach", false, "30-06-1963", "Bern", 1);
//			Tree Fanny = new Tree("Fanny", "Schwarzenbach", false, "04-05-1995", "Jegenstorf", 1);
//			Tree Fritz = new Tree("Fritz", "Schwarzenbach", true, "21-10-1925", "Zürich", 1, "09-06-2018", "Bern");
//			Tree Hedi = new Tree("Hedi", "Schwarzenbach", false, "21-11-1925", "Wädenswil", 1, "12-04-1973", "Davos");
//			Tree Hans = new Tree("Hans", "Moser", true, "16-03-1931", "Krauchthal", 1, "14-08-2015", "Bäriswil");
//			Tree Käthi = new Tree("Käthi", "Moser", false, "21-03-1936", "Hindelbank", 1);
//			Tree Hasi = new Tree("Hasi", "Schwarzenbach", true, "31-07-1953", "Wädenswil", 1);
//			Tree Heidi = new Tree("Heidi", "Stähli", false, "31-07-1955", "Wädenswil", 1);
//			Tree Susi = new Tree("Susi", "Schwarzenbach", false, "12-10-1962", "Wädenswil", 1);
//			Tree Silja = new Tree("Silja", "Stähli", false, "23-05-1986", "Wädenswil", 1);
//			Tree Patrick = new Tree("Patrick", "Wiesli", true, "24.04.1989", "St.Gallen", 1);
//			Tree Benjamin = new Tree("Benjamin", "Noclue", true, "no clue", "no clue", 1);
//			Tree Ronja = new Tree("Ronja", "Noclue", false, "no clue", "no clue", 1);
//			Tree Jürg = new Tree("Jürg", "Moser", true, "", "", 1);
//			Tree Madlen = new Tree("Madlen", "Moser", false, "", "", 1, "2003", "Bern");
//			Tree Urs = new Tree("Urs", "Moser", true, "", "", 1);
//			Tree Johanna = new Tree("Johanna","Moser", false, "", "", 1);
//			Tree Lara = new Tree("Lara", "Moser", false, "","", 1);
//			Tree Florian = new Tree("Florian", "Moser", true, "", "", 1);
//			Tree Nina = new Tree("Nina", "Moser", false, "", "", 1);
//			Tree Michel = new Tree("Michel", "Moser", true, "", "", 1);
//		
//		Lilly.addParent(Felix);
//		Felix.addSpouse(Susanna);
////////		Susanna.addChild(Fanny);
//		Felix.addParent(Fritz);
//		Fritz.addChild(Hasi);
//		Felix.addParent(Hedi);
//		Susanna.addParent(Hans);
//		Susanna.addParent(Käthi);
//		Fritz.addChild(Susi);
////////		Fritz.addParent(Hans);
//		Lilly.setBiography("Learning Java");
//		Lilly.addSibling(Fanny);
////////		Lilly.addSibling(Käthi);
//		Felix.addSibling(Heidi);
//		Heidi.addChild(Silja);
////////		Fanny.addChild(Patrick);
//		Fanny.addSpouse(Patrick);
//		Silja.addSpouse(Benjamin);
//		Silja.addChild(Ronja);
////////		Hans.addChild(Susi);
//		Susanna.addSibling(Jürg);
//		Käthi.addChild(Madlen);
//		Hans.addChild(Urs);
//		Urs.addChild(Johanna);
//		Urs.addChild(Lara);
//		Lara.addSibling(Florian);
//		Jürg.addChild(Nina);
//		Jürg.addChild(Michel);
////////		Fritz.addParent(Käthi);
//		ArrayList<Tree> trees = new ArrayList<>();
////		ArrayList<Tree> trees = TreeScreenModel.getNodes();
//////		System.out.println(trees);
//		trees.add(Lilly);
//		trees.add(Felix);
//		trees.add(Susanna);
//		trees.add(Fanny);  
//		trees.add(Fritz);
////////		System.out.println(Fritz.getChildren());
////////		System.out.println("Hans : " + Hans.getChildren());
////////		System.out.println(Felix.getChildren());
//////
//		trees.add(Hedi);
//		trees.add(Hans);
//		trees.add(Käthi);
//		trees.add(Hasi);
//		trees.add(Heidi);
//		trees.add(Susi);
//		trees.add(Silja);
//		trees.add(Benjamin);
//		trees.add(Ronja);
//		trees.add(Patrick);
//		trees.add(Jürg);
//		trees.add(Urs);
//		trees.add(Madlen);
//		trees.add(Johanna);
//		trees.add(Michel);
//		trees.add(Nina);
//		trees.add(Florian);
//		trees.add(Lara);
////		
//		
		
//		Tree focused = Lilly;
		Tree L = new Tree("Lilly", "Schwarzenbach", false, "19-11-1995", "Riggisberg", 1);
		Tree focused = L;

		Tree F = focused;
		Tree parent = F;
		Tree ch = L;
//		Group g = new Group(back, help, textbox, firstname, lastname, gender, birthdate, birthplace, deathdate, deathplace, bio, firstnameText, lastnameText, genderText, birthdateText, birthplaceText, deathdateText,
//				deathplaceText, bioText, addParentButton, addChildButton, addSpouseButton, addSiblingButton, deletePersonButton, alterPersonButton)
//		Scene s = new Scene(g, 1100, 850);
//		s.setFill(Color.MEDIUMSEAGREEN);

		
		Group r = new Group();
		r.getChildren().addAll(TreeScreenModel.generateNodes(root, trees, primaryStage, focused).getChildren());
//		root.getChildren().
		Scene scene = new Scene(r, 1100, 850);
		scene.setFill(Color.MEDIUMSEAGREEN);

		AddChildHandler ach = new AddChildHandler(primaryStage, scene, ch, parent);
		addChildButton.addEventFilter(MouseEvent.MOUSE_CLICKED, ach);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("FamilyTree");
		primaryStage.show();
//		System.out.println("-----------SUSI\n " + Susi + "\n------------------\n\n");

	}
	

	
	
	
public static void main(String[] args) {
		launch();
	}
}
