import javax.swing.*;
import java.awt.GridLayout;



class Test{
   public static void main(String args[]){
      JFrame f = new JFrame("me me");
      f.setVisible(true);
      f.setSize(400, 300);
      f.setLayout(new GridLayout(4,4));

      JButton b1 = new JButton("b1");
      JButton b2 = new JButton("b2");

      f.add(b1);
      f.add(b2);
   }
}