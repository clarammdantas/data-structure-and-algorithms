package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * Author: Clara Moraes Dantas
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	private static final int MAIOR = 1;

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (array == null || leftIndex > rightIndex || leftIndex < 0 || rightIndex > array.length)
			return;
		
		for (int i = leftIndex; i < rightIndex + 1; i++) {
			for (int j = leftIndex; j < i; j++) {
				if (array[j].compareTo(array[i]) == MAIOR) {
					Util.swap(array, i, j);
				}
			}
		}
	}
}
