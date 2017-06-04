package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Author: Clara Moraes Dantas
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 * 
 */
public class CountingSort extends AbstractSorting<Integer> {

	private static final int MENOR = -1;

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (array == null || leftIndex < 0 || rightIndex > array.length || leftIndex > rightIndex)
			return;
		
		int[] freq = countFrequencies(array, leftIndex, rightIndex);
		getCorrectPositions(freq);
		getSortedArray(array, freq, leftIndex, rightIndex);
	}
	
	/**
	 * 
	 * @param array
	 * @param leftIndex
	 * @param rightIndex
	 * @return The maximum element in a given range
	 */
	private Integer getMax(Integer[] array, int leftIndex, int rightIndex) {
		Integer max = array[leftIndex];
		for (int i = leftIndex; i <= rightIndex; i++) {
			if (max.compareTo(array[i]) == MENOR)
				max = array[i];
		}
		
		return max;
	}
	
	/**
	 * 
	 * @param array
	 * @param leftIndex
	 * @param rightIndex
	 * @return Gets the frequency of each number in a given range.
	 */
	private int[] countFrequencies(Integer[] array, int leftIndex, int rightIndex) {
		int freqLength = getMax(array, leftIndex, rightIndex);
		int[] freq = new int[freqLength + 1];
		
		for (int i = 0; i < freqLength; i++) {
			freq[i] = 0;
		}
		
		for (int i = leftIndex; i <= rightIndex; i++) {
			freq[array[i]]++;
		}
		
		return freq;
	}
	
	/**
	 * Finds the correct position of each element in the sorted array.
	 * @param frequencies
	 */
	private void getCorrectPositions(int[] frequencies) {
		for (int i = 1; i < frequencies.length; i++)
			frequencies[i] += frequencies[i - 1];
	}
	
	/**
	 * Puts each element in its correct position in the sorted array.
	 * @param array
	 * @param positions
	 * @param leftIndex
	 * @param rightIndex
	 */
	private void getSortedArray(Integer[] array, int[] positions, int leftIndex, int rightIndex) {
		Integer[] aux = array.clone();
		
		for (int i = 0; i < array.length; i++) {
			if (i >= leftIndex && i <= rightIndex) {
				int correctPosition = positions[aux[i]] + leftIndex - 1;
				array[correctPosition] = aux[i];
				
				positions[aux[i]]--;
			}
			
			else {
				array[i] = aux[i];
			}
		}
	}

}
