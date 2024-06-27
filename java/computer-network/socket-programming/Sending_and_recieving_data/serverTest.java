import java.io.*;
import java.net.*;

public class serverTest{
   public static void main(String args[]) throws IOException{

      ServerSocket serversocket = new ServerSocket(5000);
      System.out.println("Server started, waiting for the client");
      Socket clientSocket = serversocket.accept();

      
      BufferedReader fromClientIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

      System.out.println("Client connected");
      // System.out.println("Start sending message to the client: ");

      while(true){
         System.out.println("\n\n***********************************************************************");
         String str = fromClientIn.readLine();
         System.out.println("Recieved message from client is: " + str);
         System.out.println("Sending \"Thankyou\" to the client");
         out.println("Thankyou for the data ("+str+")");
         System.out.println("Thankyou sent!!");
         
         if(str.equals("exit")){
            break;
         }
      }

      System.out.println("Server shutdown");
      
   }
}