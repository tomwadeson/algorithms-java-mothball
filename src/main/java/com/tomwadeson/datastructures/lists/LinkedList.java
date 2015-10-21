package com.tomwadeson.datastructures.lists;

public class LinkedList<T> implements List<T> {
	
	private class Node {
		
		public T data;
		public Node next;
		
		public Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
		
		@Override
		public String toString() {
			return data + " -> " + ((next == null) ? "<end>" : next.toString());
		}
	}
	
	private int size;
	private Node head;

	@Override
	public void add(T item) {
		if (head == null) {
			head = new Node(item, null);
		}
		else {
			Node node = head;
			while (node.next != null) node = node.next;
			node.next = new Node(item, null);
		}
		size++;
	}

	@Override
	public void delete(int index) {
		if (index == 0)
			head = head == null ? null : head.next;
		
		Node p = head;
		for (int i = 0; i <= index - 1; i++) {
			if (i == index - 1)
				p.next = p.next.next;
			
			p = p.next;
		}
		
		size--;
	}

	@Override
	public T get(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		
		Node n = head;
		for (int i = 0; i <= index; i++) {
			if (i == index)
				return n.data;
			
			n = n.next;
		}
		return null;
	}

	@Override
	public int size() {
		return size;
	}
}