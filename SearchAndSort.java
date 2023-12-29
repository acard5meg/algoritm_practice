import java.util.*;
public class SearchAndSort {

	public static int binarySearch(int[] arr,int target) {
		// Tested
		return binSearch(arr,target,0,arr.length-1);
	}
	
	private static int binSearch(int[] arr, int target, int start, int end) {
		// Tested
		if (start > end)
			return -1;
		int mid = (start + end) / 2;
		if (arr[mid] == target)
			return mid;
		else if (arr[mid] > target)
			return binSearch(arr,target,start,mid-1);
		else
			return binSearch(arr,target,mid+1,end);
	}
	
	public static void mergeSort(int[] arr) {
		// Tested
		if (arr.length > 1) {
			int[][] leftRight = arrayMaker(arr);
			int[] left = leftRight[0];
			int[] right = leftRight[1];
			mergeSort(left);
			mergeSort(right);
			
			int l = 0,r = 0,o = 0;
			
			while (l < left.length && r < right.length) {
				if (left[l] <= right[r]) {
					arr[o] = left[l];
					l++;
				}
				else {
					arr[o] = right[r];
					r++;
				}
				o++;
			}
			
			while (l < left.length) {
				arr[o] = left[l];
				o++;
				l++;
			}
			
			while (r < right.length) {
				arr[o] = right[r];
				o++;
				r++;
			}
		}
	}
	
	private static int[][] arrayMaker(int[] arr) {
		// Tested
		int mid = arr.length / 2;
		int[] left = new int[arr.length - mid];
		int[] right = new int[mid];
		for (int i = 0; i < left.length; i++) {
			left[i] = arr[i];
		}
		for (int i = 0; i < right.length; i++) {
			right[i] = arr[i+left.length];
		}
		
		int[][] toReturn = {left,right};
		return toReturn;
	}
	
	public static void quickSort(int[] arr) {
		// Tested
		qS(arr,0,arr.length-1);
	}
	
	private static void qS(int[] arr, int start, int end) {
		// Tested
		if (end - start >= 1) {
			int partition = partition(arr,start,end);
			qS(arr,0,partition-1);
			qS(arr,partition+1,end);
		}
	}
	
	private static int partition(int[] arr, int start, int end) {
		// Tested
		int pivot = arr[end];
		int left = start, right = start;
		int temp;
		
		while (right < end) {
			if (arr[right] <= pivot) {
				temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
			}
			right++;
		}
		
		temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
		return left;
	}
	
	public static void main(String[] args) {
//		int[] testArr = {99,77,79,4,52};
//		int[] testArr = {99,77,79,4,52,4};
//		int[] testArr = {1};
//		int[] testArr = {1,1};
//		int[] testArr = {1,2};
//		int[] testArr = {2,1};
//		int[] testArr = {1,2,3};
//		int[] testArr = {1,3,2};
//		int[] testArr = {2,1,3};
//		int[] testArr = {2,3,1};
//		int[] testArr = {3,2,1};
//		int[] testArr = {3,1,2};
//		int[] testArr = {3,1,1};
//		int[] testArr = {1,3,1};
//		int[] testArr = {1,1,1};
//		int[] testArr = {1,2,3,4,5};
//		int[] testArr = {5,4,3,2,1};
//		int[] testArr = {5,1,2,3,4};
//		int[] testArr = {4,5,1,2,3};
		int[] testArr = {3,4,5,1,2,3};
		quickSort(testArr);
		System.out.println(Arrays.toString(testArr));
//		int[] testArr = {99,77,79,4,52,4,0,-1,100};
//		int[] testArr = {99};
//		int[] testArr = {};
//		int[] testArr = {6,5,4,3,2,1,0,-1};
//		int[] testArr = {6,6,6,6,6};
//		mergeSort(testArr);
//		System.out.println(Arrays.toString(testArr));
//		int[][] newArr = arrayMaker(testArr);
//		System.out.println(Arrays.toString(newArr[0]));
//		System.out.println(Arrays.toString(newArr[1]));
//		assert binarySearch(testArr,0) == -1;
//		for (int i = 0; i < testArr.length; i++)
//			assert binarySearch(testArr,testArr[i]) == i;
//		assert binarySearch(testArr,6) == -1;
//		System.out.println(0);
	}
}
