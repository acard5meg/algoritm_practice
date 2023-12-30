/**
 * Stack interface, implemented as singly linked list
 * @param <E>
 */
public class Stack <E> {
	
	private class Node {
		private E data;
		private Node next;
		
		public Node(E data, Node next) {
			this.data = data;
			this.next = next;
		}
		public Node() {
			this(null,null);
		}
	}
	
	private int length;
	private Node head;
	
	public Stack() {
		this.head = null;
		this.length = 0;
	}
	
	public void push(E data) {
		Node node = new Node(data,this.head);
		this.head = node;
		this.length++;
	}
	
	public E pop() {
		E toReturn = null;
		if (length > 0) {
			toReturn = this.head.data;
			this.head = this.head.next;
			this.length--;
		}
		return toReturn;
	}
	
	public E peek() {
		E toReturn = this.pop();
		this.push(toReturn);
		return toReturn;
	}
	
	public int length() {
		return length;
	}
	
	public boolean isEmpty() {
		return length == 0;
	}
	
	public void printStack() {
		if (this.length > 0) {
			Node curr = this.head;
			while (curr.next != null) {
				System.out.print(curr.data + " -> ");
				curr = curr.next;
			}
			System.out.println(curr.data);
		}
	}
	
	public static void main(String[] args) {
		Stack<Integer> test = new Stack<>();
		test.push(5);
		test.push(4);
		test.push(3);
		test.push(2);
		test.push(1);
		test.printStack();
		while (test.length > 0) {
			test.pop();
			test.printStack();
		}
		test.push(6);
		test.printStack();
	}
}
