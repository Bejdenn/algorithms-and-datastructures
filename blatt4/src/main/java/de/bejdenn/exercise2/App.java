package de.bejdenn.exercise2;

import de.bejdenn.algorithm.benchmark.AlgorithmBenchmark;
import de.bejdenn.algorithm.sorting.advanced.MergeSort;
import de.bejdenn.algorithm.sorting.advanced.QuickSort;
import de.bejdenn.algorithm.sorting.simple.BubbleSort;

public class App {

    public static void main(String[] args) {
        var benchmark = AlgorithmBenchmark.randomInput(210_000);
        benchmark.start(new BubbleSort());

        benchmark = AlgorithmBenchmark.randomInput(700_000);
        benchmark.start(new QuickSort());

        benchmark = AlgorithmBenchmark.randomInput(500_000_000);
        benchmark.start(new MergeSort());
    }
}
