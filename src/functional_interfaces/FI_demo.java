package functional_interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FI_demo {

    public static void main(String[] args) {

        List<String> names = List.of("jack", "JOHN", "ann", "NiCK", "Stan");
        System.out.println(tListHandler(names, s -> s.toUpperCase()));
        List<String> newList = tListHandler(names, s -> s.toUpperCase());
        System.out.println(handler(newList, s -> s.startsWith("J")));
        System.out.println(handler(tListHandler(names, s -> s.toUpperCase()), s -> s.startsWith("J")));

        System.out.println("------------------------------------------------");

        List<String> list = List.of("jack", "JOHN", "ann", "NiCK", "Stan");
        Predicate<String> predicate = s -> s.startsWith("J");
        Function<String, String> transform = s -> s.toUpperCase();
        newList = handler(tListHandler(list, transform), predicate);
        System.out.println(newList);

        System.out.println(handler(tListHandler(list, transform), s -> s.length() <= 3));

        System.out.println("--------------------------- consumer ---------------------------");
        newList.forEach(s -> System.out.println(s));

        System.out.println("--------------------------- supplier ---------------------------");

        Supplier<List<String>> supplier = () -> new ArrayList<String>();
        Supplier<List<String>> supplier1 = () -> List.of("1", "2");
        Supplier<List<Integer>> supplier2 = () -> {
            Random rnd = new Random();
            List<Integer> resList = new ArrayList<>();
            int size = rnd.nextInt(100);
            for (int i = 0; i < size; i++) {
                resList.add(rnd.nextInt());
            }
            return resList;
        };
    }

    public void productionHandler(Supplier<List<Integer>> supplier) {
        List<Integer> integerList = supplier.get();
        integerList.forEach(i -> System.out.println(i));
    }

   /* public static <T> List<T> tListHandler(List<T> list, Transformer<T> transformer) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            result.add(transformer.transform(t));
        }
        return result;
    }*/

    //    Interface Predicate - проверяем условие
    public static <T> List<T> handler(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T el : list) {
            if (predicate.test(el)) {
                result.add(el);
            }
        }
        return result;
    }

    //    Interface Function - тип Т (изначальный) преобразуем в тип R (результат) по какому-то правилу
    //    UnaryOperator<T> - преобразование по правилу, если тип один (из строки в строку), т.е. это
    //    частный случай Function<T, T>

        public static <T> List<T> tListHandler(List<T> list, Function<T, T> transformer) {
//    public static <T> List<T> tListHandler(List<T> list, UnaryOperator<T> transformer) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            result.add(transformer.apply(t));
        }
        return result;
    }
}
