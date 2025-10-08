import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		OrderFailed fail = new OrderFailed();
		
		float money, balance;
        int menu;
        char buy;
       
        // 1d Array
        double prices[] = {24.50, 60.10, 350.90};
        
        // 2d Array
        int quantity[][] = {{0},{0},{0}};
 
        boolean itemD1 = false;
        boolean itemD2 = false;
        boolean itemD3 = false;
    
        System.out.print("Welcome to Aylex fastfood drive thru ;)\nEnter your money amount: ");
        money = sc.nextFloat();

        System.out.print("Select your order:\n");
        System.out.print("1. Hamburger ₱24.50\n2. Coca-cola ₱60.10\n3. Pizza ₱350.90\nYour order: ");
        menu = sc.nextInt();
        
        float totalCost = 0;
        switch (menu){
               case 1:
                   totalCost += prices[0];
                   itemD1 = true;
                   
                   // Math Method
                   quantity[0][0] = Math.addExact(quantity[0][0], 1);
               break;
               case 2:
                   totalCost += prices[1];
                   itemD2 = true;
                   
                   // Math Method
                   quantity[1][0] = Math.addExact(quantity[1][0], 1);
               break;
               case 3:
                   totalCost += prices[2];
                   itemD3 = true;
                   
                   // Math Method
                   quantity[2][0] = Math.addExact(quantity[2][0], 1);
               break;
        }
    
        while (menu > 3) {
            listError();
            menu = sc.nextInt();
          }
    
        do {
            System.out.print("\nAnything else? (Y/N) : ");
            buy = sc.next().charAt(0);
             if(buy == 'n' || buy == 'N'){
                break;
             }

            System.out.print("1. Hamburger ₱24.50\n2. Coca-cola ₱60.10\n3. Pizza ₱350.90\nYour order: ");
            menu = sc.nextInt();
           
            switch (menu){
               case 1:
                   totalCost += prices[0];
                   itemD1 = true;
                   
                   // Math Method
                   quantity[0][0] = Math.addExact(quantity[0][0], 1);
               break;
               case 2:
                   totalCost += prices[1];
                   itemD2 = true;
                   
                   // Math Method
                   quantity[1][0] = Math.addExact(quantity[1][0], 1);
               break;
               case 3:
                   totalCost += prices[2];
                   itemD3 = true;
                   
                   // Math Method
                   quantity[2][0] = Math.addExact(quantity[2][0], 1);
               break;
            }
               while (menu > 3) {
                   listError();
                   menu = sc.nextInt();
                }
           } while (buy == 'y' || buy == 'Y');
    
        balance = money - totalCost;
    
        System.out.print("\n\nReceipt: ");
    
        if(money <= totalCost){
            fail.display();
        } else {
            System.out.println("\nItems ordered :");
            if(itemD1 == true){
                // String Method
                System.out.println(String.valueOf(quantity[0][0]).concat(" Hamburger/s"));
            }
            if(itemD2 == true){
                // String Method
                System.out.println(String.valueOf(quantity[1][0]).concat(" Coca-cola/s"));
            }
            if(itemD3 == true){
                // String Method
                System.out.println(String.valueOf(quantity[2][0]).concat(" Pizza/s"));
            }
            
            orderInfo(money, balance, totalCost);
        }
    
	}
	
	// User defined Method
	static void listError(){
	    System.out.print("\nThat is not on the list\n");
        System.out.println("1. Hamburger ₱24.50\n2. Coca-cola ₱60.10\n3. Pizza ₱350.90\nYour order: ");
	}
	
	// Method Overloading
	static void orderInfo(int a, int b, int c){
	    System.out.print("\nCash Amount : ₱" +a);
        System.out.print("\nCash Balance : ₱" +b);
        System.out.print("\nTotal cost : ₱" +c);    
	}
	
	// Method Overloading
	static void orderInfo(float a, float b, float c){
	    System.out.print("\nCash Amount : ₱" +a);
        System.out.print("\nCash Balance : ₱" +b);
        System.out.print("\nTotal cost : ₱" +c);    
	}
	
	// Method Overriding
	public static class OrderFailed extends SuccessFailed{
	    public void display(){
	        System.out.print("\nNOT ENOUGH MONEY\n");
            System.out.print("ORDER CANCELED");
	    }
	}
	
	// Method Overriding
	public static class SuccessFailed{
	    public void display(){
	        System.out.print("\nNOT ENOUGH MONEY\n");
	    }
	}
	
}
