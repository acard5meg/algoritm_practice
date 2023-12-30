/**
 * Queue interface, implemented as a doubly linked list 
 */

public class Queue <E> {

	private class Node {
		private E data;
		private Node prev, next;
		
		public Node(E data, Node next, Node prev) {
			this.data = data;
			this.next = next;
			this.prev = prev;
		}
		
		public Node() {
			this(null, null, null);
		}
	}
	
	private int length;
	private Node head, tail;
	
	public Queue() {
		this.head = null;
		this.tail = null;
		this.length = 0;
	}
	
	public boolean isEmpty() {
		return length == 0;
	}
	
	public int length() {
		return length;
	}
	
	public void enqueue(E data) {
		if (this.isEmpty()) {
			Node node = new Node(data,null,null);
			this.tail = node;
			this.head = node;
		}
		else {
			Node node = new Node(data,this.tail,null);
			this.tail.prev = node;
			this.tail = node;
		}
		this.length++;
	}
	
	public E dequeue() {
		E toReturn;
		if (this.isEmpty())
			toReturn = null;
		else {
			//When the length equals 1 the head and tail point to the same
			//reference in memory so the this.head = this.head.prev (null in this case)
			//affects this.tail as well.
			toReturn = this.head.data;
			this.head = this.head.prev;
			if (this.head != null)
				this.head.next = null;
		}
//		else if (length == 1) {
//			toReturn = this.head.data;
//			this.head = null;
//			this.tail = null;
//		}
//		else {
//			toReturn = this.head.data;
//			this.head = this.head.prev;
//			this.head.next = null;
//		}
		this.length--;
		return toReturn;
	}
	
	public void print() {
		Node curr = this.tail;
		if (curr != null) {
			while (curr.next != null) {
				System.out.print(curr.data + " -> ");
				curr = curr.next;
			}
			System.out.println(curr.data + " Front");
		}
	}
	
	public static void main(String[] args) {
		Queue<Integer> test = new Queue<>();
		test.enqueue(1);
		test.enqueue(2);
		test.enqueue(3);
		test.print();
		while (!test.isEmpty()) {
			test.print();
			test.dequeue();
		}
	}
	
	
	
	
}
