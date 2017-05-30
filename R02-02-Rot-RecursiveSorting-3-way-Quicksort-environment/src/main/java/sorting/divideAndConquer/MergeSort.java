package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	private static final int MENOR_OU_IGUAL = 1;

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (array == null || leftIndex  < 0 || rightIndex > array.length || leftIndex > rightIndex)
			return;
		
		T[] modify = array.clone();
		divide(array, leftIndex, rightIndex, modify);
		copySortedArray(array, modify);
	}
	
	private void divide(T[] aux, int leftIndex, int rightIndex, T[] modify) {
		if (leftIndex < rightIndex) {
			int mid = (leftIndex + rightIndex) / 2;
			divide(aux, leftIndex, mid, modify);
			divide(aux, mid + 1, rightIndex, modify);
			
			combine(leftIndex, mid, rightIndex, modify);
		}
	}
	
	private void combine(int leftIndex, int mid, int rightIndex, T[] modify) {
		T[] aux = modify.clone();
		int array1Index = leftIndex, array2Index = mid + 1, sortedArrayIndex = leftIndex;
		
		while (array1Index <= mid && array2Index <= rightIndex) {
			//ve se o elemento atual do primeiro array é menor ou igual ao do segundo
			if (aux[array1Index].compareTo(aux[array2Index]) < MENOR_OU_IGUAL) {
				modify[sortedArrayIndex] = aux[array1Index++];
			}
			
			else {
				modify[sortedArrayIndex] = aux[array2Index++];
			}
			
			sortedArrayIndex++;
		}
		
		//checa se ainda há elementos no primeiro array
		while (array1Index <= mid) {
			modify[sortedArrayIndex] = aux[array1Index++];
			sortedArrayIndex++;
		}
	}
	
	private void copySortedArray(T[] array, T[] modify) {
		for (int i = 0; i < array.length; i++)
			array[i] = modify[i];
	}
}
