package Graphics;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
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
	
	public AddChildHandler(Stage sta, Scene scene, Group root, Tree child, Tree parent) {
		System.out.println(root);
//		TreeScreen_3 ts3 = new TreeScreen_3();
		ts = sta;
//		scene = sta.getScene();
		this.scene = scene;

//		this.root = (Group) scene.getRoot();
		this.root = root;
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
				String out = "23,"+child.getFirstName()+","+child.getLastName() + "," + child.getMale()+","+child.getBirthDate()+","+child.getBirthPlace()+","+child.getFamilyID();
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
//				System.out.println(root.getChildren());
				
				
				
				Rectangle rec = new Rectangle(350, 150, 1000, 600);
				
				rec.setFill(Color.BLACK);
//				h.getChildren().add(rec);

				ArrayList<Tree> trees = new ArrayList<>();
//						TreeScreenModel.getNodes();
				h.getChildren().addAll(root.getChildren());
				System.out.println("--------------------------------\n");
//				for(Node n : h.getChildren()) {
//					System.out.println(n);
//				}
				
				ObservableList<Node> p = (h.getChildren());
				p.remove(p.size()-1);
				
				
//				Group gr = new Group();
//				ToggleButton tgtest = new ToggleButton();
//				int i = 0;
//				int j = 0;
//				int k = p.size();
//				while(j<k){
//					Node n = p.get(i);
//					if(n.getClass() == tgtest.getClass()) {
//						System.out.println(n);
//						h.getChildren().remove(n);
//						System.out.println("..........................................");
//						for(Node m : h.getChildren()) {
//							System.out.println(m);
//						}
//						System.out.println("...........................................");
//						i--;
//					}
//					i++;
//					j++;
//				}
//				System.out.println("--------------------------------\n");
//				for(Node n : h.getChildren()) {
//					System.out.println(n);
//				}
//
				h.getChildren().add(TreeScreenModel.generateNodes(root,trees, ts, parent));
//				Group gro = new Group(TreeScreenModel.generateNodes(root,trees, ts, parent).getChildren());
////				gro.getChildren().add(rec);
//				
//				System.out.println("GRO------------------------------------------------");
//				for(Node m : gro.getChildren()) {
//				System.out.println(m);
//			}
//				System.out.println("GRO END--------------------------------------------");
//				int l = 0;
//				int n = gro.getChildren().size();
//				while(l<n){
//					System.out.println(gro.getChildren().get(0));
//					h.getChildren().add(gro.getChildren().get(0));
//					l++;
//				}
////				for(Node m : gro.getChildren()) {
////					System.out.println(m);
////					h.getChildren().add(m);
////				}
//				System.out.println("adding gro-----------------------------------------");
////				h.getChildren().addAll(gro);
//				for(Node m : h.getChildren()) {
//					System.out.println(m);
//				}
////				scene.setRoot(h);
				Scene scene = new Scene(h, 1100, 850);
				scene.setFill(Color.MEDIUMSEAGREEN);
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
