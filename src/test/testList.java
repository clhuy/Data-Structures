package test;

import llist.LinkedList;

public class testList {
	public static void main(String [] args) {
		LinkedList<String> list = new LinkedList();
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
	}
}
