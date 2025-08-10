package Non_Linear;

import java.util.LinkedList;
import java.util.Queue;

class main{
	public static int fact(int n) {
		if(n<=1) {
			return 1;
		}
	
		else {
			return n * fact(n-1);
		}
	}
}
class SumOfDigit{
	public static int num(int data) {
		if(data<10) {
			return data;
		}
		else {
			return data % 10 + num(data/10);// 5 + (12345/10)
		}
	}
}

class TNode{
	int data;
	TNode left, right;
	public TNode(int data) {
		this.data=data;
		left=right=null;
	}
}

public class BinaryTree {
	static TNode root;
	public static void insert(int data) {
		TNode node = new TNode(data);
		if(root==null) {
			root=node;
		}
		else {
			Queue<TNode> track = new LinkedList<>();
			track.add(root);
			while(!track.isEmpty()) {
				TNode current=track.poll();
				if(current.left == null) {
					current.left=node;
					break;
				}
				else {
					track.add(current.left);
				}
				if(current.right == null) {
					current.right=node;
					break;
				}
				else {
					track.add(current.right);
				}
				
			}
		}
	}
	
	public static void preOrder(TNode root) {
		if(root!=null) {
			System.out.print(root.data+" ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	public static void inOrder(TNode root) {
		if(root!=null) {
			inOrder(root.left);
			System.out.print(root.data+" ");
			inOrder(root.right);
		}
	}
	public static void postOrder(TNode root) {
		if(root!=null) {
			
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data+" ");
		}
	}
	
	public static boolean search(TNode root, int data) {
		if(root!=null) {
			if(root.data==data) {
				return true;
			}
			return search(root.left,data) || search(root.right,data);
		}
		return false;
	}		
			
			
	public static void main(String[] args) {
		System.out.println(main.fact(5));
		System.out.println(main.fact(7));
//		12345
		System.out.println(SumOfDigit.num(12345));
		System.out.println();
		
		insert(15);
		insert(8);
		insert(20);
		insert(12);
		insert(6);
		insert(4);
		insert(16);
		
		preOrder(root);
		System.out.println();
		postOrder(root);
		System.out.println();
		inOrder(root);
		System.out.println();
		System.out.println(search(root,15));
		
	}

}
