package de.bejdenn.exercise1;

import de.bejdenn.algorithm.sorting.simple.BubbleSort;

public class MoveMaximumRightBubbleSort extends BubbleSort {

    @Override
    public void sort(int[] input) {
        // Die Laufzeit unterscheidet sich nicht groß von der des normalen Bubble
        // Sort, da nur die Laufrichtungen der for-Loops gedreht wurde.

        for (int i = (input.length - 1); i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (input[j] > input[j + 1]) {
                    int h = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = h;
                }
            }
        }
    }
}
