package TreeUtils;

import java.util.LinkedList;
import java.util.Queue;

public class Views {
   /********************************Views of the trees **********************************************************/

   //left view:
   public static void leftView(Node root){
      Queue<Node> track = new LinkedList<>();
      track.add(root);

      System.out.println("\n\n********Started left view*****************");
      while(!track.isEmpty()){
         int n = track.size();

         for(int i=0; i<n; i++){
            Node curr = track.remove();

            if(i == 0){
               System.out.print(curr.data+" ");
            }

            if(curr.lchild != null) track.add(curr.lchild);
            if(curr.rchild != null) track.add(curr.rchild);

         }
      }
      System.out.println("\n********ended left view*****************\n");
   }

   //right view
   public static void rightView(Node root){
      Queue<Node> track = new LinkedList<>();
      track.add(root);
      System.out.println("\n\n********Started right view*****************");
      while(!track.isEmpty()){
         int n = track.size();

         for(int i=0; i<n; i++){
            Node curr = track.remove();

            if(i == n-1){
               System.out.print(curr.data+" ");
            }

            if(curr.lchild != null) track.add(curr.lchild);
            if(curr.rchild != null) track.add(curr.rchild);

         }
      }
      System.out.println("\n********ended right view*****************\n");
   }
}
