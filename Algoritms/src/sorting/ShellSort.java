package sorting;

import stdlib.StdIn;

/**
 * 
 * Shellsort is a generalization of insertion sort that allows exchange
 * of items that far apart.
 * The idea is to arrange the list of elements so that, starting anywhere,
 * considering every hth element gives a sorted list. Such a list is said to be h-sorted.
 * Equivalently, it can be thought of as h interleaved lists, each individually sorted.
 * Beginning with large values of h, this rearrangement allows elements to move
 * long distances in the original list, reducing large amounts of disorder quickly,
 * and leaving less work for smaller h-sort steps to do.[7] If the list is then k-sorted
 * for some smaller integer k, then the list remains h-sorted. Following this idea
 * for a decreasing sequence of h values ending in 1 is guaranteed to leave a sorted list in the end.
 *
 */
public class ShellSort {
	
	public static <T> void sort(Comparable<T>[] a) {
		int N = a.length;
		int h = 1;
		while(h<N/3)
			h = 3*h + 1;
		while(h>=1) {
			// h-sort the array
			for(int i = h; i<N; i++) {
				// Insert a[i] among a[i-h], a[i-2*h], a[i-3h]
				for(int j=i; j>=h && less(a[j],a[j-h]); j -=h)
					exch(a,j,j-h);
			}
			h = h/3;
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
