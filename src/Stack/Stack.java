package Stack;

class SNode {
    int data;
    SNode next;
    
    public SNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Stack {
    
    private SNode top;
    private int count;
    
    public Stack() {
        top = null;
        count = 0;
    }
    
    public void push(int data) {
        SNode node = new SNode(data);
        node.next = top;  // new node points to current top
        top = node;       // new node becomes top
        count++;
    }
    
    public int pop() {
        if (count == 0) {
            System.out.println("Stack is Empty");
            return -1; // or throw exception
        }
        int poppedData = top.data;
        top = top.next;  // move top pointer down
        count--;
        return poppedData;
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public int size() {
        return count;
    }
    
    public void display() {
        SNode current = top;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    
    public static void main(String[] args) {
        Stack stack = new Stack();
        
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();  // Output: 30 -> 20 -> 10 -> null
        
        System.out.println("Popped: " + stack.pop());  // Popped: 30
        stack.display();  // Output: 20 -> 10 -> null
        
        System.out.println("Popped: " + stack.pop());  // Popped: 20
        System.out.println("Stack size: " + stack.size());  // Stack size: 1
        
        stack.pop();
        System.out.println("Is stack empty? " + stack.isEmpty()); // true
        
        stack.pop();  // Stack is Empty
    }
}
