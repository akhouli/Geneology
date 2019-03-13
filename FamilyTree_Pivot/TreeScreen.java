package FamilyTree_Pivot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
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
		int x = 20;
		
		//the actual box
		Rectangle textbox = new Rectangle(200, 600, Color.PALEGREEN);
		textbox.setX(15);
		textbox.setY(80);
		textbox.setStrokeWidth(5);
		textbox.setStroke(Color.BLACK);
		
		//the 'firstname' text that is always displayed
		Text firstname = new Text("Firstname: " );
		firstname.setFont(Font.font("System Regular", FontWeight.BOLD, 11));
		
		//the 'lastname' text that is always displayed
		Text lastname = new Text("Lastname: " );
		lastname.setFont(Font.font("System Regular", FontWeight.BOLD, 11));
		
		//the 'gender' text that is always displayed
		Text gender = new Text("Gender: " );
		gender.setFont(Font.font("System Regular", FontWeight.BOLD, 11));
		
		//the birth date text that is always displayed
		Text birthdate = new Text("Born on: " );
		birthdate.setFont(Font.font("System Regular", FontWeight.BOLD, 11));
		
		//the birth place text that is always displayed
		Text birthplace = new Text("Born in: ");
		birthplace.setFont(Font.font("System Regular", FontWeight.BOLD, 11));
		
		//the death date text that is always displayed
		Text deathdate = new Text("Died on: ");
		deathdate.setFont(Font.font("System Regular", FontWeight.BOLD, 11));
		
		//the death place text that is always displayed
		Text deathplace = new Text("Died in: ");
		deathplace.setFont(Font.font("System Regular", FontWeight.BOLD, 11));


		//where the info goes when hovered over
		Label firstnameText = new Label("");
		Label lastnameText = new Label("");
		Label genderText = new Label("");
		Label birthdateText = new Label("");
		Label birthplaceText = new Label("");
		Label deathdateText = new Label("");
		Label deathplaceText = new Label("");

		
		GridPane grid = new GridPane();
		grid.setMaxSize(200, 300);
		grid.setHgap(20);
		grid.setVgap(10);
		grid.setLayoutX(x);
		grid.setLayoutY(y);
		grid.add(firstname, 0, 1);
		grid.add(firstnameText, 1, 1);
		grid.add(lastname, 0, 2);
		grid.add(lastnameText, 1, 2);
		grid.add(gender, 0, 3);
		grid.add(genderText, 1, 3);
		grid.add(birthdate, 0, 4);
		grid.add(birthdateText, 1, 4);
		grid.add(birthplace, 0, 5);
		grid.add(birthplaceText, 1, 5);
		grid.add(deathdate, 0, 6);
		grid.add(deathdateText, 1, 6);
		grid.add(deathplace, 0, 7);
		grid.add(deathplaceText, 1, 7);
		
		//bio
		Text bio = new Text("Biography: ");
		bio.setFont(Font.font("System Regular", FontWeight.BOLD, 11));
		bio.setX(x);
		bio.setY(310);
		Label bioText = new Label("");
		bioText.setMaxSize(200, 600);
		bioText.setLayoutX(x);
		bioText.setLayoutY(320);
		
		/**
		 * adding all of the above elements into the Group
		 */
		Group root = new Group(back, help, textbox, grid, bio, bioText);

		
		/**
		 * creating the test nodes. Will have to be removed once the DB is added
		 */
		Logic Lilly = new Logic("Lilly", "Schwarzenbach", false, "19-11-1995", "Riggisberg", 1);
		Logic Felix = new Logic("Felix", "Schwarzenbach", true, "17-02-1959", "Wädenswil", 1);
		Logic Susanna = new Logic("Susanna", "Schwarzenbach", false, "30-06-1963", "Bern", 1);
		Logic Fanny = new Logic("Fanny", "Schwarzenbach", false, "04-05-1995", "Jegenstorf", 1);
		Logic Fritz = new Logic("Fritz", "Schwarzenbach", true, "21-10-1925", "Zürich", 1, "09-06-2018", "Bern");
		Logic Hedi = new Logic("Hedi", "Schwarzenbach", false, "21-11-1925", "Wädenswil", 1, "12-04-1973", "Davos");
		Logic Hans = new Logic("Hans", "Moser", true, "16-03-1931", "Krauchthal", 1, "14-08-2015", "Bäriswil");
		Logic Käthi = new Logic("Käthi", "Moser", false, "21-03-1936", "Hindelbank", 1);
		Logic Hasi = new Logic("Hasi", "Schwarzenbach", true, "31-07-1953", "Wädenswil", 1);
		Logic Heidi = new Logic("Heidi", "Stähli", false, "31-07-1955", "Wädenswil", 1);
		Logic Susi = new Logic("Susi", "Schwarzenbach", false, "12-10-1962", "Wädenswil", 1);
		Logic Silja = new Logic("Silja", "Stähli", false, "23-05-1986", "Wädenswil", 1);
		Logic Patrick = new Logic("Patrick", "Wiesli", true, "24.04.1989", "St.Gallen", 1);
		Logic Benjamin = new Logic("Benjamin", "Noclue", true, "no clue", "no clue", 1);
		Logic Ronja = new Logic("Ronja", "Noclue", false, "no clue", "no clue", 1);
		Logic Jürg = new Logic("Jürg", "Moser", true, "", "", 1);
		Logic Madlen = new Logic("Madlen", "Moser", false, "", "", 1, "2003", "Bern");
		Logic Urs = new Logic("Urs", "Moser", true, "", "", 1);
		Logic Johanna = new Logic("Johanna","Moser", false, "", "", 1);
		Logic Lara = new Logic("Lara", "Moser", false, "","", 1);
		Logic Florian = new Logic("Florian", "Moser", true, "", "", 1);
		Logic Nina = new Logic("Nina", "Moser", false, "", "", 1);
		Logic Michel = new Logic("Michel", "Moser", true, "", "", 1);
		Logic Aline = new Logic("Aline", "Stähli", false, "", "", 1);
		Logic Jonas = new Logic("Jonas", "Stähli", true, "", "", 1);
		Logic Julian = new Logic("Julian", "Noclue", true, "06-03-2019", "", 1);
		
//		Lilly.addParent(Felix);
//		Felix.addSpouse(Susanna);
////		Susanna.addChild(Fanny);
//		Felix.addParent(Fritz);
//		Fritz.addChild(Hasi);
//		Felix.addParent(Hedi);
//		Susanna.addParent(Hans);
//		Susanna.addParent(Käthi);
//		Fritz.addChild(Susi);
////		Fritz.addParent(Hans);
		Lilly.setBiography("Learning Java and Learning Java and Learning Java and Learning Java and Learning Java and Learning Java and Learning Java and Learning Java and Learning Java ");
//		Lilly.addSibling(Fanny);
////		Lilly.addSibling(Käthi);
//		Felix.addSibling(Heidi);
		Heidi.addChild(Silja);
//		Fanny.addChild(Patrick);
		Fanny.addSpouse(Patrick);
		Silja.addSpouse(Benjamin);
		Silja.addChild(Ronja);
//		Hans.addChild(Susi);
//		Susanna.addSibling(Jürg);
//		Käthi.addChild(Madlen);
//		Hans.addChild(Urs);
//		Urs.addChild(Johanna);
//		Urs.addChild(Lara);
//		Lara.addSibling(Florian);
//		Jürg.addChild(Nina);
//		Jürg.addChild(Michel);
//		Fritz.addParent(Käthi);
		Heidi.addChild(Jonas);
		Heidi.addChild(Aline);
		Silja.addChild(Julian);
		
		Silja.addChild(Madlen);
		Madlen.addSpouse(Felix);
		Julian.addSpouse(Susi);
		Silja.addChild(Lilly);
		Silja.addChild(Fanny);
		Silja.addChild(Lara);
		Heidi.addChild(Florian);
		Heidi.addChild(Nina);
		Aline.addSpouse(Michel);
		Fanny.addSpouse(Patrick);
//		Lara.addSpouse(Urs);
		Florian.addSpouse(Johanna);
		Jonas.addSpouse(Käthi);
		Lilly.addSpouse(Hasi);
		Nina.addSpouse(Hans);
		Heidi.addSpouse(Urs);
		ArrayList<Logic> trees = new ArrayList<>();
		
		trees.add(Lilly);
		trees.add(Felix);
//		trees.add(Susanna);
		trees.add(Fanny);  
//		trees.add(Fritz);
//		System.out.println(Fritz.getChildren());
//		System.out.println("Hans : " + Hans.getChildren());
//		System.out.println(Felix.getChildren());

//		trees.add(Hedi);
		trees.add(Hans);
		trees.add(Käthi);
		trees.add(Hasi);
		trees.add(Heidi);
		trees.add(Susi);
		trees.add(Silja);
		trees.add(Benjamin);
		trees.add(Ronja);
		trees.add(Patrick);
		trees.add(Jürg);
		trees.add(Urs);
		trees.add(Madlen);
		trees.add(Johanna);
		trees.add(Michel);
		trees.add(Nina);
		trees.add(Florian);
		trees.add(Lara);
		trees.add(Aline);
		trees.add(Jonas);
		trees.add(Julian);
			
		/**
		 * for every node, a Button is created
		 */
		ToggleGroup tg = new ToggleGroup();
		int y2 = 800;
		int y1 = 350;
		int x2 = 950;
		int x1 = 250;
		int maxLevel = trees.get(0).getTreeLevel();
		int minLevel = trees.get(0).getTreeLevel();
		for(Logic t1 : trees) {
			if(t1.getTreeLevel()<minLevel) {
				minLevel = t1.getTreeLevel();
			}
			else if(t1.getTreeLevel()>maxLevel) {
				maxLevel = t1.getTreeLevel();
			}
		}
		double numberOfLevels = maxLevel-minLevel + 1;

		Comparator<Logic> PosComp = new Comparator<Logic>() {
			public int compare(Logic t1, Logic t2) {
				return (int) t1.getXPos()- (int)t2.getXPos();
			}
		};
		
		Logic focused = Urs;
		double levelWithMaxNodes = 0;
		levelWithMaxNodes = focused.getTreeLevel();
		
		ArrayList<Logic> sortedTrees = new ArrayList<>();	
		
		//adding the siblings. focused made first element
		ArrayList<Logic> siblingTrees;
		if(focused.getFather() != null) {
			siblingTrees = focused.getFather().getChildren();
		}
		else if(focused.getMother() != null){
			siblingTrees = focused.getMother().getChildren();
		}
		else {
			siblingTrees = new ArrayList<>();
			siblingTrees.add(focused);
		}
		int temp = siblingTrees.indexOf(focused);
		siblingTrees.set(temp, siblingTrees.get(0));
		siblingTrees.set(0, focused);
		sortedTrees.addAll(siblingTrees);

		
		//adding the spouses
		ArrayList<Logic> spouses = new ArrayList<>();
		for(Logic t : siblingTrees) {
			if(t.getSpouse() != null) {
				spouses.add(t.getSpouse());
			}
		}
		sortedTrees.addAll(spouses);
		
		//adding parents
		if(focused.getFather() != null) {
			sortedTrees.add(focused.getFather());
		}
		if(focused.getMother() != null) {
			sortedTrees.add(focused.getMother());
		}
		
		//adding children and their spouses
		if(focused.getChildren() != null) {
			sortedTrees.addAll(focused.getChildren());
			for(Logic c : focused.getChildren()) {
				if(c.getSpouse() != null) {
					sortedTrees.add(c.getSpouse());
				}
			}
		}

		//scaling
		double scale = Math.min(2.0,  8.0/siblingTrees.size());
		if(focused.getChildren() != null) {
			scale = Math.min(scale, 7.0/focused.getChildren().size());
		}

		//middle of the siblingtrees
		int middle=(int) Math.ceil(siblingTrees.size()/2.0);
		
		//max
		int max = siblingTrees.size();
		
		levelWithMaxNodes  = numberOfLevels - (maxLevel -levelWithMaxNodes);
		
		for(Logic t : sortedTrees) {
			double treeLevel = numberOfLevels - (maxLevel -t.getTreeLevel());

			//creating the ToggleButton
			ToggleButton treebutton = new ToggleButton(t.getFirstName());
			treebutton.setShape(new Circle(10));
			
			if(t.getMale()) {
				treebutton.setStyle("-fx-background-color: #87CEFA; -fx-border-width: 2px;-fx-border-color: #006400");
			}
			else {
				treebutton.setStyle("-fx-background-color: #FFB6C1; -fx-border-width: 2px;-fx-border-color: #006400");
			}
			treebutton.setMinSize(scale*0.8*50, scale*0.8*50);
			treebutton.setMaxSize(scale*0.8*50, scale*0.8*50);

			// creating focused and siblings
			if(treeLevel==levelWithMaxNodes) {
				t.setYPos((150+((y2-y1)/2.0)));
				if(t.equals(focused)) {
					t.setXPos(x1+(x2-x1)/2.0);
					if(t.getMale()) {
						treebutton.setStyle("-fx-background-color: #87CEFA; -fx-border-width: 3px;-fx-border-color: #FF0000");
					}
					else {
						treebutton.setStyle("-fx-background-color: #FFB6C1; -fx-border-width: 3px;-fx-border-color: #FF0000");
					}
				}
				
				//focused female
				else if (!focused.getMale()){
					if(siblingTrees.contains(t)) {
						//first half of siblings
						if(siblingTrees.indexOf(t)<middle) {
							if(t.getSpouse() != null && t.getMale()) {
								t.setXPos(focused.getXPos()-scale*100*(middle-siblingTrees.indexOf(t))-scale*40);
							}
							else {
								t.setXPos(focused.getXPos()-scale*100*(middle-siblingTrees.indexOf(t)));
							}
						}
						//second half of siblings
						else {
							if(t.getSpouse() != null && t.getMale()) {
								t.setXPos(focused.getXPos()+scale*100*(siblingTrees.indexOf(t)-middle+1)-scale*40);
							}
							else {
								t.setXPos(focused.getXPos()+scale*100*(siblingTrees.indexOf(t)-middle+1));
							}
						}
					}
					else if(t.getMale()){
						t.setXPos(t.getSpouse().getXPos() - scale*0.7*60);
					}
					else {
						t.setXPos(t.getSpouse().getXPos() + scale*0.7*60);
					}
				}
				//focused male
				else {
					if(siblingTrees.contains(t)) {
						if(siblingTrees.indexOf(t)<middle) {
							if(t.getSpouse() != null && t.getMale()==false) {
								t.setXPos(focused.getXPos()-scale*100*(middle-siblingTrees.indexOf(t))+scale*40);
							}
							else {
								t.setXPos(focused.getXPos()-scale*100*(middle-siblingTrees.indexOf(t)));
							}
						}
						else {
							if(t.getSpouse() != null && t.getMale()==false) {
								t.setXPos(focused.getXPos()+scale*100*(siblingTrees.indexOf(t)-middle+1)+scale*40);
							}
							else {
								t.setXPos(focused.getXPos()+scale*100*(siblingTrees.indexOf(t)-middle+1));
							}
						}
					}
					else if(t.getMale()){
						t.setXPos(t.getSpouse().getXPos() - scale*0.7*60);
					}
					else {
						t.setXPos(t.getSpouse().getXPos() + scale*0.7*60);
					}
				}
			}
			
			//parents
			else if(treeLevel < levelWithMaxNodes) {
				t.setYPos((150+((y2-y1)/2.0)-(y2-y1)*scale/4.0));
				double numberOfChildren=0;
				if(t.getChildren() != null) {
					numberOfChildren = t.getChildren().size();
				}
				if(numberOfChildren == 1) {
					if(t.getChildren().get(0).getSpouse() == null || (t.getChildren().get(0).getSpouse().getFather() == null && t.getChildren().get(0).getSpouse().getFather() == null)) {
						if(t.getSpouse() != null && t.getMale() == false) {
							t.setXPos(t.getChildren().get(0).getXPos() + scale*41);
						}
						else {
							t.setXPos(t.getChildren().get(0).getXPos());
						}
					}
					else {
						if(t.getSpouse() != null && t.getMale() == false) {
							t.setXPos(t.getChildren().get(0).getXPos() + scale*242);
						}
						else {
							t.setXPos(t.getChildren().get(0).getXPos() + scale*200);
						}
					}
				}
				else {
					double offset = 0;
					double potentialOffset = scale*100;
					for(Logic child : t.getChildren()) {
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
							t.setXPos(((Collections.min(t.getChildren(), PosComp)).getXPos() +Collections.max(t.getChildren(), PosComp).getXPos())/2.0+scale*42);
						}
						else {
							t.setXPos(((Collections.min(t.getChildren(), PosComp)).getXPos() +Collections.max(t.getChildren(), PosComp).getXPos())/2.0);
						}
					}
					else {
						if(t.getMale()) {
							t.setXPos(offset);
						}
						else {
							t.setXPos(offset+scale*42);
						}
					}
				}
			}
			
			//children
			else {
				t.setYPos((150+((y2-y1)/2.0)+(y2-y1)*scale/4.0));

				ArrayList<Logic> kids = focused.getChildren();
				double midpoint = focused.getXPos();

				if(!kids.contains(t) && t.getSpouse() != null) {
					t.setXPos(t.getSpouse().getXPos() + scale*40);
				}
				double mid = kids.size() /2.0;

				if(focused.getMale() == false) {
					if(kids.size() % 2 != 0) {
						if(kids.contains(t)) {
							//first half of siblings
							if(kids.indexOf(t) == Math.floor(mid)) {
								if(t.getMale() && t.getSpouse() != null) {
									t.setXPos(focused.getXPos()-scale*30);
								}
								else {
									t.setXPos(focused.getXPos());

								}
							}
							else if(kids.indexOf(t)<mid) {
								if(t.getSpouse() != null && t.getMale()) {
									t.setXPos(focused.getXPos()-scale*99*(mid-kids.indexOf(t))-scale*10);
								}
								else {
									t.setXPos(focused.getXPos()-scale*99*(mid-kids.indexOf(t))+scale*30);
								}
							}
							//second half of siblings
							else {
								if(t.getSpouse() != null && t.getMale()) {
									t.setXPos(focused.getXPos()+scale*100*(kids.indexOf(t)-mid+1)-scale*40);
								}
								else {
									t.setXPos(focused.getXPos()+scale*100*(kids.indexOf(t)-mid+1));
								}
							}
						}
						else if(t.getMale()){
							t.setXPos(t.getSpouse().getXPos() - scale*40);
						}
						else {
							t.setXPos(t.getSpouse().getXPos() + scale*40);
						}
					}
					else {
						if(kids.contains(t)) {
							//first half of siblings						
							if(kids.indexOf(t)<mid) {
								if(t.getSpouse() != null && t.getMale()) {
									t.setXPos(focused.getXPos()-scale*99*(mid-kids.indexOf(t))-scale*10);
								}
								else {
									t.setXPos(focused.getXPos()-scale*99*(mid-kids.indexOf(t))+scale*30);
								}
							}
							//second half of siblings
							else {
								if(t.getSpouse() != null && t.getMale()) {
									t.setXPos(focused.getXPos()+scale*100*(kids.indexOf(t)-mid+1)+scale*10);
								}
								else {
									t.setXPos(focused.getXPos()+scale*100*(kids.indexOf(t)-mid+1)-scale*30);
								}
							}
						}
						else if(t.getMale()){
							t.setXPos(t.getSpouse().getXPos() - scale*40);
						}
						else {
							t.setXPos(t.getSpouse().getXPos() + scale*40);
						}
					}

				}
				else {
					if(kids.size() % 2 != 0) {
						if(kids.contains(t)) {
							//first half of siblings
							if(kids.indexOf(t) == Math.floor(mid)) {
								if(t.getMale() == false && t.getSpouse() != null) {
									t.setXPos(focused.getXPos() + scale*30);
								}
								else {
									t.setXPos(focused.getXPos());
								}
							}
							else if(kids.indexOf(t)<mid) {
								if(t.getSpouse() != null && t.getMale() == false) {
									t.setXPos(focused.getXPos()-scale*99*(mid-kids.indexOf(t))+scale*30);
								}
								else {
									t.setXPos(focused.getXPos()-scale*99*(mid-kids.indexOf(t))-scale*10);
								}
							}
							//second half of siblings
							else {
								if(t.getSpouse() != null && t.getMale() == false) {
									t.setXPos(focused.getXPos()+scale*100*(kids.indexOf(t)-mid+1)+scale*40);
								}
								else {
									t.setXPos(focused.getXPos()+scale*100*(kids.indexOf(t)-mid+1));
								}
							}
						}
						else if(t.getMale()){
							t.setXPos(t.getSpouse().getXPos() - scale*40);

						}
						else {
							t.setXPos(t.getSpouse().getXPos() + scale*40);
						}
					}
					else {
						if(kids.contains(t)) {
							//first half of siblings						
							if(kids.indexOf(t)<mid) {
								if(t.getSpouse() != null && t.getMale()) {
									t.setXPos(focused.getXPos()-scale*99*(mid-kids.indexOf(t))-scale*10);
								}
								else {
									t.setXPos(focused.getXPos()-scale*99*(mid-kids.indexOf(t))+scale*30);
								}
							}
							//second half of siblings
							else {
								if(t.getSpouse() != null && t.getMale()) {
									t.setXPos(focused.getXPos()+scale*100*(kids.indexOf(t)-mid+1)+scale*10);
								}
								else {
									t.setXPos(focused.getXPos()+scale*100*(kids.indexOf(t)-mid+1)-scale*30);
								}
							}
						}
						else if(t.getMale()){
							t.setXPos(t.getSpouse().getXPos() - scale*40);
						}
						else {
							t.setXPos(t.getSpouse().getXPos() + scale*40);
						}
					}
				}				
			}

			EventHandler<MouseEvent> nodeEvent = new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					ObservableList<Toggle> tgs = tg.getToggles();
					for(Toggle t : tgs) {
						ToggleButton current = (ToggleButton) t;
						if(current.isSelected()) {
							if(current.getStyle() == "-fx-background-color: #87CEFA; -fx-border-width: 2px;-fx-border-color: #006400") {
								current.setStyle("-fx-background-color: #87CEFA; -fx-border-width: 3px;-fx-border-color: #EEE8AA");
							}
							else if(current.getStyle() == "-fx-background-color: #FFB6C1; -fx-border-width: 2px;-fx-border-color: #006400"){
								current.setStyle("-fx-background-color: #FFB6C1; -fx-border-width: 3px;-fx-border-color: #EEE8AA");
							}
						}
						else {
							if(current.getStyle() == "-fx-background-color: #87CEFA; -fx-border-width: 3px;-fx-border-color: #EEE8AA") {
								current.setStyle("-fx-background-color: #87CEFA; -fx-border-width: 2px;-fx-border-color: #006400");
							}
							else if(current.getStyle() == "-fx-background-color: #FFB6C1; -fx-border-width: 3px;-fx-border-color: #EEE8AA"){
								current.setStyle("-fx-background-color: #FFB6C1; -fx-border-width: 2px;-fx-border-color: #006400");
							}
						}
					}
					firstnameText.setText(t.getFirstName());
					lastnameText.setText(t.getLastName());
					birthdateText.setText(t.getBirthDate());
					birthplaceText.setText(t.getBirthPlace());
					deathdateText.setText(t.getDeathDate());
					deathplaceText.setText(t.getDeathPlace());
					
					String biotxt = "";
					if(t.getBiography() != null) {
						String line = "";
						String[] bioWords = t.getBiography().split(" ");
						for(String word : bioWords) {
							if(line.length() + word.length() <= 33) {
								line += word + " ";
							}
							else {
								biotxt += line + "\n";
								line = word+ " ";
							}
						}
					}
					bioText.setText(biotxt);
					
					if(t.getMale()) {
						genderText.setText("male");
					}
					else {
						genderText.setText("female");
					}
					treebutton.setSelected(true);
				}
			};
			
			treebutton.setToggleGroup(tg);
			treebutton.addEventFilter(MouseEvent.MOUSE_MOVED, nodeEvent);
			treebutton.setLayoutY(t.getYPos());
			treebutton.setLayoutX(t.getXPos());

			root.getChildren().add(treebutton);
		}

		//creating the lines linking parents and children & the rings between spouses
		for(Logic t : trees) {
			//lines to mothers
			if(t.getMother() != null) {
				Line m = new Line(t.getXPos()+scale*0.9*25, t.getYPos(), t.getMother().getXPos()+scale*0.8*25, t.getMother().getYPos()+scale*0.8*50);
				m.setStyle("-fx-stroke: #FFFFFF");
				root.getChildren().add(m);
			}
			//lines to fathers
			if(t.getFather() != null) {
				Line m = new Line(t.getXPos()+scale*0.9*25, t.getYPos(), t.getFather().getXPos()+scale*0.8*25, t.getFather().getYPos()+scale*0.8*50);
				m.setStyle("-fx-stroke: #000000");
				root.getChildren().add(m);
			}
			//rings between spouses
			if(t.getSpouse() != null && t.getMale()) {
				Circle ring1 = new Circle(2.5*scale, Color.MEDIUMSEAGREEN);
				ring1.setStroke(Color.GOLD);
				ring1.setCenterX(t.getXPos() +scale*0.75*54);
				ring1.setCenterY(t.getYPos() + scale*25);
				root.getChildren().add(ring1);
				Circle ring2 = new Circle(2.5*scale, Color.MEDIUMSEAGREEN);
				ring2.setStroke(Color.GOLD);
				ring2.setCenterX(t.getXPos() +scale*0.75*57);
				ring2.setCenterY(t.getYPos() + scale*25);
				root.getChildren().add(ring2);
				Shape s = Shape.intersect(ring1, ring2);
				s.setFill(Color.TRANSPARENT);
				s.setStroke(Color.WHITESMOKE);
				root.getChildren().add(s);
			}
		}
		Scene scene = new Scene(root, 1100, 850);
		scene.setFill(Color.MEDIUMSEAGREEN);
		primaryStage.setScene(scene);
		primaryStage.setTitle("FamilyTree");
		primaryStage.show();
	}
	
	public void allocateChildPositions(Logic parent, int numberOfSiblings) {
		if(numberOfSiblings == 1) {
			parent.getChildren().get(0).setNoNo(-1);
			parent.getChildren().get(1).setNoNo(1);

		}
		else {
			double middle = numberOfSiblings/2.0;
			int counter = 1;
			for(int i = 0; i<parent.getChildren().size(); i++) {
				if(numberOfSiblings-i > middle) {
					parent.getChildren().get(i).setNoNo(-counter);
					counter--;
				}
				else {
					parent.getChildren().get(i).setNoNo(counter);
					counter++;
				}
			}
		}
		
	}
	
	
public static void main(String[] args) {
		launch();
	}
}
