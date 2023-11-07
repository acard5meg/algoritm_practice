/**
 * Merge Sort and Quick (Partition) Sort using Integer ArrayList
 * Both are O(n log n) runtime
 * Merge sort is stable, not in place
 * Quick sort is faster than merge sort for randomized data, not stable
 * Using last digit on quick sort could use more efficient method to find pivot point
 */

import java.util.ArrayList;


public class QuickAndMergeSort {
	
    public static void mergeSort(ArrayList<Integer> inpArr) {
        if (inpArr.size() > 1) {
            ArrayList<Integer> left = new ArrayList<>();
            ArrayList<Integer> right = new ArrayList<>();
            for (int i = 0; i < inpArr.size()/2; i++)
                left.add(inpArr.get(i));
            for (int i = inpArr.size()/2; i< inpArr.size(); i++)
                right.add(inpArr.get(i));
            mergeSort(left);
            mergeSort(right);
        
        
            int leftInd = 0, rightInd = 0, overallInd = 0;
            
            while (leftInd < left.size() && rightInd < right.size()) {
                if (left.get(leftInd) <= right.get(rightInd)) {
                    inpArr.set(overallInd,left.get(leftInd));
                    leftInd++;
                }
                else {
                    inpArr.set(overallInd,right.get(rightInd));
                    rightInd++;
                }
                overallInd++;
            }
            
            while (leftInd < left.size()) {
                inpArr.set(overallInd,left.get(leftInd));
                leftInd++;
                overallInd++;
            }
            while (rightInd < right.size()) {
                inpArr.set(overallInd,right.get(rightInd));
                rightInd++;
                overallInd++;
            }
        }
    }

    public static void QuickSort(ArrayList<Integer> inpArr) {
    	inQuickSort(inpArr,0,inpArr.size());
    }
	public static void inQuickSort(ArrayList<Integer> inpArr,int start,int end) {
        if (start < end) {
            int part = partition(inpArr,start,end);
            inQuickSort(inpArr,start,part);
            inQuickSort(inpArr,part+1,end);
        }
    }
    
    public static int partition(ArrayList<Integer> inpArr,int start, int end) {
        int pivot = inpArr.get(end-1), left = start, index = start, interim ;
        if (start < end) {
            while (index < end - 1) {
                if (inpArr.get(index) <= pivot) {
                    interim = inpArr.get(left);
                    inpArr.set(left,inpArr.get(index));
                    inpArr.set(index,interim);
                    left++;
                }
                index++;
            }
        }
        interim = inpArr.get(left);
        inpArr.set(left,inpArr.get(index));
        inpArr.set(index,interim);
        return left;
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<>() {
            {
            	//Test1
//                add(90);
//                add(80);
//                add(70);
//                add(50);
//                add(40);
//                add(30);
//                add(10);
            	//Test2
//            	add(10);
//            	add(30);
//            	add(40);
//            	add(50);
//            	add(70);
//            	add(80);
//            	add(90);
            	//Test3
//            	add(90);
//            	add(50);
//            	add(70);
//            	add(80);
//            	add(10);
//            	add(40);
//            	add(30);
            	//Tst4
            	add(-10);
            	add(30);
            	add(40);
            	add(-50);
            	add(70);
            	add(-80);
            	add(90);
            	//Test5
//            	add(10);
//            	add(10);
//            	add(10);
//            	add(10);
            }
        };
        ArrayList <Integer> test2 = new ArrayList<>(test);
        mergeSort(test);
        QuickSort(test2);
        System.out.println(test);
        System.out.println(test2);
    }
    
    
}
