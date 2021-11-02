package de.bejdenn.algorithm;

/**
 * A sorting algorithm is a procedure that takes an array of int's and sorts
 * them in an ascending order.
 */
@FunctionalInterface
public interface SortingAlgorithm {

    /**
     * Sorts the input array in ascending order.
     * 
     * @param input the array to sort
     */
    void sort(int[] input);

    /**
     * Swaps the values behind the positions of x and y in a.
     * 
     * @param a the input values
     * @param x one of the indexes for swapping
     * @param y the other indexes for swapping
     */
    default void swap(int[] a, int x, int y) {
        int h = a[y];
        a[y] = a[x];
        a[x] = h;
    }
}
