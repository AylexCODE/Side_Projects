import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

class Rng {
    Scanner scan = new Scanner(System.in);
    Random r = new Random();
    
    int n, max, i = 0;
    int randomized[];
    
    Rng(int num, int maxNum){
        this.n = num;
        this.max = maxNum;
        randomized = new int[num];
    }
    
    public int rand(){
        while(true){
            boolean doesExist = false;
            int randN = r.nextInt(max+1);
            for(int j = 0; j < n; j++){
                if(randomized[j] == randN){
                    doesExist = true;
                }
            }
            if(!doesExist){
                randomized[i] = randN;
                i++;
                return randN;
            }
        }
        
    }
}

class UserGuess{
    Scanner scan = new Scanner(System.in);
    int answer[], indexGreen;
    boolean showGreen = false;
    
    UserGuess(int maxN){
        this.answer = new int[maxN];
    }
    
    public void display(int index){
        for(int i = 0; i <= answer.length-1; i++){
            if(answer[i] == 0){
                System.out.println(i+1 +":");
            }else{
                if(i == index-1){
                    System.out.println("\u001B[32m" +(i+1) +": " +answer[i] +"\u001B[0m");
                }else{
                    System.out.println(i+1 +": " +answer[i]);
                }
            }
        }
    }
    
    public void addToArray(int index, int number){
        int indexOffset = index-1, maxNumber = answer.length - 1;
        boolean isAdded = false;
        
        while(!isAdded){
            if(answer[indexOffset] != 0){
                System.out.println("\033[H\033[2J" +"Error: A Value is Already Assigned in That Number (" +(indexOffset-1) +" )");
                do{
                    display(index);
                    System.out.print("\nCurrent Number [ " +(number) +" ]\n" +"PUT AT No. ");
                    indexOffset = scan.nextInt()-1;
                    if(indexOffset > maxNumber){
                        System.out.println("\033[H\033[2J" +"Error: Input is Greater than " +(maxNumber+1));
                    }
                }while(indexOffset > maxNumber);
                this.showGreen = true;
            }else{
                answer[indexOffset] = number;
                isAdded = true;
                this.indexGreen = indexOffset+1;
            }
            System.out.print("\033[H\033[2J");
        }
    }
    
    public void setShowGreen(boolean x){
        this.showGreen = x;
    }
    
    public boolean getShowGreen(){
        return this.showGreen;
    }
    
    public int getIndexGreen(){
        return this.indexGreen;
    }
    
    public void calc(){
        int mistakes = 0, maxNumber = answer.length;
        int percentage;
        boolean isWinner = true;
        System.out.print("\033[H\033[2J");
        for(int i = 0; i < maxNumber; i++){
            int valid = 0;
            for(int j = 0; j < maxNumber; j++){
                if(!(answer[i] <= answer[j])){
                    valid++;
                }
            }
            if(valid == i){
                System.out.println("\u001B[32m" +(i+1) +". " +answer[i]);
            }else{
                System.out.println("\u001B[31m" +(i+1) +". " +answer[i]);
                mistakes++;
            }
        }
        percentage = (int)(100-(((double)mistakes/maxNumber)*100));
        String message;
        if(percentage <= 10){
            message = "You're so Bad at This!";
        }else if(percentage <= 30){
            message = "Womp Womp!";
        }else if(percentage <= 50){
            message = "Better Luck Next Time!";
        }else if(percentage <= 75){
            message = "Try Again!";
        }else if(percentage <= 90){
            message = "Good Job!";
        }else if(percentage <= 99){
            message = "Excellent Almost Perfect!";
        }else{
            message = "Congratulations, You Got a Perfect Score!";
        }
        
        System.out.println("\n\u001B[0m" +message +"\nYou Got " +percentage +"%");
        
        if(percentage <= 90 && percentage != 0){
            System.out.println("Incorrect Guess: " +mistakes);
        }
    }
}

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Arrange The Numbers in Ascending Order");
		int num = 10;
		
		int maxNum;
		do {
	    	System.out.print("Enter Random Number Limit: 0 - ");
	    	maxNum = scan.nextInt();
	    	if(maxNum < (num+5)){
	    	    System.out.println("\nRandom Number Limit must not be less than " +(num+5));
	    	}
		}while(maxNum < (num+5));
		
		Rng randNum = new Rng(num, maxNum);
		UserGuess guess = new UserGuess(num);
		
		guess.display(num+1);
		for(int i = 0; i < num; i++){
		    int index, randomNumber = randNum.rand();
		    
		    do{
		        System.out.println("\nCurrent Number [ " +randomNumber +" ]");
		    
		        System.out.print("PUT AT No. ");
		        index = scan.nextInt();
		        System.out.print("\033[H\033[2J");
		        if(index > num){
		            System.out.println("Error: Input is Greater than " +num);
		            guess.display(index);
		        }
		    }while(index > num);
		    
		    guess.addToArray(index, randomNumber);
		    
		    if(guess.getShowGreen()){
	            int x = guess.getIndexGreen();
	            guess.display(x);
	            guess.setShowGreen(false);
	    	}else{
		        guess.display(index);
	    	}
		}
		
		guess.calc();
	}
}
