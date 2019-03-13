package FamilyTree_Pivot;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

import Logic.Tree;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainGUI extends Application {
	public static int countline;
	
	public void start(Stage stage) throws Exception {
        Button helpButton = new Button("Help");
        Button exit = new Button("Exit");
        Button Create = new Button("Create New Tree");
        Button Search= new Button("Search Existing Tree Directory");
        Text Title = new Text(300.0,100.0,("Family Tree"));
        Button submit= new Button("Submit");
        Button searchButton= new Button("Search");
        Button viewTree= new Button("View Tree");
        Button viewFamily= new Button("View Family List");
        Label treeName = new Label("Tree Name:");
        Label searchName = new Label("Search For Tree:");
		TextField treeField = new TextField ();
		TextField searchField = new TextField ();
        AudioClip test = new AudioClip(this.getClass().getResource("transcript.mp3").toString());
        Label title = new Label ("Please enter the information for the first person:");
        Label firstName = new Label("First Name: *");
		Label lastName = new Label("Last Name: *");
		Label birthlabel = new Label("BirthDate: *");
		Label deathlabel = new Label("Date of Death: ");
		Label birthplacelabel = new Label("Birth Country: *");
		Label deathplacelabel = new Label("Died In : ");
		Label Gender = new Label("Gender: *");
		Label biography = new Label("Biography: ");
		TextArea biographyArea = new TextArea();
		DatePicker birthDate= new DatePicker ();
		DatePicker deathDate= new DatePicker ();
		TextField firstField = new TextField ();
		TextField lastField = new TextField ();
		RadioButton genderMale = new RadioButton("Male");
		RadioButton genderFemale = new RadioButton("Female");
		ToggleGroup toggle = new ToggleGroup();
		genderMale.setToggleGroup(toggle);
		genderMale.setSelected(true);
		genderFemale.setToggleGroup(toggle);
		ObservableList<String> cities = FXCollections.observableArrayList();
        ComboBox<String> birthcountry = new ComboBox<String>(cities);
        ComboBox<String> deathcountry = new ComboBox<String>(cities);
		Button Add= new Button("Create New");
		Button Addtolist= new Button("Create New");
		Button addChildButton = new Button("Add Child");
		Button alterPersonButton = new Button("Alter this person's information");
		Button deletePersonButton = new Button("Delete this person");
		Button addParentButton = new Button("Add Parent");
		Button addSpouseButton = new Button("Add Spouse");
		
 //////////////////////////////////////////////////Searching///////////////////////////////////////////////////////////////////
	            
		TableView<Tree1> table = new TableView<Tree1>();
		 final ObservableList<Tree1> data
		  = FXCollections.observableArrayList(
	            		 new Tree1 ("Lilly", "Schwarzenbach", "1995-11-14", "Riggisberg","helllo this is bio"),
	            		 new Tree1 ("Felix", "Schwarzenbach", "1970-05-22", "Riggisberg","helllo this is bio"),
	            		 new Tree1 ("Ahmad", "Khouli", "1995-08-04", "Jordan","helllo this is bio"),
	            		 new Tree1 ("Rajai", "Khouli", "1960-05-22", "Jordan","helllo this is bio")
//	            		 new Tree1("Felix", "Schwarzenbach", "1970-10-14", "Wädenswil","helllo this is bio" ),
//	            		 new Tree1 ("Susanna", "Schwarzenbach", "1970-02-14", "Bern","helllo this is bio"),
//	            		 new Tree1 ("Fanny", "Schwarzenbach", "1995-11-14","Jegenstorf"),
//	            		 new Tree1 ("Fritz", "Schwarzenbach", "1995-11-14", "Bern"),
//	            		 new Tree1 ("Hedi", "Schwarzenbach", "1995-11-14", "Wädenswil"),
//	            		 new Tree1  ("Hans", "Moser", "1995-11-14", "Bäriswil"),
//	            		 new Tree1 ("Käthi", "Moser", "1995-11-14", "Hindelbank"),
//	            		 new Tree1  ("Hasi", "Schwarzenbach", "1995-11-14", "Wädenswil"),
//	            		 new Tree1 ("Heidi", "Stähli", "1995-11-14", "Wädenswil"),
//	            		 new Tree1("Felix", "Schwarzenbach", "1970-10-14", "Wädenswil"),
//	            		 new Tree1 ("Susanna", "Schwarzenbach", "1970-02-14", "Bern"),
//	            		 new Tree1 ("Fanny", "Schwarzenbach", "1995-11-14","Jegenstorf"),
//	            		 new Tree1 ("Fritz", "Schwarzenbach", "1995-11-14", "Bern"),
//	            		 new Tree1 ("Hedi", "Schwarzenbach", "1995-11-14", "Wädenswil"),
//	            		 new Tree1  ("Hans", "Moser", "1995-11-14", "Bäriswil"),
//	            		 new Tree1 ("Käthi", "Moser", "1995-11-14", "Hindelbank"),
//	            		 new Tree1  ("Hasi", "Schwarzenbach", "1995-11-14", "Wädenswil"),
//	            		 new Tree1 ("Heidi", "Stähli", "1995-11-14", "Wädenswil"),
//	            		 new Tree1 ("Lilly", "Schwarzenbach", "1995-11-14", "Riggisberg"),
//	            		 new Tree1("Felix", "Schwarzenbach", "1970-10-14", "Wädenswil"),
//	            		 new Tree1 ("Susanna", "Schwarzenbach", "1970-02-14", "Bern"),
//	            		 new Tree1 ("Fanny", "Schwarzenbach", "1995-11-14","Jegenstorf"),
//	            		 new Tree1 ("Fritz", "Schwarzenbach", "1995-11-14", "Bern"),
//	            		 new Tree1 ("Hedi", "Schwarzenbach", "1995-11-14", "Wädenswil"),
//	            		 new Tree1  ("Hans", "Moser", "1995-11-14", "Bäriswil"),
//	            		 new Tree1 ("Käthi", "Moser", "1995-11-14", "Hindelbank"),
////	            		 new Tree1  ("Hasi", "Schwarzenbach", "1995-11-14", "Wädenswil"),
//	            		 new Tree1 ("Heidi", "Stähli", "1995-11-14", "Wädenswil","helllo this is bio")
	            		 
	            );
		

		 final Label label = new Label("Search Tree Directory");
	        label.setFont(new Font("Arial", 50));
	        label.setTextFill(Color.IVORY);
	        table.setEditable(true);

	        TableColumn firstNameCol = new TableColumn("First Name");
	        firstNameCol.setMinWidth(250);
	        firstNameCol.setResizable(true);
	        firstNameCol.setCellValueFactory(
	                new PropertyValueFactory<Tree, String>("firstName"));

	        TableColumn lastNameCol = new TableColumn("Last Name");
	        lastNameCol.setMinWidth(250);
	        lastNameCol.setResizable(true);
	        lastNameCol.setCellValueFactory(
	                new PropertyValueFactory<Tree, String>("lastName"));
	        
	        TableColumn birthCol = new TableColumn("Birth Date (YYYY-MM-DD)");
	        birthCol.setMinWidth(250);
//	        birthCol.setResizable(true);
	        birthCol.setCellValueFactory(
	                new PropertyValueFactory<Tree, String>("birthday"));

	        TableColumn treeCol = new TableColumn("Tree Name");
	        treeCol.setMinWidth(250);
	        treeCol.setResizable(true);
	        treeCol.setCellValueFactory(
	                new PropertyValueFactory<Tree, String>("treeName"));

	        FilteredList<Tree1> flPerson = new FilteredList(data, p -> true);
	        //Passing the data to a filtered list
	        table.setItems(flPerson);
	        //Setting the table's items using the filtered list
	        table.getColumns().addAll(firstNameCol, lastNameCol, birthCol, treeCol);
	  
	        //Adding ChoiceBox and TextField here!
	        ChoiceBox<String> choiceBox = new ChoiceBox();
	        choiceBox.getItems().addAll("First Name", "Last Name", "Birth Date", "Tree Name");
	        choiceBox.setValue("First Name");
	     
	        TextField textField = new TextField();
//	      
	        
	        textField.setPromptText("Search Tree here");
	        textField.setOnKeyReleased(keyEvent ->
	        {
	            switch (choiceBox.getValue())//Switch on choiceBox value
	            {
	                case "First Name":
	                    flPerson.setPredicate(p -> p.getFirstName().toLowerCase().contains(textField.getText().toLowerCase().trim()));
	                    //filter table by first name
	                    break;
	                case "Last Name":
	                    flPerson.setPredicate(p -> p.getLastName().toLowerCase().contains(textField.getText().toLowerCase().trim()));
	                    //filter table by last name
	                    break;
	                case "Birth Date":
	                	 
	                    flPerson.setPredicate(p -> p.getBirthday().toLowerCase().contains(textField.getText().toLowerCase().trim()));
	                    //filter table by Birthday
	                    break;
	                case "Tree Name":
	                    flPerson.setPredicate(p -> p.getTreeName().toLowerCase().contains(textField.getText().toLowerCase().trim()));
	                    //filter table by Tree name
	                    break;
	            }
	        });
	//---------------------------------------------------------------------------------------------------------------------
	        
	        choiceBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) ->
	        {//reset table and textfield when new choice is selected
	            if (newVal != null)
	            {
	                textField.setText("");
	                flPerson.setPredicate(null);//This is same as saying flPerson.setPredicate(p->true);
	            }
	        });
	        HBox hBox = new HBox(choiceBox, textField);//Add choiceBox and textField to hBox
	        hBox.setAlignment(Pos.CENTER);//Center HBox
	        final VBox vbox = new VBox();
	        vbox.setSpacing(100);
	        vbox.setPadding(new Insets(10, 0, 0, 10));
	        vbox.getChildren().addAll(label, table, hBox);
	        
		 //////////////////////////////////////////////////Searching///////////////////////////////////////////////////////////////////

        display X= new display();
        Image Tree = new Image("file:src/FamilyTree_Pivot/tree.png");
        ImageView treeview= new ImageView();
        treeview.setImage(Tree);
        treeview.setX(20);
        treeview.setY(80);
        treeview.setScaleX(1.5);
        treeview.setScaleY(1.5);
        Title.setFont(Font.font(100));
        Title.setFill(Color.IVORY);
        helpButton.setLayoutX(10);
        helpButton.setLayoutY(700);
        exit.setLayoutX(10);
        exit.setLayoutY(740);
        Create.setLayoutX(470);
        Create.setLayoutY(550);
        Create.setScaleX(2);;
        Create.setScaleY(2);;
        submit.setLayoutX(750);
		submit.setLayoutY(350);
		submit.setScaleX(2);
		submit.setScaleY(2);
		searchButton.setLayoutX(750);
		searchButton.setLayoutY(350);
		searchButton.setScaleX(2);
		searchButton.setScaleY(2);
        Search.setLayoutX(430);
        Search.setLayoutY(630);
        Search.setScaleX(2);;
        Search.setScaleY(2);;
        Button back = new Button("back");
        Button backSearch = new Button("back");
		back.setLayoutX(10);
		back.setLayoutY(780);
		backSearch.setLayoutX(10);
		backSearch.setLayoutY(780);
		// BACK BUTTON EVENT
		
		EventHandler<MouseEvent> backMainEvent = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Text startText = new Text("startscreen");
				startText.setX(400);
				startText.setY(400);
				treeField.clear();
				firstField.clear();
				lastField.clear();
				birthDate.setValue(null);
				birthcountry.setValue(null);
				deathDate.setValue(null);
				deathcountry.setValue(null);
				biographyArea.clear();
				try {
					BufferedWriter writer = new BufferedWriter(new FileWriter("src/FamilyTree_Pivot/treeName.txt",true));
					writer.write("Null Tree");
					   writer.newLine();
					    writer.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				Group startgroup = new Group(treeview,helpButton, Create,Title, Search,exit);
				Scene startscreen = new Scene(startgroup, 1100, 850);
				stage.setScene(startscreen);
				
			}
		};
		EventHandler<MouseEvent> backfromSearch = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Text startText = new Text("startscreen");
				startText.setX(400);
				startText.setY(400);
				treeField.clear();
				firstField.clear();
				lastField.clear();
				birthDate.setValue(null);
				birthcountry.setValue(null);
				deathDate.setValue(null);
				deathcountry.setValue(null);
				biographyArea.clear();
				
				
				Tree1 tree=table.getSelectionModel().getSelectedItem();
				if (tree !=null) {
				System.out.println(tree.getFirstName() +","+ tree.getLastName()+ "," + tree.getBirthday()+"," + tree.getTreeName());
				}
				table.getSelectionModel().clearSelection();
				Group startgroup = new Group(treeview,helpButton, Create,Title, Search,exit);
				Scene startscreen = new Scene(startgroup, 1100, 850);
				stage.setScene(startscreen);
				
			}
		};
		//HELP BUTTON EVENT
        
        EventHandler<MouseEvent> helpEvent = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				try {

//					InputStream rid = new FileInputStream("src/Graphics/help.txt");

				BufferedReader reader = new BufferedReader(new FileReader("src/FamilyTree_Pivot/help.txt"));	
				String a = "";
				String line;

				while ((line =reader.readLine()) != null){

					a+=line;
					a+= "\n";
				}
				Text helpText = new Text(a);

				helpText.setX(10);
				helpText.setY(30);
				Group helpgroup = new Group(helpText,back);
				Scene helpscreen = new Scene(helpgroup, 1100, 850);
				stage.setScene(helpscreen);

				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		};
		
		//COUNTRY LIST
        String[] locales1 = Locale.getISOCountries();
        for (String countrylist : locales1) {
            Locale obj = new Locale("", countrylist);
            String[] city = { obj.getDisplayCountry() };
            for (int x = 0; x < city.length; x++) {
                cities.add(obj.getDisplayCountry());
                Collections.sort(cities);
            }
        }
        birthcountry.setItems(cities);
        deathcountry.setItems(cities);
	    
        //SUBMIT NEW TREE FORM EVENT
		EventHandler<MouseEvent> submitEvent = new EventHandler<MouseEvent>() {
			@Override
	public void handle(MouseEvent event) {
		try {
				BufferedWriter writer = new BufferedWriter(new FileWriter("src/FamilyTree_Pivot/treeName.txt",true));
				    writer.write(treeField.getText().toString());
				   writer.newLine();
				    writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
				Add.setLayoutX(920);
				Add.setLayoutY(780);
				Add.setScaleX(2);
				Add.setScaleY(2);
				title.setLayoutX(40);
				title.setLayoutY(40);
				title.setUnderline(true);
				title.setFont(Font.font(30));
		        title.setTextFill(Color.IVORY);
		        firstName.setLayoutX(120);
		        firstName.setLayoutY(150);
				firstName.setScaleX(1.5);
				firstName.setScaleY(1.5);
				lastName.setLayoutX(120);
				lastName.setLayoutY(210);
				lastName.setScaleX(1.5);
				lastName.setScaleY(1.5);
				birthlabel.setLayoutX(118);
				birthlabel.setLayoutY(270);
				birthlabel.setScaleX(1.5);
				birthlabel.setScaleY(1.5);
				deathlabel.setLayoutX(118);
				deathlabel.setLayoutY(460);
				deathlabel.setScaleX(1.5);
				deathlabel.setScaleY(1.5);
				deathDate.setLayoutX(396);
				deathDate.setLayoutY(450);
				deathDate.setScaleX(1.5);
				deathDate.setScaleY(1.5);
				birthplacelabel.setLayoutX(120);
				birthplacelabel.setLayoutY(330);
				birthplacelabel.setScaleX(1.5);
				birthplacelabel.setScaleY(1.5);
				deathplacelabel.setScaleX(1.5);
				deathplacelabel.setScaleY(1.5);
				deathplacelabel.setLayoutX(108);
				deathplacelabel.setLayoutY(528);
				biography.setScaleX(1.5);
				biography.setScaleY(1.5);
				biography.setLayoutX(108);
				biography.setLayoutY(588);
				biographyArea.setLayoutX(300);
				biographyArea.setLayoutY(600);
				biographyArea.setScaleX(0.9);
				Gender.setLayoutX(111);
				Gender.setLayoutY(390);
				Gender.setScaleX(1.5);
				Gender.setScaleY(1.5);
				birthcountry.setLayoutX(343);
				birthcountry.setLayoutY(330);
				birthcountry.setScaleY(1.5);
				deathcountry.setLayoutX(343);
				deathcountry.setLayoutY(520);
				deathcountry.setScaleY(1.5);
				birthDate.setLayoutX(396);
				birthDate.setLayoutY(270);
				birthDate.setScaleX(1.5);
				birthDate.setScaleY(1.5);
				firstField.setScaleX(1.5);
				firstField.setScaleY(1.5);
				firstField.setLayoutX(390);
				firstField.setLayoutY(150);
				lastField.setScaleX(1.5);
				lastField.setScaleY(1.5);
				lastField.setLayoutX(390);
				lastField.setLayoutY(210);
				genderMale.setLayoutX(350);
				genderMale.setLayoutY(395);
				genderFemale.setLayoutX(430);
				genderFemale.setLayoutY(395);
				
				Group creategroup = new Group(firstName,firstField,lastName,lastField,birthlabel
						,birthDate,birthplacelabel,birthcountry,title,Gender,genderMale,genderFemale,
						deathlabel,deathDate,deathplacelabel,deathcountry,biography,biographyArea,Add,helpButton,back);
				Scene createscreen = new Scene(creategroup, 1100, 850);
				createscreen.setFill(Color.MEDIUMSEAGREEN);
				stage.setScene(createscreen);
				
			}
		};
		
		//CREATING A NODE EVENT -------------------------------------------------------------------------------------------------------
		
		EventHandler<MouseEvent> CreateNew = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
		if((firstField.getText().equals(null)) || (lastField.getText().equals(null)) || (birthDate.getValue() == null)){
			Label titleError = new Label ("First name, Last name & Birthdate must be filled");
			titleError.setLayoutX(40);
			titleError.setLayoutY(40);
			titleError.setUnderline(true);
			titleError.setFont(Font.font(30));
			titleError.setTextFill(Color.RED);
	       
			Group creategroup = new Group(firstName,firstField,lastName,lastField,birthlabel
					,birthDate,birthplacelabel,birthcountry,titleError,Gender,genderMale,genderFemale,
					deathlabel,deathDate,deathplacelabel,deathcountry,biography,biographyArea,Add,helpButton,back);
			Scene createscreen = new Scene(creategroup, 1100, 850);
			createscreen.setFill(Color.MEDIUMSEAGREEN);
			stage.setScene(createscreen);
			}
		else {
			TableView<Tree1> newchosenList = new TableView<Tree1>();
			ObservableList<Tree1> newlistdata= FXCollections.observableArrayList();
			try {

//				InputStream rid = new FileInputStream("src/Graphics/help.txt");

			BufferedReader listreader = new BufferedReader(new FileReader("src/FamilyTree_Pivot/newNode.txt"));	
			String a = "";
			String line;
			
			
				Tree1 t;
			
				while((line = listreader.readLine()) != null) {
					String[] lineA = line.split(",");
					String firstname = lineA[0];
					String lastname = lineA[1];
					String birthday = lineA[2];
					String birthplace = lineA[3];
					String bio = lineA[4];
					
						t = new Tree1(firstname, lastname, birthday, birthplace, bio);
						newlistdata.add(t);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			treeField.clear();
			firstField.clear();
			lastField.clear();
			birthDate.setValue(null);
			birthcountry.setValue(null);
			deathDate.setValue(null);
			deathcountry.setValue(null);
			biographyArea.clear();

			 final Label label = new Label("Search Tree Directory");
		        label.setFont(new Font("Arial", 50));
		        label.setTextFill(Color.IVORY);
		        newchosenList.setEditable(true);

		        TableColumn firstNameCol = new TableColumn("First Name");
		        firstNameCol.setMinWidth(250);
		        firstNameCol.setResizable(true);
		        firstNameCol.setCellValueFactory(
		                new PropertyValueFactory<Tree, String>("firstName"));

		        TableColumn lastNameCol = new TableColumn("Last Name");
		        lastNameCol.setMinWidth(250);
		        lastNameCol.setResizable(true);
		        lastNameCol.setCellValueFactory(
		                new PropertyValueFactory<Tree, String>("lastName"));
		        
		        TableColumn birthCol = new TableColumn("Birth Date (YYYY-MM-DD)");
		        birthCol.setMinWidth(250);
		        birthCol.setCellValueFactory(
		                new PropertyValueFactory<Tree, String>("birthday"));

		        TableColumn treeCol = new TableColumn("Tree Name");
		        treeCol.setMinWidth(250);
		        treeCol.setResizable(true);
		        treeCol.setCellValueFactory(
		                new PropertyValueFactory<Tree, String>("treeName"));

		        FilteredList<Tree1> flPerson = new FilteredList(newlistdata, p -> true);
		        //Passing the data to a filtered list
		        newchosenList.setItems(flPerson);
		        //Setting the table's items using the filtered list
		        newchosenList.getColumns().addAll(firstNameCol, lastNameCol, birthCol, treeCol);
		  
		        //Adding ChoiceBox and TextField here!
		        ChoiceBox<String> choicelist = new ChoiceBox();
		        choicelist.getItems().addAll("First Name", "Last Name", "Birth Date", "Tree Name");
		        choicelist.setValue("First Name");
		     
		        TextField textField = new TextField();
//		      
		        
		        textField.setPromptText("Search Tree here");
		        textField.setOnKeyReleased(keyEvent ->
		        {
		            switch (choicelist.getValue())//Switch on choiceBox value
		            {
		                case "First Name":
		                    flPerson.setPredicate(p -> p.getFirstName().toLowerCase().contains(textField.getText().toLowerCase().trim()));
		                    //filter table by first name
		                    break;
		                case "Last Name":
		                    flPerson.setPredicate(p -> p.getLastName().toLowerCase().contains(textField.getText().toLowerCase().trim()));
		                    //filter table by last name
		                    break;
		                case "Birth Date":
		                	 
		                    flPerson.setPredicate(p -> p.getBirthday().toLowerCase().contains(textField.getText().toLowerCase().trim()));
		                    //filter table by Birthday
		                    break;
		                case "Tree Name":
		                    flPerson.setPredicate(p -> p.getTreeName().toLowerCase().contains(textField.getText().toLowerCase().trim()));
		                    //filter table by Tree name
		                    break;
		            }
		        });
		//---------------------------------------------------------------------------------------------------------------------
		        
		        choicelist.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) ->
		        {//reset table and textfield when new choice is selected
		            if (newVal != null)
		            {
		                textField.setText("");
		                flPerson.setPredicate(null);//This is same as saying flPerson.setPredicate(p->true);
		            }
		        });
		        HBox hBoxlist = new HBox(choicelist, textField);//Add choiceBox and textField to hBox
		        hBoxlist.setAlignment(Pos.CENTER);//Center HBox
		        final VBox vboxlist = new VBox();
		        vboxlist.setSpacing(100);
		        vboxlist.setPadding(new Insets(10, 0, 0, 10));
		        vboxlist.getChildren().addAll(label, newchosenList, hBoxlist);
		        viewTree.setLayoutX(920);
		        viewTree.setLayoutY(780);
		        viewTree.setScaleX(1.7);
		        viewTree.setScaleY(1.7);
				addParentButton.setLayoutX(230);
				addParentButton.setLayoutY(590);
				addParentButton.setMinWidth(100);
				addSpouseButton.setLayoutX(470);
				addSpouseButton.setLayoutY(590);
				addSpouseButton.setMinWidth(100);
				addChildButton.setLayoutX(700);
				addChildButton.setLayoutY(590);
				addChildButton.setMinWidth(100);
				alterPersonButton.setLayoutX(230);
				alterPersonButton.setLayoutY(627);
				alterPersonButton.setMinWidth(100);
				deletePersonButton.setLayoutX(660);
				deletePersonButton.setLayoutY(627);
				deletePersonButton.setMinWidth(100);
				Scene scene = new Scene(new Group(), 1100, 850);
				scene.setFill(Color.MEDIUMSEAGREEN);
		        stage.setTitle("Search Tree");
		        ((Group) scene.getRoot()).getChildren().addAll(vboxlist,backSearch,viewTree,addParentButton,addSpouseButton,deletePersonButton,alterPersonButton,addChildButton);

		        stage.setScene(scene);
		        stage.show();
		        
		}		
		}
		};
	//CREATE A NEW TREE MAIN MENU
		//Hello lilly 
		///sa
		///
		EventHandler<MouseEvent> createEvent = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Image plus = new Image("file:src/FamilyTree_Pivot/plus.png");
				Image tree = new Image("file:src/FamilyTree_Pivot/Famtree.png");
				
				Label title = new Label ("Create New Tree");
				ImageView plusview= new ImageView();
				ImageView treeview= new ImageView();
				treeview.setImage(tree);
				treeview.setScaleX(.5);
				treeview.setScaleY(.5);
				treeview.setX(550);
				treeview.setY(120);
		        plusview.setImage(plus);
		        plusview.setX(650);
		        plusview.setY(65);
		        plusview.setScaleX(0.1);
		        plusview.setScaleY(0.1);
				title.setLayoutX(80);
				title.setLayoutY(60);
				title.setUnderline(true);
				title.setFont(Font.font(80));
		        title.setTextFill(Color.IVORY);
				treeName.setLayoutX(150);
				treeName.setLayoutY(350);
				treeName.setScaleX(2);
				treeName.setScaleY(2);
				treeField.setScaleX(2);
				treeField.setScaleY(2);
				treeField.setLayoutX(390);
				treeField.setLayoutY(350);
				Group creategroup = new Group(treeName,treeField,title,submit,helpButton,back,plusview, treeview);
				Scene createscreen = new Scene(creategroup, 1100, 850);
				createscreen.setFill(Color.MEDIUMSEAGREEN);
				stage.setScene(createscreen);
				
			}
		};
		
		//Search For Tree MAIN MENU
		EventHandler<MouseEvent> searchingEvent = new EventHandler<MouseEvent>() {
			@Override
	public void handle(MouseEvent event) {
				viewTree.setLayoutX(920);
				viewTree.setLayoutY(780);
				viewTree.setScaleX(2);
				viewTree.setScaleY(2);
				
				viewFamily.setLayoutX(920);
				viewFamily.setLayoutY(780);
				viewFamily.setScaleX(1.7);
				viewFamily.setScaleY(1.7);
				Scene scene = new Scene(new Group(), 1100, 850);
				scene.setFill(Color.MEDIUMSEAGREEN);
		        stage.setTitle("Search Tree");
		        ((Group) scene.getRoot()).getChildren().addAll(vbox,backSearch,viewFamily);

		        stage.setScene(scene);
		        stage.show();
				
			}
		};
		EventHandler<MouseEvent> FamilyListEvent = new EventHandler<MouseEvent>() {
			@Override
	public void handle(MouseEvent event) {
				if(!table.getSelectionModel().getSelectedCells().isEmpty()) {
				TableView<Tree1> chosenList = new TableView<Tree1>();
				 final ObservableList<Tree1> listdata
				  = FXCollections.observableArrayList(
			            		 new Tree1 ("Lilly", "Schwarzenbach", "1995-11-14", "Riggisberg","helllo this is bio"),
			            		 new Tree1("Felix", "Schwarzenbach", "1970-10-14", "Wädenswil","helllo this is bio" ),
			            		 new Tree1 ("Susanna", "Schwarzenbach", "1970-02-14", "Bern","helllo this is bio"),
			            		 new Tree1 ("Fanny", "Schwarzenbach", "1995-11-14","Jegenstorf","helllo this is bio"),
			            		 new Tree1 ("Fritz", "Schwarzenbach", "1995-11-14", "Bern","helllo this is bio"),
			            		 new Tree1 ("Heidi", "Stähli", "1995-11-14", "Wädenswil","helllo this is bio")
			            		 
			            );
				

				 final Label label = new Label("Search Tree Directory");
			        label.setFont(new Font("Arial", 50));
			        label.setTextFill(Color.IVORY);
			        chosenList.setEditable(true);

			        TableColumn firstNameCol = new TableColumn("First Name");
			        firstNameCol.setMinWidth(250);
			        firstNameCol.setResizable(true);
			        firstNameCol.setCellValueFactory(
			                new PropertyValueFactory<Tree, String>("firstName"));

			        TableColumn lastNameCol = new TableColumn("Last Name");
			        lastNameCol.setMinWidth(250);
			        lastNameCol.setResizable(true);
			        lastNameCol.setCellValueFactory(
			                new PropertyValueFactory<Tree, String>("lastName"));
			        
			        TableColumn birthCol = new TableColumn("Birth Date (YYYY-MM-DD)");
			        birthCol.setMinWidth(250);
			        birthCol.setCellValueFactory(
			                new PropertyValueFactory<Tree, String>("birthday"));

			        TableColumn treeCol = new TableColumn("Tree Name");
			        treeCol.setMinWidth(250);
			        treeCol.setResizable(true);
			        treeCol.setCellValueFactory(
			                new PropertyValueFactory<Tree, String>("treeName"));

			        FilteredList<Tree1> flPerson = new FilteredList(listdata, p -> true);
			        //Passing the data to a filtered list
			        chosenList.setItems(flPerson);
			        //Setting the table's items using the filtered list
			        chosenList.getColumns().addAll(firstNameCol, lastNameCol, birthCol, treeCol);
			  
			        //Adding ChoiceBox and TextField here!
			        ChoiceBox<String> choicelist = new ChoiceBox();
			        choicelist.getItems().addAll("First Name", "Last Name", "Birth Date", "Tree Name");
			        choicelist.setValue("First Name");
			     
			        TextField textField = new TextField();
//			      
			        
			        textField.setPromptText("Search Tree here");
			        textField.setOnKeyReleased(keyEvent ->
			        {
			            switch (choicelist.getValue())//Switch on choiceBox value
			            {
			                case "First Name":
			                    flPerson.setPredicate(p -> p.getFirstName().toLowerCase().contains(textField.getText().toLowerCase().trim()));
			                    //filter table by first name
			                    break;
			                case "Last Name":
			                    flPerson.setPredicate(p -> p.getLastName().toLowerCase().contains(textField.getText().toLowerCase().trim()));
			                    //filter table by last name
			                    break;
			                case "Birth Date":
			                	 
			                    flPerson.setPredicate(p -> p.getBirthday().toLowerCase().contains(textField.getText().toLowerCase().trim()));
			                    //filter table by Birthday
			                    break;
			                case "Tree Name":
			                    flPerson.setPredicate(p -> p.getTreeName().toLowerCase().contains(textField.getText().toLowerCase().trim()));
			                    //filter table by Tree name
			                    break;
			            }
			        });
			//---------------------------------------------------------------------------------------------------------------------
			        
			        choicelist.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) ->
			        {//reset table and textfield when new choice is selected
			            if (newVal != null)
			            {
			                textField.setText("");
			                flPerson.setPredicate(null);//This is same as saying flPerson.setPredicate(p->true);
			            }
			        });
			        HBox hBoxlist = new HBox(choicelist, textField);//Add choiceBox and textField to hBox
			        hBoxlist.setAlignment(Pos.CENTER);//Center HBox
			        final VBox vboxlist = new VBox();
			        vboxlist.setSpacing(100);
			        vboxlist.setPadding(new Insets(10, 0, 0, 10));
			        vboxlist.getChildren().addAll(label, chosenList, hBoxlist);
			        viewFamily.setLayoutX(920);
					viewFamily.setLayoutY(780);
					viewFamily.setScaleX(1.7);
					viewFamily.setScaleY(1.7);
					addParentButton.setLayoutX(230);
					addParentButton.setLayoutY(590);
					addParentButton.setMinWidth(100);
					addSpouseButton.setLayoutX(470);
					addSpouseButton.setLayoutY(590);
					addSpouseButton.setMinWidth(100);
					addChildButton.setLayoutX(700);
					addChildButton.setLayoutY(590);
					addChildButton.setMinWidth(100);
					alterPersonButton.setLayoutX(230);
					alterPersonButton.setLayoutY(627);
					alterPersonButton.setMinWidth(100);
					deletePersonButton.setLayoutX(660);
					deletePersonButton.setLayoutY(627);
					deletePersonButton.setMinWidth(100);
					Scene scene = new Scene(new Group(), 1100, 850);
					scene.setFill(Color.MEDIUMSEAGREEN);
			        stage.setTitle("Search Tree");
			        ((Group) scene.getRoot()).getChildren().addAll(vboxlist,backSearch,viewTree,addParentButton,addSpouseButton,deletePersonButton,alterPersonButton,addChildButton);

			        stage.setScene(scene);
			        stage.show();
			        
			}
				else {
					Label listError = new Label ("Please Choose a member to display the family");
					listError.setLayoutX(20);
					listError.setLayoutY(80);
					listError.setUnderline(true);
					listError.setFont(Font.font(30));
					listError.setTextFill(Color.RED);
					Scene scene = new Scene(new Group(), 1100, 850);
					scene.setFill(Color.MEDIUMSEAGREEN);
			        stage.setTitle("Search Tree");
				    ((Group) scene.getRoot()).getChildren().addAll(vbox,backSearch,viewFamily,listError);

			        stage.setScene(scene);
			        stage.show();
					
				}
			}	
			};
			
			EventHandler<MouseEvent> AddtoFamilyListEvent = new EventHandler<MouseEvent>() {
				@Override
		public void handle(MouseEvent event) {
					
					if((firstField.getText().equals(null)) || (lastField.getText().equals(null)) || (birthDate.getValue() == null)){
						Label titleError = new Label ("First name, Last name & Birthdate must be filled");
						titleError.setLayoutX(40);
						titleError.setLayoutY(40);
						titleError.setUnderline(true);
						titleError.setFont(Font.font(30));
						titleError.setTextFill(Color.RED);
				       
						Group creategroup = new Group(firstName,firstField,lastName,lastField,birthlabel
								,birthDate,birthplacelabel,birthcountry,titleError,Gender,genderMale,genderFemale,
								deathlabel,deathDate,deathplacelabel,deathcountry,biography,biographyArea,Addtolist,helpButton,back);
						Scene createscreen = new Scene(creategroup, 1100, 850);
						createscreen.setFill(Color.MEDIUMSEAGREEN);
						stage.setScene(createscreen);
						}
					else {
						try {
							BufferedWriter writer = new BufferedWriter(new FileWriter("src/FamilyTree_Pivot/newNode.txt",true));
						writer.newLine();
						String first = firstField.getText();
						String last= lastField.getText();
						writer.write(first.toString() + ",");
						writer.write(last.toString() + ",");
						
						if(birthDate.getValue() != null) {
						String birth = birthDate.getValue().toString();
						writer.write(birth.toString()+ ",");
						}
						if(birthcountry.getValue() != null) {
						String birthplace = birthcountry.getValue().toString();
						writer.write(birthplace.toString()+ ",");
						}
						if(genderMale.isSelected()) {
							writer.write(genderMale.getText().toString()+ ",");
						}
						else {
							writer.write(genderFemale.getText().toString()+ ",");
						}
						if(deathDate.getValue() != null) {
							String death = deathDate.getValue().toString();
							writer.write(death.toString()+ ",");
						}
						if(deathcountry.getValue() != null) {
							String deathplace = deathcountry.getValue().toString();
							writer.write(deathplace.toString()+ ",");
							
						}
						if(biographyArea.getText() != null) {
							String biog = biographyArea.getText().toString();
							writer.write("(" +biog.toString()+ ").");
						}
						
						  writer.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					
					TableView<Tree1> newchosenList = new TableView<Tree1>();
					ObservableList<Tree1> newlistdata= FXCollections.observableArrayList();
					try {

//						InputStream rid = new FileInputStream("src/Graphics/help.txt");

					BufferedReader listreader = new BufferedReader(new FileReader("src/FamilyTree_Pivot/newNode.txt"));	
					String a = "";
					String line;
					
					
						Tree1 t;
					
						while((line = listreader.readLine()) != null) {
							String[] lineA = line.split(",");
							String firstname = lineA[0];
							String lastname = lineA[1];
							String birthday = lineA[2];
							String birthplace = lineA[3];
							String bio = lineA[4];
							
								t = new Tree1(firstname, lastname, birthday, birthplace, bio);
								newlistdata.add(t);
						}
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					treeField.clear();
					firstField.clear();
					lastField.clear();
					birthDate.setValue(null);
					birthcountry.setValue(null);
					deathDate.setValue(null);
					deathcountry.setValue(null);
					biographyArea.clear();

					 final Label label = new Label("Search Tree Directory");
				        label.setFont(new Font("Arial", 50));
				        label.setTextFill(Color.IVORY);
				        newchosenList.setEditable(true);

				        TableColumn firstNameCol = new TableColumn("First Name");
				        firstNameCol.setMinWidth(250);
				        firstNameCol.setResizable(true);
				        firstNameCol.setCellValueFactory(
				                new PropertyValueFactory<Tree, String>("firstName"));

				        TableColumn lastNameCol = new TableColumn("Last Name");
				        lastNameCol.setMinWidth(250);
				        lastNameCol.setResizable(true);
				        lastNameCol.setCellValueFactory(
				                new PropertyValueFactory<Tree, String>("lastName"));
				        
				        TableColumn birthCol = new TableColumn("Birth Date (YYYY-MM-DD)");
				        birthCol.setMinWidth(250);
				        birthCol.setCellValueFactory(
				                new PropertyValueFactory<Tree, String>("birthday"));

				        TableColumn treeCol = new TableColumn("Tree Name");
				        treeCol.setMinWidth(250);
				        treeCol.setResizable(true);
				        treeCol.setCellValueFactory(
				                new PropertyValueFactory<Tree, String>("treeName"));

				        FilteredList<Tree1> flPerson = new FilteredList(newlistdata, p -> true);
				        //Passing the data to a filtered list
				        newchosenList.setItems(flPerson);
				        //Setting the table's items using the filtered list
				        newchosenList.getColumns().addAll(firstNameCol, lastNameCol, birthCol, treeCol);
				  
				        //Adding ChoiceBox and TextField here!
				        ChoiceBox<String> choicelist = new ChoiceBox();
				        choicelist.getItems().addAll("First Name", "Last Name", "Birth Date", "Tree Name");
				        choicelist.setValue("First Name");
				     
				        TextField textField = new TextField();
//				      
				        
				        textField.setPromptText("Search Tree here");
				        textField.setOnKeyReleased(keyEvent ->
				        {
				            switch (choicelist.getValue())//Switch on choiceBox value
				            {
				                case "First Name":
				                    flPerson.setPredicate(p -> p.getFirstName().toLowerCase().contains(textField.getText().toLowerCase().trim()));
				                    //filter table by first name
				                    break;
				                case "Last Name":
				                    flPerson.setPredicate(p -> p.getLastName().toLowerCase().contains(textField.getText().toLowerCase().trim()));
				                    //filter table by last name
				                    break;
				                case "Birth Date":
				                	 
				                    flPerson.setPredicate(p -> p.getBirthday().toLowerCase().contains(textField.getText().toLowerCase().trim()));
				                    //filter table by Birthday
				                    break;
				                case "Tree Name":
				                    flPerson.setPredicate(p -> p.getTreeName().toLowerCase().contains(textField.getText().toLowerCase().trim()));
				                    //filter table by Tree name
				                    break;
				            }
				        });
				//---------------------------------------------------------------------------------------------------------------------
				        
				        choicelist.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) ->
				        {//reset table and textfield when new choice is selected
				            if (newVal != null)
				            {
				                textField.setText("");
				                flPerson.setPredicate(null);//This is same as saying flPerson.setPredicate(p->true);
				            }
				        });
				        HBox hBoxlist = new HBox(choicelist, textField);//Add choiceBox and textField to hBox
				        hBoxlist.setAlignment(Pos.CENTER);//Center HBox
				        final VBox vboxlist = new VBox();
				        vboxlist.setSpacing(100);
				        vboxlist.setPadding(new Insets(10, 0, 0, 10));
				        vboxlist.getChildren().addAll(label, newchosenList, hBoxlist);
				        viewFamily.setLayoutX(920);
						viewFamily.setLayoutY(780);
						viewFamily.setScaleX(1.7);
						viewFamily.setScaleY(1.7);
						addParentButton.setLayoutX(230);
						addParentButton.setLayoutY(590);
						addParentButton.setMinWidth(100);
						addSpouseButton.setLayoutX(470);
						addSpouseButton.setLayoutY(590);
						addSpouseButton.setMinWidth(100);
						addChildButton.setLayoutX(700);
						addChildButton.setLayoutY(590);
						addChildButton.setMinWidth(100);
						alterPersonButton.setLayoutX(230);
						alterPersonButton.setLayoutY(627);
						alterPersonButton.setMinWidth(100);
						deletePersonButton.setLayoutX(660);
						deletePersonButton.setLayoutY(627);
						deletePersonButton.setMinWidth(100);
						Scene scene = new Scene(new Group(), 1100, 850);
						scene.setFill(Color.MEDIUMSEAGREEN);
				        stage.setTitle("Search Tree");
				        ((Group) scene.getRoot()).getChildren().addAll(vboxlist,backSearch,viewTree,addParentButton,addSpouseButton,deletePersonButton,alterPersonButton,addChildButton);

				        stage.setScene(scene);
				        stage.show();
				        
				}		
				}
				};
			
			EventHandler<MouseEvent> submitList = new EventHandler<MouseEvent>() {
				@Override
		public void handle(MouseEvent event) {
			try {
					BufferedWriter writer = new BufferedWriter(new FileWriter("src/FamilyTree_Pivot/treeName.txt",true));
					    writer.write(treeField.getText().toString());
					   writer.newLine();
					    writer.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					
					Addtolist.setLayoutX(920);
					Addtolist.setLayoutY(780);
					Addtolist.setScaleX(2);
					Addtolist.setScaleY(2);
					title.setLayoutX(40);
					title.setLayoutY(40);
					title.setUnderline(true);
					title.setFont(Font.font(30));
			        title.setTextFill(Color.IVORY);
			        firstName.setLayoutX(120);
			        firstName.setLayoutY(150);
					firstName.setScaleX(1.5);
					firstName.setScaleY(1.5);
					lastName.setLayoutX(120);
					lastName.setLayoutY(210);
					lastName.setScaleX(1.5);
					lastName.setScaleY(1.5);
					birthlabel.setLayoutX(118);
					birthlabel.setLayoutY(270);
					birthlabel.setScaleX(1.5);
					birthlabel.setScaleY(1.5);
					deathlabel.setLayoutX(118);
					deathlabel.setLayoutY(460);
					deathlabel.setScaleX(1.5);
					deathlabel.setScaleY(1.5);
					deathDate.setLayoutX(396);
					deathDate.setLayoutY(450);
					deathDate.setScaleX(1.5);
					deathDate.setScaleY(1.5);
					birthplacelabel.setLayoutX(120);
					birthplacelabel.setLayoutY(330);
					birthplacelabel.setScaleX(1.5);
					birthplacelabel.setScaleY(1.5);
					deathplacelabel.setScaleX(1.5);
					deathplacelabel.setScaleY(1.5);
					deathplacelabel.setLayoutX(108);
					deathplacelabel.setLayoutY(528);
					biography.setScaleX(1.5);
					biography.setScaleY(1.5);
					biography.setLayoutX(108);
					biography.setLayoutY(588);
					biographyArea.setLayoutX(300);
					biographyArea.setLayoutY(600);
					biographyArea.setScaleX(0.9);
					Gender.setLayoutX(111);
					Gender.setLayoutY(390);
					Gender.setScaleX(1.5);
					Gender.setScaleY(1.5);
					birthcountry.setLayoutX(343);
					birthcountry.setLayoutY(330);
					birthcountry.setScaleY(1.5);
					deathcountry.setLayoutX(343);
					deathcountry.setLayoutY(520);
					deathcountry.setScaleY(1.5);
					birthDate.setLayoutX(396);
					birthDate.setLayoutY(270);
					birthDate.setScaleX(1.5);
					birthDate.setScaleY(1.5);
					firstField.setScaleX(1.5);
					firstField.setScaleY(1.5);
					firstField.setLayoutX(390);
					firstField.setLayoutY(150);
					lastField.setScaleX(1.5);
					lastField.setScaleY(1.5);
					lastField.setLayoutX(390);
					lastField.setLayoutY(210);
					genderMale.setLayoutX(350);
					genderMale.setLayoutY(395);
					genderFemale.setLayoutX(430);
					genderFemale.setLayoutY(395);
					
					Group creategroup = new Group(firstName,firstField,lastName,lastField,birthlabel
							,birthDate,birthplacelabel,birthcountry,title,Gender,genderMale,genderFemale,
							deathlabel,deathDate,deathplacelabel,deathcountry,biography,biographyArea,Addtolist,helpButton,back);
					Scene createscreen = new Scene(creategroup, 1100, 850);
					createscreen.setFill(Color.MEDIUMSEAGREEN);
					stage.setScene(createscreen);
					
				}
			};
		//Search For Tree MAIN MENU
				EventHandler<MouseEvent> searchResultEvent = new EventHandler<MouseEvent>() {
					@Override
			public void handle(MouseEvent event) {
				try {
					BufferedReader reader = new BufferedReader(new FileReader("src/FamilyTree_Pivot/treeName.txt"));	
					String a = "";
					String inc= "";
					String line;
		
					while ((line = reader.readLine()) != null){
						
						if(searchField.getText().toLowerCase() != line.toLowerCase()) {
							System.out.println(line);
						}
						else {
							System.out.println(line);
							System.out.println("Sorry, Tree does not Exist. Please go back and create a new tree");
						}
					}
					Text helpText = new Text(a);
						} catch (IOException e) {
							e.printStackTrace();
						}
						

///////////////////////////////////////////////////////////////////////////////////////
						int y = 100;
						int ydiff = 30;
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
						 * adding all of the above elements into the Group
						 */
						Group root = new Group(back, helpButton, textbox, firstname, lastname, gender, birthdate, birthplace, deathdate, deathplace, bio, firstnameText, lastnameText, genderText, birthdateText, birthplaceText, deathdateText,
								deathplaceText, bioText);

						Scene scene = new Scene(root, 1100, 850);
						scene.setFill(Color.MEDIUMSEAGREEN);

						viewTree.setLayoutX(920);
						viewTree.setLayoutY(780);
						viewTree.setScaleX(2);
						viewTree.setScaleY(2);


				        stage.setScene(scene);
				        stage.show();
				      
					}
					
				};

       handler Exit= new  handler(X);
       exit.addEventFilter(MouseEvent.MOUSE_CLICKED, Exit);
       back.addEventFilter(MouseEvent.MOUSE_CLICKED, backMainEvent);
       backSearch.addEventFilter(MouseEvent.MOUSE_CLICKED, backfromSearch);
       helpButton.addEventFilter(MouseEvent.MOUSE_CLICKED, helpEvent);
       Create.addEventFilter(MouseEvent.MOUSE_CLICKED, createEvent);
       Search.addEventFilter(MouseEvent.MOUSE_CLICKED, searchingEvent);
       submit.addEventFilter(MouseEvent.MOUSE_CLICKED, submitEvent);
       Add.addEventFilter(MouseEvent.MOUSE_CLICKED, CreateNew);
       viewTree.addEventFilter(MouseEvent.MOUSE_CLICKED, searchResultEvent);
       viewFamily.addEventFilter(MouseEvent.MOUSE_CLICKED, FamilyListEvent);
       addParentButton.addEventFilter(MouseEvent.MOUSE_CLICKED, submitList);
       addChildButton.addEventFilter(MouseEvent.MOUSE_CLICKED, submitList);
       addSpouseButton.addEventFilter(MouseEvent.MOUSE_CLICKED, submitList);
       Addtolist.addEventFilter(MouseEvent.MOUSE_CLICKED, AddtoFamilyListEvent);
       Group root = new Group(treeview,helpButton, Create,Title, Search,exit);

        Scene scene = new Scene(root, 1100, 850);
        stage.setTitle("Family Tree");
        stage.setScene(scene);
        
        stage.setResizable(false);
        stage.show();
        test.play();
    }
	
				
	public static void main(String[] args) {
		launch(args);
	}
}

