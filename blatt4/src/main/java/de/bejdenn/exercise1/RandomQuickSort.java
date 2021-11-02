package de.bejdenn.exercise1;

import java.util.concurrent.ThreadLocalRandom;

import de.bejdenn.algorithm.sorting.advanced.QuickSort;

public class RandomQuickSort extends QuickSort {

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    @Override
    public void sort(int[] input) {
        sortInternal(input, 0, input.length - 1);
    }

    private void sortInternal(int[] input, int first, int last) {
        int part = 0;

        if (first < last) {
            part = preparePartition(input, first, last, part);
            sortInternal(input, first, part - 1);
            sortInternal(input, part + 1, last);
        }
    }

    private int preparePartition(int[] input, int first, int last, int part) {
        int pivotIndex = RANDOM.nextInt(first, last + 1);

        int pivot = input[pivotIndex];

        swap(input, pivotIndex, first);

        part = first - 1;

        for (int i = first; i <= last; i++) {
            if (input[i] <= pivot) {
                part++;
                swap(input, part, i);
            }
        }

        swap(input, part, first);

        return part;
    }
}
