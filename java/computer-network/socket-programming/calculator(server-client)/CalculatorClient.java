import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorClient{
   public static void main(String[] args) {
      //creating new soclet for client.
      Socket socket = null;

      try{
         Scanner sc = new Scanner(System.in);

         //ip address of server is mention along with its port number with Socket() constructor
         socket = new Socket("127.0.0.1", 8000);
         System.out.println("Connected to the socket");

         //DataInputStream, DataOutputStream classes of io package is used to send data from client
         //to server and to recieve data from client in server side respectively
         //Note the use of getInputStream(), getOutputStream() with constructors
         DataInputStream dis = new DataInputStream(socket.getInputStream());
         DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

         while(true){
            System.out.println("Enter the operation in form operator operand operator form(Ex: 3 + 5): ");
            String input = sc.nextLine();

            if(input.equals("over")){
               //System.out.println("Thankyou for using service, exiting. Thankyou");
               dos.writeUTF(input);
               break;
            }

            //Sends data to server 
            dos.writeUTF(input);

            //Recieves data from the server
            String ans = dis.readUTF();

            System.out.println("Answer: "+ans+"\n\n");

         }
         System.out.println("Thankyou for using service, exiting. Thankyou");
         
         //destroying the socket connection
         socket.close();
      }
      catch(Exception e){
         System.out.println(e);
      }

   }
}