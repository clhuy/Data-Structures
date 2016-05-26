package test;

import data_structures.Queue;

public class testQueue {
	public static void main(String [] args) {
		Queue<String> q = new Queue<>();
		
		System.out.println("The queue is initially empty: "+q.isEmpty());
		
		q.enqueue("Huong");
		q.enqueue("Huy");
		q.print();
		
		q.dequeue();
		q.print();
		
		q.dequeue();
		q.print();
		
		q.dequeue();
	}
}
