package de.bejdenn.algorithm.sorting.advanced;

import de.bejdenn.algorithm.SortingAlgorithm;

public class MergeSort implements SortingAlgorithm {

    @Override
    public void sort(int[] input) {
        sortInternal(input, 0, input.length - 1);
    }

    protected void sortInternal(int[] input, int first, int last) {
        if (first < last) {
            int mid = (first + last + 1) / 2;
            sortInternal(input, first, mid - 1);
            sortInternal(input, mid, last);
            merge(input, first, last, mid);
        }
    }

    private void merge(int[] input, int first, int last, int mid) {
        int i;
        int n = last - first + 1;

        int a1f = first;
        int a1l = mid - 1;
        int a2f = mid;
        int a2l = last;

        int[] newInput = new int[n];

        for (i = 0; i < n; i++) {
            if (a1f <= a1l) {
                if (a2f <= a2l) {
                    if (input[a1f] <= input[a2f]) {
                        newInput[i] = input[a1f++];
                    } else {
                        newInput[i] = input[a2f++];
                    }
                } else {
                    newInput[i] = input[a1f++];
                }
            } else {
                newInput[i] = input[a2f++];
            }
        }

        for (i = 0; i < n; i++) {
            input[first + i] = newInput[i];
        }
    }
}