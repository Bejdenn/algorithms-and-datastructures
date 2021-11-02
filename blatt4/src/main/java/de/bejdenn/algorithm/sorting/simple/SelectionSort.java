package de.bejdenn.algorithm.sorting.simple;

import de.bejdenn.algorithm.SortingAlgorithm;

public class SelectionSort implements SortingAlgorithm {

    @Override
    public void sort(int[] input) {
        int i, j, min;
        for (i = 0; i < input.length; i++) {
            min = i;
            for (j = i; j < input.length; j++) {
                if (input[j] < input[min])
                    min = j;
            }

            swap(input, i, min);
        }
    }
}
