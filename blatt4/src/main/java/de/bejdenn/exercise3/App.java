package de.bejdenn.exercise3;

import de.bejdenn.algorithm.benchmark.AlgorithmBenchmark;
import de.bejdenn.algorithm.sorting.advanced.HeapSort;

public class App {

    public static void main(String[] args) {
        var benchmark = new AlgorithmBenchmark(new int[] { 34, 45, 12, 34, 23, 18, 38, 17, 43, 51 });
        benchmark.start(new HeapSort());
    }
}
