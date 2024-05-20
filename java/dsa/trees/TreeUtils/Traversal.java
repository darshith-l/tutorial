package TreeUtils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Traversal {

   //inorder traversal**********************************************************************************
   public static void inorder(boolean reccurssion, Node root){
       System.out.println("\n\n************Started In order traversal");

      if(reccurssion){
         inorder(root);
         System.out.println("\n*************Ended inorder traversal");
         return;
      }

      //Without reccurssion:

      Stack<Node> stack = new Stack<>();

      Node curr = root;

      //See readMe for complete understanding of algo used:
      while(curr != null || !stack.isEmpty()){

         while(curr != null){
            stack.push(curr);
            curr = curr.lchild;
         }

         curr = stack.pop();

         System.out.print(curr.data + "-> ");

         curr = curr.rchild;

      }

      System.out.println();
      System.out.println("\n*************Ended inorder traversal");
   }

   private static void inorder(Node root){
      if(root != null){
         inorder(root.lchild);
         System.out.print(root.data + "-> ");
         inorder(root.rchild);
      }
   }

   //postorder traversal**********************************************************************************
   public static void postorder(boolean reccurssion, Node root){
      
      System.out.println("\n\n************Started Post order traversal");

      if(reccurssion){
         postorder(root);
         System.out.println("\n*************Ended postorder traversal");
         return;
      }

      Stack<Node> stack1 = new Stack<>();
      Stack<Node> stack2 = new Stack<>();

      stack1.push(root);

      while(!stack1.isEmpty()){
         Node curr = stack1.pop();
         stack2.push(curr);
         if(curr.lchild != null) stack1.push(curr.lchild);
         if(curr.rchild != null) stack1.push(curr.rchild);
      }

      while(!stack2.isEmpty()){
         System.out.print(stack2.pop().data + "-> ");
      }

      System.out.println();
      System.out.println("\n*************Ended postorder traversal");

   }

   private static void postorder(Node root){
      if(root != null){
         postorder(root.lchild);
         postorder(root.rchild);
         System.out.print(root.data + "-> ");
      }
   }

   //pre-order traversal*********************************************************************************
   public static void preorder(boolean reccurssion, Node root){
      System.out.println("\n\n************Started Pre order traversal");

      if(reccurssion){
         preorder(root);
         System.out.println("\n*************Ended preorder traversal");
         return;
      }

      //Without reccurssion:
      Stack<Node> stack = new Stack<>();

      stack.push(root);

      while(!stack.isEmpty()){
         Node curr = stack.pop();

         System.out.print(curr.data + "-> ");

         if(curr.rchild != null) stack.push(curr.rchild);
         if(curr.lchild != null) stack.push(curr.lchild);
      }

      System.out.println();
      System.out.println("\n*************Ended preorder traversal");

   }

   private static void preorder(Node root){

      if(root != null){
         System.out.print(root.data + "-> ");
         preorder(root.lchild);
         preorder(root.rchild);
      }
   }

   public static void levelorder(boolean reverse, Node root){
      System.out.println("\n\n************Started Level order traversal reverse: " + reverse);
      if(!reverse){
         
         Queue<Node> displayTrack = new LinkedList<>();
         displayTrack.add(root);

         while(!displayTrack.isEmpty()){
            Node presendtNode = displayTrack.remove();
            System.out.print(presendtNode.data+"-> ");
            if(presendtNode.lchild != null)
            displayTrack.add(presendtNode.lchild);
            if(presendtNode.rchild != null)
            displayTrack.add(presendtNode.rchild);
         }

      }
      else{
         Queue<Node> displayTrack = new LinkedList<>();
         Stack<Node> orderTrack = new Stack<>();
         displayTrack.add(root);

         while(!displayTrack.isEmpty()){
            Node presendtNode = displayTrack.remove();
            if(presendtNode.rchild != null){
               displayTrack.add(presendtNode.rchild);
               orderTrack.push(presendtNode.rchild);
            }
            if(presendtNode.lchild != null){
               displayTrack.add(presendtNode.lchild);
               orderTrack.push(presendtNode.lchild);
            }
         }

         while(!orderTrack.isEmpty()){
            System.out.print(orderTrack.pop().data+"-> ");
         }
      }

      System.out.println();
      System.out.println("\n*************Ended Level order traversal reverse: " + reverse);
   }
}
