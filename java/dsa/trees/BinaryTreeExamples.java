import TreeUtils.Node;
public class BinaryTreeExamples {
   public static Node getTree1(){
      Node root = new Node(0);
      root.data = 1;
      root.lchild = new Node(2);
      root.rchild = new Node(3);
      root.lchild.lchild = new Node(4);
      root.lchild.rchild = new Node(5);
      root.rchild.lchild = new Node(10);
      root.rchild.rchild = new Node(11);
      root.lchild.lchild.lchild = new Node(6);
      root.lchild.lchild.rchild = new Node(7);
      root.lchild.rchild.lchild = new Node(8);
      root.lchild.rchild.rchild = new Node(9);
      root.rchild.lchild.lchild = new Node(12);
      root.rchild.lchild.rchild = new Node(13);
      root.rchild.rchild.lchild = new Node(15);
      root.rchild.rchild.rchild = new Node(14);
      root.rchild.rchild.lchild.lchild = new Node(16);
      root.rchild.rchild.lchild.rchild = new Node(17);

      return root;
   }

   public static Node getTree2(){
      Node root = new Node(10);
      root.data = 1;
      root.lchild = new Node(2);
      root.rchild = new Node(7);
      root.lchild.rchild = new Node(3);
      root.lchild.rchild.lchild = new Node(4);
      root.lchild.rchild.lchild.rchild = new Node(5);
      root.lchild.rchild.lchild.rchild.lchild = new Node(6);
      root.rchild.lchild = new Node(8);
      root.rchild.lchild.rchild = new Node(9);
      root.rchild.lchild.rchild.lchild = new Node(10);

      return root;
   }
}
