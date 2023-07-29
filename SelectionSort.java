/**
 * Selection sort of input array
 * Sort in ascending order input array
 * O(n^2)
 * In place sorting 
 * First attempt in Java 
 */

//import java.util.Arrays;

public class SelectionSort {
	
	public static int[] sSort(int[] arrayToSort)
	{
		int switchPointer = 0;
		int minNum; // This gets sets to the switch pointer element
		int minIndex;
		int totalIndex = 0;
		while (totalIndex < arrayToSort.length)
		{
			int i = totalIndex;
			minNum = arrayToSort[switchPointer];
			minIndex = switchPointer;
			while (i < arrayToSort.length)
			{
				if (arrayToSort[i] < minNum)
				{
					minNum = arrayToSort[i];
					minIndex = i;
					i++;
				}
				else
					i++;
			}
			swap(arrayToSort,switchPointer,minIndex);
			switchPointer++;
			totalIndex++;
		}
		
		
		return arrayToSort;
	}
	
	
	private static void swap(int[] inpArray, int currentIndex, int switchIndex)
	{
		int placeHolder = inpArray[currentIndex];
		inpArray[currentIndex] = inpArray[switchIndex];
		inpArray[switchIndex] = placeHolder;
	}
	
//	public static void main(String[] args)
//	{
//		int[] question = {7,6,11,17,3,15,5,19,30,14};
//		System.out.println(Arrays.toString(SelectionSort.sSort(question)));
//		int[] question2 = {7,7,11,17,3,15,5,19,30,14};
//		System.out.println(Arrays.toString(SelectionSort.sSort(question2)));
//		int[] question3 = {1,2,3};
//		System.out.println(Arrays.toString(SelectionSort.sSort(question3)));
//		int[] question4 = {};
//		System.out.println(Arrays.toString(SelectionSort.sSort(question4)));
//		int[] question5 = {-12,-56,1,7,9,8,12,0,-100};
//		System.out.println(Arrays.toString(SelectionSort.sSort(question5)));
//
//
//
//
//	}
	
}
