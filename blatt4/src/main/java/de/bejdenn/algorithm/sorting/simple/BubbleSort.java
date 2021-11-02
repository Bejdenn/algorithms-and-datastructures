package de.bejdenn.algorithm.sorting.simple;

import de.bejdenn.algorithm.SortingAlgorithm;

public class BubbleSort implements SortingAlgorithm {

    @Override
    public void sort(int[] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = input.length - 2; j >= i; j--) {
                if (input[j] > input[j + 1]) {
                    int h = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = h;
                }
            }
        }
    }
}