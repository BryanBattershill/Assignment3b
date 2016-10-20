/****************************************************************************
*
* Created by: Bryan Battershill
* Created on: Oct 2016
* This program creates an array and sorts it from least to greates value
* A new number can also be inputed and sorted
*
****************************************************************************/

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BinarySearch {

	public static int[] sortArray(int[] array){
		
		int[] sortedArray = new int[array.length];
		int lowestValue = 1000;
		int indexedLowestValue = 0;
		
		for (int counter1 = 0; counter1 < array.length; counter1++){
			
			lowestValue = 1000;
			
			for (int counter2 = 0; counter2 < array.length; counter2++){
				
				if (array[counter2] <= lowestValue){
					
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
		int lowest = 0;
		int highest = array.length - 1;
		int middle = 0;
		
		int lowerBound;
		int upperBound;
		int range = 1;
		
		while (lowest <= highest){
			middle = (lowest + highest)/2;
			if (array[middle] < userInput){
				lowest = middle + 1;
			}
			else if (array[middle] > userInput){
				highest = middle - 1;
			}
			else{
				break;
			}
			
			if (lowest > highest){
				System.out.println("That number could not be found.");
				break;
			}
		}
		
		lowerBound = middle;
		upperBound = middle;
		
		while (lowest <= highest){
			if (middle - range >= 0){
				if (array[middle - range] == userInput){
					lowerBound --;
				}
			}
			if (middle + range <= array.length - 1){
				if (array[middle + range] == userInput){
					upperBound ++;
				}
			}

			if ((middle - range < 0)&&(middle + range >array.length - 1)){
				break;
			}
			if ((middle - range < 0)&&(middle + range <= array.length - 1)){
				if (array[middle + range] != userInput){
					break;
				}
			}
			if ((middle - range >= 0)&&(middle + range > array.length - 1)){
				if (array[middle - range] != userInput){
					break;
				}
			}
			if ((middle - range >= 0)&&(middle + range <= array.length - 1)){
				if ((array[middle + range] != userInput)&&(array[middle - range] != userInput)){
					break;
				}
			}
			range++;
		}
		if (lowest <= highest){
			if (lowerBound != upperBound){
				System.out.println("The numbers can be found from places " + (lowerBound + 1) + " - " + (upperBound + 1) + ".");
			}
			else{
				System.out.println("The number can be found at place " + (middle + 1));
			}
		}
	}
	
	public static int[] addNewValue(int[] array, int number){
		
		int[] addedArray = new int [array.length];
		
		addedArray = array.clone();
		addedArray[addedArray.length - 1] = number;
		addedArray = sortArray(addedArray);
		
		return addedArray;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random randomNumber = new Random();
		
		int[] numberSet = new int[250];
		int[] sortedNumberSet = new int[250];
		
		int userInputInt;
		
		Scanner userInput = new Scanner(System.in);
		
		for (int counter = 0; counter < 250; counter++){
			
			numberSet[counter] = randomNumber.nextInt(1000) + 1;

		}

		System.out.println(Arrays.toString(numberSet));
		sortedNumberSet = sortArray(numberSet).clone(); 
		System.out.println(Arrays.toString(sortedNumberSet));
		
		while (true){
			
			System.out.println("What number would you like to find (1-1000)? Type 0 to add a new number.");
			
			if (userInput.hasNextInt()){
				
				userInputInt = userInput.nextInt();
				
				if ((userInputInt>0)&&(userInputInt<1001)){
					
					searchForVal(sortedNumberSet, userInputInt);
				}
				else if (userInputInt == 0){
					
					System.out.println("What number would you like to add (1-1000)?");
					
					if (userInput.hasNextInt()){
						
						userInputInt = userInput.nextInt();
						
						sortedNumberSet = Arrays.copyOf(sortedNumberSet, sortedNumberSet.length + 1);
						sortedNumberSet = addNewValue(sortedNumberSet, userInputInt).clone();		
						
						System.out.println("Added.");
						System.out.println(Arrays.toString(sortedNumberSet));
						
					}
					else {
						
						System.out.println("That is not valid.");
						break;
						
					}
				}
				else{
					
					System.out.println("That is not a number between 1-1000.");
					
				}
			}
			else {
				
				System.out.println("That is not valid.");
				break;
				
			}
		}
	}

}
