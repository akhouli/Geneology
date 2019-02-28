package Graphics;

import java.util.Calendar;
import java.util.Locale;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainGUI extends Application {

	
	public void start(Stage stage) throws Exception {
        Button helpButton = new Button("Help");
        Button exit = new Button("Exit");
        Button Create = new Button("Create New Tree");
        Button Search= new Button("Search Existing Tree Directory");
        Text Title = new Text(300.0,100.0,("Family Tree"));
        Button submit= new Button("Submit");
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
		Button Add= new Button("Create New");
        
 
        display X= new display();
        Image Tree = new Image("file:src/Graphics/tree.png");
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
        Search.setLayoutX(430);
        Search.setLayoutY(630);
        Search.setScaleX(2);;
        Search.setScaleY(2);;
        Button back = new Button("back");
		back.setLayoutX(10);
		back.setLayoutY(780);
		EventHandler<MouseEvent> backMainEvent = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Text startText = new Text("startscreen");
				startText.setX(400);
				startText.setY(400);
				Group startgroup = new Group(treeview,helpButton, Create,Title, Search,exit);
				Scene startscreen = new Scene(startgroup, 1100, 850);
				stage.setScene(startscreen);
				
			}
		};
	
        
        EventHandler<MouseEvent> helpEvent = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Text helpText = new Text("helpscreen");
				helpText.setX(400);
				helpText.setY(400);
				Group helpgroup = new Group(helpText,back);
				Scene helpscreen = new Scene(helpgroup, 1100, 850);
				stage.setScene(helpscreen);
				
			}
		};
		ObservableList<String> cities = FXCollections.observableArrayList();
        ComboBox<String> birthcountry = new ComboBox<String>(cities);
        ComboBox<String> deathcountry = new ComboBox<String>(cities);

        String[] locales1 = Locale.getISOCountries();
        for (String countrylist : locales1) {
            Locale obj = new Locale("", countrylist);
            String[] city = { obj.getDisplayCountry() };
            for (int x = 0; x < city.length; x++) {
                cities.add(obj.getDisplayCountry());
            }
        }
        birthcountry.setItems(cities);
        deathcountry.setItems(cities);
	    
		EventHandler<MouseEvent> submitEvent = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
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
			String first = firstField.getText();
			String last= lastField.getText();
			System.out.println(first);
			System.out.println(last);
			if(birthDate.getValue() != null) {
			String birth = birthDate.getValue().toString();
			System.out.println(birth);
			}
			if(birthcountry.getValue() != null) {
			String birthplace = birthcountry.getValue().toString();
			System.out.println(birthplace);
			}
			if(genderMale.isSelected()) {
				System.out.println(genderMale.getText());
			}
			else {
				System.out.println(genderFemale.getText());
			}
		}
		
		}
	};
		EventHandler<MouseEvent> createEvent = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Image plus = new Image("file:src/Graphics/plus.png");
				Image tree = new Image("file:src/Graphics/Famtree.png");
				Label treeName = new Label("Tree Name:");
				TextField treeField = new TextField ();
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
		

        handler Exit= new  handler(X);
        exit.addEventFilter(MouseEvent.MOUSE_CLICKED, Exit);
        back.addEventFilter(MouseEvent.MOUSE_CLICKED, backMainEvent);
       helpButton.addEventFilter(MouseEvent.MOUSE_CLICKED, helpEvent);
       Create.addEventFilter(MouseEvent.MOUSE_CLICKED, createEvent);
       submit.addEventFilter(MouseEvent.MOUSE_CLICKED, submitEvent);
       Add.addEventFilter(MouseEvent.MOUSE_CLICKED, CreateNew);
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
