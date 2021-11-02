package de.bejdenn.algorithm.sorting.simple;

import de.bejdenn.algorithm.SortingAlgorithm;

public class InsertionSort implements SortingAlgorithm {

    @Override
    public void sort(int[] input) {
        int key = 0;

        for (int j = 1; j < input.length; j++) {
            key = input[j];
            int i = j - 1;

            while (i >= 0 && input[i] > key) {
                input[i + 1] = input[i];
                i--;
            }

            input[i + 1] = key;
        }
    }
}