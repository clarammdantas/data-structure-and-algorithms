package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Author: Clara Moraes Dantas
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos: - Alocar o tamanho minimo
 * possivel para o array de contadores (C) - Ser capaz de ordenar arrays
 * contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	private static final int MAIOR = 1;
	private static final int MENOR = -1;

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (array == null || leftIndex < 0 || rightIndex > array.length || leftIndex > rightIndex)
			return;
		
		int[] freq = countFrequencies(array, leftIndex, rightIndex);
		getCorrectPositions(freq);
		getSortedArray(array, leftIndex, rightIndex, freq);
	}
	
	/**
	 * 
	 * @param array
	 * @param leftIndex
	 * @param rightIndex
	 * @return Gets the frequency of each number in a given range.
	 */
	private int[] countFrequencies(Integer[] array, int leftIndex, int rightIndex) {
		Integer min = getMin(array, leftIndex, rightIndex);
		Integer max = getMax(array, leftIndex, rightIndex);
		
		int freqLen = max - min + 1;
		int[] freq = new int[freqLen];
		for (int i = 0; i < freqLen; i++) {
			freq[i] = 0;
		}
		
		for (int i = leftIndex; i <= rightIndex; i++) {
			freq[array[i] - min]++;
		}
		
		return freq;
	}
	
	/**
	 * Finds the correct position of each element in the sorted array.
	 * @param freq
	 */
	private void getCorrectPositions(int[] freq) {
		for (int i = 1; i < freq.length; i++) {
			freq[i] += freq[i - 1];
		}
	}
	
	/**
	 * 
	 * @param array
	 * @param leftIndex
	 * @param rightIndex
	 * @param positions Puts each element in its correct position in the sorted array.
	 */
	private void getSortedArray(Integer[] array, int leftIndex, int rightIndex, int[] positions) {
		Integer[] aux = array.clone();
		int min = getMin(aux, leftIndex, rightIndex);
		
		for (int i = 0; i < aux.length; i++) {
			if (i >= leftIndex && i <= rightIndex) {
				int pos = positions[aux[i]- min] + leftIndex - 1;
				array[pos] = aux[i];
				
				positions[aux[i] - min]--;
			}
			
			else {
				array[i] = aux[i];
			}
			
		}
	}
	
	/**
	 * 
	 * @param array
	 * @param leftIndex
	 * @param rightIndex
	 * @return The maximum element in a given range.
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
	 * @return The minimum element in a given range.
	 */
	private Integer getMin(Integer[] array, int leftIndex, int rightIndex) {
		Integer min = array[leftIndex];
		
		for (int i = leftIndex; i <= rightIndex; i++) {
			if (min.compareTo(array[i]) == MAIOR)
				min = array[i];
		}
		
		return min;
	}
}
