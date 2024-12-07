
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Today {

    public static void main(String[] args) {
        String input = loadDataFile("d6_input");
        // String input = """
        //                ....#.....
        //                .........#
        //                ..........
        //                ..#.......
        //                .......#..
        //                ..........
        //                .#..^.....
        //                ........#.
        //                #.........
        //                ......#...
        //                """;

        System.out.println("today's answer: " + Aoc.Day6.Part1(input));
    }

    public static String loadDataFile(String path) {
        try {
            return new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
