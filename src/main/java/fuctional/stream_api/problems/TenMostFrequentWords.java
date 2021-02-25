package fuctional.stream_api.problems;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class TenMostFrequentWords {
    public List<String> getWords(String text) {
        text = text.replace(".","")
            .replace(",","")
            .replace(":","")
            .replace(";","")
            .replace(" - "," ")
            .replace("!","")
            .replace("?","");

        return Arrays.stream(text.split("\\s"))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
