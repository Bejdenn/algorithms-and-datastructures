package de.bejdenn.algorithm.sorting.advanced;

import de.bejdenn.algorithm.SortingAlgorithm;

public class HeapSort implements SortingAlgorithm {

    @Override
    public void sort(int[] input) {
        sortInternal(input, 0, input.length - 1);
    }

    private void sortInternal(int[] a, int f, int l) {
        buildHeap(a, f, l);
        for (int i = l; i > f; i--) {
            swap(a, f, i);
            heapify(a, f, i - 1, f);
        }
    }

    private void heapify(int[] a, int f, int l, int root) {
        int largest, left = f + (root - f) * 2 + 1, right = f + (root - f) * 2 + 2;
        if (left <= l && a[left] > a[root])
            largest = left;
        else
            largest = root;
        if (right <= l && a[right] > a[largest])
            largest = right;
        if (largest != root) {
            swap(a, root, largest);
            heapify(a, f, l, largest);
        }
    }

    private void buildHeap(int[] a, int f, int l) {
        int n = l - f + 1;
        for (int i = f + (n - 2) / 2; i >= f; i--)
            heapify(a, f, l, i);
    }
}