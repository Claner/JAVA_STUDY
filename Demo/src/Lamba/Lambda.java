package Lamba;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Clanner on 2017/10/22.
 */
public class Lambda {
    public static void main(String[] args) {
        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
//        features.forEach(n -> System.out.println(n));

        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

//        System.out.println("Languages which starts with J :");
//        filter(languages, (str) -> str.startsWith("J"));

//        System.out.println("Languages which ends with a ");
//        filter(languages, (str) -> str.endsWith("a"));

        System.out.println("Print all languages :");
        filter(languages, (str) -> true);

        System.out.println("Print no language : ");
        filter(languages, (str) -> false);

//        System.out.println("Print language whose length greater than 4:");
//        filter(languages, (str)->str.length() > 4);

        // 使用lambda表达式
//        List costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
//        costBeforeTax.stream().map((cost) -> cost + cost*0.12).forEach(System.out::println);

//        List costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
//        double bill = costBeforeTax.stream().map((cost) -> cost + .12*cost).reduce((sum, cost) -> sum + cost).get();
//        System.out.println("Total : " + bill);
    }

    public static void filter(List<String> names, Predicate condition) {
        names.stream().filter((name) -> (condition.test(name))).forEach((name) -> {
            System.out.println(name+"");
        });
    }
}
