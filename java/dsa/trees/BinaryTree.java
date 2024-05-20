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

import javax.swing.text.View;

import java.util.Queue;
import java.util.LinkedList;
import TreeUtils.Node;
import TreeUtils.Properties;
import TreeUtils.Traversal;
// import BinaryTrees;
import TreeUtils.Views;

class Tree{
   Node root = null;
   private Scanner sc = new Scanner(System.in);

   public Tree(Node node){
      root = node;
   }

   public Tree(){
      root = null;
   }


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


   /**************************************Deletion************************************************** */
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
      levelOrder_traversal(false);
   }
   public void levelOrder_traversal(boolean reccurssion){
      Traversal.levelorder(reccurssion, root);
   }
   

   //inorder
   public void inorder(){
      inorder(true);
   }
   public void inorder(boolean isReccurssion){
      Traversal.inorder(isReccurssion, root);
   }

   //preorder
   public void preorder(){
      preorder(true);
   }
   public void preorder(boolean isReccurssion){
      Traversal.preorder(isReccurssion, root);
   }

   //postorder
   public void postorder(){
      postorder(true);
   }
   public void postorder(boolean isReccurssion){
      Traversal.postorder(isReccurssion, root);
   }

   //***************************************************Searching***************************************************
   public boolean search(int key){
      return Properties.search(key, root);
   }

   //***************************************************Height***************************************************
   public int heigth(){
      return Properties.heigth(root);
   }
   
   //***************************************************deepest Node***************************************************
   public Node deepestNode(){
      return Properties.deepestNode(root);
   }

   public Queue<Node> getLeafNode(){
      return Properties.getLeafNode(root);
   }

   public void leftView(){
      Views.leftView(root);
   }
   public void rightView(){
      Views.rightView(root);
   }
}

class BinaryTree{
   public static void main(String[] args) {
      System.out.println("Welcome!! ");

      Tree t1 = new Tree(BinaryTreeExamples.getTree2());

      t1.inorder(false);
      t1.preorder(false);
      t1.postorder(false);

      System.out.println("\nIs element 15 present? " + (t1.search(15)) + "\n");
      
      for(Node node:  t1.getLeafNode()){
         System.out.println(node.data);
      }

      System.out.println(t1.heigth());

      t1.levelOrder_traversal(true);
      t1.leftView();
      t1.rightView();
   }
}