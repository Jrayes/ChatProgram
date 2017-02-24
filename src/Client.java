import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable {

	private Socket socket;
	private String User = "";
	public Client(Socket s)
	{
		socket = s;
	}
	

	public void run()
	{
		try
		{
			Scanner chat = new Scanner(System.in);//GET THE INPUT FROM THE CMD
			Scanner in = new Scanner(socket.getInputStream());//GET THE CLIENTS INPUT STREAM (USED TO READ DATA SENT FROM THE SERVER)
			PrintWriter out = new PrintWriter(socket.getOutputStream());//GET THE CLIENTS OUTPUT STREAM (USED TO SEND DATA TO THE SERVER)
			DBM Connection = new DBM();
			User = Connection.Connect("Ali","345678");
			while (true)//WHILE THE PROGRAM IS RUNNING
			{	
				
				String input = chat.nextLine();	//SET NEW VARIABLE input TO THE VALUE OF WHAT THE CLIENT TYPED IN
				
				out.println(input);//SEND IT TO THE SERVER
				out.flush();//FLUSH THE STREAM
				
				if(in.hasNext())//IF THE SERVER SENT US SOMETHING
					System.out.println(User + " Said:"  + in.nextLine());//PRINT IT OUT
			
				
				else {
					
					in.close();
					chat.close();
				}
			}
		}
		catch (Exception e)
		{	
			e.printStackTrace();//MOST LIKELY WONT BE AN ERROR, GOOD PRACTICE TO CATCH THOUGH
		} 
	}

}