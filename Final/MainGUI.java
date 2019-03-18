package Final;

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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Stream;

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
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainGUI extends Application {
	public static int countline;
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
        Label title = new Label ("Please enter the information:");
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
		Button Addchildtolist= new Button("Create New");
		Button Addparenttolist= new Button("Create New");
		Button Addspousetolist= new Button("Create New");
		Button AddfromAlter = new Button("Update info");
		
		Addchildtolist.setLayoutX(920);
		Addchildtolist.setLayoutY(780);
		Addchildtolist.setScaleX(2);
		Addchildtolist.setScaleY(2);
		Addparenttolist.setLayoutX(920);
		Addparenttolist.setLayoutY(780);
		Addparenttolist.setScaleX(2);
		Addparenttolist.setScaleY(2);
		Addspousetolist.setLayoutX(920);
		Addspousetolist.setLayoutY(780);
		Addspousetolist.setScaleX(2);
		Addspousetolist.setScaleY(2);
		AddfromAlter.setLayoutX(920);
		AddfromAlter.setLayoutY(780);
		AddfromAlter.setScaleX(2);
		AddfromAlter.setScaleY(2);
		Button addChildButton = new Button("Add Child");
		Button alterPersonButton = new Button("Alter this person's information");
		
		
		Button deletePersonButton = new Button("Delete this person");
		Button addParentButton = new Button("Add Parent");
		Button addSpouseButton = new Button("Add Spouse");
		
 /////////////////////////////////////////////////SearchingDBtableView////////////////////////////////////////////////////////////////
//		String g;
//		if(genderMale.isSelected()) {
//			g=(genderMale.getText().toString());
//		}
//		else {
//			g= (genderFemale.getText().toString());
//		}
//		String bio = "";
//		if( biographyArea.getText() != null) {
//			bio =  biographyArea.getText();
//		}
//		DB.familyMemberCreate(firstField.getText(), lastField.getText(), g, birthDate.getValue(), birthcountry.getValue(),deathDate.getValue()
//				,deathcountry.getValue(), bio);
		TableView<Tree1> table = new TableView<Tree1>();
		ObservableList<Tree1> data= DB.FullList();         
		

//		TableView<Tree1> table = new TableView<Tree1>();
//		 final ObservableList<Tree1> data
//		  = FXCollections.observableArrayList(
//	            		 new Tree1 ("Lilly", "Schwarzenbach", "1995-11-14", "Riggisberg","helllo this is bio"),
//	            		 new Tree1 ("Felix", "Schwarzenbach", "1970-05-22", "Riggisberg","helllo this is bio"),
//	            		 new Tree1 ("Ahmad", "Khouli", "1995-08-04", "Jordan","helllo this is bio"),
//	            		 new Tree1 ("Rajai", "Khouli", "1960-05-22", "Jordan","helllo this is bio")
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
	            		 
//	            );
		

		 final Label label = new Label("Search Tree Directory");
	        label.setFont(new Font("Arial", 50));
	        label.setTextFill(Color.IVORY);
	        table.setEditable(true);

	        TableColumn firstNameCol = new TableColumn("First Name");
	        firstNameCol.setMinWidth(250);
	        firstNameCol.setResizable(true);
	        firstNameCol.setCellValueFactory(
	                new PropertyValueFactory<Logic, String>("firstName"));

	        TableColumn lastNameCol = new TableColumn("Last Name");
	        lastNameCol.setMinWidth(250);
	        lastNameCol.setResizable(true);
	        lastNameCol.setCellValueFactory(
	                new PropertyValueFactory<Logic, String>("lastName"));
	        
	        TableColumn birthCol = new TableColumn("Birth Date (YYYY-MM-DD)");
	        birthCol.setMinWidth(250);
//	        birthCol.setResizable(true);
	        birthCol.setCellValueFactory(
	                new PropertyValueFactory<Logic, String>("birthday"));

	        TableColumn treeCol = new TableColumn("Tree Name");
	        treeCol.setMinWidth(250);
	        treeCol.setResizable(true);
	        treeCol.setCellValueFactory(
	                new PropertyValueFactory<Logic, String>("treeName"));

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
	                    //filter table by Logic name
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
        Image Logic = new Image("file:src/Final/tree.png");
        ImageView treeview= new ImageView();
        treeview.setImage(Logic);
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
//				table.getSelectionModel().clearSelection(table.getSelectionModel().getFocusedIndex());;
//				table.setSelectionModel(null);
				
//				try {
//					BufferedWriter writer = new BufferedWriter(new FileWriter("src/Final/treeName.txt",true));
//					writer.write("Null Tree");
//					   writer.newLine();
//					    writer.close();
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
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
				 System.out.println(table.getSelectionModel().getFocusedIndex());
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

				BufferedReader reader = new BufferedReader(new FileReader("src/Final/help.txt"));	
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
//		try {
//				BufferedWriter writer = new BufferedWriter(new FileWriter("src/Final/treeName.txt",true));
//				    writer.write(treeField.getText().toString());
//				   writer.newLine();
//				    writer.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
				DB.Create_New_Tree(treeField.getText().toString());
				
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
		/**
		 * 
		 * 
		 * 
		 * 
		 * 
		 * THIS IS a Compelete section ( Create new family)
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		EventHandler<MouseEvent> CreateNew = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
		if((firstField.getText().equals(null)) || (lastField.getText().equals(null)) || (birthDate.getValue() == null) || (birthcountry.getValue() == null)){
			Label titleError = new Label ("First Name, Last Name, Birthdate & Birth Place must be filled");
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
			

			String g;
			if(genderMale.isSelected()) {
				g=(genderMale.getText().toString());
			}
			else {
				g= (genderFemale.getText().toString());
			}
			String bio = "";
			if( biographyArea.getText() != null) {
				bio =  biographyArea.getText();
			}
			DB.familyMemberCreate(firstField.getText(), lastField.getText(), g, birthDate.getValue(), birthcountry.getValue(),deathDate.getValue()
					,deathcountry.getValue(), bio);
			TableView<Tree1> newchosenList = new TableView<Tree1>();
			ObservableList<Tree1> newlistdata= DB.nodeListCreate();
			
			
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
		                new PropertyValueFactory<Tree1, String>("firstName"));

		        TableColumn lastNameCol = new TableColumn("Last Name");
		        lastNameCol.setMinWidth(250);
		        lastNameCol.setResizable(true);
		        lastNameCol.setCellValueFactory(
		                new PropertyValueFactory<Tree1, String>("lastName"));
		        
		        TableColumn birthCol = new TableColumn("Birth Date (YYYY-MM-DD)");
		        birthCol.setMinWidth(250);
		        birthCol.setCellValueFactory(
		                new PropertyValueFactory<Tree1, String>("birthday"));

		        TableColumn treeCol = new TableColumn("Tree Name");
		        treeCol.setMinWidth(250);
		        treeCol.setResizable(true);
		        treeCol.setCellValueFactory(
		                new PropertyValueFactory<Tree1, String>("treeName"));

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
		                    flPerson.setPredicate(p -> p.getFirstName().toLowerCase().contains(textField.getText().toLowerCase().trim()));
		                    //filter table by Logic name
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
		
		/**
		 * 
		 * 
		 * 
		 * 
		 * 
		 * THIS IS a Compelete section ( Create new family)
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		EventHandler<MouseEvent> AlterCurrent = new EventHandler<MouseEvent>() {
			@Override
	public void handle(MouseEvent event) {

				ObservableList<Tree1> o = DB.nodeListCreate();
				Tree1 t1 = ((Tree1)table.getSelectionModel().getSelectedCells());
//				System.out.println(t1.getFirstName());
				int aID;
				DB_Alter.setCurrentTreeID((DB.updateCurrentPID(t1)));
				aID=DB.updateCurrentPID(t1);
				Logic l1 = DB_Alter.createLogic(aID);
//				DB_Alter.parentID=DB.updateCurrentPID(table.getSelectionModel().getSelectedItem());
//				Streamselected.forEach(System.out::print);
//				Streamselected.filter(s->s.startsWith("E")).forEach(System.out::println);
//				System.out.println(.stream());
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
				firstField.setText(l1.getFirstName());
				lastField.setText(l1.getLastName());
				birthDate.setValue(LocalDate.parse(l1.getBirthDate()));
				birthcountry.setValue(l1.getBirthPlace());
				if(l1.getMale()) {
					genderMale.setSelected(true);
				}
				else {
					genderFemale.setSelected(true);
				}
				if(l1.getDeathDate()!=null) {
				deathDate.setValue(LocalDate.parse(l1.getDeathDate()));
			}
			if(l1.getDeathPlace()!=null) {
				deathcountry.setValue(l1.getDeathPlace());
			}
			if(l1.getBiography()!=null) {
				biographyArea.setText(l1.getBiography());
			}
				
				Group creategroup = new Group(firstName,firstField,lastName,lastField,birthlabel
						,birthDate,birthplacelabel,birthcountry,title,Gender,genderMale,genderFemale,
						deathlabel,deathDate,deathplacelabel,deathcountry,biography,biographyArea,AddfromAlter,helpButton,back);
				Scene createscreen = new Scene(creategroup, 1100, 850);
				createscreen.setFill(Color.MEDIUMSEAGREEN);
				stage.setScene(createscreen);
				
			}
		};
		EventHandler<MouseEvent> AlterUpdateEvent= new EventHandler<MouseEvent>() {
			@Override
	public void handle(MouseEvent event) {
				System.out.println("Were in");
				
				if((firstField.getText().equals(null)) || (lastField.getText().equals(null)) || (birthDate.getValue() == null)){
					Label titleError = new Label ("First name, Last name & Birthdate must be filled");
					titleError.setLayoutX(40);
					titleError.setLayoutY(40);
					titleError.setUnderline(true);
					titleError.setFont(Font.font(30));
					titleError.setTextFill(Color.RED);
			       
					Group creategroup = new Group(firstName,firstField,lastName,lastField,birthlabel
							,birthDate,birthplacelabel,birthcountry,titleError,Gender,genderMale,genderFemale,
							deathlabel,deathDate,deathplacelabel,deathcountry,biography,biographyArea, AddfromAlter,helpButton,back);
					Scene createscreen = new Scene(creategroup, 1100, 850);
					createscreen.setFill(Color.MEDIUMSEAGREEN);
					stage.setScene(createscreen);
					}
			// we are here
	else {
		String g;
		if(genderMale.isSelected()) {
			g=(genderMale.getText().toString());
		}
		else {
			g= (genderFemale.getText().toString());
		}
		String bio;
		if( biographyArea.getText() != null) {
			bio =  biographyArea.getText();
		}
		else {
			bio = "";
		}
		DB_Alter.AlterPerson(firstField.getText(), lastField.getText(), birthDate.getValue(), birthcountry.getValue(), g, deathDate.getValue()
				,deathcountry.getValue(), bio);
		//we are here
	TableView<Tree1> newchosenList = new TableView<Tree1>();
	ObservableList<Tree1> newlistdata= DB.nodeListCreate();	
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
			                new PropertyValueFactory<Logic, String>("firstName"));

			        TableColumn lastNameCol = new TableColumn("Last Name");
			        lastNameCol.setMinWidth(250);
			        lastNameCol.setResizable(true);
			        lastNameCol.setCellValueFactory(
			                new PropertyValueFactory<Logic, String>("lastName"));
			        
			        TableColumn birthCol = new TableColumn("Birth Date (YYYY-MM-DD)");
			        birthCol.setMinWidth(250);
			        birthCol.setCellValueFactory(
			                new PropertyValueFactory<Logic, String>("birthday"));

			        TableColumn treeCol = new TableColumn("Tree Name");
			        treeCol.setMinWidth(250);
			        treeCol.setResizable(true);
			        treeCol.setCellValueFactory(
			                new PropertyValueFactory<Logic, String>("treeName"));

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
			                    //filter table by Logic name
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
	//CREATE A NEW TREE MAIN MENU
		//Hello lilly 
		///sa
		///
		EventHandler<MouseEvent> createEvent = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Image plus = new Image("file:src/Final/plus.png");
				Image tree = new Image("file:src/Final/Famtree.png");
				
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
//			            		 new Tree1 ("Lilly", "Schwarzenbach", "1995-11-14", "Riggisberg","helllo this is bio"),
//			            		 new Tree1("Felix", "Schwarzenbach", "1970-10-14", "Wädenswil","helllo this is bio" ),
//			            		 new Tree1 ("Susanna", "Schwarzenbach", "1970-02-14", "Bern","helllo this is bio"),
//			            		 new Tree1 ("Fanny", "Schwarzenbach", "1995-11-14","Jegenstorf","helllo this is bio"),
//			            		 new Tree1 ("Fritz", "Schwarzenbach", "1995-11-14", "Bern","helllo this is bio"),
//			            		 new Tree1 ("Heidi", "Stähli", "1995-11-14", "Wädenswil","helllo this is bio")
//			            		 
			            );
				

				 final Label label = new Label("Search Tree Directory");
			        label.setFont(new Font("Arial", 50));
			        label.setTextFill(Color.IVORY);
			        chosenList.setEditable(true);

			        TableColumn firstNameCol = new TableColumn("First Name");
			        firstNameCol.setMinWidth(250);
			        firstNameCol.setResizable(true);
			        firstNameCol.setCellValueFactory(
			                new PropertyValueFactory<Logic, String>("firstName"));

			        TableColumn lastNameCol = new TableColumn("Last Name");
			        lastNameCol.setMinWidth(250);
			        lastNameCol.setResizable(true);
			        lastNameCol.setCellValueFactory(
			                new PropertyValueFactory<Logic, String>("lastName"));
			        
			        TableColumn birthCol = new TableColumn("Birth Date (YYYY-MM-DD)");
			        birthCol.setMinWidth(250);
			        birthCol.setCellValueFactory(
			                new PropertyValueFactory<Logic, String>("birthday"));

			        TableColumn treeCol = new TableColumn("Logic Name");
			        treeCol.setMinWidth(250);
			        treeCol.setResizable(true);
			        treeCol.setCellValueFactory(
			                new PropertyValueFactory<Logic, String>("treeName"));

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
			                    //filter table by Logic name
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
			EventHandler<MouseEvent> AddChildtoFamily= new EventHandler<MouseEvent>() {
				@Override
		public void handle(MouseEvent event) {
					System.out.println("Were in");
					
					if((firstField.getText().equals(null)) || (lastField.getText().equals(null)) || (birthDate.getValue() == null)){
						Label titleError = new Label ("First name, Last name & Birthdate must be filled");
						titleError.setLayoutX(40);
						titleError.setLayoutY(40);
						titleError.setUnderline(true);
						titleError.setFont(Font.font(30));
						titleError.setTextFill(Color.RED);
				       
						Group creategroup = new Group(firstName,firstField,lastName,lastField,birthlabel
								,birthDate,birthplacelabel,birthcountry,titleError,Gender,genderMale,genderFemale,
								deathlabel,deathDate,deathplacelabel,deathcountry,biography,biographyArea,Addchildtolist,helpButton,back);
						Scene createscreen = new Scene(creategroup, 1100, 850);
						createscreen.setFill(Color.MEDIUMSEAGREEN);
						stage.setScene(createscreen);
						}
				
		else {
			String g;
			if(genderMale.isSelected()) {
				g=(genderMale.getText().toString());
			}
			else {
				g= (genderFemale.getText().toString());
			}
			String bio = "";
			if( biographyArea.getText() != null) {
				bio =  biographyArea.getText();
			}
			Tree1 child = new Tree1(firstField.getText(), lastField.getText(),birthDate.getValue().toString(),bio);
			DB.familyMemberCreate(firstField.getText(), lastField.getText(), g, birthDate.getValue(), birthcountry.getValue(),deathDate.getValue()
					,deathcountry.getValue(), bio);
			DB_Alter.setChildID(DB.updateCurrentPID(child));
			DB_Alter.addChild();
		TableView<Tree1> newchosenList = new TableView<Tree1>();
		ObservableList<Tree1> newlistdata= DB.nodeListCreate();
//						try {
//							
//							BufferedWriter writer = new BufferedWriter(new FileWriter("src/Final/newNode.txt",true));
//						writer.newLine();
//						String first = firstField.getText();
//						String last= lastField.getText();
//						writer.write(first.toString() + ",");
//						writer.write(last.toString() + ",");
//						
//						if(birthDate.getValue() != null) {
//						String birth = birthDate.getValue().toString();
//						writer.write(birth.toString()+ ",");
//						}
//						if(birthcountry.getValue() != null) {
//						String birthplace = birthcountry.getValue().toString();
//						writer.write(birthplace.toString()+ ",");
//						}
//						if(genderMale.isSelected()) {
//							writer.write(genderMale.getText().toString()+ ",");
//						}
//						else {
//							writer.write(genderFemale.getText().toString()+ ",");
//						}
//						if(deathDate.getValue() != null) {
//							String death = deathDate.getValue().toString();
//							writer.write(death.toString()+ ",");
//						}
//						if(deathcountry.getValue() != null) {
//							String deathplace = deathcountry.getValue().toString();
//							writer.write(deathplace.toString()+ ",");
//							
//						}
//						if(biographyArea.getText() != null) {
//							String biog = biographyArea.getText().toString();
//							writer.write("(" +biog.toString()+ ").");
//						}
//						
//						  writer.close();
//						} catch (IOException e) {
//							e.printStackTrace();
//						}
//					
//					TableView<Tree1> newchosenList = new TableView<Tree1>();
//					ObservableList<Tree1> newlistdata= FXCollections.observableArrayList();
//					try {
//
////						InputStream rid = new FileInputStream("src/Graphics/help.txt");
//
//					BufferedReader listreader = new BufferedReader(new FileReader("src/Final/newNode.txt"));	
//					String a = "";
//					String line;
//					
//					
//						Tree1 t;
					
//						while((line = listreader.readLine()) != null) {
//							String[] lineA = line.split(",");
//							String firstname = lineA[0];
//							String lastname = lineA[1];
//							String birthday = lineA[2];
//							String birthplace = lineA[3];
//							String bio = lineA[4];
//							
//								t = new Tree1(firstname, lastname, birthday, birthplace, bio);
//								newlistdata.add(t);
//						}
//					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
//						e.printStackTrace();
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
					
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
				                new PropertyValueFactory<Logic, String>("firstName"));

				        TableColumn lastNameCol = new TableColumn("Last Name");
				        lastNameCol.setMinWidth(250);
				        lastNameCol.setResizable(true);
				        lastNameCol.setCellValueFactory(
				                new PropertyValueFactory<Logic, String>("lastName"));
				        
				        TableColumn birthCol = new TableColumn("Birth Date (YYYY-MM-DD)");
				        birthCol.setMinWidth(250);
				        birthCol.setCellValueFactory(
				                new PropertyValueFactory<Logic, String>("birthday"));

				        TableColumn treeCol = new TableColumn("Tree Name");
				        treeCol.setMinWidth(250);
				        treeCol.setResizable(true);
				        treeCol.setCellValueFactory(
				                new PropertyValueFactory<Logic, String>("treeName"));

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
				                    //filter table by Logic name
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
				EventHandler<MouseEvent> AddParenttoFamily= new EventHandler<MouseEvent>() {
					@Override
			public void handle(MouseEvent event) {
						System.out.println("Were in Parent Adding");
						
						if((firstField.getText().equals(null)) || (lastField.getText().equals(null)) || (birthDate.getValue() == null)){
							Label titleError = new Label ("First name, Last name & Birthdate must be filled");
							titleError.setLayoutX(40);
							titleError.setLayoutY(40);
							titleError.setUnderline(true);
							titleError.setFont(Font.font(30));
							titleError.setTextFill(Color.RED);
					       
							Group creategroup = new Group(firstName,firstField,lastName,lastField,birthlabel
									,birthDate,birthplacelabel,birthcountry,titleError,Gender,genderMale,genderFemale,
									deathlabel,deathDate,deathplacelabel,deathcountry,biography,biographyArea,Addparenttolist,helpButton,back);
							Scene createscreen = new Scene(creategroup, 1100, 850);
							createscreen.setFill(Color.MEDIUMSEAGREEN);
							stage.setScene(createscreen);
							}
					
			else {
				String g;
				if(genderMale.isSelected()) {
					g=(genderMale.getText().toString());
				}
				else {
					g= (genderFemale.getText().toString());
				}
				String bio = "";
				if( biographyArea.getText() != null) {
					bio =  biographyArea.getText();
				}
				Tree1 parent = new Tree1(firstField.getText(), lastField.getText(),birthDate.getValue().toString(),bio);
				DB.familyMemberCreate(firstField.getText(), lastField.getText(), g, birthDate.getValue(), birthcountry.getValue(),deathDate.getValue()
						,deathcountry.getValue(), bio);
				DB_Alter.setParentID(DB.updateCurrentPID(parent));
				DB_Alter.addParent();
			TableView<Tree1> newchosenList = new TableView<Tree1>();
			ObservableList<Tree1> newlistdata= DB.nodeListCreate();
//							try {
//								
//								BufferedWriter writer = new BufferedWriter(new FileWriter("src/Final/newNode.txt",true));
//							writer.newLine();
//							String first = firstField.getText();
//							String last= lastField.getText();
//							writer.write(first.toString() + ",");
//							writer.write(last.toString() + ",");
//							
//							if(birthDate.getValue() != null) {
//							String birth = birthDate.getValue().toString();
//							writer.write(birth.toString()+ ",");
//							}
//							if(birthcountry.getValue() != null) {
//							String birthplace = birthcountry.getValue().toString();
//							writer.write(birthplace.toString()+ ",");
//							}
//							if(genderMale.isSelected()) {
//								writer.write(genderMale.getText().toString()+ ",");
//							}
//							else {
//								writer.write(genderFemale.getText().toString()+ ",");
//							}
//							if(deathDate.getValue() != null) {
//								String death = deathDate.getValue().toString();
//								writer.write(death.toString()+ ",");
//							}
//							if(deathcountry.getValue() != null) {
//								String deathplace = deathcountry.getValue().toString();
//								writer.write(deathplace.toString()+ ",");
//								
//							}
//							if(biographyArea.getText() != null) {
//								String biog = biographyArea.getText().toString();
//								writer.write("(" +biog.toString()+ ").");
//							}
//							
//							  writer.close();
//							} catch (IOException e) {
//								e.printStackTrace();
//							}
//						
//						TableView<Tree1> newchosenList = new TableView<Tree1>();
//						ObservableList<Tree1> newlistdata= FXCollections.observableArrayList();
//						try {
	//
////							InputStream rid = new FileInputStream("src/Graphics/help.txt");
	//
//						BufferedReader listreader = new BufferedReader(new FileReader("src/Final/newNode.txt"));	
//						String a = "";
//						String line;
//						
//						
//							Tree1 t;
						
//							while((line = listreader.readLine()) != null) {
//								String[] lineA = line.split(",");
//								String firstname = lineA[0];
//								String lastname = lineA[1];
//								String birthday = lineA[2];
//								String birthplace = lineA[3];
//								String bio = lineA[4];
//								
//									t = new Tree1(firstname, lastname, birthday, birthplace, bio);
//									newlistdata.add(t);
//							}
//						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
//							e.printStackTrace();
//						} catch (IOException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
						
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
					                new PropertyValueFactory<Logic, String>("firstName"));

					        TableColumn lastNameCol = new TableColumn("Last Name");
					        lastNameCol.setMinWidth(250);
					        lastNameCol.setResizable(true);
					        lastNameCol.setCellValueFactory(
					                new PropertyValueFactory<Logic, String>("lastName"));
					        
					        TableColumn birthCol = new TableColumn("Birth Date (YYYY-MM-DD)");
					        birthCol.setMinWidth(250);
					        birthCol.setCellValueFactory(
					                new PropertyValueFactory<Logic, String>("birthday"));

					        TableColumn treeCol = new TableColumn("Tree Name");
					        treeCol.setMinWidth(250);
					        treeCol.setResizable(true);
					        treeCol.setCellValueFactory(
					                new PropertyValueFactory<Logic, String>("treeName"));

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
					                    //filter table by Logic name
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
					EventHandler<MouseEvent> AddSpousetoFamily= new EventHandler<MouseEvent>() {
						@Override
				public void handle(MouseEvent event) {
							System.out.println("Were in Parent Adding");
							
							if((firstField.getText().equals(null)) || (lastField.getText().equals(null)) || (birthDate.getValue() == null)){
								Label titleError = new Label ("First name, Last name & Birthdate must be filled");
								titleError.setLayoutX(40);
								titleError.setLayoutY(40);
								titleError.setUnderline(true);
								titleError.setFont(Font.font(30));
								titleError.setTextFill(Color.RED);
						       
								Group creategroup = new Group(firstName,firstField,lastName,lastField,birthlabel
										,birthDate,birthplacelabel,birthcountry,titleError,Gender,genderMale,genderFemale,
										deathlabel,deathDate,deathplacelabel,deathcountry,biography,biographyArea,Addparenttolist,helpButton,back);
								Scene createscreen = new Scene(creategroup, 1100, 850);
								createscreen.setFill(Color.MEDIUMSEAGREEN);
								stage.setScene(createscreen);
								}
						
				else {
					String g;
					if(genderMale.isSelected()) {
						g=(genderMale.getText().toString());
					}
					else {
						g= (genderFemale.getText().toString());
					}
					String bio = "";
					if( biographyArea.getText() != null) {
						bio =  biographyArea.getText();
					}
					Tree1 newSpouse = new Tree1(firstField.getText(), lastField.getText(),birthDate.getValue().toString(),bio);
					DB.familyMemberCreate(firstField.getText(), lastField.getText(), g, birthDate.getValue(), birthcountry.getValue(),deathDate.getValue()
							,deathcountry.getValue(), bio);
					DB_Alter.setNewSpouseID(DB.updateCurrentPID(newSpouse));
					DB_Alter.addSpouse();
				TableView<Tree1> newchosenList = new TableView<Tree1>();
				ObservableList<Tree1> newlistdata= DB.nodeListCreate();

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
						                new PropertyValueFactory<Logic, String>("firstName"));

						        TableColumn lastNameCol = new TableColumn("Last Name");
						        lastNameCol.setMinWidth(250);
						        lastNameCol.setResizable(true);
						        lastNameCol.setCellValueFactory(
						                new PropertyValueFactory<Logic, String>("lastName"));
						        
						        TableColumn birthCol = new TableColumn("Birth Date (YYYY-MM-DD)");
						        birthCol.setMinWidth(250);
						        birthCol.setCellValueFactory(
						                new PropertyValueFactory<Logic, String>("birthday"));

						        TableColumn treeCol = new TableColumn("Tree Name");
						        treeCol.setMinWidth(250);
						        treeCol.setResizable(true);
						        treeCol.setCellValueFactory(
						                new PropertyValueFactory<Logic, String>("treeName"));

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
						                    //filter table by Logic name
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
						EventHandler<MouseEvent> DeletefromFamily= new EventHandler<MouseEvent>() {
							@Override
					public void handle(MouseEvent event) {
								System.out.println("Were in Deleting ---- MAINGUI");
			
				Tree1 t1 = (table.getSelectionModel().getSelectedItem());
				ObservableList<Tree1> o = DB.nodeListCreate();
				DB_Alter.setCurrentTreeID(DB.updateCurrentPID(t1));		
				DB_Alter.deletePerson();
		
			
					TableView<Tree1> newchosenList = new TableView<Tree1>();
					ObservableList<Tree1> newlistdata= DB.nodeListCreate();

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
							                new PropertyValueFactory<Logic, String>("firstName"));

							        TableColumn lastNameCol = new TableColumn("Last Name");
							        lastNameCol.setMinWidth(250);
							        lastNameCol.setResizable(true);
							        lastNameCol.setCellValueFactory(
							                new PropertyValueFactory<Logic, String>("lastName"));
							        
							        TableColumn birthCol = new TableColumn("Birth Date (YYYY-MM-DD)");
							        birthCol.setMinWidth(250);
							        birthCol.setCellValueFactory(
							                new PropertyValueFactory<Logic, String>("birthday"));

							        TableColumn treeCol = new TableColumn("Tree Name");
							        treeCol.setMinWidth(250);
							        treeCol.setResizable(true);
							        treeCol.setCellValueFactory(
							                new PropertyValueFactory<Logic, String>("treeName"));

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
							                    //filter table by Logic name
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
							BufferedWriter writer = new BufferedWriter(new FileWriter("src/Final/newNode.txt",true));
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

					BufferedReader listreader = new BufferedReader(new FileReader("src/Final/newNode.txt"));	
					String a = "";
					String line;
					
					
						Tree1 t;
					
//						while((line = listreader.readLine()) != null) {
//							String[] lineA = line.split(",");
//							String firstname = lineA[0];
//							String lastname = lineA[1];
//							String birthday = lineA[2];
//							String birthplace = lineA[3];
//							String bio = lineA[4];
//							
//								t = new Tree1(firstname, lastname, birthday, birthplace, bio);
//								newlistdata.add(t);
//						}
//					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
//						e.printStackTrace();
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
				                new PropertyValueFactory<Logic, String>("firstName"));

				        TableColumn lastNameCol = new TableColumn("Last Name");
				        lastNameCol.setMinWidth(250);
				        lastNameCol.setResizable(true);
				        lastNameCol.setCellValueFactory(
				                new PropertyValueFactory<Logic, String>("lastName"));
				        
				        TableColumn birthCol = new TableColumn("Birth Date (YYYY-MM-DD)");
				        birthCol.setMinWidth(250);
				        birthCol.setCellValueFactory(
				                new PropertyValueFactory<Logic, String>("birthday"));

				        TableColumn treeCol = new TableColumn("Tree Name");
				        treeCol.setMinWidth(250);
				        treeCol.setResizable(true);
				        treeCol.setCellValueFactory(
				                new PropertyValueFactory<Logic, String>("treeName"));

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
				                    //filter table by Logic name
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
			
			EventHandler<MouseEvent> submitListaddChild = new EventHandler<MouseEvent>() {
				@Override
		public void handle(MouseEvent event) {
//			try {
//					BufferedWriter writer = new BufferedWriter(new FileWriter("src/Final/treeName.txt",true));
//					    writer.write(treeField.getText().toString());
//					   writer.newLine();
//					    writer.close();
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
					ObservableList<Tree1> o = DB.nodeListCreate();
					Tree1 t1 = (table.getSelectionModel().getSelectedItem());
//					System.out.println(t1.getFirstName());
					DB_Alter.setParentID(DB.updateCurrentPID(t1));
					System.out.println(DB_Alter.getParentID());

//					DB_Alter.parentID=DB.updateCurrentPID(table.getSelectionModel().getSelectedItem());
				System.out.println(table.getSelectionModel().getFocusedIndex());
//					Streamselected.forEach(System.out::print);
//					Streamselected.filter(s->s.startsWith("E")).forEach(System.out::println);
//					System.out.println(.stream());
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
							deathlabel,deathDate,deathplacelabel,deathcountry,biography,biographyArea,Addchildtolist,helpButton,back);
					Scene createscreen = new Scene(creategroup, 1100, 850);
					createscreen.setFill(Color.MEDIUMSEAGREEN);
					stage.setScene(createscreen);
					
				}
			};
			EventHandler<MouseEvent> submitListaddParent = new EventHandler<MouseEvent>() {
				@Override
		public void handle(MouseEvent event) {
//			try {
//					BufferedWriter writer = new BufferedWriter(new FileWriter("src/Final/treeName.txt",true));
//					    writer.write(treeField.getText().toString());
//					   writer.newLine();
//					    writer.close();
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
					ObservableList<Tree1> o = DB.nodeListCreate();
					Tree1 t1 = (table.getSelectionModel().getSelectedItem());
//					System.out.println(t1.getFirstName());
					DB_Alter.setChildID(DB.updateCurrentPID(t1));
					System.out.println(DB_Alter.getChildID());

//					DB_Alter.parentID=DB.updateCurrentPID(table.getSelectionModel().getSelectedItem());
				System.out.println(table.getSelectionModel().getFocusedIndex());
//					Streamselected.forEach(System.out::print);
//					Streamselected.filter(s->s.startsWith("E")).forEach(System.out::println);
//					System.out.println(.stream());
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
							deathlabel,deathDate,deathplacelabel,deathcountry,biography,biographyArea,Addparenttolist,helpButton,back);
					Scene createscreen = new Scene(creategroup, 1100, 850);
					createscreen.setFill(Color.MEDIUMSEAGREEN);
					stage.setScene(createscreen);
					
				}
			};
			EventHandler<MouseEvent> submitListaddspouse = new EventHandler<MouseEvent>() {
				@Override
		public void handle(MouseEvent event) {
//			try {
//					BufferedWriter writer = new BufferedWriter(new FileWriter("src/Final/treeName.txt",true));
//					    writer.write(treeField.getText().toString());
//					   writer.newLine();
//					    writer.close();
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
					ObservableList<Tree1> o = DB.nodeListCreate();
					Tree1 t1 = (table.getSelectionModel().getSelectedItem());
//					System.out.println(t1.getFirstName());
					DB_Alter.setSpouseExistingID((DB.updateCurrentPID(t1)));
//					System.out.println(DB_Alter.getChildID());

//					DB_Alter.parentID=DB.updateCurrentPID(table.getSelectionModel().getSelectedItem());
				System.out.println(table.getSelectionModel().getFocusedIndex());
//					Streamselected.forEach(System.out::print);
//					Streamselected.filter(s->s.startsWith("E")).forEach(System.out::println);
//					System.out.println(.stream());
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
							deathlabel,deathDate,deathplacelabel,deathcountry,biography,biographyArea,Addspousetolist,helpButton,back);
					Scene createscreen = new Scene(creategroup, 1100, 850);
					createscreen.setFill(Color.MEDIUMSEAGREEN);
					stage.setScene(createscreen);
//					table.setSelectionModel(null);
				}
			};
			EventHandler<MouseEvent> submitList = new EventHandler<MouseEvent>() {
				@Override
		public void handle(MouseEvent event) {
			try {
					BufferedWriter writer = new BufferedWriter(new FileWriter("src/Final/treeName.txt",true));
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
		//Search For Logic MAIN MENU
			//PROGRESS HERE -------------------------------------------------------------------------------------------
				EventHandler<MouseEvent> searchResultEvent = new EventHandler<MouseEvent>() {
					@Override
			public void handle(MouseEvent event) {
//						if(!table.getSelectionModel().getSelectedCells().isEmpty()) {
//							
//							System.out.println("---------------------------------------------------" + current);
//						}
				try {
					BufferedReader reader = new BufferedReader(new FileReader("src/Final/treeName.txt"));	
					String a = "";
					String inc= "";
					String line;
		
					while ((line = reader.readLine()) != null){
						
						if(searchField.getText().toLowerCase() != line.toLowerCase()) {
							System.out.println(line);
							 System.out.println(table.getSelectionModel().getFocusedIndex());
						}
						else {
							System.out.println(line);
							System.out.println("Sorry, Tree does not Exist. Please go back and create a new tree");
							 System.out.println(table.getSelectionModel().getFocusedIndex());
						}
					}
					Text helpText = new Text(a);
						} catch (IOException e) {
							e.printStackTrace();
						}
				
				
				int y = 100;
						int x = 20;
						viewTree.setLayoutX(920);
						viewTree.setLayoutY(780);
						viewTree.setScaleX(2);
						viewTree.setScaleY(2);
						
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
						Group root = new Group(back, helpButton, textbox, grid, bio, bioText);

						
						/**
						 * creating the test nodes. Will have to be removed once the DB is added
						 */
//						Logic Lilly = new Logic("Lilly", "Schwarzenbach", false, "19-11-1995", "Riggisberg", 1);
//						Logic Felix = new Logic("Felix", "Schwarzenbach", true, "17-02-1959", "Wädenswil", 1);
//						Logic Susanna = new Logic("Susanna", "Schwarzenbach", false, "30-06-1963", "Bern", 1);
//						Logic Fanny = new Logic("Fanny", "Schwarzenbach", false, "04-05-1995", "Jegenstorf", 1);
//						Logic Fritz = new Logic("Fritz", "Schwarzenbach", true, "21-10-1925", "Zürich", 1, "09-06-2018", "Bern");
//						Logic Hedi = new Logic("Hedi", "Schwarzenbach", false, "21-11-1925", "Wädenswil", 1, "12-04-1973", "Davos");
//						Logic Hans = new Logic("Hans", "Moser", true, "16-03-1931", "Krauchthal", 1, "14-08-2015", "Bäriswil");
//						Logic Käthi = new Logic("Käthi", "Moser", false, "21-03-1936", "Hindelbank", 1);
//						Logic Hasi = new Logic("Hasi", "Schwarzenbach", true, "31-07-1953", "Wädenswil", 1);
//						Logic Heidi = new Logic("Heidi", "Stähli", false, "31-07-1955", "Wädenswil", 1);
//						Logic Susi = new Logic("Susi", "Schwarzenbach", false, "12-10-1962", "Wädenswil", 1);
//						Logic Silja = new Logic("Silja", "Stähli", false, "23-05-1986", "Wädenswil", 1);
//						Logic Patrick = new Logic("Patrick", "Wiesli", true, "24.04.1989", "St.Gallen", 1);
//						Logic Benjamin = new Logic("Benjamin", "Noclue", true, "no clue", "no clue", 1);
//						Logic Ronja = new Logic("Ronja", "Noclue", false, "no clue", "no clue", 1);
//						Logic Jürg = new Logic("Jürg", "Moser", true, "", "", 1);
//						Logic Madlen = new Logic("Madlen", "Moser", false, "", "", 1, "2003", "Bern");
//						Logic Urs = new Logic("Urs", "Moser", true, "", "", 1);
//						Logic Johanna = new Logic("Johanna","Moser", false, "", "", 1);
//						Logic Lara = new Logic("Lara", "Moser", false, "","", 1);
//						Logic Florian = new Logic("Florian", "Moser", true, "", "", 1);
//						Logic Nina = new Logic("Nina", "Moser", false, "", "", 1);
//						Logic Michel = new Logic("Michel", "Moser", true, "", "", 1);
//						Logic Aline = new Logic("Aline", "Stähli", false, "", "", 1);
//						Logic Jonas = new Logic("Jonas", "Stähli", true, "", "", 1);
//						Logic Julian = new Logic("Julian", "Noclue", true, "06-03-2019", "", 1);
						
//						Lilly.addParent(Felix);
//						Felix.addSpouse(Susanna);
////						Susanna.addChild(Fanny);
//						Felix.addParent(Fritz);
//						Fritz.addChild(Hasi);
//						Felix.addParent(Hedi);
//						Susanna.addParent(Hans);
//						Susanna.addParent(Käthi);
//						Fritz.addChild(Susi);
////						Fritz.addParent(Hans);
//						Lilly.setBiography("Learning Java and Learning Java and Learning Java and Learning Java and Learning Java and Learning Java and Learning Java and Learning Java and Learning Java ");
////						Lilly.addSibling(Fanny);
//////						Lilly.addSibling(Käthi);
////						Felix.addSibling(Heidi);
//						Heidi.addChild(Silja);
////						Fanny.addChild(Patrick);
//						Fanny.addSpouse(Patrick);
//						Silja.addSpouse(Benjamin);
//						Silja.addChild(Ronja);
////						Hans.addChild(Susi);
////						Susanna.addSibling(Jürg);
////						Käthi.addChild(Madlen);
////						Hans.addChild(Urs);
////						Urs.addChild(Johanna);
////						Urs.addChild(Lara);
////						Lara.addSibling(Florian);
////						Jürg.addChild(Nina);
////						Jürg.addChild(Michel);
////						Fritz.addParent(Käthi);
//						Heidi.addChild(Jonas);
//						Heidi.addChild(Aline);
//						Silja.addChild(Julian);
//						
//						Silja.addChild(Madlen);
//						Madlen.addSpouse(Felix);
//						Julian.addSpouse(Susi);
//						Silja.addChild(Lilly);
//						Silja.addChild(Fanny);
//						Silja.addChild(Lara);
//						Heidi.addChild(Florian);
//						Heidi.addChild(Nina);
//						Aline.addSpouse(Michel);
//						Fanny.addSpouse(Patrick);
////						Lara.addSpouse(Urs);
//						Florian.addSpouse(Johanna);
//						Jonas.addSpouse(Käthi);
//						Lilly.addSpouse(Hasi);
//						Nina.addSpouse(Hans);
//						Heidi.addSpouse(Urs);
//						ObservableList<Logic> trees= DB.TreeNodeCreate();
						ArrayList<Logic> trees = new ArrayList<>();
//						
//						trees.add(Lilly);
//						trees.add(Felix);
////						trees.add(Susanna);
//						trees.add(Fanny);  
////						trees.add(Fritz);
////						System.out.println(Fritz.getChildren());
////						System.out.println("Hans : " + Hans.getChildren());
////						System.out.println(Felix.getChildren());
//
////						trees.add(Hedi);
//						trees.add(Hans);
//						trees.add(Käthi);
//						trees.add(Hasi);
//						trees.add(Heidi);
//						trees.add(Susi);
//						trees.add(Silja);
//						trees.add(Benjamin);
//						trees.add(Ronja);
//						trees.add(Patrick);
//						trees.add(Jürg);
//						trees.add(Urs);
//						trees.add(Madlen);
//						trees.add(Johanna);
//						trees.add(Michel);
//						trees.add(Nina);
//						trees.add(Florian);
//						trees.add(Lara);
//						trees.add(Aline);
//						trees.add(Jonas);
//						trees.add(Julian);
							
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
						Tree1 current = (Tree1) table.getSelectionModel().getSelectedCells();
						DB.updateCurrentPID(current);
						Logic focused =null;
						for(Logic l : trees) {
							if(l.getID() == DB.getCurrentPID()) {
								focused = l;
							}
						}
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
						stage.setScene(scene);
						stage.setTitle("FamilyTree");
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
       addParentButton.addEventFilter(MouseEvent.MOUSE_CLICKED, submitListaddParent);
       addChildButton.addEventFilter(MouseEvent.MOUSE_CLICKED, submitListaddChild);
       addSpouseButton.addEventFilter(MouseEvent.MOUSE_CLICKED, submitListaddspouse);
       Addtolist.addEventFilter(MouseEvent.MOUSE_CLICKED, AddtoFamilyListEvent);
       Addchildtolist.addEventFilter(MouseEvent.MOUSE_CLICKED, AddChildtoFamily);
       Addparenttolist.addEventFilter(MouseEvent.MOUSE_CLICKED, AddParenttoFamily);
       Addspousetolist.addEventFilter(MouseEvent.MOUSE_CLICKED, AddSpousetoFamily);
       
       deletePersonButton.addEventFilter(MouseEvent.MOUSE_CLICKED, DeletefromFamily);
       alterPersonButton.addEventFilter(MouseEvent.MOUSE_CLICKED, AlterCurrent);
       AddfromAlter.addEventFilter(MouseEvent.MOUSE_CLICKED, AlterUpdateEvent);
       
       
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

