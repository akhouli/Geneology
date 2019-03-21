package Final;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client_Tree {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket s = new Socket ("Khouli",4455);
		 ObjectOutputStream p = new ObjectOutputStream(s.getOutputStream());

	        p.close();
		
		s.close();
		
	}

}
