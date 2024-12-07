package Aoc;

public class Day6 {

    public static int Part1(String input) {
        while (input.contains(">") || input.contains("<") || input.contains("^") || input.contains("v")) {
            input = step(input);
        }

        return input.chars().filter(c -> c == 'X').toArray().length;
    }

    public static int Part2(String input) {
        return 0;
    }

    private static String step(String input) {
        String[] rows = input.split("\n");

        int height = rows.length;
        int width = rows[0].length();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                switch (rows[i].charAt(j)) {
                    case '^' -> {
                        if (i == 0) {
                            rows[i] = rows[i].substring(0, j) + "X" + rows[i].substring(j + 1);
                        } else if (rows[i - 1].charAt(j) == '.' || rows[i - 1].charAt(j) == 'X') {
                            rows[i - 1] = rows[i - 1].substring(0, j) + "^" + rows[i - 1].substring(j + 1);
                            rows[i] = rows[i].substring(0, j) + "X" + rows[i].substring(j + 1);
                        } else if (rows[i - 1].charAt(j) == '#') {
                            rows[i] = rows[i].substring(0, j) + ">" + rows[i].substring(j + 1);
                        }
                        return String.join("\n", rows);
                    }

                    case '>' -> {
                        if (j == width - 1) {
                            rows[i] = rows[i].substring(0, j) + "X";
                        } else if (rows[i].charAt(j + 1) == '.' || rows[i].charAt(j + 1) == 'X') {
                            rows[i] = rows[i].substring(0, j) + "X>" + rows[i].substring(j + 2);
                        } else if (rows[i].charAt(j + 1) == '#') {
                            rows[i] = rows[i].substring(0, j) + "v" + rows[i].substring(j + 1);
                        }
                        return String.join("\n", rows);
                    }

                    case 'v' -> {
                        if (i == height - 1) {
                            // System.out.println("here");
                            rows[i] = rows[i].substring(0, j) + "X" + rows[i].substring(j + 1);
                            // System.out.println("not here");
                        } else if (rows[i + 1].charAt(j) == '.' || rows[i + 1].charAt(j) == 'X') {
                            rows[i] = rows[i].substring(0, j) + "X" + rows[i].substring(j + 1);
                            rows[i + 1] = rows[i + 1].substring(0, j) + "v" + rows[i + 1].substring(j + 1);
                        } else if (rows[i + 1].charAt(j) == '#') {
                            rows[i] = rows[i].substring(0, j) + "<" + rows[i].substring(j + 1);
                        }
                        return String.join("\n", rows);
                    }

                    case '<' -> {
                        if (j == 0) {
                            rows[i] = "#" + rows[i].substring(1);
                        } else if (rows[i].charAt(j - 1) == '.' || rows[i].charAt(j - 1) == 'X') {
                            rows[i] = rows[i].substring(0, j - 1) + "<X" + rows[i].substring(j + 1);
                        } else if (rows[i].charAt(j - 1) == '#') {
                            rows[i] = rows[i].substring(0, j) + "^" + rows[i].substring(j + 1);
                        }
                        return String.join("\n", rows);
                    }
                }
            }
        }

        return input;
    }
}
