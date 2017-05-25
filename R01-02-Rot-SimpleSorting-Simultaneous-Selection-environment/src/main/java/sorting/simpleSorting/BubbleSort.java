package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * Author: Clara Moraes Dantas
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	private static final int MAIOR = 1;

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (array == null || leftIndex > rightIndex || leftIndex < 0 || rightIndex > array.length)
			return;
		
		boolean swapped = true;
		while (swapped) {
			swapped = false;
			
			for (int i = leftIndex; i < rightIndex; i++) {
				if (array[i].compareTo(array[i + 1]) == MAIOR) {
					swapped = true;
					Util.swap(array, i, i + 1);
				}
			}
		}
	}
}
