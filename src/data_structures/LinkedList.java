package data_structures;

/**
 * 
 * @author Cu Le Huy
 * @param <T>
 * last updated: 05/25/2016
 */

public class LinkedList<T> {
	private Node<T> head, tail;
	private int size;
	
	
	/**
	 * Node class
	 */
	private class Node<E> {
		E val;
		Node<E> next;
		Node<E> prev;
		
		// Node constructor
		public Node(E val){
			this.next = null;
			this.prev = null;
			this.val = val;
		}
	}
	
	// Constructor
	public LinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	// Return the number of elements in the list
	public int size(){
		return size;
	}
	
	// Check whether the list is empty
	public boolean isEmpty() {
		return size == 0;
	}
	
	// Insert value val at index pos
	public void insert(int pos, T val) {
		// Validate pos
		if(pos < 0 || pos > size) throw new IndexOutOfBoundsException();
		
		Node<T> newNode = new Node<>(val);
		// Inserting into an empty list
		if(isEmpty()) { 
			head = newNode;
			tail = head;
		}
		// Inserting into the front of the list
		else if(pos == 0) {
			head.prev = newNode;
			newNode.next = head;
			head = newNode;
		}
		// Inserting into the end of the list
		else if(pos == size()) {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		// Normal insertion
		else if(pos > 0 && pos < size()){
			newNode.next = getNodeAtIndex(pos);
			newNode.prev = getNodeAtIndex(pos-1);
			getNodeAtIndex(pos).prev = newNode;
			getNodeAtIndex(pos-1).next = newNode;
		}
		
		System.out.println("'"+val+"'" + " is inserted");
		size++;
	}
	
	// Remove the node at index pos
	public void remove(int pos) {
		// Validate pos
		if(isEmpty() || pos < 0 || pos > size-1) throw new IndexOutOfBoundsException();
		
		System.out.println("'"+get(pos)+"'" + " is removed");
		
		// Remove only element
		if (size() == 1) {
			head = null;
			tail = null;
		}
		// Remove head
		else if(pos == 0) {
			head = head.next;
			head.prev = null;
		}
		// Remove tail
		else if(pos == size()-1) {
			tail = tail.prev;
			tail.next = null;
		}
		// Normal removal
		else if(pos > 0 && pos < size()) {
			Node<T> tempPrev = getNodeAtIndex(pos-1);
			Node<T> tempNext = getNodeAtIndex(pos+1);
			tempPrev.next = tempNext;
			tempNext.prev = tempPrev;
		}
		
		size--;
	}
	
	// Overwrites the old value at index pos with value val
	public void set(int pos, T val) {
		// Validate pos
		if(isEmpty() || pos < 0 || pos > size-1) throw new IndexOutOfBoundsException();
		
		getNodeAtIndex(pos).val = val;
		System.out.println("The "+pos+"th element is set to "+val);
	}
	
	// Return the value at index pos
	public T get(int pos) {
		// Validate pos
		if(isEmpty() || pos < 0 || pos > size-1) throw new IndexOutOfBoundsException();
		
		return getNodeAtIndex(pos).val;
	}
	
	// Return the node at specified index pos
	public Node<T> getNodeAtIndex(int pos) {
		Node<T> temp = head;
		if(pos >= 0 && pos < size()) {
			for(int i=0; i<pos; i++) {
				temp = temp.next;
			}
			return temp;
		}
		else throw new IndexOutOfBoundsException();
	}
	
	// Print the list
	public void print() {
		System.out.print("The list: ");
		Node<T> curr = this.head;
		
		// The list is empty
		if(isEmpty()) System.out.print("The list is empty");

		// The list is not empty
		else {
			while(curr != null){
				System.out.print("["+curr.val+"] ");
				curr = curr.next;
			}
		}
		System.out.println();
	}
}
