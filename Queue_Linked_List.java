class Node {
    int data;
    Node ref;
    public Node(int data){
        this.data = data;
        this.ref = null;
    }
}

class LinkedListQueue {
    Node front, rear;
    
    public void enqueue(int data){
        Node newNode = new Node(data);
        
        if(rear != null){
            rear.ref = newNode;
        }
        
        rear = newNode;
        if(isEmpty()){
            front = rear;
        }
        
    }
    
    public int dequeue(){
        if(isEmpty()) throw new IllegalStateException("Queue is empty");
        
        int value = front.data;
        front = front.ref;
        
        if(isEmpty()){
            rear = null;
        }
        
        return value;
    }
    
    public boolean isEmpty(){
        return front == null;
    }
    
    public int peek(){
        return front.data;
    }
    
    public void traverse(){
        Node t = front;
        while(t != null){
            System.out.print(t.data + " -> ");
            t = t.ref;
        }
        
        System.out.println("null");
    }
}


public class Main {
	public static void main(String[] args) {
		LinkedListQueue LLQ = new LinkedListQueue();
		
		System.out.println("Enqueue: 10");
		LLQ.enqueue(10);
		LLQ.traverse();
		System.out.println();
		
		System.out.println("Enqueue: 20, 30");
		LLQ.enqueue(20);
		LLQ.enqueue(30);
		LLQ.traverse();
		System.out.println();
		
		System.out.println("Dequeue: " +LLQ.dequeue());
		LLQ.traverse();
		System.out.println();
		
		System.out.println("Peek: " +LLQ.peek());
	}
}
