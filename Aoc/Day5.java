package Aoc;

import java.util.*;
import java.util.stream.Collectors;

public class Day5 {
    public static int Part1(String input) {
        String[] sections = input.split("\n\n");
        List<Rule> rules = parseRules(sections[0]);
        List<List<String>> updates = parseUpdates(sections[1]);

        return updates.stream()
                .filter(update -> isValidUpdate(update, rules))
                .mapToInt(Day5::getMiddleValue)
                .sum();
    }

    public static int Part2(String input) {
        String[] sections = input.split("\n\n");
        List<Rule> rules = parseRules(sections[0]);
        List<List<String>> updates = parseUpdates(sections[1]);

        return updates.stream()
                .filter(update -> !isValidUpdate(update, rules))
                .map(update -> {
                    ArrayList<String> sorted = new ArrayList<>(update);
                    sortAccordingToRules(sorted, rules);
                    return sorted;
                })
                .mapToInt(Day5::getMiddleValue)
                .sum();
    }

    private static class Rule {

        final String before;
        final String after;

        Rule(String before, String after) {
            this.before = before;
            this.after = after;
        }
    }

    private static List<Rule> parseRules(String input) {
        return Arrays.stream(input.split("\n"))
                .map(line -> line.split("\\|"))
                .map(parts -> new Rule(parts[0], parts[1]))
                .collect(Collectors.toList());
    }

    private static List<List<String>> parseUpdates(String input) {
        return Arrays.stream(input.split("\n"))
                .map(line -> Arrays.asList(line.split(",")))
                .collect(Collectors.toList());
    }

    private static boolean isValidUpdate(List<String> update, List<Rule> rules) {
        return rules.stream().allMatch(rule -> {
            if (!update.contains(rule.before) || !update.contains(rule.after)) {
                return true;
            }
            return update.indexOf(rule.before) < update.indexOf(rule.after);
        });
    }

    private static int getMiddleValue(List<String> numbers) {
        return Integer.parseInt(numbers.get((numbers.size() - 1) / 2));
    }

    private static void sortAccordingToRules(List<String> numbers, List<Rule> rules) {
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                for (Rule rule : rules) {
                    if (numbers.get(i).equals(rule.after) && numbers.get(j).equals(rule.before)) {
                        Collections.swap(numbers, i, j);
                    }
                }
            }
        }
    }
}
