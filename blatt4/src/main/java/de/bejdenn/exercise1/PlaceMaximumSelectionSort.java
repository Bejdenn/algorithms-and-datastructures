package de.bejdenn.exercise1;

import de.bejdenn.algorithm.sorting.simple.SelectionSort;

public class PlaceMaximumSelectionSort extends SelectionSort {

    @Override
    public void sort(int[] input) {
        // Die Laufzeit unterscheidet sich nicht groß von der des normalen Selection
        // Sort, da nur die Laufrichtungen der for-Loops und der Vergleichsoperator
        // gedreht wurden.

        int i, j, max;
        for (i = input.length - 1; i > 0; i--) {
            max = i;
            for (j = i; j >= 0; j--) {
                if (input[j] > input[max])
                    max = j;
            }

            swap(input, i, max);
        }
    }
}
