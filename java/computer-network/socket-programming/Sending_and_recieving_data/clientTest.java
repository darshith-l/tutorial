import java.io.*;
import java.net.*;

public class clientTest {
   public static void main(String[] args) throws IOException{
      Socket client = new Socket("localhost", 5000);

      BufferedReader fromServerIn = new BufferedReader(new InputStreamReader(client.getInputStream()));
      BufferedReader  fromUserIn = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter out = new PrintWriter(client.getOutputStream(), true);

      System.out.println("Client connected to server");

      while(true){
         System.out.println("\n\n*********************************************************************");
         System.out.println("Enter the data to the server: ");
         String sending_data = fromUserIn.readLine();
         System.out.println("Sending data to server initiated");
         out.println(sending_data);
         System.out.println("Data (" + sending_data + ") is sent successfully");
         System.out.println("Initiating thankyou from the server ");
         String recieved_data = fromServerIn.readLine();
         System.out.println("Recieved thankyou from server: " + recieved_data);

         if(sending_data.equals("exit")){
            System.out.println("Thankyou for using the service :)");
            break;
         }
      }

      System.out.println("\n\nOperation Ended successfully");

      
   }
}