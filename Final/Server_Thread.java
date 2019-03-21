package Final;

import java.net.Socket;

public class Server_Thread {
	
	private Socket client;
	
	public Server_Thread(Socket client) {
		this.client=client;
		new Thread() {
	public void run() {
		javafx.application.Application.launch(MainGUI.class);

		
	}
	}.start();
	}

}