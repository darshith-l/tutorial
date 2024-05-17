//Implementation of Binary tree:
//Insertion
//Deletion
//Preorder Traversal(recurssion)
//Preorder Traversal(non-recurssive)
//Postorder Traversal(recurssion)
//Postorder Traversal(non-recurssive)
//Inorder Traversal(recurssion)
//Inorder Traversal(non-recurssive)
//Level order
//Reverse level order
//Height of a tree
//Leaf nodes of tree
//Deepest node
//Left view
//Right view
//Top view 
//Bottom view
//Serializing tree
//Search

import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

class Node{
   int data;
   Node lchild, rchild;

   public Node(int data){
      this.data = data;
      lchild = rchild = null;
   }
}

class Tree{
   Node root = new Node(0);
   private Scanner sc = new Scanner(System.in);

   /*************************************Insertion*************************************** */
   public void insert(){
      Queue<Node> insertionTrack = getLeafNode();

      while(!insertionTrack.isEmpty()){
         Node presentNode = insertionTrack.remove();
         char createChild = '\0';

         System.out.println("\n\n");
         
         while(createChild != 'y' && createChild != 'n'){
            System.out.print("Create left child for "+ presentNode.data +" Y/N? ");
            createChild = Character.toLowerCase(sc.next().charAt(0));
         }

         if(createChild == 'y'){
            System.out.print("Enter the element for left child: ");
            int leftChildData = sc.nextInt();
            Node leftChild = new Node(leftChildData);
            presentNode.lchild = leftChild;
            insertionTrack.add(leftChild);
         }

         createChild = '\0';
         
         while(createChild != 'y' && createChild != 'n'){
            System.out.print("Create right child for "+ presentNode.data +" Y/N? ");
            createChild = Character.toLowerCase(sc.next().charAt(0));
         }

         if(createChild == 'y'){
            System.out.print("Enter the element for right child: ");
            int rightChildData = sc.nextInt();
            Node rightChild = new Node(rightChildData);
            presentNode.rchild = rightChild;
            insertionTrack.add(rightChild);
         }
         
      }
   }


   /*************************************Searching************************************************ */
   public boolean search(int key){
      Queue<Node> treeTrack = new LinkedList<>();
      treeTrack.add(root);

      while(!treeTrack.isEmpty()){
         Node presendtNode = treeTrack.remove();
         if(presendtNode.data == key) return true;
         if(presendtNode.lchild != null)
         treeTrack.add(presendtNode.lchild);
         if(presendtNode.rchild != null)
         treeTrack.add(presendtNode.rchild);
      }

      return false;
   }

   public boolean delete(int key){
      Queue<Node> treeTrack = new LinkedList<>();
      treeTrack.add(root);
      Node targetNode = null;
      Node parentNode = root;

      //finding the node where our key is present
      while(!treeTrack.isEmpty()){
         parentNode = treeTrack.remove();

         if(parentNode.lchild != null){
            if(parentNode.lchild.data == key){
               targetNode = parentNode.lchild;
               break;
            }
            treeTrack.add(parentNode.lchild);
         }
         if(parentNode.rchild != null){
            if(parentNode.rchild.data == key){
               targetNode = parentNode.rchild;
               break;
            }
            treeTrack.add(parentNode.rchild);
         }
         
      }

      if(targetNode == null){
         return false;
      }

      //deleting the leaf node
      if(targetNode.lchild == null && targetNode.rchild == null){
         if(parentNode.lchild.data == key){
            parentNode.lchild = null;
            //clear(targetNode);
         }
         else{
            parentNode.rchild = null;
            //clear(targetNode);
         }
      }

      //deleting node with only one child

      else if(targetNode.lchild == null || targetNode.rchild == null){

         //deliting node whoose right child is present
         if(targetNode.lchild == null){
            //if target node is present left to parent
            if(parentNode.lchild.data == key){
               parentNode.lchild = targetNode.rchild;
            }
            //if target node is present right to parent
            else{
               parentNode.rchild = targetNode.rchild;
            }
         }

         //deleting node whoose only left child is present
         else{
            if(parentNode.lchild.data == key){
               parentNode.lchild = targetNode.lchild;
            }
            else{
               parentNode.rchild = targetNode.lchild;
            }
         }
      }

      //deleting node with both children

      else{
         Node deepestRightNode = null, deepestRightNodeParent = targetNode;

         // for(deepestRightNode = targetNode; deepestRightNode.lchild == null && deepestRightNode.rchild == null; deepestRightNode = deepestRightNode.rchild);

         //finding deepest right node
         while(true){
            if(deepestRightNodeParent.rchild.lchild == null || deepestRightNodeParent.rchild.rchild == null){
               deepestRightNode = deepestRightNodeParent.rchild;
               break;
            }

            deepestRightNodeParent = deepestRightNodeParent.rchild;
         }

         deepestRightNodeParent.rchild = null;

         targetNode.data = deepestRightNode.data; //replacing target node

         //if rightmost node has left child
         if(deepestRightNode.lchild != null){
            deepestRightNodeParent.rchild = deepestRightNode.lchild;
         }

      }


      return true;     
   }

   /*********************************** Traversals ****************************************** */

   //levelorder
   public void levelOrder_traversal(){
      System.out.println("\n\n************Started Level order traversal");
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

      System.out.println();
      System.out.println("\n*************Ended preorder traversal");
   }

   //inorder
   public void inorder_traversal(){
      inorder_traversal(true);
   }
   public void inorder_traversal(boolean isReccurssion){

      System.out.println("\n\n************Started In order traversal");

      if(isReccurssion){
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

   //preorder
   public void preorder_traversal(){
      preorder_traversal(true);
   }
   public void preorder_traversal(boolean isReccurssion){

      System.out.println("\n\n************Started Pre order traversal");

      if(isReccurssion){
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

   //postorder
   public void postorder_traversal(){
      postorder_traversal(true);
   }
   public void postorder_traversal(boolean isReccurssion){

      System.out.println("\n\n************Started Post order traversal");

      if(isReccurssion){
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

   //Reccurssive inorder
   private static void inorder(Node root){
      if(root != null){
         inorder(root.lchild);
         System.out.print(root.data + "-> ");
         inorder(root.rchild);
      }
   }

   //Reccurssive preorder
   private static void preorder(Node root){
      if(root != null){
         System.out.print(root.data + "-> ");
         preorder(root.lchild);
         preorder(root.rchild);
      }
   }

   //Reccurssive postorder
   private static void postorder(Node root){
      if(root != null){
         postorder(root.lchild);
         postorder(root.rchild);
         System.out.print(root.data + "-> ");
      }
   }

   //Utility private functions:
   private Queue<Node> getLeafNode(){
      Queue<Node> leafNodes = new LinkedList<>();
      if(root == null){
         return leafNodes;
      }

      Queue<Node> iterator = new LinkedList<>();
      iterator.add(root);

      while(!iterator.isEmpty()){
         Node presentNode = iterator.remove();
         if(presentNode.lchild != null)
         iterator.add(presentNode.lchild);
         if(presentNode.rchild != null)
         iterator.add(presentNode.rchild);

         if(presentNode.lchild == null && presentNode.rchild == null){
            leafNodes.add(presentNode);
         }
      }

      return leafNodes;
   }
}

class BinaryTree{
   public static void main(String[] args) {
      System.out.println("Welcome!! ");

      Tree t2 = new Tree();

      t2.root.data = 1;

      t2.root.lchild = new Node(2);
      t2.root.rchild = new Node(7);

      t2.root.lchild.rchild = new Node(3);
      t2.root.lchild.rchild.lchild = new Node(4);
      t2.root.lchild.rchild.lchild.rchild = new Node(5);
      t2.root.lchild.rchild.lchild.rchild.lchild = new Node(6);

      t2.root.rchild.lchild = new Node(8);
      t2.root.rchild.lchild.rchild = new Node(9);
      t2.root.rchild.lchild.rchild.lchild = new Node(10);

      t2.levelOrder_traversal();

      t2.inorder_traversal();
      t2.inorder_traversal(false);

      System.out.println();
      t2.postorder_traversal();
      t2.postorder_traversal(false);
      
      System.out.println();
      t2.preorder_traversal();
      t2.preorder_traversal(false);

   }
}
