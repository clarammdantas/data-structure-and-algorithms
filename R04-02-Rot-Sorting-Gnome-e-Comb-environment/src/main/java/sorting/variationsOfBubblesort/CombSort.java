package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * Author: Clara Moraes Dantas
 * The combsort algoritm.
 */
public class CombSort<T extends Comparable<T>> extends AbstractSorting<T> {
	
	private static final int MAIOR = 1;
	private static final double K = 1.3;
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (array == null || leftIndex < 0 || rightIndex > array.length || leftIndex > rightIndex)
			return;
		
		int gap = rightIndex;
		boolean swapped = true;
		
		while (gap > 1 || swapped) {
			swapped = false;
			gap = (int) (gap / K);
			for (int i = leftIndex; i + gap <= rightIndex; i++){
				if (array[i].compareTo(array[i + gap]) == MAIOR) {
					Util.swap(array, i, i + gap);
					swapped = true;
				}
			}
		}
	}
}
