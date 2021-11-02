package de.bejdenn.exercise4;

import de.bejdenn.algorithm.benchmark.AlgorithmBenchmark;

public class App {

    public static void main(String[] args) {
        var benchmark = new AlgorithmBenchmark(new int[] { 34, 45, 12, 34, 23, 18, 38, 17, 43, 51 });
        // tester.test(new InsertionSort());

        // tester = new AlgorithmPerformanceTester(new int[] { 34, 45, 12, 34, 23, 18,
        // 38, 17, 43, 51 });
        // tester.test(new RecursiveInsertionSort());

        benchmark.start(new IterativeMergeSort());
    }
}
