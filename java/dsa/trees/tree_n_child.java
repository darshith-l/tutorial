//Implimentation of tree, each node can have multiple childrens, operations:
//Inserting the tree
//level order traversal
//list of leaf nodes


import java.util.Queue;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;

class Node{
	int data;
	List<Node> links;

	public Node(int n){
		data = n;
	}

	public void getLinks(){
		links = new ArrayList<>();
	}
}

class Tree{
	Queue<Node> q = new LinkedList<>();
	Node root = new Node(0);
	Scanner sc = new Scanner(System.in);

	public void insert(){
		// q = getLeafNodes();
		while(!q.isEmpty()){
				
			Node presentNode = q.remove();
			System.out.println("\n\n");
			System.out.print("Enter the number of new children for node " + presentNode.data + ":   ");
			int n = sc.nextInt();
			presentNode.getLinks();

			//Adding n number of elements to present node;
			for(int i=0; i<n; i++){
				System.out.printf("Enter the %dth child:	", presentNode.links.size()+i+1);
				int childData = sc.nextInt();
				Node newNode = new Node(childData);
				q.add(newNode);
				presentNode.links.add(newNode);
			}

		}
	}

	public void levelOrder_traversal(){
		Queue<Node> display = new LinkedList<>();
		display.add(root);

		while(!display.isEmpty()){
			Node presenNode = display.remove();

			System.out.println(presenNode.data);

			for(Node n0: presenNode.links){
				display.add(n0);
			}
		}
	}
}

class temp{
	public static void main(String[] args) {
		System.out.println("Welcome!!!");

		Tree t1 = new Tree();
		t1.root.data = 0;
		t1.q.add(t1.root);

		t1.insert();
		t1.levelOrder_traversal();
		
	}
}



