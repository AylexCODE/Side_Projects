import java.util.Stack;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Stack<String> stack = new Stack<String>();
		Stack<String> tempStack = new Stack<String>();
		
		while(true){
			System.out.println("Content: " +stack);
			System.out.println("1. Undo\n2. Redo\n3. Exit");
			System.out.print("Enter Action: ");
      
			String x = scanner.nextLine();
			
			if(x.equals("1")){
				stack.pop();
			}else if(x.equals( "2")){
				int i = 0;
				for(String s : stack){
					i++;
				}
				
				stack.add(tempStack.elementAt(i));
			}else if(x.equals("3")){
				scanner.close();
				break;
			}else{
				tempStack.clear();
				tempStack.addAll(stack);
				tempStack.add(x);
				
				stack.clear();
				stack.addAll(tempStack);
			}
			
			System.out.println();
		}
	}
}
