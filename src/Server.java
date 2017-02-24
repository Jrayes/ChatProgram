import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Scanner;

public class Server implements Runnable {
	String PORT  = "8889";
	String HOST = "localhost";
	private String User = ""; 
	    private Socket socket;//SOCKET INSTANCE VARIABLE
	    public Server(Socket s)

	    {

	        socket = s;//INSTANTIATE THE SOCKET
	
	    }
	
	     
	    
	    @Override

	    public void run() 
	    {
	    	
	
	        try 
	
	        {
	        	
	        	
	            Scanner in = new Scanner(socket.getInputStream());//GET THE SOCKETS INPUT STREAM (THE STREAM THAT YOU WILL GET WHAT THEY TYPE FROM)
	            PrintWriter out = new PrintWriter(socket.getOutputStream());//GET THE SOCKETS OUTPUT STREAM (THE STREAM YOU WILL SEND INFORMATION TO THEM FROM)
	            Scanner chat = new Scanner(System.in);
	            DBM Connection = new DBM();
	            User = Connection.Connect("Jad","123456");
	  
	            while (true)//WHILE THE PROGRAM IS RUNNING
	
	            {      
	            	
	                if (in.hasNextLine())
	
	                {
	                	
	                	
	                    String input = in.nextLine();
	                    
	                    System.out.println(User + " Said: " + input);
	                    
	                    out.println(chat.nextLine());
	                    
	                    out.flush();
	
	                }
	                
	                else {
	                	in.close();
	                	chat.close();
	                	
	                }
	
	            }
	
	        }
	        
	        catch (IOException io)
	
	        {

	        	System.out.println("IOConnection Error(View stack trace for more details) : " + io.getMessage());
	            io.printStackTrace();
	        } catch (SQLException e) {
	        	System.out.println("Failed to log you in");
				e.printStackTrace();
			}  
	    }

	
	}

