
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Today {

    public static void main(String[] args) {
        String input = loadDataFile("d4_input");
        // String input = """
        //                MMMSXXMASM
        //                MSAMXMSMSA
        //                AMXSXMAAMM
        //                MSAMASMSMX
        //                XMASAMXAMM
        //                XXAMMXXAMA
        //                SMSMSASXSS
        //                SAXAMASAAA
        //                MAMMMXMMMM
        //                MXMXAXMASX
        //                """;

        System.out.println(Aoc.Day4.Part2(input));
    }

    public static String loadDataFile(String path) {
        try {
            return new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
