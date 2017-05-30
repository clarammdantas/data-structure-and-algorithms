package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

/**
 * Author: Clara Moraes Dantas
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	private static final int MAIOR = 1;
	private static final int MENOR = -1;

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (array == null || leftIndex > rightIndex || leftIndex < 0 || rightIndex > array.length)
			return;
		
		divide(array, leftIndex, rightIndex);
	}
	
	private void divide(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int pivotIndex = quickSort(array, leftIndex, rightIndex);
			
			divide(array, leftIndex, pivotIndex - 1);
			divide(array, pivotIndex + 1, rightIndex);
		}
	}
	
	private int quickSort(T[] array, int leftIndex, int rightIndex) {
		int pivotIndex = (leftIndex + rightIndex) / 2;
		T pivot = array[pivotIndex];
		
		int i = leftIndex, j = rightIndex;
		while (i < j) {
			if (array[i].compareTo(pivot) == MENOR) {
				i++;
			}
			
			else if (array[j].compareTo(pivot) == MAIOR) {
				j--;
			}
			
			else if (array[i].compareTo(pivot) == MAIOR && array[j].equals(pivot)) {
				Util.swap(array, i, j);
				j--;
				pivotIndex = i;
			}
			
			else if (array[j].compareTo(pivot) == MENOR && array[i].equals(pivot)) {
				Util.swap(array, i, j);
				i++;
				pivotIndex = j;
			}
			
			else {
				Util.swap(array, i, j);
				i++;
				j--;
			}
		}
		
		return pivotIndex;
	}
}
