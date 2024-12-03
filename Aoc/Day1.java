package Aoc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Day1 {

    public static int Part1(String input) {
        // split over newlines first, then over spaces
        String[] lines = input.split("\n");

        int[] left = new int[lines.length];
        int[] right = new int[lines.length];

        for (int i = 0; i < lines.length; i++) {
            String[] parts = lines[i].split("   ");
            left[i] = Integer.parseInt(parts[0]);
            right[i] = Integer.parseInt(parts[1]);
        }

        // sort left and right from smallest to largest
        Arrays.sort(left);
        Arrays.sort(right);

        int total = 0;
        for (int i = 0; i < left.length; i++) {
            int distance = Math.abs(left[i] - right[i]);
            total += distance;
        }

        return total;
    }

    public static int Part2(String input) {
        // split over newlines first, then over spaces
        String[] lines = input.split("\n");

        int[] left = new int[lines.length];
        int[] right = new int[lines.length];

        for (int i = 0; i < lines.length; i++) {
            String[] parts = lines[i].split("   ");
            left[i] = Integer.parseInt(parts[0]);
            right[i] = Integer.parseInt(parts[1]);
        }

        // take "right" and count how many times each number appears within the list
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < right.length; i++) {
            counts.put(right[i], counts.getOrDefault(right[i], 0) + 1);
        }

        int total = 0;
        for (int i = 0; i < left.length; i++) {
            int similarity = left[i] * counts.getOrDefault(left[i], 0);
            total += similarity;
        }

        return total;
    }
}
