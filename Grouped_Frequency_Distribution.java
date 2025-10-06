import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter data(Separted by a comma: ");
		String data = scanner.next();
		
		System.out.print("Enter Number of Classes: ");
		int numClasses = scanner.nextInt();
		
		int arrData[] = convertToInteger(data);
		int highestNum = getHighestOrLowest(arrData, true);
		int lowestNum = getHighestOrLowest(arrData, false);
		int classInterval = Integer.parseInt(Math.round(Double.valueOf(highestNum - lowestNum) / Double.valueOf(numClasses)) + "");
		
		System.out.println("Highest: " +highestNum +"\nLowest: " +lowestNum);
		System.out.println("Class Interval: " +classInterval);
		
		int classes[][] = getClass(classInterval, lowestNum, highestNum, numClasses);
		String classBoundaries[] = getClassBoundaries(classes, numClasses);
		
		int frequency[] = getFrequency(classes, numClasses, arrData);
		int cumulativeFrequency = 0;
		System.out.printf("| %-10s | %-17s | %-5s | %-10s | %-12s |", "Class", "Class Boundaries", "Tally", "Frequency", "Cumulative F");
		for(int i = 0; i < numClasses; i++){
		    cumulativeFrequency += frequency[i];
		    System.out.println();
		    System.out.printf("| %-10s | %-17s | %-5s | %-10s | %-12s |", classes[i][0] +" - " +classes[i][1], classBoundaries[i], " ", frequency[i], cumulativeFrequency);
		}
	}
	
	public static int[] getFrequency(int classes[][], int numClasses, int arrData[]){
	    int frequency[] = new int[numClasses];
	    
	    for(int i = 0; i < arrData.length; i++){
	        for(int j = 0; j < numClasses; j++){
	            if(arrData[i] >= classes[j][0] && arrData[i] <= classes[j][1]){
	                //System.out.println(arrData[i] +" > " +classes[j][0] +" - " +classes[j][1]);
	                frequency[j] = frequency[j]+1;
	            }
	        }
	    }
	    
	    return frequency;
	}
	
	public static String[] getClassBoundaries(int classes[][], int numClasses){
	    String classBoundaries[] = new String[numClasses];
	    
	    for(int i = 0; i < numClasses; i++){
	        classBoundaries[i] = (classes[i][0] - 0.5) +" - " +(classes[i][1] + 0.5);
	    }
	    
	    return classBoundaries;
	}
	
	public static int[][] getClass(int classInterval, int lowestNum, int highestNum, int numClasses){
	    int classes[][] = new int[numClasses][2];
	    int lastNumClass = lowestNum;
	    
	    for(int i = 0; i < numClasses; i++){
	        classes[i][0] = lastNumClass;
	        lastNumClass = lastNumClass + classInterval;
	        classes[i][1] = (lastNumClass - 1);
	        
	        if(i == (numClasses - 1)){
	            if((highestNum > lastNumClass - 1)){
	                classes[i][1] = highestNum;
	            }
	        }	        
	    }
	    
	    return classes;
	}
	
	public static int[] convertToInteger(String data){
	    String stringData[] = data.split(",");
	    
	    int arrData[] = new int[stringData.length];
	    for(int i = 0; i < stringData.length; i++){
	        arrData[i] = Integer.valueOf(stringData[i]);
	    }
	    
	    return arrData;
	}
	
	public static int getHighestOrLowest(int data[], boolean isHighest){
	    int dataLength = data.length;
	    
	    if(isHighest){
	        int num = 0;
	        for(int i = 0; i < dataLength; i++){
	            if(data[i] > num){
	                num = data[i];
	            }
	        }
	        
	        return num;
	    }else{
	        int num = data[0];
	        for(int i = 0;  i < dataLength; i++){
	            if(data[i] < num){
	                num = data[i];
	            }
	        }
	        
	        return num;
	    }
	}
}
