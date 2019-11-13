import java.util.Arrays;
import java.util.List;

public class streamExamples2 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("hi", "hello", "hola", "bye", "goodbye", "adios");
        System.out.println(Arrays.asList(words));

        String upperCaseWords = words.stream().reduce("", (s1, s2) -> s1 + s2.toUpperCase());
        System.out.println(Arrays.asList(upperCaseWords));

        String upperCaseWordsAlt = words.stream().reduce("", String::concat).toUpperCase();
        System.out.println(Arrays.asList(upperCaseWordsAlt));

        String upperCaseWords2 = words.stream().map(String::toUpperCase)     // Or .map (s -> s.toUpperCase())
                        .reduce("", String::concat);  // Or .reduce("", (s1,s2) -> s1+s2)
        System.out.println(Arrays.asList(upperCaseWords2));

        String wordsWithCommas = words.stream().reduce((s1, s2) -> s1 + "," + s2)
                        .orElse("need at least two strings");
        System.out.println(Arrays.asList(wordsWithCommas));

        int numberOfChars = words.stream().mapToInt(String::length)
                            .sum();
        System.out.println("Total number of characters: "+numberOfChars);

        long numberOfWordsWithH = words.stream().filter(s -> s.contains("h"))
                                    .count();
        System.out.println("Number of words containing 'h': "+ numberOfWordsWithH);
    }
}
