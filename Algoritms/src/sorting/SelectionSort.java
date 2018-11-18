package sorting;

import stdlib.StdIn;

public class SelectionSort<T> {
	
	public static <T> void sort(Comparable<T>[] a) {
		// sort a[] into increasing order
		int N = a.length;
		for(int i=0; i<N; i++) {
			int min = i;
			for(int j=i; j<N; j++) {
				if(less(a[j],a[min]))
					min = j;
			}
			exch(a, i, min);
		}
	}
	
	@SuppressWarnings("unchecked")
	private static <T> boolean less(Comparable<T> v, Comparable<T> w) {
		return v.compareTo((T) w)< 0;
	}

	private static <T> void exch(Comparable<T>[] a, int i, int j) {
		Comparable<T> t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	private static <T> void show(Comparable<T>[] a) {
		// Print the array, on a single line
		for(int i=0; i<a.length; i++) 
			System.out.print(a[i] + " ");
		System.out.println();
	}
	private static <T> boolean isSorted(Comparable<T>[] a) {
		// Test whether the array entires are in order
		for(int i=1; i<a.length; i++) {
			if(less(a[i],a[i-1]))
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// Read strings from standard input, sort them, and print.
		String[] a = StdIn.readAllStrings();
		sort(a);
		assert isSorted(a);
		show(a);
	}
}
