package de.bejdenn.exercise1;

import de.bejdenn.algorithm.sorting.simple.InsertionSort;

public class UseMinimumInsertionSort extends InsertionSort {

    @Override
    public void sort(int[] input) {
        int key = 0;

        for (int j = 0; j < input.length; j++) {
            key = input[j];
            int i = j + 1;

            while (i < input.length && input[i] < key) {
                input[i + 1] = input[i];
                i--;
            }

            input[i + 1] = key;
        }
    }
}