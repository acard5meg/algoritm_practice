
public class BinarySearch {

	public static void main(String[] args) {
		String[] test = {"apple", "bear", "cat", "dog", "egg", 
				"file", "google", "hello", "iphone", "jeep"}; 
		System.out.println(binarySearch(test,"egg")); // 4
		System.out.println(binarySearch(test,"apple")); //0
		System.out.println(binarySearch(test,"bear")); // 1
		System.out.println(binarySearch(test,"cat")); // 2
		System.out.println(binarySearch(test,"dog")); // 3
		System.out.println(binarySearch(test,"file")); // 5
		System.out.println(binarySearch(test,"google")); // 6
		System.out.println(binarySearch(test,"hello")); // 7
		System.out.println(binarySearch(test,"iphone")); //8
		System.out.println(binarySearch(test,"jeep")); // 9
		System.out.println(binarySearch(test,"aardvark")); // -1
		System.out.println(binarySearch(test,"zebra")); // -1
	}
	
	
	public static int binarySearch(String[] arr, String val) {
		return search(arr,val,0,arr.length-1);
	}
	
	private static int search(String[] arr, String val, int start, int end) {
		int middle = (end + start) / 2;
		int comparison = val.compareTo(arr[middle]);
		if (start > end)
			return -1;
		else {
			if (comparison == 0)
				return middle;
			else if (comparison < 0)
				return search(arr,val,0,middle-1);
			else
				return search(arr,val,middle+1,end);
		}
	}
}
