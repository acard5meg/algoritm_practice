/**
 * This answers Execise #10 p.905
 * This is an example of a singly linked String list
 */

public class StringLinkedList {

	private StringNode head;
	private int length;
	
	public StringLinkedList() {
		head = null;
		length = 0;
	}
	
	public void addFront(String data) {
		head = new StringNode(data,head);
		length++;
	}
	
	public void deleteFront() {
		if (head == null) {
			System.out.print("List empty");
			System.exit(0);
		}
		
		if (head.next != null)
			head = head.next;
		else
			head = null;
		length--;
			
	}
	
	public void addEnd(String data) {
		if (head == null)
			head = new StringNode(data,head);
		else {
			StringNode curr = head;
			while (curr.next != null) {
				curr = curr.next;
			}
			curr.next = new StringNode(data,null);
		}
		length++;
	}
	
	public void deleteEnd() {
		if (head == null) {
			System.out.println("List empty");
			System.exit(0);
		}
		
		StringNode curr = head;
		
		if (curr.next == null)
			head = null;
		else {
			while (curr.next.next != null) {
				curr = curr.next;
			}
			
			curr.next = null;
		}
		length--;
	}
	
	public void printList() {
		StringNode curr = head;
		while (curr != null) {
			if (curr.next != null) {
				System.out.print(curr.data + " -> ");
			}
			else {
				System.out.print(curr.data);
			}
			curr = curr.next;
		}
		System.out.println();
	}
	
	public int getLength() {
		return length;
	}
	
	public void reverseInPlace() {
		StringNode curr, prev, nxt;
		curr = head;
		nxt = head;
		prev = null;
		
		while (curr != null) {
			nxt = nxt.next;
			curr.next = prev;
			prev = curr;
			curr = nxt;
		}
		
		head = prev;
	}
	
	
	private class StringNode {
		private String data;
		private StringNode next;
		
		public StringNode() {
			data = null;
			next = null;
		}
		
		public StringNode(String strData, StringNode nodeNext) {
			data = strData;
			next = nodeNext;
		}
	}
	
	public static void main(String[] args) {
		StringLinkedList test = new StringLinkedList();
		test.addFront("dog");
		test.addEnd("fish");
//		test.deleteEnd();
		test.addEnd("horse");
//		test.deleteFront();
//		test.deleteEnd();
		test.addFront("cow");
		test.addEnd("bird");
		test.addFront("monkey");
		test.printList();
		test.reverseInPlace();
		test.printList();
	}
}
