package comparator_demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatoeDemo {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();

    }

    public void temp(List<Person> list) {
        Comparator<Person> comparatorPerson2 = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return 0;
            }
        };

        ComparatorPerson comparatorPerson = new ComparatorPerson();
//        list.sort(comparatorPerson);
        list.sort(comparatorPerson2);

        list.sort((o1, o2) -> o1.getAge() - o2.getAge());

        /* так тоже можно: просто передать компаратор без анонимного класса и создания переменной
        list.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        */
    }
}
