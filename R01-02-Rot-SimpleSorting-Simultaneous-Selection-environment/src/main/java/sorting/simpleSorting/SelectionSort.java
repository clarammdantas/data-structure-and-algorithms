package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * Author: Clara Moraes Dantas
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	private static final int MENOR = -1;

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		int correctPosition = leftIndex;
		for (int i = leftIndex; i <= rightIndex; i++) {
			T min = getMinElement(array, i, rightIndex);
			
			for (int j = correctPosition; j <= rightIndex; j++) {
				if (array[j].equals(min) && correctPosition <= rightIndex) {
					Util.swap(array, j, correctPosition);
					correctPosition++;
				}
			}
		}
	}
	
	private T getMinElement(T[] array, int leftIndex, int rightIndex) {
		T min  = (T) array[leftIndex];
		for (int i = leftIndex; i <= rightIndex; i++) {
			if (array[i].compareTo(min) == MENOR)
				min = array[i];
		}
		
		return min;
	}
}
