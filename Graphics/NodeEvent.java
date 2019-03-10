//package Graphics;
//import Logic.Tree;
//import javafx.event.EventHandler;
//import javafx.scene.Group;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.text.Text;
//
//public class NodeEvent {
//	Tree t;
//	Button b;
//	Group root;
//	public NodeEvent(Tree t, Button b, Group root) {
//		this.t = t;
//		this.b = b;
//		this.root = root;
//	}
//	
//	public Button newButton() {
//		b.addEventFilter(MouseEvent.MOUSE_CLICKED, nodeEvent);
//		return b;
//	}
//	
//	EventHandler<MouseEvent> nodeEvent = new EventHandler<MouseEvent>() {
//		@Override
//		public void handle(MouseEvent event) {
//			Text firstnameText = new Text(t.getFirstName());
//			firstnameText.setX(100);
//			firstnameText.setY(100);
//			Group startgroup = new Group(firstnameText);
//			startgroup.getChildren().addAll(root.getChildren());
//			Scene startscreen = new Scene(startgroup, 1100, 850);
//			primaryStage.setScene(startscreen);
//			
//		}
//	};
//
//}
