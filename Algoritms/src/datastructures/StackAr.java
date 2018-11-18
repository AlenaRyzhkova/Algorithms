package datastructures;

public class StackAr<Item> {
	private Item[] a;
	private int N;
	
	@SuppressWarnings("unchecked")
	public StackAr() {
		a = (Item[]) new Object[1];
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public int size() {
		return N;
	}
	
	public void push(Item item) {
		//Add item to top of stack
		if(N==a.length)
			resize(2*a.length);
		a[N++] = item;
	}
	
	public Item pop() {
		// Remove item from top of stack
		Item item = a[--N];
		a[N] = null; // Avoid loitering
		if(N>0 && N==a.length/4)
			resize(a.length/2);
		return item;
		
	}
	
	public void resize(int max) {
		@SuppressWarnings("unchecked")
		Item[] temp = (Item[]) new Object[max];
		for(int i=0; i<N; i++)
			temp[i] = a[i];
		a = temp;
	}
}
