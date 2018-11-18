package datastructures;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
	private Node first;	// link to least recently added node
	private Node last;	// link to most recently added node
	private int N;		// Number of items on the queue
	
	private class Node{
		Item item;
		Node next;
	}
	
	public boolean isEmpty(){ return first == null; }
	public int size() {return N; }
	
	// Add item to the end of the list
	public void enqueue(Item item) {
		Node oldLast = last;
		last.item = item;
		last.next = null;
		if(isEmpty())
			first = last;
		else
			oldLast.next = last;
		N++;
	}
	
	//Remove item from the beginning of the list
	public Item dequeue() {
		Item item = first.item;
		first = first.next;
		if(isEmpty())
			last = null;
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
