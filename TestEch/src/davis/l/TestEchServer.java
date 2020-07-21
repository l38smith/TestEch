package davis.l;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Formatter;

public class TestEchServer {

    public static void main(String[] args) throws Exception {
    	System.out.printf("%n Welcome to Server!%n%n");
        
       	
        ExecutorService pool = Executors.newFixedThreadPool(5);

        int port = 12715;
      
        ServerSocket server = new ServerSocket(port);
      
        
        while (true) {
     
        System.out.printf(" Waiting to accept client connection....%n");
          // Main thread will block until a client connects to the server    
        Socket s = server.accept();
        Formatter toClient =
        		new Formatter(s.getOutputStream());
      
       
        
        System.out.printf(" Handling connection from %s%n"
		          , s.getRemoteSocketAddress());
        System.out.printf(" Sending client the \"connected\" message%n");
        
      
        toClient.format(" CONNECTED!%n");
        toClient.flush();
        
            // After the #accept() method call unblocks and a connection
            // between client and server is established, create a 
            // Runnable for that socket so that communication between
            // the client and server can be done in another thread
        TestEchRun runnable
                = new TestEchRun(s);
            
            // Run the runnable in a thread pool to free up the Main
            // thread to accept other connections.
        pool.execute(runnable);}
     }
    }

    	
