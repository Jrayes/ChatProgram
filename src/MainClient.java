import java.io.IOException;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
public class MainClient {
		
	 

		//private final static int PORT = 6677;//SET A CONSTANT VARIABLE PORT
		//private final static String HOST = "localhost";//SET A CONSTANT VARIABLE HOST
		
		public static void main(String[] args) throws IOException
		{
			try 
			{
				//MainClient MainC = new MainClient();
				//MainC.Connect("root","root");
				Socket s = new Socket(args[0], Integer.parseInt(args[1]));//CONNECT TO THE SERVER
				
				System.out.println("You connected to " + args[0]);//IF CONNECTED THEN PRINT IT OUT
				
				Client client = new Client(s);//START NEW CLIENT OBJECT
				
				Thread t = new Thread(client);//INITIATE NEW THREAD
				t.start();//START THREAD
				
			} 
			catch (Exception noServer)
			{
				System.out.println("The server might not be up at this time.");
				System.out.println("Please try again later.");
			}
		}
	}



