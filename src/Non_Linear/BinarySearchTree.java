package Non_Linear;

class Bst{
	int data;
	Bst left,right;
	public Bst(int data) {
		this.data=data;
		left = right = null;
	}
}

public class BinarySearchTree {
	
	static Bst root;
	public static void insert(int data) {
		Bst node = new Bst(data);
		if(root == null) {
			root = node;
		}
		else {
			Bst current=root;
			while(true) {
				if(data>current.data) {
					if(current.right==null) {
						current.right=node;
						break;
					}
					else {
						current=current.right;
					}
				}
				else {
					if(current.left==null) {
						current.left=node;
						break;
					}
					else {
						current=current.left;
					}
				}
			}
		}
	}
	
	public static void preOrder(Bst root) {
		if(root!=null) {
			System.out.print(root.data+" ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	public static void inOrder(Bst root) {
		if(root!=null) {
			inOrder(root.left);
			System.out.print(root.data+" ");
			inOrder(root.right);
		}
	}
	public static void postOrder(Bst root) {
		if(root!=null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data+" ");
		}
	}
	
	public static boolean search(int data, Bst root) {
		Bst current = root;
		while (current != null) {
			if (data == current.data)
				return true;
			else if (data < current.data)
				current = current.left;
			else
				current = current.right;
		}
		return false;
	}

	public static void main(String[] args) {
		
		insert(26);
		insert(22);
		insert(120);
		insert(70);
		insert(7);
		insert(11);
		insert(6);
		
		preOrder(root);
		System.out.println();
		inOrder(root);
		System.out.println();
		postOrder(root);
		System.out.println();
		System.out.println(search(70, root));

	}

}
