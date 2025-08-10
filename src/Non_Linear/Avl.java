package Non_Linear;
class ANode{
	int data,height;
	ANode right,left;
	public ANode(int data) {
		this.data=data;
		height=1;
		left=right=null;
	}
}

public class Avl {
	static ANode root;
	static ANode createNode(int data) {
		return new ANode(data);
		
	}
	public static int height(ANode root) {
		return root == null ? 0:root.height;
	}
	public static void insert(ANode root,int data) {
		//ANode node = new ANode(data);
		//if(root==null) return createNode(data);
		
		if(data>root.data) {
						
		}
		
	}

	public static void main(String[] args) {
		

	}//15.8.20.6
	//app.py run

}
