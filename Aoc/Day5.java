package Aoc;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Day5 {

    public static int Part1(String input) {
        String[] inputs = input.split("\n\n");

        String[][] rules = Arrays.stream(inputs[0].split("\n"))
                .map(x -> Arrays.stream(x.split("\\|")).toArray(String[]::new))
                .toArray(String[][]::new);

        String[][] updates = Arrays.stream(inputs[1].split("\n"))
                .map(x -> Arrays.stream(x.split(",")).toArray(String[]::new))
                .toArray(String[][]::new);

        int total = 0;
        for (String[] nums : updates) {
            List<String> numList = Arrays.asList(nums);

            // for each rule    
            // check if all the rules are satisfied
            boolean rulesSatisfied = true;
            for (String[] r : rules) {
                String before = r[0];
                String after = r[1];

                // see if both numbers in the rule are in the update
                // if not, skip to the next rule
                if (!numList.contains(before) || !numList.contains(after)) {
                    continue;
                }

                // see if the "before" number appears before the "after" number
                int beforeIndex = numList.indexOf(before);
                int afterIndex = numList.indexOf(after);
                if (beforeIndex > afterIndex) {
                    rulesSatisfied = false;
                    break;
                }
            }

            if (rulesSatisfied) {
                String middle = nums[(nums.length - 1) / 2];
                total += Integer.parseInt(middle);
            }

            // if so, get the middle number and add it to the total
        }

        return total;
    }

    public static int Part2(String input) {
        String[] inputs = input.split("\n\n");

        String[][] rules = Arrays.stream(inputs[0].split("\n"))
                .map(x -> Arrays.stream(x.split("\\|")).toArray(String[]::new))
                .toArray(String[][]::new);

        String[][] updates = Arrays.stream(inputs[1].split("\n"))
                .map(x -> Arrays.stream(x.split(",")).toArray(String[]::new))
                .toArray(String[][]::new);

        Stack<String[]> wrongUpdates = new Stack<>();

        for (String[] nums : updates) {
            List<String> numList = Arrays.asList(nums);

            // for each rule    
            // check if all the rules are satisfied
            boolean rulesSatisfied = true;
            for (String[] r : rules) {
                String before = r[0];
                String after = r[1];

                // see if both numbers in the rule are in the update
                // if not, skip to the next rule
                if (!numList.contains(before) || !numList.contains(after)) {
                    continue;
                }

                // see if the "before" number appears before the "after" number
                int beforeIndex = numList.indexOf(before);
                int afterIndex = numList.indexOf(after);
                if (beforeIndex > afterIndex) {
                    rulesSatisfied = false;
                    break;
                }
            }

            if (!rulesSatisfied) {
                wrongUpdates.push(nums);
            }
        }

        int total = 0;
        for (String[] nums : wrongUpdates) {
            // System.out.println();
            // System.out.println(Arrays.toString(nums));

            // sort the numbers in the update
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {

                    for (String[] r : rules) {
                        String before = r[0];
                        String after = r[1];

                        // see if both numbers in the rule are in the update
                        // if not, skip to the next rule
                        if (nums[i].equals(after) && nums[j].equals(before)) {
                            // if the "before" number appears before the "after" number
                            // then sort so that the "before" number is first
                            String temp = nums[i];
                            nums[i] = nums[j];
                            nums[j] = temp;

                        }
                    }
                }
            }

            // System.out.println("sorted: " + Arrays.toString(nums));
            String middle = nums[(nums.length - 1) / 2];
            total += Integer.parseInt(middle);
        }

        return total;
    }
}
