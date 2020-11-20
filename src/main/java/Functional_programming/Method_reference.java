package Functional_programming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Method_reference {
    //    public static void main(String[] args) {
//       String[] array=new String[] { "Apple", "Orange", "Banana", "Lemon" };
//        Arrays.sort(array,Method_reference::cmp);
//        System.out.println(String.join(",",array));
//    }
//
//    static int cmp(String s1, String s2) {
//        return s1.compareTo(s2);
//    }
    public static void main(String[] args) {
        List<String> names = List.of("Bob", "Alice", "Tim");
        List<Person> persons = names.stream().map(Person::new).collect(Collectors.toList());
        System.out.println(persons);
    }
}

class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }

    public String toString() {
        return "Person:" + this.name;
    }
}
