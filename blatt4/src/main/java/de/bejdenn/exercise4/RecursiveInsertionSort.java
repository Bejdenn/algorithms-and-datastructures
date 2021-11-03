package de.bejdenn.exercise4;

import de.bejdenn.algorithm.sorting.simple.InsertionSort;

/**
 * Laufzeitanalyse: Vermutlich in etwa die selbe Laufzeit wie die iterative
 * Variante.
 */
public class RecursiveInsertionSort extends InsertionSort {

    @Override
    public void sort(int[] input) {
        sortInternal(input, 1);
    }

    private void sortInternal(int[] input, int keyIndex) {
        if (keyIndex >= input.length) {
            return;
        }

        int key = input[keyIndex];
        int i = keyIndex - 1;

        i = move(input, i, key);

        input[i + 1] = key;

        sortInternal(input, keyIndex + 1);
    }

    private int move(int[] input, int sourceIndex, int key) {
        if (sourceIndex < 0 || input[sourceIndex] < key) {
            return sourceIndex;
        }

        input[sourceIndex + 1] = input[sourceIndex];
        sourceIndex--;

        return move(input, sourceIndex, key);
    }
}
