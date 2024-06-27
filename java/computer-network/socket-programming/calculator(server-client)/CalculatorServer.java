import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

class CalculatorServer{
   public static void main(String[] args) {
      try{

         System.out.println("Server started successfully");
         ServerSocket ss = new ServerSocket(8000);
         Socket socket = ss.accept();

         System.out.println("Connection made successfully");

         DataInputStream dis = new DataInputStream(socket.getInputStream());
         DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

         while(true){
            
            String input = dis.readUTF();

            if(input.equals("over")){
               System.out.println("Stopping the server");
               break;
            }

            System.out.println("Equation recieved is " + input);

            StringTokenizer st = new StringTokenizer(input);

            int op1 = Integer.parseInt(st.nextToken());
            char operand = st.nextToken().charAt(0);
            int op2 = Integer.parseInt(st.nextToken());

            int result = 0;

            if(operand == '+'){
               result = op1 + op2;
            }
            else if(operand == '-'){
               result = op1 - op2;
            }
            else if(operand == '*'){
               result = op1 * op2;
            }
            else if(operand == '/'){
               result = op1 / op2;
            }
            else{
               result = op1%op2;
            }

            System.out.println("Result "+ result +" is sent successfully" );

            dos.writeUTF(Integer.toString(result));
         }

          socket.close();
      }

      catch(Exception e){
         System.out.println(e);
      }

   }
}