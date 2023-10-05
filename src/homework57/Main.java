package homework57;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        List<Person> people = List.of(new Person("John", "Smith", "js@mail.com", "012345678", new Address("01234", "City", "Street", "01")), (new Person("Jill", "Peterson", "jp@mail.com", "012987456", new Address("01345", "City1", "Street1", "15"))), (new Person("Jim", "Beam", "jb@mail.com", "012658432", new Address("05340", "City2", "Street12", "101"))), (new Person("Jeffrey", "Thomas", "jt@mail.com", "012165437", new Address("03451", "City3", "Street13", "1a"))), (new Person("Jack", "Mason", "jm@mail.com", "012356874", new Address("02445", "City4", "Avenue21", "215"))), (new Person("Julia", "Larson", "jl@mail.com", "012587124", new Address("08547", "City7", "Street78", "111"))));

        System.out.println(getListOfData(people, p -> p.getFirstName() + " " + p.getLastName()));
        System.out.println(getListOfData(people, p -> p.getEmail()));
        System.out.println(getListOfData(people, p -> p.getPhone()));
        System.out.println(getListOfData(people, p -> p.getAddress().toString()));

        System.out.println("---------------------------------------------");

        List<String> listNames = getListOfData(people, p -> p.getFirstName() + " " + p.getLastName());
        System.out.println(filter(listNames, s -> s.startsWith("Ji")));

    }

    public static <T, R> List<R> getListOfData(List<T> list, Function<T, R> function) {
        List<R> listRes = new ArrayList<>();
        for (T el : list) {
            listRes.add(function.apply(el));
        }
        return listRes;
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> filteredList = new ArrayList<>();
        for (T el : list) {
            if (predicate.test(el)) {
                filteredList.add(el);
            }
        }
        return filteredList;
    }
}
