class Node {
    int data;
    Node ref;
    
    public Node(int data){
        this.data = data;
        this.ref = null;
    }
}

class LinkedListStack {
    Node top;
    
    public void push(int data){
        Node newNode = new Node(data);
        
        if(top == null){
            top = newNode;
        }else{
            Node t = top;
            while(t.ref != null){
                t = t.ref;
            }
            
            t.ref = newNode;
        }
    }
    
    public int pop(){
        Node t = top, u = top;
        int value = 0;
        boolean preventLast = false;
        
        while(t.ref != null){
            t = t.ref;
            value = t.data;
            
            if(preventLast){
                u = u.ref;
            }
            preventLast = true;
        }
        u.ref = null;
        return value;
    }
    
    public int peek(){
        Node t = top;
        int value = 0;
        while(t.ref != null){
            t = t.ref;
            value = t.data;
        }
        return value;
    }
    
    public void traverse(){
        Node t = top;
        while(t != null){
            System.out.print(t.data + " -> ");
            t = t.ref;
        }
        System.out.println("null");
    }
}

public class Main {
	public static void main(String[] args) {
		LinkedListStack LLS = new LinkedListStack();
		
		LLS.push(10);
		System.out.println("Push 10");
		LLS.traverse();
		System.out.println();
		
		LLS.push(20);
		System.out.println("Push 20");
		LLS.traverse();
		System.out.println();
		
		System.out.println("Peek:" +LLS.peek());
		LLS.traverse();
		System.out.println();
		
		System.out.println("Pop: " +LLS.pop());
		LLS.traverse();
	}
}
