package fuctional.stream_api.problems;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         Arrays.stream(sc.nextLine().split("\\s"))
                .map(Integer::parseInt)
                .filter(o -> o % 2 == 0)
                .sorted(Comparator.reverseOrder())
                .forEach(o -> System.out.println(o + " "));
    }


}
