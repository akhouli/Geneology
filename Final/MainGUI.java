package Final;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
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

public class MainGUI extends Application implements java.io.Serializable{
	public static int countline;

	Tree1 simplifiedList;
	TableView<Tree1> simplifiedTable;
	ObservableList<Tree1> simplifiedOList;
	
public MainGUI() {
	
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
		 AudioClip test = new AudioClip(this.getClass().getResource("transcript.mp3").toString());
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
		
        display X= new display();
        Image Logic = new Image("file:tree.png");
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
				simplifiedOList = DB.FullList();
				simplifiedTable = new TableView();
				TableView<Tree1> table = new TableView<Tree1>();
				ObservableList<Tree1> data= DB.FullList();         
				

				

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
			        

		        display X= new display();
		        Image Logic = new Image("file:tree.png");
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

				BufferedReader reader = new BufferedReader(new FileReader("help.txt"));	
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
		
		//CREATING A NODE 
		
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
			simplifiedTable =newchosenList;
			simplifiedOList =newlistdata; 
			
			
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
	
		EventHandler<MouseEvent> AlterCurrent = new EventHandler<MouseEvent>() {
			@Override
	public void handle(MouseEvent event) {

				
				TableView<Tree1> newchosenList1 = simplifiedTable;
				ObservableList<Tree1> newlistdata1= simplifiedOList;
				
				ObservableList<TablePosition> t1 = newchosenList1.getSelectionModel().getSelectedCells();
				int[] rows = t1.stream().mapToInt(tp -> tp.getRow()).sorted().toArray();
				int[] cols = t1.stream().mapToInt(tp -> tp.getColumn()).sorted().toArray();
				Tree1 selectedobject = newlistdata1.get(rows[0]);
	
				int x = DB.updateCurrentPID(selectedobject);
				DB_Alter.setAlterCurrentID(x);
				Logic l1 = DB_Alter.createLogic(x);
	
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
			 simplifiedTable  = newchosenList1;
			 simplifiedOList= newlistdata1;
				
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
				TableView<Tree1> newchosenList1 = simplifiedTable;
				ObservableList<Tree1> newlistdata1= simplifiedOList;
				
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
		
		newchosenList1 = new TableView<Tree1>();
		newlistdata1= DB.nodeListCreate();
	
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
			        newchosenList1.setEditable(true);

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

			        FilteredList<Tree1> flPerson = new FilteredList(newlistdata1, p -> true);
			        //Passing the data to a filtered list
			        newchosenList1.setItems(flPerson);
			        //Setting the table's items using the filtered list
			        newchosenList1.getColumns().addAll(firstNameCol, lastNameCol, birthCol, treeCol);
			  
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
			        vboxlist.getChildren().addAll(label, newchosenList1, hBoxlist);
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
					simplifiedTable=newchosenList1;
					simplifiedOList=newlistdata1;
					
					
					
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
	
		EventHandler<MouseEvent> createEvent = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Image plus = new Image("file:plus.png");
				Image tree = new Image("file:Famtree.png");
				
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
				simplifiedTable = new TableView();
				simplifiedOList = DB.FullList();
				TableView<Tree1> table = simplifiedTable;
				ObservableList<Tree1> data= simplifiedOList;         
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
//			        birthCol.setResizable(true);
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
				
				TableView<Tree1> newchosenList1 = simplifiedTable;
				ObservableList<Tree1> newlistdata1= simplifiedOList;
				
				ObservableList<TablePosition> t1 = newchosenList1.getSelectionModel().getSelectedCells();
				int[] rows = t1.stream().mapToInt(tp -> tp.getRow()).sorted().toArray();
				int[] cols = t1.stream().mapToInt(tp -> tp.getColumn()).sorted().toArray();
				Tree1 selectedobject = newlistdata1.get(rows[0]);

				int x = DB.updateCurrentPID(selectedobject);
				DB_Alter.setCurrentTreeID(DB.lookupTreeID(x));
				DB_Alter.setExistingChildID((x));

				
				
				
				
			newchosenList1 = new TableView<Tree1>();
			newlistdata1= DB.nodeListSearch(x);
			


				 final Label label = new Label("Search Tree Directory");
			        label.setFont(new Font("Arial", 50));
			        label.setTextFill(Color.IVORY);
			        newchosenList1.setEditable(true);

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

			        FilteredList<Tree1> flPerson = new FilteredList(newlistdata1, p -> true);
			        //Passing the data to a filtered list
			        newchosenList1.setItems(flPerson);
			        //Setting the table's items using the filtered list
			        newchosenList1.getColumns().addAll(firstNameCol, lastNameCol, birthCol, treeCol);
			  
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
			        vboxlist.getChildren().addAll(label, newchosenList1, hBoxlist);
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
					
					simplifiedTable=newchosenList1;
					simplifiedOList= newlistdata1;
					
					Scene scene = new Scene(new Group(), 1100, 850);
					scene.setFill(Color.MEDIUMSEAGREEN);
			        stage.setTitle("Search Tree");
			        ((Group) scene.getRoot()).getChildren().addAll(vboxlist,backSearch,viewTree,addParentButton,addSpouseButton,deletePersonButton,alterPersonButton,addChildButton);

			        stage.setScene(scene);
			        stage.show();

			}	
			};
			EventHandler<MouseEvent> AddChildtoFamily= new EventHandler<MouseEvent>() {
				@Override
		public void handle(MouseEvent event) {
					
					TableView<Tree1> newchosenList1 = simplifiedTable;
					ObservableList<Tree1> newlistdata1= simplifiedOList;
					
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

			
			
			newchosenList1 = new TableView<Tree1>();
			newlistdata1= DB.nodeListCreate();

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
				        newchosenList1.setEditable(true);

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

				        FilteredList<Tree1> flPerson = new FilteredList(newlistdata1, p -> true);
				        //Passing the data to a filtered list
				        newchosenList1.setItems(flPerson);
				        //Setting the table's items using the filtered list
				        newchosenList1.getColumns().addAll(firstNameCol, lastNameCol, birthCol, treeCol);
				  
				        //Adding ChoiceBox and TextField here!
				        ChoiceBox<String> choicelist = new ChoiceBox();
				        choicelist.getItems().addAll("First Name", "Last Name", "Birth Date", "Tree Name");
				        choicelist.setValue("First Name");
				     
				        TextField textField = new TextField();
			      
				        
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
				        vboxlist.getChildren().addAll(label, newchosenList1, hBoxlist);
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
						simplifiedTable=newchosenList1;
						simplifiedOList=newlistdata1;
						
						
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
						TableView<Tree1> newchosenList1 = simplifiedTable;
						ObservableList<Tree1> newlistdata1= simplifiedOList;						
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
				DB_Alter.setNewParentID(DB.updateCurrentPID(parent));
				DB_Alter.addParent();
				newchosenList1 = new TableView<Tree1>();
				newlistdata1= DB.nodeListCreate();
			
 
						
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
					        newchosenList1.setEditable(true);

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

					        FilteredList<Tree1> flPerson = new FilteredList(newlistdata1, p -> true);
					        //Passing the data to a filtered list
					        newchosenList1.setItems(flPerson);
					        //Setting the table's items using the filtered list
					        newchosenList1.getColumns().addAll(firstNameCol, lastNameCol, birthCol, treeCol);
					  
					        //Adding ChoiceBox and TextField here!
					        ChoiceBox<String> choicelist = new ChoiceBox();
					        choicelist.getItems().addAll("First Name", "Last Name", "Birth Date", "Tree Name");
					        choicelist.setValue("First Name");
					     
					        TextField textField = new TextField();					      
					        
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
					        vboxlist.getChildren().addAll(label, newchosenList1, hBoxlist);
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
							simplifiedTable=newchosenList1;
							simplifiedOList=newlistdata1;
							
							
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
							
						TableView<Tree1> newchosenList1 = simplifiedTable;
						ObservableList<Tree1> newlistdata1= simplifiedOList;
							
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
					newlistdata1= DB.nodeListCreate();
					 newchosenList1 = new TableView();
					

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
						        newchosenList1.setEditable(true);

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

						        FilteredList<Tree1> flPerson = new FilteredList(newlistdata1, p -> true);
						        //Passing the data to a filtered list
						        newchosenList1.setItems(flPerson);
						        //Setting the table's items using the filtered list
						        newchosenList1.getColumns().addAll(firstNameCol, lastNameCol, birthCol, treeCol);
						  
						        //Adding ChoiceBox and TextField here!
						        ChoiceBox<String> choicelist = new ChoiceBox();
						        choicelist.getItems().addAll("First Name", "Last Name", "Birth Date", "Tree Name");
						        choicelist.setValue("First Name");
						     
						        TextField textField = new TextField();						      
						        
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
						        
						        choicelist.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) ->
						        {//reset table and textfield when new choice is selected
						            if (newVal != null)
						            {
						                textField.setText("");
						                flPerson.setPredicate(null);//This is same as saying flPerson.setPredicate(p->true);
						            }
						        });
						        HBox hBoxlist1 = new HBox(choicelist, textField);//Add choiceBox and textField to hBox
						        hBoxlist1.setAlignment(Pos.CENTER);//Center HBox
						        final VBox vboxlist1 = new VBox();
						        vboxlist1.setSpacing(100);
						        vboxlist1.setPadding(new Insets(10, 0, 0, 10));
						        vboxlist1.getChildren().addAll(label, newchosenList1, hBoxlist1);
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

								simplifiedTable=newchosenList1;
								simplifiedOList=newlistdata1;
								
								Scene scene = new Scene(new Group(), 1100, 850);
								scene.setFill(Color.MEDIUMSEAGREEN);
						        stage.setTitle("Search Tree");
						        ((Group) scene.getRoot()).getChildren().addAll(vboxlist1,backSearch,viewTree,addParentButton,addSpouseButton,deletePersonButton,alterPersonButton,addChildButton);

						        stage.setScene(scene);
						        stage.show();
						        
						        

						        
						}		
						}
						};
						EventHandler<MouseEvent> DeletefromFamily= new EventHandler<MouseEvent>() {
							@Override
					public void handle(MouseEvent event) {
								
								TableView<Tree1> newchosenList1 = simplifiedTable;
								ObservableList<Tree1> newlistdata1= simplifiedOList;
								
								ObservableList<TablePosition> t1 = newchosenList1.getSelectionModel().getSelectedCells();
								int[] rows = t1.stream().mapToInt(tp -> tp.getRow()).sorted().toArray();
								int[] cols = t1.stream().mapToInt(tp -> tp.getColumn()).sorted().toArray();
								Tree1 selectedobject = newlistdata1.get(rows[0]);
								
							
								int x = DB.updateCurrentPID(selectedobject);
								DB_Alter.setCurrentTreeID(DB.lookupTreeID(x));
								int y = DB_Alter.deletePerson(x);
								
								newchosenList1= new TableView();
								newlistdata1= DB.PostDeleteList(DB_Alter.getCurrentTreeID());
								
								simplifiedTable = newchosenList1;
								simplifiedOList= newlistdata1;
								
								
								
								 final Label label = new Label("Search Tree Directory");
							        label.setFont(new Font("Arial", 50));
							        label.setTextFill(Color.IVORY);
							        newchosenList1.setEditable(true);

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
								

							        FilteredList<Tree1> flPerson1 = new FilteredList(newlistdata1, p -> true);
							        //Passing the data to a filtered list
							        newchosenList1.setItems(flPerson1);
							        //Setting the table's items using the filtered list
							        newchosenList1.getColumns().addAll(firstNameCol, lastNameCol, birthCol, treeCol);
							  
							        //Adding ChoiceBox and TextField here!
							        ChoiceBox<String> choicelistx = new ChoiceBox();
							        choicelistx.getItems().addAll("First Name", "Last Name", "Birth Date", "Tree Name");
							        choicelistx.setValue("First Name");
							     
							        TextField textField = new TextField();
						      
							        
							        textField.setPromptText("Search Tree here");
							        textField.setOnKeyReleased(keyEvent ->
							        {
							            switch (choicelistx.getValue())//Switch on choiceBox value
							            {
							                case "First Name":
							                    flPerson1.setPredicate(p -> p.getFirstName().toLowerCase().contains(textField.getText().toLowerCase().trim()));
							                    //filter table by first name
							                    break;
							                case "Last Name":
							                    flPerson1.setPredicate(p -> p.getLastName().toLowerCase().contains(textField.getText().toLowerCase().trim()));
							                    //filter table by last name
							                    break;
							                case "Birth Date":
							                	 
							                    flPerson1.setPredicate(p -> p.getBirthday().toLowerCase().contains(textField.getText().toLowerCase().trim()));
							                    //filter table by Birthday
							                    break;
							                case "Tree Name":
							                    flPerson1.setPredicate(p -> p.getTreeName().toLowerCase().contains(textField.getText().toLowerCase().trim()));
							                    //filter table by Logic name
							                    break;
							            }
							        });
							//---------------------------------------------------------------------------------------------------------------------
							        
							        choicelistx.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) ->
							        {//reset table and textfield when new choice is selected
							            if (newVal != null)
							            {
							                textField.setText("");
							                flPerson1.setPredicate(null);//This is same as saying flPerson.setPredicate(p->true);
							            }
							        });
							        HBox hBoxlistx = new HBox(choicelistx, textField);//Add choiceBox and textField to hBox
							        hBoxlistx.setAlignment(Pos.CENTER);//Center HBox
							        final VBox vboxlist1 = new VBox();
							        vboxlist1.setSpacing(100);
							        vboxlist1.setPadding(new Insets(10, 0, 0, 10));
							        vboxlist1.getChildren().addAll(label, newchosenList1, hBoxlistx);
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

									

								
									
									Scene scenex = new Scene(new Group(), 1100, 850);
									scenex.setFill(Color.MEDIUMSEAGREEN);
							        stage.setTitle("Search Tree");
							        ((Group) scenex.getRoot()).getChildren().addAll(vboxlist1,backSearch,viewTree,addParentButton,addSpouseButton,deletePersonButton,alterPersonButton,addChildButton);

							        stage.setScene(scenex);
							        stage.show();					        
							}	
							
							};
							
			EventHandler<MouseEvent> submitListaddChild = new EventHandler<MouseEvent>() {
				@Override
		public void handle(MouseEvent event) {

					
					TableView<Tree1> newchosenList1 = simplifiedTable;
					ObservableList<Tree1> newlistdata1= simplifiedOList;
					
					ObservableList<TablePosition> t1 = newchosenList1.getSelectionModel().getSelectedCells();
					int[] rows = t1.stream().mapToInt(tp -> tp.getRow()).sorted().toArray();
					int[] cols = t1.stream().mapToInt(tp -> tp.getColumn()).sorted().toArray();
					Tree1 selectedobject = newlistdata1.get(rows[0]);
				
					int x = DB.updateCurrentPID(selectedobject);
					DB_Alter.setCurrentTreeID(DB.lookupTreeID(x));
					DB_Alter.setParentID((x));	
										
					
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
					
					 simplifiedTable = newchosenList1;
					 simplifiedOList = newlistdata1;
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

					TableView<Tree1> newchosenList1 = simplifiedTable;
					ObservableList<Tree1> newlistdata1= simplifiedOList;
					
					ObservableList<TablePosition> t1 = newchosenList1.getSelectionModel().getSelectedCells();
					int[] rows = t1.stream().mapToInt(tp -> tp.getRow()).sorted().toArray();
					int[] cols = t1.stream().mapToInt(tp -> tp.getColumn()).sorted().toArray();
					Tree1 selectedobject = newlistdata1.get(rows[0]);
				
					int x = DB.updateCurrentPID(selectedobject);
					DB_Alter.setCurrentTreeID(DB.lookupTreeID(x));
					DB_Alter.setExistingChildID((x));

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
					
				  simplifiedTable=newchosenList1;
				simplifiedOList =newlistdata1;
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
					TableView<Tree1> newchosenList1 = simplifiedTable;
					ObservableList<Tree1> newlistdata1= simplifiedOList;
					
					ObservableList<TablePosition> t1 = newchosenList1.getSelectionModel().getSelectedCells();
					int[] rows = t1.stream().mapToInt(tp -> tp.getRow()).sorted().toArray();
					int[] cols = t1.stream().mapToInt(tp -> tp.getColumn()).sorted().toArray();
					Tree1 selectedobject = newlistdata1.get(rows[0]);
					

					int x = DB.updateCurrentPID(selectedobject);
					DB_Alter.setCurrentTreeID(DB.lookupTreeID(x));
					DB_Alter.setSpouseExistingID((x));

					simplifiedTable = newchosenList1;
					simplifiedOList= newlistdata1;

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

				}
			};
		//Search For Logic MAIN MENU
				EventHandler<MouseEvent> searchResultEvent = new EventHandler<MouseEvent>() {
					@Override
			public void handle(MouseEvent event) {
						TableView<Tree1> newchosenList1 = simplifiedTable;
						ObservableList<Tree1> newlistdata1= simplifiedOList;
						
						ObservableList<TablePosition> t1 = newchosenList1.getSelectionModel().getSelectedCells();
						int[] rows = t1.stream().mapToInt(tp -> tp.getRow()).sorted().toArray();
						int[] cols = t1.stream().mapToInt(tp -> tp.getColumn()).sorted().toArray();
						Tree1 selectedobject = newlistdata1.get(rows[0]);
						int xPID = DB.updateCurrentPID(selectedobject);
						DB_Alter.setCurrentTreeID(DB.lookupTreeID(xPID));
						ArrayList<Logic> trees = DB.findFamilyMembersDisplay(xPID);
												
					newchosenList1 = new TableView<Tree1>();
					newlistdata1= DB.nodeListSearch(xPID);
				
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
						Text biog = new Text("Biography: ");
						biog.setFont(Font.font("System Regular", FontWeight.BOLD, 11));
						biog.setX(x);
						biog.setY(340);
						Label bioText = new Label("");
						bioText.setMaxSize(200, 600);
						bioText.setLayoutX(x);
						bioText.setLayoutY(360);
						
						/**
						 * adding all of the above elements into the Group
						 */
						Group root = new Group(back, helpButton, textbox, grid, biog, bioText);

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
						for(Logic t2 : trees) {
							if(t2.getTreeLevel()<minLevel) {
								minLevel = t2.getTreeLevel();
							}
							else if(t2.getTreeLevel()>maxLevel) {
								maxLevel = t2.getTreeLevel();
							}
						}
						double numberOfLevels = maxLevel-minLevel + 1;

						Comparator<Logic> PosComp = new Comparator<Logic>() {
							public int compare(Logic t1, Logic t2) {
								return (int) t1.getXPos()- (int)t2.getXPos();
							}
						};

						Logic focused = trees.get(0);

						double levelWithMaxNodes = focused.getTreeLevel();

						//scaling
						ArrayList<Logic> siblingTrees = DB.getSiblingTrees();
						if(siblingTrees == null) {
							siblingTrees = new ArrayList<>();
						}
						int max = siblingTrees.size() + 1;
						double scale = Math.min(1.5,  8.0/max);
						if(focused.getChildren() != null) {
							scale = Math.min(scale, 7.0/focused.getChildren().size());
						}

						//middle of the siblingtrees
						int middle=((max+1)/2) -1;
						

						
						levelWithMaxNodes  = numberOfLevels - (maxLevel -levelWithMaxNodes);
						
						for(Logic t : trees) {
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
										if(siblingTrees.size()==2) {
											t.setXPos(focused.getXPos() + scale * 60);
										}
										//first half of siblings
										else if(siblingTrees.indexOf(t)<middle) {
											if(t.getSpouse() != null && t.getMale()) {
												t.setXPos(focused.getXPos()-scale*100*(middle-siblingTrees.indexOf(t)-1)-scale*40);
											}
											else {
												t.setXPos(focused.getXPos()-scale*100*(middle-siblingTrees.indexOf(t)-1));
											}
										}
										//second half of siblings
										else {
											if(t.getSpouse() != null && t.getMale()) {
												t.setXPos(focused.getXPos()+scale*100*(siblingTrees.indexOf(t)-middle)-scale*40);
											}
											else {
												t.setXPos(focused.getXPos()+scale*100*(siblingTrees.indexOf(t)-middle));
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
									if(siblingTrees.size()==1) {
										t.setXPos(focused.getXPos() + scale * 60);
									}
									else if(siblingTrees.contains(t)) {
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
								if(t.getSpouse() == null) {
									t.setXPos(focused.getXPos());
								}
								else if(t.getMale()) {
									t.setXPos(focused.getXPos() - 22 * scale);
								}
								else {
									t.setXPos(focused.getXPos() + 22 * scale);

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
													t.setXPos(focused.getXPos()-scale*99*(mid-kids.indexOf(t))+scale*40);
												}
											}
											//second half of siblings
											else {
												if(t.getSpouse() != null && t.getMale()) {
													t.setXPos(focused.getXPos()+scale*100*(kids.indexOf(t)-mid+1)-scale*40);
												}
												else {
													t.setXPos(focused.getXPos()+scale*100*(kids.indexOf(t)-mid+1)-scale*40);
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
													t.setXPos(focused.getXPos()-scale*90*(mid-kids.indexOf(t)));
												}
												else {
													t.setXPos(focused.getXPos()-scale*90*(mid-kids.indexOf(t))+scale*40);
												}
											}
											//second half of siblings
											else {
												if(t.getSpouse() != null && t.getMale()) {
													t.setXPos(focused.getXPos()+scale*90*(kids.indexOf(t)-mid+1));
												}
												else {
													t.setXPos(focused.getXPos()+scale*90*(kids.indexOf(t)-mid+1)+scale*40);
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
											
											if(line.length() + word.length() <= 28) {
												line += word + " ";
											}
											else {
												biotxt += line + "\n";
												line = word+ " ";
											}
										}
										biotxt += line;
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
       backSearch.addEventFilter(MouseEvent.MOUSE_CLICKED, backMainEvent);
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

