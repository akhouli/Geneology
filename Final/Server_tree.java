package Final;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
public class Server_tree {

	public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(4455);
        System.out.println("Server started");
        try {
        while (true) {
            Socket client = ss.accept();// wait for client to connect
            System.out.println("server connected");
            Server_Thread ServerThread = new Server_Thread(client);
           
            ObjectInputStream b = new ObjectInputStream(client.getInputStream());

            client.close();
        }

    }
	catch(Exception e) {
		try {
			ss.close();
		}
		catch(IOException io) {
			System.out.println("Cant close server socket");
		}
	}
}
}
	

