//Simple button tutorial:
import java.awt.event.*;
import javax.swing.*;

class a_1_buttonTutorial{
   public static void main(String args[]){
      JFrame f = new JFrame("Button Example");
      JButton b = new JButton("Click Here");
      b.setBounds(50,100,95,30);
      f.add(b);
      f.setSize(400,400);
      f.setLayout(null);
      f.setVisible(true);
   }
}
