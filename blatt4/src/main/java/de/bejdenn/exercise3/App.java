package de.bejdenn.exercise3;

import de.bejdenn.algorithm.benchmark.AlgorithmBenchmark;

public class App {

    public static void main(String[] args) {
        var benchmark = new AlgorithmBenchmark(new int[] { -5, 13, -32, 7, -3, 17, 23, 12, -35, 19 });
        benchmark.start(new VisualizedMergeSort());
    }
}
