package test;

import data_structures.Stack;

public class testStack {
	public static void main(String [] args) {
		Stack<String> stack = new Stack<>();
		
		System.out.println("The stack is initially empty: "+stack.isEmpty());
		
		stack.push("Huy");
		stack.push("Huong");
		stack.print();
		
		String top = stack.peek();
		System.out.println("The top element is: "+top);
		
		stack.pop();
		stack.print();
		
		stack.pop();
		stack.print();
		
		stack.pop();
	}
}
