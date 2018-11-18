package sorting;

import stdlib.StdIn;

public class MergeSort {
	
	 private static Comparable[] tmp;
	
	public static <T> void sort(Comparable<T>[] a) {
		tmp = new Comparable[a.length];
		sort(a,0, a.length-1);
	}
	
	public static <T> void sort(Comparable<T>[] a, int lo, int hi) {
		if(hi<=lo)
			return;
		int mid = lo + (hi-lo)/2;
		sort(a, lo, mid);
		sort(a,mid+1,hi);
		merge(a, lo, mid, hi);
	}
	
	//Merge a[lo...mid] with a[mid+1 ... hi]
	public static <T> void merge(Comparable<T>[] a, int lo, int mid, int hi) {
		int i=lo;
		int j=mid+1;
		
		//Copy to the temporary array
		for(int k=lo; k<=hi; k++)
			tmp[k] = a[k];
		
		// Merge  to the original array
		for(int k=lo; k<=hi; k++) {
			
			if(i>mid)					// if elements in first part of array have run out
				a[k] = tmp[j++];		// we will take from the second part
			else if(j>hi)				// if elements in the second part of array have run out
				a[k] = tmp[i++];		// we will take from the first part
			else if(less(tmp[j],tmp[i]))//compare elements from both part one by one 
				a[k] = tmp[j++];
			else
				a[k] = tmp[i++];
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
		System.out.println("This is Merge sort:");
		System.out.println();
		// Read strings from standard input, sort them, and print.
		String[] a = StdIn.readAllStrings();
		sort(a);
		assert isSorted(a);
		show(a);
	}
}
