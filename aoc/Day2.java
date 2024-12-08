package aoc;

import java.util.Arrays;

public class Day2 {

    public static int Part1(String input) {
        return Arrays.stream(input.split("\n"))
                .map(chars -> Arrays.stream(chars.split(" ")).mapToInt(Integer::parseInt).toArray()).filter(Day2::isReportSafe).toArray().length;
    }

    public static int Part2(String input) {
        return Arrays.stream(input.split("\n"))
                .map(chars -> Arrays.stream(chars.split(" ")).mapToInt(Integer::parseInt).toArray()).filter(Day2::isReportSafeSmarter).toArray().length;
    }

    static boolean isReportSafe(int[] report) {
        int[] diff = new int[report.length - 1];
        for (int i = 0; i < diff.length; i++) {
            diff[i] = report[i + 1] - report[i];
        }

        boolean allPositive = Arrays.stream(diff).allMatch(d -> 0 < d);
        boolean allNegative = Arrays.stream(diff).allMatch(d -> 0 > d);
        boolean allInRange = Arrays.stream(diff).allMatch(d -> Math.abs(d) <= 3);

        return (allPositive || allNegative) && allInRange;
    }

    static boolean isReportSafeSmarter(int[] report) {
        if (isReportSafe(report)) {
            return true;
        } else {
            int[] attempt = new int[report.length - 1];

            for (int i = 0; i < report.length; i++) {
                // create a copy of the report, but with the level deleted
                System.arraycopy(report, 0, attempt, 0, i);
                System.arraycopy(report, i + 1, attempt, i, attempt.length - i);

                if (isReportSafe(attempt)) {
                    return true;
                }
            }

            return false;
        }
    }
}
