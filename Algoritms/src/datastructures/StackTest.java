package datastructures;

import stdlib.StdIn;
import stdlib.StdOut;

public class StackTest {
	public static void main(String[] args) {
		StackAr<String> s = new StackAr<>();
		while(!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if(!item.equals("-"))
				s.push(item);
			else if(!s.isEmpty())
				StdOut.print(s.pop() + " ");
		}
		StdOut.println("(" + s.size() + " left on stack)");
	}
}
