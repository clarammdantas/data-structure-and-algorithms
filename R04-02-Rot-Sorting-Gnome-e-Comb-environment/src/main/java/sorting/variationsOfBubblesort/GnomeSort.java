package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * Author: Clara Moraes Dantas
 * The implementation of the algorithm must be in-place!
 */
public class GnomeSort<T extends Comparable<T>> extends AbstractSorting<T> {
	private static final int MENOR = -1;

	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (array == null || leftIndex < 0 || rightIndex > array.length || leftIndex > rightIndex)
			return;
		
		int pivot = leftIndex;
		while (pivot <= rightIndex) {
			if (pivot == leftIndex || array[pivot].compareTo(array[pivot - 1]) >= 0) {
				pivot++;
			}
			
			else if (array[pivot].compareTo(array[pivot - 1]) == MENOR) {
				Util.swap(array, pivot, pivot - 1);
				pivot--;
			}
		}
	}
}
