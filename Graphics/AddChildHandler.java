package Graphics;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Logic.Tree;

public class AddChildHandler implements EventHandler<MouseEvent> {
	
	TreeScreen_3 ts3;
	Stage ts;
	Scene scene;
	Group root;
	Tree child;
	Tree parent;
	
	public AddChildHandler(Stage sta, Scene scene, Tree child, Tree parent) {
		System.out.println(root);
		TreeScreen_3 ts3 = new TreeScreen_3();
		ts = sta;
//		scene = sta.getScene();
		this.scene = scene;

		this.root = (Group) scene.getRoot();
		
		parent.addChild(child);
		this.child = child;
		this.parent = parent;
	}
	
		public void handle(MouseEvent event) {
			parent.addChild(child);
//			Text startText = new Text("startscreen");
//			startText.setX(400);
//			startText.setY(400);
//			Group startgroup = new Group(startText);
//			Scene s = new Scene(startgroup, 1100, 850);	
//			try {
//				ts.setScene(s);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			try {
				BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\lschw\\Documents\\Bham\\Term2\\TeamProject\\FamilyTree\\src\\Graphics\\DatabaseMockUp"));
				ArrayList<String> previousLines = new ArrayList<>();
				
				String line;
				int i = 0;
				while((line = br.readLine()) != null) {
					previousLines.add(line);
				}
				BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\lschw\\Documents\\Bham\\Term2\\TeamProject\\FamilyTree\\src\\Graphics\\DatabaseMockUp"));
				String out = child.getFirstName()+","+child.getLastName() + "," + child.getMale()+","+child.getBirthDate()+","+child.getBirthPlace()+","+child.getFamilyID();
				System.out.println(out);
				previousLines.add(out);
				for(String l : previousLines) {
					bw.write(l+"\n");
				}
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
//				Group g = (Group) scene.getRoot();
				Group h = new Group();
				System.out.println(root.getChildren());

				h.getChildren().addAll(root.getChildren());
				ArrayList<Tree> trees = TreeScreenModel.getNodes();
				
				h.getChildren().addAll(TreeScreenModel.generateNodes(root, trees, ts, parent).getChildren());
				scene.setRoot(h);
//				Scene s = new Scene(h, 1100, 800);
//				scene.setFill(Color.MEDIUMSEAGREEN);
				ts.setScene(scene);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	
//		public Scene getAddChildScene() {
//			return ts;
//		}

}
