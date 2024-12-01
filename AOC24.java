
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class AOC24 {

    public static void main(String[] args) {
        // System.out.println(d1p1(loadDataFile("day_1_input")));
        System.err.println(d1p2(loadDataFile("day_1_input")));
    }

    // day 1
    public static int d1p1(String input) {
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

    public static int d1p2(String input) {
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

    // helpers
    public static String loadDataFile(String path) {
        try {
            return new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
