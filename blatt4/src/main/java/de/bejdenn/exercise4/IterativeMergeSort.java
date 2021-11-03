package de.bejdenn.exercise4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import de.bejdenn.algorithm.sorting.advanced.MergeSort;

/**
 * Laufzeitanalyse: Vermutlich in etwa die selbe Laufzeit wie die rekursive
 * Variante.
 */
public class IterativeMergeSort extends MergeSort {

    @Override
    public void sort(int[] input) {
        List<List<Integer>> groups = new ArrayList<>();

        // Laufzeit -> n
        for (int i = 0; i < input.length; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(input[i]);
            groups.add(list);
        }

        // Laufzeit -> n log n
        while (groups.size() > 1) {
            Iterator<List<Integer>> iterator = groups.iterator();
            var left = iterator.next();
            var right = iterator.next();

            groups.remove(left);
            groups.remove(right);

            groups.add(merge(left, right));
        }

        // Copy list values manually to array to preserve int data type instead of
        // Integer
        List<Integer> last = groups.iterator().next();
        for (int i = 0; i < input.length; i++) {
            input[i] = last.get(i);
        }

        // Ergebnis: IterativeMergeSort hat wie sein rekursives Pendant O(nlogn)
    }

    // Laufzeit -> n
    private List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> temp = new ArrayList<>();

        while (!left.isEmpty() && !right.isEmpty()) {
            Integer l = left.iterator().next();
            Integer r = right.iterator().next();

            if (l <= r) {
                temp.add(l);
                left.remove(l);
            } else {
                temp.add(r);
                right.remove(r);
            }
        }

        temp.addAll(left);
        temp.addAll(right);

        return temp;
    }
}
