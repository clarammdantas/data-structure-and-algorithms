package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;
import util.Util;

/**
 * Author: Clara Moraes Dantas
 * This algorithm applies two selection sorts simultaneously. In a same
 * iteration, a selection sort pushes the greatest elements to the right and
 * another selection sort pushes the smallest elements to the left. At the end
 * of the first iteration, the smallest element is in the first position (index
 * 0) and the greatest element is the last position (index N-1). The next
 * iteration does the same from index 1 to index N-2. And so on. The execution
 * continues until the array is completely ordered.
 */
public class SimultaneousSelectionsort<T extends Comparable<T>> extends
		AbstractSorting<T> {
	private static final int MAIOR = 1;
	private static final int MENOR = -1;

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex > rightIndex || leftIndex < 0 || rightIndex > array.length || array == null)
			return;
		
		int i = leftIndex, j = rightIndex, minPosition = leftIndex, maxPosition = rightIndex;
		
		while (i < j) {
			T min = getMin(array, i, j);
			T max = getMax(array, i, j);
			
			for (int k = i; k <= j; k++) {
				if (array[k].equals(min) && minPosition <= rightIndex) {
					Util.swap(array, k, minPosition);
					minPosition++;
				}
			}
			i++;
			if (minPosition > maxPosition) break;
			
			for (int k = j; k >= i; k--) {
				if (array[k].equals(max) && maxPosition >= leftIndex) {
					Util.swap(array, maxPosition, k);
					maxPosition--;
				}
			}
			
			j--;
		}
	}
	
	private T getMax(T[] array, int leftIndex, int rightIndex) {
		T max = array[leftIndex];
		for (int i = leftIndex; i <= rightIndex; i++) {
			if (array[i].compareTo(max) == MAIOR)
				max = array[i];
		}
		
		return max;
	}
	
	private T getMin(T[] array, int leftIndex, int rightIndex) {
		T min = array[leftIndex];
		for (int i = leftIndex; i <= rightIndex; i++) {
			if (array[i].compareTo(min) == MENOR)
				min = array[i];
		}
		
		return min;
	}
}
