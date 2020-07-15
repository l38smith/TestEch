package davis.l;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;



public class TestEchClient {


     public static void main(String[] args) throws Exception {
        System.out.printf("%nWelcome to Client!%n%n%n");

        Scanner scanner = new Scanner (System.in)    ;
	   
	   Socket socket
            = new Socket("localhost", 12715);
        Formatter toServer 
           = new Formatter(socket.getOutputStream());
     
        Scanner fromServer
           = new Scanner(socket.getInputStream());
     
        String Connected = fromServer.nextLine() ;
        System.out.printf("%s%n", Connected) ;
           
      boolean prompted = true;

     
        
        
       while (prompted) {

      
    	   System.out.printf("%n What do you want echoed (\".\" to exit)?");
    	    String wishechoed = scanner.nextLine() ;  
    	    System.out.printf("%n");

        	try {   
        		   
        		    
	    toServer.format("%s%n", wishechoed);
        toServer.flush();
        String echoing = fromServer.nextLine();
	    System.out.printf("  %s%n%n"
	    		+ "", echoing);
	       
        Thread.sleep(1000 * 5);
	    
        	
	    
	    if (wishechoed.equals(".")) {
	    	prompted = false;
	    	
	    	toServer.format("null%n");
	    	toServer.flush();
	    	scanner.close();
	    	fromServer.close();
	    	toServer.close();
	    	
	    	socket.close();
	    	
	    	System.out.printf(" %n Closing connection to server...%n%n");
	    	System.out.printf(" Good bye!%n%n"); 
	    	
	    	//socket.close(); 
	    	 while (prompted);
	    	
	    }
	    } catch (InterruptedException  e) {
	         throw new RuntimeException(e) ;   
	       
	       
}  
    
}
   
}
}    

