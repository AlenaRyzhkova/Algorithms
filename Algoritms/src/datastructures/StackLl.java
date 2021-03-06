package datastructures;

import java.util.Iterator;

public class StackLl<Item> implements Iterable<Item> {
	private Node first; 	// top of stack (most recently added node)
	private int N;			// namber of items
	
	private class Node{
		// nested class to define nodes
		Item item;
		Node next;
	}
	
	public boolean isEmpty() { return first == null; }
	public int size() {return N;}
	
	// Add item to top of stack
	public void push(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item =  item;
		first.next = oldfirst;
		N++;
	}
	
	// Remove item from top of stack
	public Item pop() {
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}
	
	// Iterator implementation
	public Iterator<Item> iterator(){
		return new ListIterator();
	}
	private class ListIterator implements Iterator<Item>{
		private Node current = first;
		
		public boolean hasNext() {
			return current !=null;
		}
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
	
}
