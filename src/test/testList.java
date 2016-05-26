package test;

import data_structures.LinkedList;

public class testList {
	public static void main(String [] args) {
		LinkedList<String> list = new LinkedList<>();
		
		System.out.println("The list is initially empty: "+list.isEmpty());
		
		list.insert(0, "Huy");
		list.insert(0, "Huong");
		list.insert(2, "Lilian");
		list.insert(1, "Hung");
		list.print();

		list.remove(0);
		list.remove(1);
		list.remove(1);
		list.remove(0);
		list.print();
		
		list.insert(0, "Huy");
		String temp = list.get(0);
		System.out.println("The 0th element is "+temp);
		
		list.set(0, "Huong");
		System.out.println("The 0th element is now "+list.get(0));
	}
}
