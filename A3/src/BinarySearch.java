import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BinarySearch {

	public static int[] sortArray(int[] array){
		
		int[] sortedArray = new int[250];
		int lowestValue = 1000;
		int indexedLowestValue = 0;
		
		for (int counter1 = 0; counter1 < 250; counter1++){
			
			lowestValue = 1000;
			
			for (int counter2 = 0; counter2 < 250; counter2++){
				
				if ((array[counter2] < lowestValue)||(array[counter2] == lowestValue)){
					
					lowestValue = array[counter2];
					indexedLowestValue = counter2;	
				}
			}
			sortedArray[counter1] = lowestValue;
			array[indexedLowestValue] = 1001;
		}
		return sortedArray;
	}
	
	public static void searchForVal(int[]array, int userInput){

		boolean wasFound = false;
		
		for (int counter = 0; counter < 250; counter++){
			if (userInput == array[counter]){
				
				System.out.println("The number is placed at " + (counter + 1) + ".");
				wasFound = true;
			}
		}
		if (!wasFound){
			System.out.println("That number could not be found.");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random randomNumber = new Random();
		int[] numberSet = new int[250];
		int[] sortedNumberSet = new int[250];
		Scanner userInput = new Scanner(System.in);
		int userInputInt;
		
		for (int counter = 0; counter < 250; counter++){
			numberSet[counter] = randomNumber.nextInt(1000) + 1;
		}
		
		System.out.println(Arrays.toString(numberSet));
		sortedNumberSet = sortArray(numberSet).clone(); 
		System.out.println(Arrays.toString(sortedNumberSet));
		
		while (true){
			System.out.println("What number would you like to find (1-1000)?");
			if (userInput.hasNextInt()){
				userInputInt = userInput.nextInt();
				searchForVal(sortedNumberSet, userInputInt);
			}
			else {
				System.out.println("That is not a number between 1-1000.");
				break;
			}
		}
	}

}
