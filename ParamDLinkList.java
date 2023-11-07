/**
 * Parameterized Doubly Linked List
 * No action within the linked list
 * Lacking jargon, but acts as a stack
 * Implement iterator interface
 * @param <E>
 */
public class ParamDLinkList <E> {

	
	private class Node {
		private E data;
		private Node next;
		private Node prev;
		
		public Node() {
			data = null;
			next = null;
			prev = null;
		}
		
		public Node(E inpData, Node inpNext, Node inpPrev) {
			data = inpData;
			next = inpNext;
			prev = inpPrev;
		}
	}
	
	private Node head, tail;
	
	public ParamDLinkList() {
		head = null;
		tail = null;
	}
	
	public void addToFront(E inpData) {
		if (head == null) {
			head = new Node(inpData,null,null);
			tail = head;
		}
		else {
			head.prev = new Node(inpData,head,null);
			head = head.prev;
		}
	}
	
	public void printFromFront() {
		if (head != null) {
			Node curr = head;
			while (curr.next != null) {
				System.out.print(curr.data + " <-> ");
				curr = curr.next;
			}
			System.out.println(curr.data);
		}
	}
	
	public void addToEnd(E inpData) {
		if (tail == null) {
			head = new Node(inpData,null,null);
			tail = head;
		}
		else {
			tail.next = new Node(inpData,null, tail);
			tail = tail.next;
		}
	}
	
	public void printFromTail() {
		if (tail != null) {
			Node curr = tail;
			while (curr.prev != null) {
				System.out.print(curr.data + " <-> ");
				curr = curr.prev;
			}
			System.out.println(curr.data);
		}
	}
	
	public void deleteFromHead() {
		if (head != null) {
			if (head == tail) {
				head = null;
				tail = null;
			}
			else {
				head = head.next;
				head.prev = null;
			}
		}
		else {
			System.out.println("List is empty. Progam ending.");
			System.exit(0);
		}
	}
	
	public void deleteFromTail() {
		if (tail != null) {
			if (head == tail) {
				head = null;
				tail = null;
			}
			else {
				tail = tail.prev;
				tail.next = null;
			}
		}
		else {
			System.out.println("List is empty. Program ending");
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		ParamDLinkList<String> test = new ParamDLinkList<>();
		test.addToEnd("G");
		test.addToEnd("E");
		test.addToFront("A");
//		test.printFromFront();
		test.addToEnd("L");
		test.addToFront("W");
//		test.printFromFront();
		test.printFromTail();
	}
}
