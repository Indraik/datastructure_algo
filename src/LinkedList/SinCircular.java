package LinkedList;

class Node {
    int data;
    Node next;
    
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
// 
public class SinCircular {
    static Node head = null;

    // Insert at the end of the circular list
    public static void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            newNode.next = head; // Circular link
        } else {
            Node temp = head;

            while (temp.next != head) {
                temp = temp.next;
            }

            temp.next = newNode;
            newNode.next = head; // Circular link
        }
    }

    // Insert at the beginning of the circular list
    public static void insertAtBeg(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            newNode.next = head; // Circular link
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }

            temp.next = newNode; // Last node points to new node
            newNode.next = head; // New node points to head
            head = newNode; // Update head to the new node
        }
    }

    // Insert at a specific position
    public static void insertAtPos(int pos, int data) {
        if (pos <= 0) {
            System.out.println("Invalid position");
            return;
        }

        Node newNode = new Node(data);

        if (pos == 1) {
            insertAtBeg(data);
            return;
        }

        Node temp = head;
        int count = 1;

        // Traverse the list to find the node just before the desired position
        while (temp != null && count < pos - 1) {
            temp = temp.next;
            count++;
            if (temp == head) break; // Stop if we have looped around the list
        }

        if (temp == null || temp.next == head) {
            insertAtEnd(data); // If position exceeds list length, insert at the end
        } else {
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    // Delete a node by its value
    public static void deleteByValue(int data) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        Node prev = null;

        // If the node to be deleted is the head
        if (head.data == data) {
            while (temp.next != head) {
                temp = temp.next;
            }

            if (head.next == head) { // Only one node in the list
                head = null;
            } else {
                temp.next = head.next;
                head = head.next;
            }
            return;
        }

        // Traverse to find the node with the specified data
        do {
            prev = temp;
            temp = temp.next;
        } while (temp != head && temp.data != data);

        if (temp == head) {
            System.out.println("Node with data " + data + " not found");
            return;
        }

        // Remove the node by adjusting the links
        prev.next = temp.next;
    }

    // Delete a node at a specific position
    public static void deleteAtPos(int pos) {
        if (pos <= 0 || head == null) {
            System.out.println("Invalid position or empty list");
            return;
        }

        Node temp = head;
        int count = 1;

        if (pos == 1) {
            // Deleting the head node
            while (temp.next != head) {
                temp = temp.next;
            }

            if (head.next == head) { // Only one node in the list
                head = null;
            } else {
                temp.next = head.next;
                head = head.next;
            }
            return;
        }

        // Traverse to the node just before the one to be deleted
        Node prev = null;
        while (temp != null && count < pos) {
            prev = temp;
            temp = temp.next;
            count++;
            if (temp == head) break;
        }

        if (temp == head) {
            System.out.println("Position exceeds list size");
            return;
        }

        // Deleting the node by adjusting the links
        prev.next = temp.next;
    }

    // Display the list
    public static void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head); // Stop when we loop back to the head

        System.out.println();
    }

    // Count the number of nodes
    public static int countNodes() {
        if (head == null) return 0;

        int count = 0;
        Node temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        return count;
    }

    public static void main(String[] args) {
        insertAtEnd(10);
        insertAtEnd(20);
        insertAtEnd(30);
        insertAtEnd(40);

        System.out.println("Original List:");
        display(); // Output: 10 20 30 40

        insertAtBeg(5);
        System.out.println("After inserting 5 at the beginning:");
        display(); // Output: 5 10 20 30 40

        insertAtPos(3, 25);
        System.out.println("After inserting 25 at position 3:");
        display(); // Output: 5 10 25 20 30 40

        deleteByValue(20);
        System.out.println("After deleting 20:");
        display(); // Output: 5 10 25 30 40

        deleteAtPos(2);
        System.out.println("After deleting node at position 2:");
        display(); // Output: 5 25 30 40

        System.out.println("Number of nodes: " + countNodes()); // Output: 4
    }
}
