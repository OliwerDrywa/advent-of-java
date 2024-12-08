package aoc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3 {

    public static int Part1(String input) {
        Pattern pattern = Pattern.compile("mul\\(\\d*,\\d*\\)");
        Matcher matcher = pattern.matcher(input);

        int total = 0;
        while (matcher.find()) {
            String instruction = matcher.group();

            String[] factors = instruction.substring(4, instruction.length() - 1).split(",");
            total += Integer.parseInt(factors[0]) * Integer.parseInt(factors[1]);
        }

        return total;
    }

    public static int Part2(String input) {
        Pattern pattern = Pattern.compile("(mul\\(\\d*,\\d*\\))|(don't\\(\\))|(do\\(\\))");
        Matcher matcher = pattern.matcher(input);

        int total = 0;
        boolean doing = true;
        while (matcher.find()) {
            String instruction = matcher.group();

            if ("do()".equals(instruction)) {
                doing = true;
            } else if ("don't()".equals(instruction)) {
                doing = false;
            } else if (doing) {
                String[] factors = instruction.substring(4, instruction.length() - 1).split(",");
                total += Integer.parseInt(factors[0]) * Integer.parseInt(factors[1]);
            }
        }

        return total;
    }
}
