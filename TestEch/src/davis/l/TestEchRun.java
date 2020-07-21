package davis.l;
import java.io.IOException;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;

public class TestEchRun implements Runnable {
	
	private Socket socket;
	
	public TestEchRun(Socket socket) {
		this.socket = socket;
}
	
	  @Override
	    public void run() {

	     
	             Thread.currentThread().getName();
	             socket.getRemoteSocketAddress();
	           
	        
	       try (
	            Formatter toClient 
	                = new Formatter(socket.getOutputStream());
	            Scanner fromClient 
	                = new Scanner(socket.getInputStream());) {
	        	
            		
	            while (true) {
	                // read from client
	            	           
	            	String toEcho = fromClient.nextLine();	            	
	            	 if (toEcho.equals(".")) {
	            		            		 
	            		 toClient.format(" ");
	            		 toClient.flush();
	            		 socket.close();
	            		
	            		System.out.printf("Server received \"null\" from client%n");
	            		System.out.printf("Lost connection from %s%n",  
	            				socket.getRemoteSocketAddress());
	            		         		
	            		while (true); 
	            	 }
	            	 else {
	              System.out.printf(
	                    " SERVER: %s: received \" %s\" from client %n"
	                    , Thread.currentThread().getName()
	                    , toEcho);
	              System.out.printf(" \"ECHO\": %s%n", toEcho);
	                // write to client
	               	             
	              toClient.format(" ECHO: \"%s\"%n", toEcho);
	              toClient.flush();
	                               
	            	 }
	                }
	               } 
	                catch (IOException e) {

	        	 System.out.printf("SERVER: %s: %s Connection lost%n"
		         , Thread.currentThread().getName()
		         , socket.getRemoteSocketAddress()); 	                   
	       	 
  }
 }    
}
	 
	        
 
	                      