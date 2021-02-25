package fuctional.stream_api.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class UniqueWordsCount {
    /**
     * Counts the number of unique words ignoring case sensitivity
     * for given lines with words. Processes only n lines.

     */
    public static long count(int n, List<List<String>> lines) {
        return lines.stream()
                .limit(n)
                .flatMap(Collection::stream)
                .map(String::toLowerCase)
                .distinct()
                .count();
    }

    public static void main(String[] args) {

        List<List<String>> lines = new ArrayList<>();
        String line1 = "Word word wORD";
        String line2 = "line Line SplinE word";
        String line3 = "spline align Java java";
        String line4 = "asd dfg dfg ff";


        lines.add(Arrays.asList(line1.split("\\s+")));
        lines.add(Arrays.asList(line2.split("\\s+")));
        lines.add(Arrays.asList(line3.split("\\s+")));
        lines.add(Arrays.asList(line4.split("\\s+")));
        
        System.out.println(count(3, lines));
    }
}
