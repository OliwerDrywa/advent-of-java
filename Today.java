
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Today {

    public static void main(String[] args) {
        String input = loadDataFile("d5_input");
        // String input = """
        //                47|53
        //                97|13
        //                97|61
        //                97|47
        //                75|29
        //                61|13
        //                75|53
        //                29|13
        //                97|29
        //                53|29
        //                61|53
        //                97|53
        //                61|29
        //                47|13
        //                75|47
        //                97|75
        //                47|61
        //                75|61
        //                47|29
        //                75|13
        //                53|13

        //                75,47,61,53,29
        //                97,61,53,29,13
        //                75,29,13
        //                75,97,47,61,53
        //                61,13,29
        //                97,13,75,29,47
        //                """;

        System.out.println("today's answer: " + Aoc.Day5.Part2(input));
    }

    public static String loadDataFile(String path) {
        try {
            return new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
