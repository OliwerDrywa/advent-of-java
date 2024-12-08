package aoc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Day8 {

    public static int Part1(String input) {
        String[] lines = input.split("\n");
        int height = lines.length;
        int width = lines[0].length();

        Map<Character, List<int[]>> charMap = countChars(lines);

        Set<String> antinodes = new HashSet<>();
        for (Map.Entry<Character, List<int[]>> entry : charMap.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                for (int j = i + 1; j < entry.getValue().size(); j++) {
                    int[] a = entry.getValue().get(i);
                    int[] b = entry.getValue().get(j);

                    int[] c = new int[]{b[0] + (b[0] - a[0]), b[1] + (b[1] - a[1])};
                    if (c[0] >= 0 && c[0] < width && c[1] >= 0 && c[1] < height) {
                        antinodes.add(c[0] + "," + c[1]);
                    }

                    c = new int[]{a[0] + (a[0] - b[0]), a[1] + (a[1] - b[1])};
                    if (c[0] >= 0 && c[0] < width && c[1] >= 0 && c[1] < height) {
                        antinodes.add(c[0] + "," + c[1]);
                    }
                }
            }
        }

        return antinodes.size();
    }

    public static int Part2(String input) {
        String[] lines = input.split("\n");
        int height = lines.length;
        int width = lines[0].length();

        Map<Character, List<int[]>> charMap = countChars(lines);

        Set<String> antinodes = new HashSet<>();
        for (Map.Entry<Character, List<int[]>> entry : charMap.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                for (int j = i + 1; j < entry.getValue().size(); j++) {
                    int[] a = entry.getValue().get(i);
                    int[] b = entry.getValue().get(j);

                    int dx = b[0] - a[0];
                    int dy = b[1] - a[1];

                    int[] c = a.clone();
                    while (true) {
                        if (c[0] < 0 || c[0] >= width || c[1] < 0 || c[1] >= height) {
                            break;
                        }

                        antinodes.add(c[0] + "," + c[1]);

                        c[0] -= dx;
                        c[1] -= dy;
                    }

                    c = b.clone();
                    while (true) {
                        if (c[0] < 0 || c[0] >= width || c[1] < 0 || c[1] >= height) {
                            break;
                        }

                        antinodes.add(c[0] + "," + c[1]);

                        c[0] += dx;
                        c[1] += dy;
                    }
                }
            }
        }

        return antinodes.size();
    }

    private static Map<Character, List<int[]>> countChars(String[] lines) {
        // in input string, find every character that is not a '.' or '\n'
        Map<Character, List<int[]>> charMap = new HashMap<>();

        for (int y = 0; y < lines.length; y++) {
            for (int x = 0; x < lines[y].length(); x++) {
                char c = lines[y].charAt(x);

                if (c != '.' && c != '\n') {
                    if (charMap.containsKey(c)) {
                        charMap.get(c).add(new int[]{x, y});
                    } else {
                        List<int[]> coordinates = new ArrayList<>();
                        coordinates.add(new int[]{x, y});
                        charMap.put(c, coordinates);
                    }
                }
            }
        }

        return charMap;
    }
}
