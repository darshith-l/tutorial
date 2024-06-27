import java.awt.event.*;
import javax.swing.*;

class a_2_buttonTutorial{
   public static void main(String[] args) {
      JFrame f = new JFrame("Button with action listener");
      final JTextField tf = new JTextField();
      final JButton b = new JButton("Click Here");

      tf.setBounds(50,50,150, 20);
      b.setBounds(50,80,95,30);

      b.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            tf.setText("welcome to tutorial!!");
         }
      });

      f.add(b);
      f.add(tf);
      f.setSize(500,500);
      f.setLayout(null);
      f.setVisible(true);

      
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
      System.out.println("Hello");
   }
}