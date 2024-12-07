
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Today {

    public static void main(String[] args) {
        String input = loadDataFile("d7_input");
        // String input = """
        //                190: 10 19
        //                3267: 81 40 27
        //                83: 17 5
        //                156: 15 6
        //                7290: 6 8 6 15
        //                161011: 16 10 13
        //                192: 17 8 14
        //                21037: 9 7 18 13
        //                292: 11 6 16 20
        //                """;

        System.out.println("today's answer: " + Aoc.Day7.Part2(input));
    }

    public static String loadDataFile(String path) {
        try {
            return new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
