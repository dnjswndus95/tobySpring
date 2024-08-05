package tobyspring.hellospring.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortUtils {
    public static void main(String[] args){
        List<Integer> scores = Arrays.asList(5, 7, 1, 9, 2, 6);
        Collections.sort(scores);

        List<String> strScores = Arrays.asList("z", "x", "spring", "java");
        Collections.sort(strScores, (o1, o2) -> o1.length() - o2.length());

        scores.forEach(System.out::println);
        strScores.forEach(System.out::println);
    }
}
