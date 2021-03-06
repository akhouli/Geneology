package Graphics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import Logic.Tree;
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

public class TreeScreen_2 extends Application{

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
		
		VBox c = new VBox();
//		c.getChildren().add(e)
		
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
		Tree Felix = new Tree("Felix", "Schwarzenbach", true, "17-02-1959", "W�denswil", 1);
		Tree Susanna = new Tree("Susanna", "Schwarzenbach", false, "30-06-1963", "Bern", 1);
		Tree Fanny = new Tree("Fanny", "Schwarzenbach", false, "04-05-1995", "Jegenstorf", 1);
		Tree Fritz = new Tree("Fritz", "Schwarzenbach", true, "21-10-1925", "Z�rich", 1, "09-06-2018", "Bern");
		Tree Hedi = new Tree("Hedi", "Schwarzenbach", false, "21-11-1925", "W�denswil", 1, "12-04-1973", "Davos");
		Tree Hans = new Tree("Hans", "Moser", true, "16-03-1931", "Krauchthal", 1, "14-08-2015", "B�riswil");
		Tree K�thi = new Tree("K�thi", "Moser", false, "21-03-1936", "Hindelbank", 1);
		Tree Hasi = new Tree("Hasi", "Schwarzenbach", true, "31-07-1953", "W�denswil", 1);
		Tree Heidi = new Tree("Heidi", "St�hli", false, "31-07-1955", "W�denswil", 1);
		Tree Susi = new Tree("Susi", "Schwarzenbach", false, "12-10-1962", "W�denswil", 1);
		Tree Silja = new Tree("Silja", "St�hli", false, "23-05-1986", "W�denswil", 1);
		Tree Patrick = new Tree("Patrick", "Wiesli", true, "24.04.1989", "St.Gallen", 1);
		Tree Benjamin = new Tree("Benjamin", "Noclue", true, "no clue", "no clue", 1);
		Tree Ronja = new Tree("Ronja", "Noclue", false, "no clue", "no clue", 1);
		Tree J�rg = new Tree("J�rg", "Moser", true, "", "", 1);
		Tree Madlen = new Tree("Madlen", "Moser", false, "", "", 1, "2003", "Bern");
		Tree Urs = new Tree("Urs", "Moser", true, "", "", 1);
		Tree Johanna = new Tree("Johanna","Moser", false, "", "", 1);
		Tree Lara = new Tree("Lara", "Moser", false, "","", 1);
		Tree Florian = new Tree("Florian", "Moser", true, "", "", 1);
		Tree Nina = new Tree("Nina", "Moser", false, "", "", 1);
		Tree Michel = new Tree("Michel", "Moser", true, "", "", 1);
		
		Lilly.addParent(Felix);
		Felix.addSpouse(Susanna);
//		Susanna.addChild(Fanny);
		Felix.addParent(Fritz);
		Fritz.addChild(Hasi);
		Felix.addParent(Hedi);
		Susanna.addParent(Hans);
		Susanna.addParent(K�thi);
		Fritz.addChild(Susi);
//		Fritz.addParent(Hans);
		Lilly.setBiography("Learning Java");
		Lilly.addSibling(Fanny);
//		Lilly.addSibling(K�thi);
		Felix.addSibling(Heidi);
		Heidi.addChild(Silja);
//		Fanny.addChild(Patrick);
		Fanny.addSpouse(Patrick);
		Silja.addSpouse(Benjamin);
		Silja.addChild(Ronja);
//		Hans.addChild(Susi);
		Susanna.addSibling(J�rg);
		K�thi.addChild(Madlen);
		Hans.addChild(Urs);
		Urs.addChild(Johanna);
		Urs.addChild(Lara);
		Lara.addSibling(Florian);
		J�rg.addChild(Nina);
		J�rg.addChild(Michel);
//		Fritz.addParent(K�thi);
		ArrayList<Tree> trees = new ArrayList<>();
		
		trees.add(Lilly);
		trees.add(Felix);
		trees.add(Susanna);
		trees.add(Fanny);  
		trees.add(Fritz);
//		System.out.println(Fritz.getChildren());
//		System.out.println("Hans : " + Hans.getChildren());
//		System.out.println(Felix.getChildren());

		trees.add(Hedi);
		trees.add(Hans);
		trees.add(K�thi);
		trees.add(Hasi);
		trees.add(Heidi);
		trees.add(Susi);
		trees.add(Silja);
		trees.add(Benjamin);
		trees.add(Ronja);
		trees.add(Patrick);
		trees.add(J�rg);
		trees.add(Urs);
		trees.add(Madlen);
		trees.add(Johanna);
		trees.add(Michel);
		trees.add(Nina);
		trees.add(Florian);
		trees.add(Lara);
		
//		
		/**
		 * for every node, a Button is created
		 */
		ToggleGroup tg = new ToggleGroup();
		double scale = 1.0;
		int y2 = 800;
		int y1 = 350;
		int x2 = 1000;
		int x1 = 250;
		int maxLevel = trees.get(0).getTreeLevel();
		int minLevel = trees.get(0).getTreeLevel();
		for(Tree t1 : trees) {
			if(t1.getTreeLevel()<minLevel) {
				minLevel = t1.getTreeLevel();
			}
			else if(t1.getTreeLevel()>maxLevel) {
				maxLevel = t1.getTreeLevel();
			}
		}
		

		double numberOfLevels = maxLevel-minLevel + 1;
//		System.out.println("number of levels: " +numberOfLevels);

		
		double maxNodesInOneLevel = 0;
		Comparator<Tree> LevelComp = new Comparator<Tree>() {
			public int compare(Tree t1, Tree t2) {
				return t1.getTreeLevel()-t2.getTreeLevel();
			}
		};
		Comparator<Tree> PosComp = new Comparator<Tree>() {
			public int compare(Tree t1, Tree t2) {
				return (int) t1.getXPos()- (int)t2.getXPos();
			}
		};
//		ArrayList<Tree> temp = trees;
//		Collections.sort(temp, LevelComp);
		
		Tree focused = Lilly;
		int max = 0;
		double levelWithMaxNodes = 0;
		int level = minLevel;
		if(focused != null) {
			levelWithMaxNodes = focused.getTreeLevel();
		}
		else {
			for(int i = 1; i<numberOfLevels; i++) {
				int no = 0;
				for(int j = 0; j<trees.size(); j++) {
					if(trees.get(j).getTreeLevel()==level) {
						no++;
					}
				}
				if(no>max) {
					max = no;
					levelWithMaxNodes = level;
				}
				level++;
			}
		}
		int nodeIndex = 0;
//		System.out.println("max "+max);

			
//		System.out.println("level with max: " + levelWithMaxNodes);
		ArrayList<Tree> sortedTrees = new ArrayList<Tree>();
		ArrayList<Tree> higherTrees = new ArrayList<Tree>();
		ArrayList<Tree> copyTrees = new ArrayList<>();
		copyTrees.addAll(trees);
		for(Tree t : trees) {
			if(t.getTreeLevel() == levelWithMaxNodes) {
				sortedTrees.add(t);
				copyTrees.remove(t);
			}
			if(t.getTreeLevel() < levelWithMaxNodes) {
				higherTrees.add(t);
				copyTrees.remove(t);
			}
		}
		
		System.out.println("Sorted trees:  "+ sortedTrees);
		ArrayList<Tree> sortedWithoutSpouses = new ArrayList<>();
		ArrayList<Tree> siblingTrees = new ArrayList<>();
		
		if(focused != null) {
			siblingTrees.add(focused);
		}
		for(Tree t1 : sortedTrees) {
			if(!t1.equals(focused)) {
				if(t1.getSpouse() != null) {
					if(!siblingTrees.contains(t1.getSpouse())) {
						siblingTrees.add(t1);
					}
					else {
//						System.out.println(t1.getFirstName());
						sortedWithoutSpouses.add(t1);
					}
				}
				else {
					siblingTrees.add(t1);
				}
			}
			
		}
		int middle=(int) Math.ceil(siblingTrees.size()/2.0);

		System.out.println("Sibling trees here:  "+ siblingTrees);

		max = siblingTrees.size();
		
		Collections.sort(higherTrees, LevelComp.reversed());
		Collections.sort(copyTrees, LevelComp);
		sortedTrees.addAll(higherTrees);
		sortedTrees.addAll(copyTrees);
		
		System.out.println("------------------------------------------------------------------------\n");
		for(Tree t : sortedTrees) {
			System.out.println(t.getFirstName());
		}
		System.out.println("------------------------------------------------------------------------\n");

		
		ToggleButton[] tbA = new ToggleButton[trees.size()];
		int i = 0;
		levelWithMaxNodes  = numberOfLevels - (maxLevel -levelWithMaxNodes);
		System.out.println("sibling trees " + siblingTrees);
		for(Tree t : sortedTrees) {
			double treeLevel = numberOfLevels - (maxLevel -t.getTreeLevel());
			System.out.println(t.getFirstName() + " level: " + treeLevel);
			System.out.println("level with max nodes " + levelWithMaxNodes);
			ToggleButton treebutton = new ToggleButton(t.getFirstName());
			treebutton.setShape(new Circle(10));
//			if(t == sortedTrees.get(0)) {
//				treebutton.setLayoutX(500);
//				treebutton.setLayoutY(200);
//			}
			
			if(t.getMale()) {
				treebutton.setStyle("-fx-background-color: #87CEFA; -fx-border-width: 2px;-fx-border-color: #006400");
			}
			else {
				treebutton.setStyle("-fx-background-color: #FFB6C1; -fx-border-width: 2px;-fx-border-color: #006400");
			}
			treebutton.setMinSize(scale*0.8*50, scale*0.8*50);
			treebutton.setMaxSize(scale*0.8*50, scale*0.8*50);
			treebutton.setLayoutY(y1+  scale*(((y2-y1)/2)*((1+2*(treeLevel-levelWithMaxNodes))/numberOfLevels)));
			t.setYPos(y1+  scale*(((y2-y1)/2)*((1+2*(treeLevel-levelWithMaxNodes))/numberOfLevels)));
//			System.out.println("(1+2*treeLevel)/numberOfLevels : "+(1+2*treeLevel)/numberOfLevels);
//			System.out.println(t.getFirstName()+ " y: " + ((y2-y1)/2)*((1+2*treeLevel)/numberOfLevels));
//			if(t.getChildren() != null && t.getMale()) {
//				treebutton.setLayoutX(610-50);
//			}
//			else if(t.getChildren() != null) {
//				treebutton.setLayoutX(610+50);
//			}
//			else {
//				treebutton.setLayoutX(610);
//			}
////			treebutton.setLayoutY(425+(t.getTreeLevel()*50));
//			if(t.getChildren() != null) {
//			allocateChildPositions(t);
//			}
			if(treeLevel==levelWithMaxNodes) {
				System.out.println("HERE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! " + t.getFirstName());
				if(focused != null) {
					if(t.equals(focused)) {
						treebutton.setLayoutX(x1+(x2-x1)/2.0);
//						treebutton.setLayoutY((y2-y1)/2);
						treebutton.setStyle("-fx-background-color: #FFB6C1; -fx-border-width: 3px;-fx-border-color: #EEE8AA");
					}
					else {
						if(siblingTrees.contains(t)) {
							if(siblingTrees.indexOf(t)<middle) {
								System.out.println("<middle " + t.getFirstName());
								treebutton.setLayoutX(scale*(x1+(((x2-x1)/2.0-x1)*3 *((1+2.0*nodeIndex)/max))));
							}
							else {
								System.out.println(">middle " + t.getFirstName());
								if(middle >=3) {
									treebutton.setLayoutX(siblingTrees.get(middle-1).getXPos() - siblingTrees.get(middle-2).getXPos() +scale*((x1+((x2-x1)/2.0-x1)*3 *((1+2.0*nodeIndex)/max))));
								}
								else {
									treebutton.setLayoutX(scale*((x1+((x2-x1)/2.0-x1)*3 *((1+2.0*nodeIndex)/max))));
								}
							}
						}
						else if(t.getMale()){
							treebutton.setLayoutX(t.getSpouse().getXPos() - scale*0.7*60);
						}
						else {
							treebutton.setLayoutX(t.getSpouse().getXPos() + scale*0.7*60);
						}
					}
					
					
				}
				else {
					if(siblingTrees.contains(t) || t.getSpouse() == null) {
		//				System.out.println("Level with most nodes " + ", first name: " + t.getFirstName());
						treebutton.setLayoutX(x1+scale*(x1+((x2-x1)/2.0 *((1+2.0*nodeIndex)/max))));
	//					t.pos =x1+((x2-x1)/2.0 *((1+2.0*nodeIndex)/max));
	//					System.out.println("Level with most nodes, firstname : " + t.getFirstName() + ", position : " + t.pos);
	//					System.out.println((1+2*nodeIndex)/2.0);
	//					System.out.println("max "+ max);
		//				System.out.println(Hasi.pos);
					}
					else if(t.getMale()){
						treebutton.setLayoutX(t.getSpouse().getXPos() - scale*0.8*60);
					}
					else {
						treebutton.setLayoutX(t.getSpouse().getXPos() + scale*0.9*60);
					}
				}
			}
			else if(t.getTreeLevel() < levelWithMaxNodes) {
				
//				System.out.println(Hasi.pos);
				double numberOfChildren=0;
				if(t.getChildren() != null) {
					numberOfChildren = t.getChildren().size();
//					System.out.println(t.getFirstName() +" no children: " + numberOfChildren);
				}
				if(numberOfChildren == 0) {
					treebutton.setLayoutX(300);
				}
				
				else if(numberOfChildren == 1) {
					if(t.getChildren().get(0).getSpouse() == null || (t.getChildren().get(0).getSpouse().getFather() == null && t.getChildren().get(0).getSpouse().getFather() == null)) {
						if(t.getSpouse() != null && t.getMale() == false) {
							treebutton.setLayoutX(t.getChildren().get(0).getXPos() + scale*0.8*60);
						}
						else {
							treebutton.setLayoutX(t.getChildren().get(0).getXPos());
						}
					}
					else {
						System.out.println("here!!!!!!!!!!!!!!!!!!!!!!!");
							if(t.getSpouse() != null && t.getMale() == false) {
								treebutton.setLayoutX(t.getChildren().get(0).getXPos() + scale*260);
							}
							else {
								treebutton.setLayoutX(t.getChildren().get(0).getXPos() + scale*200);
							}
					}
				}
				else {
//					System.out.println(Hasi.pos);
					double offset = 0;
					double potentialOffset = scale*100;
					for(Tree child : t.getChildren()) {
						if(child.getMale() == false && child.getSpouse() != null && (child.getSpouse().getFather() != null || child.getSpouse().getFather() != null)){
							offset = potentialOffset;
							if(child.getSpouse().getFather() != null) {
								offset += Collections.max(child.getSpouse().getFather().getChildren(), PosComp).getXPos();
							}
							else {
								offset += Collections.max(child.getSpouse().getMother().getChildren(), PosComp).getXPos();
							}
						}
						
					}
					
					if(offset == 0) {
						if(t.getSpouse() != null && t.getMale() == false) {
							treebutton.setLayoutX(((Collections.min(t.getChildren(), PosComp)).getXPos() +Collections.max(t.getChildren(), PosComp).getXPos())/2.0+scale*0.8*60);
	//						t.pos = (((Collections.min(t.getChildren(), PosComp)).pos +Collections.max(t.getChildren(), PosComp).pos)/2.0)+60;
						}
						else {
	//						treebutton.setLayoutX(((t.getChildren().get(t.getChildren().size()-1).pos +t.getChildren().get(0).pos)/2.0));
							treebutton.setLayoutX(((Collections.min(t.getChildren(), PosComp)).getXPos() +Collections.max(t.getChildren(), PosComp).getXPos())/2.0);
	//						if(t.equals(Susi)) {
	//						System.out.println(t.getFirstName() + "'s children: " + t.getChildren());
	//						System.out.println("t.getChildren().get(t.getChildren().size()-1).getFirstName() : " +t.getChildren().get(t.getChildren().size()-1).getFirstName());
	//						System.out.println("t.getChildren().get(0).pos) : "+(t.getChildren().get(0).pos));
	//						System.out.println("t.getChildren().get(t.getChildren().size()-1).pos + t.getChildren().get(0).pos)/2: " + (t.getChildren().get(t.getChildren().size()-1).pos + t.getChildren().get(0).pos)/2);
	//						System.out.println("first name : " + t.getFirstName() + ", last child name " +t.getChildren().get(t.getChildren().size()-1).getFirstName() + ", pos " + t.getChildren().get(t.getChildren().size()-1).pos + "; first child pos: " + t.getChildren().get(0).pos);
	//						}
	//						t.pos = ((t.getChildren().get(t.getChildren().size()-1).pos + t.getChildren().get(0).pos)/2.0);
	//						t.pos = ((Collections.min(t.getChildren(), PosComp)).pos +Collections.max(t.getChildren(), PosComp).pos)/2.0;
	//						System.out.println("pos : " + t.pos);
						}
					}
					else {
						if(t.getMale()) {
							treebutton.setLayoutX(offset);
						}
						else {
							treebutton.setLayoutX(offset+scale*0.8*60);
						}
					}
					
				}
				
				
			}
			else {
				if(t.getSpouse() != null && t.getSpouse().getXPos() != 0.0) {
					if(t.getMale()) {
//						System.out.println(t.getSpouse().pos);
						treebutton.setLayoutX(t.getSpouse().getXPos() - scale*60);
	//					t.pos = t.getSpouse().pos + 60;
//						System.out.println("here");
					}
					else {
//						System.out.println(t.getSpouse().pos);
						treebutton.setLayoutX(t.getSpouse().getXPos() + scale*60);
	//					t.pos = t.getSpouse().pos + 60;
//						System.out.println("here");
					}
				}
				else {
					int numberOfSiblings;
					if(t.getFather() != null) {
						numberOfSiblings = t.getFather().getChildren().size()-1;
						allocateChildPositions(t.getFather(), numberOfSiblings);
					}
					else {
						numberOfSiblings = t.getMother().getChildren().size()-1;
						allocateChildPositions(t.getMother(), numberOfSiblings);
					}
					if(numberOfSiblings > 0) {
						if(t.getMother() == null) {
							double minBorder = t.getFather().getXPos() - scale*164;
							double maxBorder = t.getFather().getXPos() + scale*164;
	//						System.out.println("minBorder " + minBorder);
	//						System.out.println("maxBorder " + maxBorder);
	//						System.out.println("t.getFather().pos " + t.getFather().pos);
		
							treebutton.setLayoutX(t.getFather().getXPos()+(maxBorder-minBorder)/2.0 * ((2.0*t.getNoNo())/(numberOfSiblings+1)));
//							t.pos = t.getFather().pos+ (maxBorder-minBorder)/2.0 * ((2.0*t.noNo)/numberOfSiblings);
	//						System.out.println(t.getFirstName() + "pos: " + (t.getFather().pos+ (maxBorder-minBorder)/2.0 * ((1+2.0*t.noNo)/numberOfSiblings)));
						}
						else {
							double minBorder = t.getFather().getXPos() - scale*(564.0/(treeLevel+0.5));
							double maxBorder = t.getFather().getXPos() + scale*(564.0/(treeLevel+0.5));
	//						System.out.println("minBorder " + minBorder);
	//						System.out.println("maxBorder " + maxBorder);
	//						System.out.println("t.getFather().pos " + t.getFather().pos);
	
							treebutton.setLayoutX(t.getFather().getXPos()+ scale*30 + (maxBorder-minBorder)/2.0 * ((2.0*t.getNoNo())/(numberOfSiblings+1)));
//							t.pos = t.getFather().pos+ 30 + (maxBorder-minBorder)/2.0 * ((2.0*t.noNo)/numberOfSiblings);
//							System.out.println(t.getFirstName() + "pos: " + (t.getFather().pos+ (maxBorder-minBorder)/2.0 * ((1+2.0*t.noNo)/numberOfSiblings)));
						}
					}
					else {
						if(t.getMother() == null) {
	//						System.out.println("t.getFather().pos " + t.getFather().pos);
							treebutton.setLayoutX(t.getFather().getXPos());
//							t.pos = t.getFather().pos;
		//					System.out.println("node : " + t.getFirstName() + ", pos: " + t.pos);
						}
						else {
	//						System.out.println("t.getFather().pos " + t.getFather().pos);
							if(t.getFather()==null) {
								treebutton.setLayoutX(t.getMother().getXPos());
//								t.pos = t.getMother().pos;
	//							System.out.println("node : " + t.getFirstName() + ", pos: " + t.pos);
							}
							else {
								treebutton.setLayoutX(t.getFather().getXPos()+scale*30);
//								t.pos = t.getFather().pos;
							}
							
	//						System.out.println("node : " + t.getFirstName() + ", pos: " + t.pos);
						}
	
					}
				}
			}
//			System.out.println(t.getFirstName() + " x: " + t.getTreeLevel());

			EventHandler<MouseEvent> nodeEvent = new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
//					ToggleButton selected = (ToggleButton) tg.getSelectedToggle();
					ObservableList<Toggle> tgs = tg.getToggles();
					for(Toggle t : tgs) {
						ToggleButton current = (ToggleButton) t;
						if(current.isSelected()) {
							if(current.getStyle() == "-fx-background-color: #87CEFA; -fx-border-width: 2px;-fx-border-color: #006400") {
								current.setStyle("-fx-background-color: #87CEFA; -fx-border-width: 3px;-fx-border-color: #EEE8AA");
							}
							else if(current.getStyle() == "-fx-background-color: #FFB6C1; -fx-border-width: 2px;-fx-border-color: #006400"){
								current.setStyle("-fx-background-color: #FFB6C1; -fx-border-width: 3px;-fx-border-color: #EEE8AA");
//								treebutton.setStyle("-fx-background-color: #FFB6C1; -fx-border-width: 2px;-fx-border-color: #006400");
							}
//							current.setStyle("-fx-background-color: #EEE8AA; -fx-border-width: 2px;-fx-border-color: #006400");
						}
//						Color.gold
						else {
//							System.out.println(current.getStyle());
							if(current.getStyle() == "-fx-background-color: #87CEFA; -fx-border-width: 3px;-fx-border-color: #EEE8AA") {
								current.setStyle("-fx-background-color: #87CEFA; -fx-border-width: 2px;-fx-border-color: #006400");
							}
							else if(current.getStyle() == "-fx-background-color: #FFB6C1; -fx-border-width: 3px;-fx-border-color: #EEE8AA"){
								current.setStyle("-fx-background-color: #FFB6C1; -fx-border-width: 2px;-fx-border-color: #006400");
//								treebutton.setStyle("-fx-background-color: #FFB6C1; -fx-border-width: 2px;-fx-border-color: #006400");
							}
//							current.setStyle("-fx-background-color: #98FB98; -fx-border-width: 2px;-fx-border-color: #006400");
						}
					}
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
					treebutton.setSelected(true);
//					treebutton.setStyle("-fx-background-color: #EEE8AA");

				}
			};
			treebutton.setToggleGroup(tg);
			treebutton.addEventFilter(MouseEvent.MOUSE_MOVED, nodeEvent);
//			treebutton.setOnAction(evt -> {if(treebutton.isSelected()) {treebutton.setStyle("-fx-background-color: #EEE8AA");} else{treebutton.setStyle("-fx-background-color: #006400");}});

			t.setXPos(treebutton.getLayoutX());
//			System.out.println("firstname: " + t.getFirstName() + ", x pos: " + treebutton.getLayoutX());
			root.getChildren().add(treebutton);
			tbA[i] = treebutton;
			if(t.getTreeLevel() == levelWithMaxNodes && siblingTrees.contains(t)) {
			nodeIndex++;
			}
			i++;
		}

		for(Tree t : trees) {
			if(t.getMother() != null) {
//				System.out.println("mother: " +t.getMother().getFirstName());
//				System.out.println(t.getMother().pos);
				Line m = new Line(t.getXPos()+scale*0.9*25, t.getYPos(), t.getMother().getXPos()+scale*0.9*25, t.getMother().getYPos()+scale*0.9*50);
				m.setStyle("-fx-stroke: #FFFFFF");
//				System.out.println("firstname: "+ t.getFirstName());
				root.getChildren().add(m);
			}
			if(t.getFather() != null) {
//				System.out.println("mother: " +t.getMother().getFirstName());
//				System.out.println(t.getMother().pos);
				Line m = new Line(t.getXPos()+scale*0.9*25, t.getYPos(), t.getFather().getXPos()+scale*0.9*25, t.getFather().getYPos()+scale*0.9*50);
				m.setStyle("-fx-stroke: #000000");
//				System.out.println("firstname: "+ t.getFirstName());
				root.getChildren().add(m);
			}
			if(t.getSpouse() != null && t.getMale()) {
				Circle ring1 = new Circle(2.5*scale, Color.MEDIUMSEAGREEN);
				ring1.setStroke(Color.GOLD);
				ring1.setCenterX(t.getXPos() +scale*0.85*54);
				ring1.setCenterY(t.getYPos() + scale*25);
				root.getChildren().add(ring1);
				Circle ring2 = new Circle(2.5*scale, Color.MEDIUMSEAGREEN);
				ring2.setStroke(Color.GOLD);
				ring2.setCenterX(t.getXPos() +scale*0.85*57);
				ring2.setCenterY(t.getYPos() + scale*25);
				root.getChildren().add(ring2);
				Shape s = Shape.intersect(ring1, ring2);
				s.setFill(Color.TRANSPARENT);
				s.setStroke(Color.WHITESMOKE);
				root.getChildren().add(s);
			}
			
			
			
		}
//		root.getChildren().
		Scene scene = new Scene(root, 1100, 850);
		scene.setFill(Color.MEDIUMSEAGREEN);
		primaryStage.setScene(scene);
		primaryStage.setTitle("FamilyTree");
		primaryStage.show();
//		System.out.println("-----------SUSI\n " + Susi + "\n------------------\n\n");

	}
	

	public void allocateChildPositions(Tree parent, int numberOfSiblings) {
		if(numberOfSiblings == 1) {
			parent.getChildren().get(0).setNoNo(-1);
			parent.getChildren().get(1).setNoNo(1);

		}
		else {
		double middle = numberOfSiblings/2.0;
//		System.out.println("middle " + middle);
//		if(numberOfSiblings % 2 != 0) {
//			parent.getChildren().get((int)middle).noNo = 0;
//		}
//		int i = (int) Math.round(-middle)-1;
//		System.out.println("i" + i);
//		for(int j = 0; j<middle; j++) {
//			parent.getChildren().get(j).noNo = i;
//			i++;
//			System.out.println("here: "+ parent.getChildren().get(j).getFirstName() + " j : "+ j);
//		}
//		i = (int) Math.round(middle);
//		for(int k = (int) Math.ceil(middle); k<parent.getChildren().size(); k++) {
//			parent.getChildren().get(k).noNo = i;
//			i++;
//
//		}
		
		int counter = 1;
		for(int i = 0; i<parent.getChildren().size(); i++) {
			if(numberOfSiblings-i > middle) {
				parent.getChildren().get(i).setNoNo(-counter);
//				System.out.println(parent.getChildren().get(i).getFirstName() + " noNO: " + parent.getChildren().get(i).noNo);
				counter--;
			}
			else {
				parent.getChildren().get(i).setNoNo(counter);
				counter++;
//				System.out.println(parent.getChildren().get(i).getFirstName() + " noNO: " + parent.getChildren().get(i).noNo);

			}
		}
		}
		
	}
	
	
public static void main(String[] args) {
		launch();
	}
}
