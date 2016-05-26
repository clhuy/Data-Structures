package data_structures;

import java.util.EmptyStackException;

/**
 * 
 * @author Cu Le Huy
 * @param <T>
 * last updated: 05/25/2016
 */

public class Stack<T> {
	private Node<T> top;
	
	/**
	 * Node class
	 */
	private class Node<E> {
		E value;
		Node<E> next;
		
		// Node constructor
		public Node(E value) {
			this.value = value;
			next = null;
		}
	}
	
	// Constructor
	public Stack() {
		top = null;
	}
	
	// Check whether the stack is empty
	public boolean isEmpty() {
		return top == null;
	}
	
	// Push value val onto the top of the stack
	public void push(T val) {
		Node<T> newNode = new Node<>(val);
		newNode.next = top;
		top = newNode;
		
		System.out.println("'"+val+"'" + " is pushed to the stack");
	}
	
	// Remove and return the top value
	public T pop() {
		// Handle empty stack
		if(isEmpty()) throw new EmptyStackException();
		
		T val = top.value;
		top = top.next;
		
		System.out.println("'"+val+"'" + " is popped from the stack");

		return val;
	}
	
	// Return the top value 
	public T peek() {
		// Handle empty stack
		if(isEmpty()) throw new EmptyStackException();
		
		return top.value;
	}
	
	// Print the stack
	public void print() {
		System.out.print("The stack: ");
		Node<T> curr = top;
		
		// The stack is empty
		if(isEmpty()) {
			System.out.print("The stack is empty");
		}
		// The stack is not empty
		else {
			while(curr != null){
				System.out.print("["+curr.value+"] ");
				curr = curr.next;
			}
		}
		System.out.println();
	}
}
