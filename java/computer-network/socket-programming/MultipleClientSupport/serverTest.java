import java.io.*;
import java.net.*;

public class serverTest{
   public static void main(String args[]) throws IOException{

      ServerSocket serversocket = new ServerSocket(5000);
      System.out.println("Server started, waiting for the client");
      
      int i = 0; 
      while(true){
         Socket clientSocket = serversocket.accept();
         //System.out.println("Client connected");

         BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
         String name = in.readLine();

         System.out.println("[ " + name + " ] connected");

         new Thread(new multipleClients(name, clientSocket)).start();
         i++;
      }
      
   }
}

class multipleClients implements Runnable{
   String name;
   Socket clientSocket;
   
   multipleClients(String name, Socket clientSocket){
      this.name = name; 
      this.clientSocket = clientSocket;
   }

   public void run(){
      try{
         BufferedReader fromClientIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
         PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

         while(true){
            String str = fromClientIn.readLine();
            System.out.println("[ " +name + " sent ]:       " + str);
            
            if(str.equals("exit")){
               System.out.println("[ " +name + " closed connection]:       " + str);
               break;
            }
         }
      }
      catch(Exception e){
         System.out.println("Exception in run()");
      }
   
      
   }
}

