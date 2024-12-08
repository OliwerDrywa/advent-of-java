package aoc;

import java.util.Arrays;

public class Day7 {

    public static long Part1(String input) {
        String[] lines = input.split("\n");

        long total = 0;
        for (String line : lines) {
            String[] sections = line.split(": ");
            long targetResult = Long.parseLong(sections[0]);
            int[] nums = Arrays.stream(sections[1].split(" ")).mapToInt(Integer::valueOf).toArray();

            for (int i = 0; i < Math.pow(2, nums.length - 1); i++) {
                String binary = String.format("%" + (nums.length - 1) + "s", Integer.toBinaryString(i)).replace(' ', '0');

                long sum = nums[0];
                for (int j = 0; j < binary.length(); j++) {
                    if (binary.charAt(j) == '0') {
                        sum += nums[j + 1];
                    } else if (binary.charAt(j) == '1') {
                        sum *= nums[j + 1];
                    }
                }
                if (sum == targetResult) {
                    total += sum;
                    break;
                }
            }
        }

        return total;
    }

    public static long Part2(String input) {
        String[] lines = input.split("\n");

        long total = 0;
        for (String line : lines) {
            String[] sections = line.split(": ");
            long targetResult = Long.parseLong(sections[0]);
            int[] nums = Arrays.stream(sections[1].split(" ")).mapToInt(Integer::valueOf).toArray();

            for (int i = 0; i < Math.pow(3, nums.length - 1); i++) {
                String combinations = String.format("%" + (nums.length - 1) + "s", Integer.toString(Integer.parseInt(Integer.toString(i), 10), 3)).replace(' ', '0');

                long sum = nums[0];
                for (int j = 0; j < combinations.length(); j++) {
                    switch (combinations.charAt(j)) {
                        case '0' ->
                            sum += nums[j + 1];
                        case '1' ->
                            sum *= nums[j + 1];
                        case '2' ->
                            sum = Long.parseLong("" + sum + nums[j + 1]);
                    }
                }
                if (sum == targetResult) {
                    total += sum;
                    break;
                }
            }
        }

        return total;
    }

}
