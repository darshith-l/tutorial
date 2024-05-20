package TreeUtils;

import java.util.LinkedList;
import java.util.Queue;

public class Properties {
   /*************************************Searching************************************************ */
   public static boolean search(int key, Node root){
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

   /**************************************Height of the tree***************************************************** */
   public static int heigth(Node root){
      Queue<Node> levelOrderTrack = new LinkedList<>();
      levelOrderTrack.add(root);
      levelOrderTrack.add(null);


      int depth = 0;
      while(!levelOrderTrack.isEmpty()){
         Node currNode = levelOrderTrack.remove();

         if(currNode == null){
            depth++;
            if(!levelOrderTrack.isEmpty())
               levelOrderTrack.add(null);
         }

         else{
            if(currNode.lchild != null) levelOrderTrack.add(currNode.lchild);
            if(currNode.rchild != null) levelOrderTrack.add(currNode.rchild);
         }
      }

      return depth;
   }

   //**************************************Deepest node:**************************************
   public static Node deepestNode(Node root){
      Node deepestNode = null;

      Queue<Node> levelOrderTrack = new LinkedList<>();

      levelOrderTrack.add(root);

      while(!levelOrderTrack.isEmpty()){
         deepestNode = levelOrderTrack.remove();
         if(deepestNode.rchild != null) levelOrderTrack.add(deepestNode.rchild);
         if(deepestNode.lchild != null) levelOrderTrack.add(deepestNode.lchild);
      }

      return deepestNode;
   }
   
   //**************************************leaf nodes**************************************:
   public static Queue<Node> getLeafNode(Node root){
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
