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
        // Da man anstelle des ersten Elements ein zufälliges Element für das Pivot
        // wählt, ist die Wahrscheinlichkeit etwas höher, bessere Subpartitionen zu
        // mischen. Der Worst-Case von n^2 wird kaum mehr vorkommen, aber an der
        // Average-Case und Best-Case-Laufzeit wird sich auch nicht viel ändern, weil
        // der Algorithmus abgesehen davon nicht verändert wurde.

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
