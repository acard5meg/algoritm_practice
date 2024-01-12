// generic BST
// less than equal to left
// Need Queue class in directory for level order traversal
import java.util.*;

public class BinarySearchTree <E extends Comparable <E>> {

	private class Node {
		private E val;
		private Node left, right;
		
		public Node(E val, Node left, Node right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
		
		public Node(E val) {
			this(val,null,null);
		}
		
	}
	
	private Node root;
	
	public BinarySearchTree() {
		this.root = null;
	}
	
	public BinarySearchTree(E[] arr) {
		for (int i = 0; i < arr.length; i++)
			this.addNode(arr[i]);
	}
	
	public void addNode(E val) {
		// Tested
		if (this.root == null)
			this.root = new Node(val);
		else {
			Node curr = this.root;
			while (true) {
				int comp = val.compareTo(curr.val);
				if (comp <= 0) {
					if (curr.left != null)
						curr = curr.left;
					else {
						curr.left = new Node(val);
						break;
					}
				}
				else {
					if (curr.right != null)
						curr = curr.right;
					else {
						curr.right = new Node(val);
						break;
					}
				}
			}
		}
	}
	
	public void preOrderTraversal() {
		this.preOT(this.root);
		System.out.println();
	}
	
	private void preOT(Node node) {
		if (node != null)
			System.out.print(node.val + " ");
		if (node.left != null)
			this.preOT(node.left);
		if (node.right != null)
			this.preOT(node.right);
	}
	
	public void inOrderTraversal() {
		this.inOT(this.root);
		System.out.println();
	}
	
	private void inOT(Node node) {
		if (node.left != null)
			this.inOT(node.left);
		if (node != null)
			System.out.print(node.val + " ");
		if (node.right != null)
			this.inOT(node.right);
	}
	
	public void postOrderTraversal() {
		this.postOT(this.root);
		System.out.println();
	}
	
	private void postOT(Node node) {
		if (node.left != null)
			this.postOT(node.left);
		if (node.right != null)
			this.postOT(node.right);
		if (node != null)
			System.out.print(node.val + " ");
	}
	
	public void reverseOrderTraversal() {
		this.reverseOT(this.root);
		System.out.println();
	}
	
	private void reverseOT(Node node) {
		// Attempt to print nodes in reverse order
		if (node.right != null)
			this.reverseOT(node.right);
		if (node != null)
			System.out.print(node.val + " ");
		if (node.left != null)
			this.reverseOT(node.left);
	}
	
	public void levelOrderTraversal() {
		Queue<Node> q = new Queue<>();
		q.enqueue(this.root);
		while (! q.isEmpty()) {
			Node temp = q.dequeue();
			if (temp == null)
				break;
			System.out.print(temp.val + " ");
			if (temp.left != null)
				q.enqueue(temp.left);
			if (temp.right != null)
				q.enqueue(temp.right);
		}
		System.out.println();
	}
	
	public int size() {
		return this.sizeBin(this.root);
	}
	
	private int sizeBin(Node node) {
		if (node == null)
			return 0;
		return this.sizeBin(node.left)+ this.sizeBin(node.right)+ 1;  
	}
	
	public int maxHeight() {
		// Max number of nodes from root to leaf 
		return this.maxHeightBin(this.root);
	}
	
	private int maxHeightBin(Node node) {
		if (node == null)
			return 0;
		return Math.max(this.maxHeightBin(node.left), this.maxHeightBin(node.right)) + 1;
	}
	
	public void balance() {
//		int size = this.size();
//		ArrayList<E> elems = new ArrayList<>(size);
		ArrayList<E> elems = new ArrayList<>();
		this.inorderBalance(this.root, elems);
		Queue<E> q = new Queue<>();
		this.balanceSearch(elems, q, 0, elems.size()-1);
		BinarySearchTree<E> newTree = new BinarySearchTree<>();
		for (int i = 0; i < elems.size(); i++)
			newTree.addNode(q.dequeue());
		this.root = newTree.root;
	}
	
	private void inorderBalance(Node node, ArrayList<E> arr) {
		if (node.left != null)
			this.inorderBalance(node.left,arr);
		if (node != null)
			arr.add(node.val);
		if (node.right != null)
			this.inorderBalance(node.right,arr);
	}
	
	private void balanceSearch(ArrayList<E> arr, Queue<E> q, int start, int end) {
		if (start <= end) {
			int mid = (start + end) / 2;
			q.enqueue(arr.get(mid));
			this.balanceSearch(arr,q,start,mid-1);
			this.balanceSearch(arr, q, mid+1, end);
		}
	}
	
	public void delete(E deleteVal) {
		boolean found = this.findVal(deleteVal, this.root);
		// You'll need to wrap this inside found
		if (found) {
			ArrayList<Node> parentChild = this.nodeAndParent(this.root, null, deleteVal);
			Node parent = parentChild.get(0), child = parentChild.get(1);
			int numberOfChildren = this.getNumberOfChildren(child);
			// Don't forget case where parent is null b/c deleting root
			if (parent == null) {
				if (numberOfChildren == 0)
					this.root = null;
				else if (numberOfChildren == 1) {
					this.root = child.left;
				}
				else if (numberOfChildren == 2)
					this.root = child.right;
				else {
					child.val = this.findLeftmostRight(child.right, child);
				}
			}
			else {
				if (numberOfChildren == 0) {
					if (parent.left == child)
						parent.left = null;
					else
						parent.right = null;
				}
				else if (numberOfChildren == 1) {
					if (parent.left == child)
						parent.left = child.left;
					else
						parent.right = child.left;
				}
				else if (numberOfChildren == 2) {
					if (parent.left == child)
						parent.left = child.right;
					else
						parent.right = child.right;
				}
				else {
					child.val = this.findLeftmostRight(child.right, child);
				}
			}
		}
		
	}
	
	private boolean findVal(E val, Node node) {
		if (node == null)
			return false;
		int comparison = val.compareTo(node.val);
		if (comparison == 0)
			return true;
		else if (comparison < 0)
			return this.findVal(val, node.left);
		else
			return this.findVal(val, node.right);
	}
	
	/**
	 * Returns a 1D array with 2 elems, the first element
	 * is the parent node, the second is the node to delete
	 * @param node
	 * @return
	 */
	private ArrayList<Node> nodeAndParent(Node curr, Node parent, E deleteVal) {
		int comparison = deleteVal.compareTo(curr.val);
		if (comparison == 0) {
			ArrayList<Node> toReturn = new ArrayList<Node>(2);
			toReturn.add(parent);
			toReturn.add(curr);
			return toReturn;
		}
		else if(comparison < 0)
			return this.nodeAndParent(curr.left, curr, deleteVal);
		else
			return this.nodeAndParent(curr.right, curr, deleteVal);
	}
	
	/**
	 * Returns int that denotes number of children and position
	 * @param node
	 * @return 0 - no children
	 * 1 - left child
	 * 2 - right child
	 * 3 - two children
	 */
	private int getNumberOfChildren(Node node) {
		if (node.left != null && node.right != null)
			return 3;
		else if (node.right != null)
			return 2;
		else if (node.left != null)
			return 1;
		else 
			return 0;
	}
	
	private E findLeftmostRight(Node start, Node parent) {
		while (start.left != null) {
			parent = start;
			start = start.left;
		}		
		if (parent.left == start)
			parent.left = start.right;
		else
			parent.right = start.right;
		
		return start.val;
			
	}
	
	public static void main(String[] args) {
		// degenerate tree
//		Integer[] toInit = {4,10,12,15,18,22,24,25,31,35,44,50,66,70,90};
		Integer[] toInit = {25,15,50,10,22,35,70,4,12,18,24,31,44,66,90};
//		Integer[] toInit = {25,15,50,10,23,42,67,9,12,24,8,14};
//		Integer[] toInit = {25,15,50,10,23,42,67,9,12,24,8,14};
//		Integer[] toInit = {35,15,25};
//		Integer[] toInit = {1,2,3,4,5,6,7};
		BinarySearchTree<Integer> tree = new BinarySearchTree<>(toInit);
		tree.preOrderTraversal();
		System.out.println();
		tree.delete(70);
		tree.preOrderTraversal();

//		tree.preOrderTraversal();
//		System.out.println();
//		tree.balance();
//		tree.preOrderTraversal();
//		System.out.println();
//		tree.delete(25);
		
//		tree.delete(15);
//		tree.delete(50);
//		tree.delete(10);
//		tree.delete(12);
//		tree.delete(18);
//		tree.delete(35);
//		tree.delete(44);
//		tree.delete(25);
//		tree.delete(24);
//		
//		System.out.println();
//		tree.delete(50);
//		tree.delete(24);
//		tree.delete(44);
//		tree.delete(66);

//		tree.delete(91);
//		System.out.println(tree.maxHeight());
//		System.out.println(tree.size());
//		tree.levelOrderTraversal();
		
//		tree.reverseOrderTraversal();
//		tree.inOrderTraversal();
//		tree.postOrderTraversal();
//		tree.preOrderTraversal();
//		tree.addNode(1);
//		tree.preOrderTraversal();
		
	}
}
