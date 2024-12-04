package Aoc;

import java.util.Arrays;

public class Day4 {

    public static int Part1(String input) {
        char[][] rows = Arrays.stream(input.split("\n")).map(r -> r.toCharArray()).toArray(char[][]::new);

        int[][] DIRECTIONS = {{-1, -1}, {0, -1}, {1, -1}, {-1, 0}, {1, 0}, {-1, 1}, {0, 1}, {1, 1}};

        int total = 0;
        for (int y = 0; y < rows.length; y++) {
            for (int x = 0; x < rows[y].length; x++) {
                for (int[] d : DIRECTIONS) {
                    int dx = d[0];
                    int dy = d[1];

                    if ((x + (dx * 3)) >= 0
                            && (x + (dx * 3)) < rows[y].length
                            && (y + (dy * 3)) >= 0
                            && (y + (dy * 3)) < rows.length) {

                        if (rows[(y + (0 * dy))][(x + (0 * dx))] == 'X'
                                && rows[(y + (1 * dy))][(x + (1 * dx))] == 'M'
                                && rows[(y + (2 * dy))][(x + (2 * dx))] == 'A'
                                && rows[(y + (3 * dy))][(x + (3 * dx))] == 'S') {

                            total++;
                        }
                    }
                }
            }
        }

        return total;
    }

    public static int Part2(String input) {
        char[][] rows = Arrays.stream(input.split("\n")).map(r -> r.toCharArray()).toArray(char[][]::new);

        int total = 0;
        for (int y = 1; y < rows.length - 1; y++) {
            for (int x = 1; x < rows[y].length - 1; x++) {
                if (rows[y][x] == 'A') {
                    if ((rows[y - 1][x - 1] == 'M' && rows[y + 1][x + 1] == 'S' || rows[y - 1][x - 1] == 'S' && rows[y + 1][x + 1] == 'M')
                            && (rows[y - 1][x + 1] == 'M' && rows[y + 1][x - 1] == 'S' || rows[y - 1][x + 1] == 'S' && rows[y + 1][x - 1] == 'M')) {
                        total++;
                    }
                }
            }
        }

        return total;
    }
}
