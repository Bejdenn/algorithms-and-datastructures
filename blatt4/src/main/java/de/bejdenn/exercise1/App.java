package de.bejdenn.exercise1;

import java.util.Arrays;

import de.bejdenn.algorithm.benchmark.AlgorithmBenchmark;
import de.bejdenn.algorithm.sorting.simple.SelectionSort;

public class App {

    public static void main(String[] args) {
        // var benchmark = new AlgorithmBenchmark(new int[] { 34, 45, 12, 34, 23, 18,
        // 38, 17, 43, 7 });
        // benchmark.start(new RandomQuickSort());

        int[] testInput1 = AlgorithmBenchmark.generateTestInput(6);
        int[] testInput2 = Arrays.copyOf(testInput1, testInput1.length);

        var benchmark2 = new AlgorithmBenchmark(testInput1);
        // benchmark2.start(new QuickSort());

        var benchmark1 = new AlgorithmBenchmark(testInput2);
        // benchmark1.start(new RandomQuickSort());

        benchmark1.start(new SelectionSort());
    }
}
