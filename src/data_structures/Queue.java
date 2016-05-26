package data_structures;

import java.util.NoSuchElementException;

/**
 * 
 * @author Cu Le Huy
 * @param <T>
 * last updated: 05/26/2016
 */

public class Queue<T> {
	private Node<T> first, last;
	
	/**
	 * Node class
	 */
	private class Node<E> {
		E val;
		Node<E> next;
		
		// Node constructor
		public Node(E val){
			this.next = null;
			this.val = val;
		}
	}
	
	// Constructor
	public Queue() {
		first = null;
		last = null;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void enqueue(T val) {
		Node<T> newNode = new Node<>(val);
		if (last != null) last.next = newNode;	
		last = newNode;
		// Handle empty stack
		if(first == null) first = last;
		
		System.out.println("'"+last.val+"'" + " is added");
	}
	
	public T dequeue() {
		if(first == null) throw new NoSuchElementException();
	
		T val = first.val;
		first = first.next;
		
		// If there's no more elements
		if(first == null) last = null;
		
		System.out.println("'"+val+"'" + " is removed");
		return val;
	}
	
	// Print the queue
	public void print() {
		System.out.print("The queue: ");
		Node<T> curr = this.first;
		
		// The queue is empty
		if(isEmpty()) System.out.print("The queue is empty");

		// The queue is not empty
		else {
			while(curr != null){
				System.out.print("["+curr.val+"] ");
				curr = curr.next;
			}
		}
		System.out.println();
	}
}
