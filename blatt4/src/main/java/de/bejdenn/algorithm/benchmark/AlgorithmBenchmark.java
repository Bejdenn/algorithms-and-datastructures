package de.bejdenn.algorithm.benchmark;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

import de.bejdenn.algorithm.SortingAlgorithm;

public class AlgorithmBenchmark {

    private int[] testInput;

    public AlgorithmBenchmark(int[] testInput) {
        this.testInput = testInput;
    }

    public static AlgorithmBenchmark randomInput(int amount) {
        return new AlgorithmBenchmark(generateTestInput(amount));
    }

    public static int[] generateTestInput(int amount) {
        var testInput = new int[amount];

        for (int i = 0; i < testInput.length; i++) {
            testInput[i] = ThreadLocalRandom.current().nextInt(0, 101);
        }

        return testInput;
    }

    public void start(SortingAlgorithm algorithm) {
        String algorithmName = algorithm.getClass().getSimpleName();

        System.out.println("TESTING: " + algorithmName);

        Supplier<String> testInputContent = () -> testInput.length < 15 ? Arrays.toString(testInput) : "";
        String testInputAtStart = testInputContent.get();

        System.out.println("-> Generated test input... " + testInputContent.get());

        final int inputLength = testInput.length;

        Instant start = Instant.now();
        algorithm.sort(testInput);
        Instant end = Instant.now();

        // Check that sorting has not modified list length
        if (inputLength != testInput.length) {
            throw new IllegalStateException(
                    "List is not as long as before! Expected: " + inputLength + "; Actual: " + testInput.length);
        }

        // Sanity check to ensure that list was really sorted
        for (int i = 0; i < testInput.length - 1; i++) {
            if (Integer.compare(testInput[i], testInput[i + 1]) > 0) {
                throw new IllegalStateException(
                        algorithmName + " did not sort the list properly: " + testInputContent.get());
            }
        }

        // Check if sorting has not changed the elements
        if (!verifyAllEqual(Arrays.asList(testInput))) {
            throw new IllegalStateException("Test input does not contain the same elements as at start: "
                    + testInputAtStart + " vs. " + testInputContent.get());
        }

        System.out.println("No problems found!");

        Duration duration = Duration.between(start, end);
        System.out.println("-> " + algorithmName + " took " + duration + " " + testInputContent.get() + "\n");
    }

    private boolean verifyAllEqual(List<?> list) {
        return list.isEmpty() || Collections.frequency(list, list.get(0)) == list.size();
    }
}
