import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class streamExamples {

    public static String firstFunnyString(List<String> words,
                                          String containedTest) {
        String result =
                words.stream()
                        .map(String::toUpperCase)
                        .filter(s -> s.length() < 4)
                        .filter(s -> s.contains(containedTest))
                        .findFirst().orElse("No match");
        return (result);
    }


    public static void main(String[] args) {
        List<String> words = Arrays.asList("hola", "hi", "hello", "bye", "goodbye", "adios");


        System.out.println("Words (with spaces):");
        words.stream().forEach(s -> System.out.print("  " + s));
        System.out.println();

        System.out.println();
        System.out.println("Words (no spaces):");
        words.stream().forEach(System.out::print);
        System.out.println();
        System.out.println();
        List<String> excitingwords = words.stream()
                .map(s -> s +"!")
                .collect(Collectors.toList());
        System.out.print(Arrays.asList(excitingwords));
        System.out.println();
        System.out.println();

        List<String> eyeWords = words.stream()
                .map(s -> s.replace("i", "eye"))
                .collect(Collectors.toList());
        System.out.println(Arrays.asList(eyeWords));

        List<String> upperCaseWords = words.stream()
                .map(String::toUpperCase)  // or  .map(s -> s.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(Arrays.asList(upperCaseWords));

        List<String> shortWords = words.stream()
                .filter(s -> s.length() < 4)
                .collect(Collectors.toList());
        System.out.println(Arrays.asList(shortWords));

        List<String> wordsWithB = words.stream()
                .filter(s -> s.contains("b"))
                .collect(Collectors.toList());
        System.out.println(Arrays.asList(wordsWithB));

        List<String> evenLengthWords = words.stream()
                .filter(s -> (s.length() % 2) == 0)
                .collect(Collectors.toList());
        System.out.println(Arrays.asList(evenLengthWords));

        String result1 = firstFunnyString(words, "H");
        System.out.println("Uppercase short word with 'H': " + result1);
        String result2 = firstFunnyString(words, "E");
        System.out.println("Uppercase short word with 'E': " + result2);

        Function<String,String> toUpper =
                s -> { System.out.println("Uppercasing " + s);
                    return(s.toUpperCase());
                };
        String result3 = words.stream()
                .map(toUpper)
                .filter(s -> s.length() < 4)
                .filter(s -> s.contains("E"))
                .findFirst().orElse("No match");
        System.out.println("Uppercase short word with 'E': " + result3);
        System.out.println();

        String[] excitingWords2 = words.stream()
                .map(s -> s + "!")
                .map(String::toUpperCase)
                .toArray(String[]::new);
        System.out.println(Arrays.asList(excitingWords2));
        System.out.println();
    }

}
