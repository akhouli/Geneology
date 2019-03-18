package Final;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class handler implements EventHandler<MouseEvent> {
	display press;
	public handler(display press) {
		this.press=press;
	}
		public void handle(MouseEvent event) {
		press.Exit();
		
	}
}
