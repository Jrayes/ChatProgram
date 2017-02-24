import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/* CHAT RC - 1.0 Alpha
 * Add a DB component to allow people to login and chat 
 * Also add capability to quit program.
 * */


public class Main {
	public static void main(String[] args) throws IOException {
		
		        try
		
		        {
		           final int PORT = Integer.parseInt(args[0]);
		
		            ServerSocket server = new ServerSocket(PORT);
		
		            System.out.println("Waiting for members...");
		
		         
		
		            while (true)
		
		            {                                              
		            	
		                Socket s = server.accept();
		                 
		
		                System.out.println("Client connected from " + s.getLocalAddress().getHostName());   //  TELL THEM THAT THE CLIENT CONNECTED
		
		                 
		
		                Server chat = new Server(s);
		
		                
		                Thread t = new Thread(chat);
		
		               
		                t.start();
		
		            }
		        }
		
		        catch(IOException e)
	
		        {
		
		            System.out.println("IOConnection Error(view stack trace for more details)" + e.getMessage());
		
		                        e.printStackTrace();
		                        
		
		        }
		    }

		 

}
