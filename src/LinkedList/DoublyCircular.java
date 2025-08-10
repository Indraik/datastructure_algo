package LinkedList;

class DNode {
    int data;
    DNode next;
    DNode prev;

    public DNode(int data) {
        this.data = data;
        this.next = this.prev = null;
    }
}

public class DoublyCircular {
    static DNode head = null;

    // Insert at the end of the list
    public static void insertAtEnd(int data) {
        DNode newNode = new DNode(data);

        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            DNode tail = head.prev;

            tail.next = newNode;
            newNode.prev = tail;

            newNode.next = head;
            head.prev = newNode;
        }
    }

    // Insert at the beginning
    public static void insertAtBeg(int data) {
        DNode newNode = new DNode(data);

        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            DNode tail = head.prev;

            newNode.next = head;
            newNode.prev = tail;

            head.prev = newNode;
            tail.next = newNode;

            head = newNode;
        }
    }

    // Insert at a specific position
    public static void insertAtPos(int pos, int data) {
        if (pos <= 0) {
            System.out.println("Invalid position");
            return;
        }

        if (pos == 1) {
            insertAtBeg(data);
            return;
        }

        DNode temp = head;
        int count = 1;

        while (count < pos - 1 && temp.next != head) {
            temp = temp.next;
            count++;
        }

        // If position is greater than list size, insert at end
        if (temp.next == head) {
            insertAtEnd(data);
        } else {
            DNode newNode = new DNode(data);

            newNode.next = temp.next;
            newNode.prev = temp;

            temp.next.prev = newNode;
            temp.next = newNode;
        }
    }

    // Delete a node by value
    public static void deleteByValue(int data) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        DNode temp = head;

        do {
            if (temp.data == data) {
                if (temp.next == temp) {
                    head = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;

                    if (temp == head) {
                        head = head.next;
                    }
                }
                return;
            }
            temp = temp.next;
        } while (temp != head);

        System.out.println("Node with data " + data + " not found");
    }

    // Delete a node at a specific position
    public static void deleteAtPos(int pos) {
        if (head == null || pos <= 0) {
            System.out.println("Invalid position or empty list");
            return;
        }

        DNode temp = head;
        int count = 1;

        if (pos == 1) {
            if (head.next == head) {
                head = null;
            } else {
                DNode tail = head.prev;

                tail.next = head.next;
                head.next.prev = tail;

                head = head.next;
            }
            return;
        }

        while (count < pos && temp.next != head) {
            temp = temp.next;
            count++;
        }

        if (temp == head) {
            System.out.println("Position exceeds list size");
            return;
        }

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }

    // Display the list forward
    public static void displayForward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        DNode temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    // Display the list in reverse
    public static void displayReverse() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        DNode tail = head.prev;
        DNode temp = tail;

        do {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        } while (temp != tail);
        System.out.println();
    }

    // Count number of nodes
    public static int countNodes() {
        if (head == null) return 0;

        int count = 0;
        DNode temp = head;
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
        displayForward(); // 10 20 30 40

        insertAtBeg(5);
        System.out.println("After inserting 5 at beginning:");
        displayForward(); // 5 10 20 30 40

        insertAtPos(3, 25);
        System.out.println("After inserting 25 at position 3:");
        displayForward(); // 5 10 25 20 30 40

        deleteByValue(20);
        System.out.println("After deleting 20:");
        displayForward(); // 5 10 25 30 40

        deleteAtPos(2);
        System.out.println("After deleting node at position 2:");
        displayForward(); // 5 25 30 40

        System.out.println("Display in reverse:");
        displayReverse(); // 40 30 25 5

        System.out.println("Number of nodes: " + countNodes()); // Output: 4
    }
}
