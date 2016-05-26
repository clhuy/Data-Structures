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
		
		// Set the previous element
		public void setPrev(Node<E> prev) {
			this.prev = prev;
		}
		
		// Set the next element
		public void setNext(Node<E> next) {
			this.next = next;
		}
	}
	
	// Constructor
	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	// Return the number of elements in the list
	public int size(){
		return this.size;
	}
	
	// Check whether the list is empty
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	// Insert value val at index pos
	public void insert(int pos, T val) {
		// Validate pos
		if(pos < 0 || pos > size) throw new IndexOutOfBoundsException();
		
		Node<T> newNode = new Node<>(val);
		// Inserting into an empty list
		if(this.isEmpty()) { 
			this.head = newNode;
			this.tail = head;
		}
		// Inserting into the front of the list
		else if(pos == 0) {
			this.head.setPrev(newNode);
			newNode.setNext(this.head);
			this.head = newNode;
		}
		// Inserting into the end of the list
		else if(pos == this.size()) {
			this.tail.setNext(newNode);
			newNode.setPrev(tail);
			this.tail = newNode;
		}
		// Normal insertion
		else if(pos > 0 && pos < this.size()){
			newNode.setNext(this.getNodeAtIndex(pos));
			newNode.setPrev(this.getNodeAtIndex(pos-1));
			this.getNodeAtIndex(pos).setPrev(newNode);
			this.getNodeAtIndex(pos-1).setNext(newNode);
		}
		
		System.out.println("'"+val+"'" + " is inserted");
		this.size++;
	}
	
	// Remove the node at index pos
	public void remove(int pos) {
		// Validate pos
		if(this.isEmpty() || pos < 0 || pos > size-1) throw new IndexOutOfBoundsException();
		
		System.out.println("'"+this.get(pos)+"'" + " is removed");
		
		// Remove only element
		if (this.size() == 1) {
			this.head = null;
			this.tail = null;
		}
		// Remove head
		else if(pos == 0) {
			this.head = this.head.next;
			this.head.setPrev(null);
		}
		// Remove tail
		else if(pos == this.size()-1) {
			this.tail = this.tail.prev;
			this.tail.setNext(null);
		}
		// Normal removal
		else if(pos > 0 && pos < this.size()) {
			Node<T> tempPrev = this.getNodeAtIndex(pos-1);
			Node<T> tempNext = this.getNodeAtIndex(pos+1);
			tempPrev.setNext(tempNext);
			tempNext.setPrev(tempPrev);
		}
		
		this.size--;
	}
	
	// Overwrites the old value at index pos with value val
	public void set(int pos, T val) {
		// Validate pos
		if(this.isEmpty() || pos < 0 || pos > size-1) throw new IndexOutOfBoundsException();
		
		this.getNodeAtIndex(pos).val = val;
		System.out.println("The "+pos+"th element is set to "+val);
	}
	
	// Return the value at index pos
	public T get(int pos) {
		// Validate pos
		if(this.isEmpty() || pos < 0 || pos > size-1) throw new IndexOutOfBoundsException();
		
		return this.getNodeAtIndex(pos).val;
	}
	
	// Return the node at specified index pos
	public Node<T> getNodeAtIndex(int pos) {
		Node<T> temp = this.head;
		if(pos >= 0 && pos < this.size()) {
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
		if(this.isEmpty()) System.out.print("The list is empty");

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
