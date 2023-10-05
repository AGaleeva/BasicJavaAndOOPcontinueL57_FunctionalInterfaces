package lambda_demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        double sum = calc(10, 10, new DoubleOperation() {
            @Override
            public double apply(double num1, double num2) {
                return num1 + num2;
            }
        });

        sum = calc(10, 10, ((num1, num2) -> num1 + num2));
        double pow = calc(2, 3, new DoubleOperation() {
            @Override
            public double apply(double num1, double num2) {
                return Math.pow(num1, num2);
            }
        });

        pow = calc(2, 3, ((num1, num2) -> Math.pow(num1, num2)));

        double min = calc(3, 5, (num1, num2) -> Math.min(num1, num2));
        min = calc(3, 5, (num1, num2) -> Math.min(num1, num2) * 10);

        List<String> strings = List.of("jack", "JoHn", "ann", "Nick");

        System.out.println(strListHandler(strings, s -> s.toUpperCase()));
        System.out.println(strListHandler(strings, s -> s.toLowerCase()));
        System.out.println(strListHandler(strings, s -> "user: " + s));
        System.out.println(strListHandler(strings, s -> "user: " + s.toUpperCase()));
        System.out.println(tListHandler(List.of(1, 2, 3, 4), i -> i * 2));
        System.out.println(tListHandler(List.of(1, 2, 3, 4), i -> Integer.bitCount(i)));

    }

    public static double calc(double num1, double num2, DoubleOperation operation) {
        return operation.apply(num1, num2);
    }

    public static List<String> strListHandler(List<String> list, StringTransformer transformer) {
        List<String> result = new ArrayList<>();
        for (String s : list) {
            result.add(transformer.transform(s));
        }
        return result;
    }

    public static <T> List<T> tListHandler(List<T> list, Transformer<T> transformer) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            result.add(transformer.transform(t));
        }
        return result;
    }
}
