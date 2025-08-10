package LinkedList;

class DubNode{
	int data;
	DubNode prev, next;
	public DubNode(int data) {
		this.data=data;
		prev=next=null;
	}
}
class DubMethods{
	static DubNode head,tail;
	public static void insertAtBeg(int data) {
		
		DubNode node=new DubNode(data);
		
		if(head==null && tail==null) {
			head=node;
			tail=node;
		}
		else {
			node.next=head;
			head.prev=node;
			head=node;
		}
	}
	public static void insertAtPos(int pos, int data) {
	    if (pos <= 0) {
	        System.out.println("Invalid position");
	        return;
	    }
	    
	    DubNode node = new DubNode(data);
	    
	    if (pos == 1) {
	        insertAtBeg(data);
	        return;
	    }
	    
	    DubNode temp = head;
	    int count = 1;  // Starting position from the head node

	    // Traverse the list to find the position
	    while (temp != null && count < pos - 1) {
	        temp = temp.next;
	        count++;
	    }

	    // If position is beyond the list's length, insert at the end
	    if (temp == null) {
	        insertAtEnd(data);
	        return;
	    }

	    // Inserting in the middle
	    node.next = temp.next;
	    node.prev = temp;
	    
	    // Adjust the next node's prev pointer if it exists
	    if (temp.next != null) {
	        temp.next.prev = node;
	    }
	    
	    temp.next = node;
	}


	public static void insertAtEnd(int data) {
		DubNode node=new DubNode(data);
		if(head==null && tail==null) {
			insertAtBeg(data);
		}
		else {
			node.prev=tail;
			tail.next=node;
			tail=node;
		}
	}
	public static void display() {
		DubNode temp=head;
		
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
	}
}
public class DoublyLinkedList extends DubMethods{
	public static void main(String[] args){
		insertAtBeg(1);
		insertAtBeg(0);
		insertAtEnd(3);
		display();
		insertAtPos(3,2);
		display();
	}
}